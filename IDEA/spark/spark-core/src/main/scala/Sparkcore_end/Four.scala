package Sparkcore_end

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2

import scala.collection.mutable

/**
  * @title: Four
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1314:38
  */
object Four {
  def main(args: Array[String]): Unit = {
    val top1: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Top10")
    val sc = new SparkContext(top1)

    val userfile: RDD[String] = sc.textFile("data/user_visit_action.txt")

    val acc = new HotCategoryAccumulator
      sc.register(acc,"HostCategory")

    userfile.foreach(
      action => {
        val datas =  action.split("_")
        if(datas(6) != "-1"){
          acc.add((datas(6),"click"))
        }else if (datas(8) != "null"){
          val ids = datas(8).split(",")
          ids.foreach(
            id =>{
              acc.add((id,"order"))
            }
          )
        }else if(datas(10) != "null"){
          val ids = datas(10).split(",")
          ids.foreach(
            id =>{
              acc.add((id,"pay"))
            }
          )
        }
      }
    )

  val accVal: mutable.Map[String, HotCategory] = acc.value
  val categories: mutable.Iterable[HotCategory] = accVal.map(_._2)

    val sort = categories.toList.sortWith(
      (left,right) =>{
        if (left.clickCnt>right.clickCnt) {
          true
        }else if(left.clickCnt>right.clickCnt){
            if (left.orderCnt>right.orderCnt) {
              true
            }else if(left.orderCnt == right.orderCnt) {
              left.payCnt>right.payCnt
            }else{
              false
            }
        }else {
          false
        }
      }
    )

    sort.take(10).foreach(println)
    
    sc.stop()
  }

  case class HotCategory( cid: String,var clickCnt:Int,var orderCnt:Int,var payCnt:Int)


  class HotCategoryAccumulator extends AccumulatorV2[(String,String),mutable.Map[String,HotCategory]]{

    private val hcMap = mutable.Map[String,HotCategory]()

    override def isZero: Boolean = hcMap.isEmpty

    override def copy(): AccumulatorV2[(String, String), mutable.Map[String, HotCategory]] = new HotCategoryAccumulator()

    override def reset(): Unit = hcMap.clear()

    override def add(v: (String, String)): Unit = {
      val cid = v._1
      val actionType = v._2
      val catgory = hcMap.getOrElse(cid,HotCategory(cid,0,0,0))
      if (actionType == "click"){
        catgory.clickCnt += 1
      }else if (actionType == "order"){
        catgory.orderCnt += 1
      }else if(actionType == "pay"){
        catgory.payCnt += 1
      }
      hcMap.update(cid,catgory)
    }

    override def merge(other: AccumulatorV2[(String, String), mutable.Map[String, HotCategory]]): Unit = {
      val map1 = this.hcMap
      val map2 = other.value

      map2.foreach{
        case (cid,hc) =>{
          val category: HotCategory = map1.getOrElse(cid,HotCategory(cid,0,0,0))
          category.clickCnt += hc.clickCnt
          category.orderCnt += hc.orderCnt
          category.payCnt += hc.payCnt
          map1.update(cid,category)

        }
      }
    }

    override def value: mutable.Map[String, HotCategory] = hcMap
  }
}
