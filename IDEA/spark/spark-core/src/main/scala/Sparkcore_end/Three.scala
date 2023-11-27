package Sparkcore_end

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * @title: Three
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/1314:13
  */
object Three {
  def main(args: Array[String]): Unit = {
    val top1: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Top10")
    val sc = new SparkContext(top1)

    val userfile: RDD[String] = sc.textFile("data/user_visit_action.txt")

    //将数据转换结构
    //点击的场合：（品类ID，(1,0,0)）
    //下单的场合：（品类ID，(0,1,0)）
    //支付的场合：（品类ID，(0,1,0)）
   val flatRDD:RDD[(String,(Int,Int,Int))]=  userfile.flatMap(
      action => {
       val datas =  action.split("_")
        if(datas(6) != "-1"){
          List((datas(6),(1,0,0)))
        }else if (datas(8) != "null"){
         val ids = datas(8).split(",")
          ids.map(id => (id,(0,1,0)))
        }else if(datas(10) != "null"){
          val ids = datas(10).split(",")
          ids.map(id => (id,(0,0,1)))
        }else{
          Nil
        }
      }
    )


    //将相同的品类的数据进行分组聚合
    //(品类ID，(点击数量，下单数量，支付数量))

    val analysisRDD: RDD[(String, (Int, Int, Int))] = flatRDD.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )



    val resultRDD =  analysisRDD.sortBy(_._2,false).take(10)



    //将结果采集输出到控制台打印出来
    resultRDD.foreach(println)


    sc.stop()
  }
}
