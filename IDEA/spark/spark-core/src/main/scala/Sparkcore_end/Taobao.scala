package Sparkcore_end

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: Taobao
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/1310:25
  */
object Taobao {
  def main(args: Array[String]): Unit = {

    //TODO : Top10 热门品类


    val top1: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Top10")
    val sc = new SparkContext(top1)

    val userfile: RDD[String] = sc.textFile("data/user_visit_action.txt")
    userfile.cache()

    //统计品类的点击数量（品类ID，点击数量）

    val clickActionRDD: RDD[String] = userfile.filter(
      action => {
        val datas = action.split("_")
        datas(6) != "-1"
      }
    )
    val clickCountRDD: RDD[(String, Int)] = clickActionRDD.map(
      action => {
        val datas = action.split("_")
        (datas(6), 1)
      }
    ).reduceByKey(_ + _)


    //统计品类的下单数量（品类ID，下单数量）
    val orderActionRDD: RDD[String] = userfile.filter(
      action => {
        val datas = action.split("_")
        datas(8) != "null"
      }
    )
    val orderCountRDD: RDD[(String, Int)] = orderActionRDD.flatMap(
      action => {
        val data = action.split("_")
        val cid = data(8)
        val cids = cid.split(",")
        cids.map((_,1))
      }
    ).reduceByKey(_ + _)





    //统计品类的支付数量（品类ID，支付数量）
    val payActionRDD: RDD[String] = userfile.filter(
      action => {
        val datas = action.split("_")
        datas(10) != "null"
      }
    )
    val payCountRDD: RDD[(String, Int)] = payActionRDD.flatMap(
      action => {
        val data = action.split("_")
        val cid = data(10)
        val cids = cid.split(",")
        cids.map((_,1))
      }
    ).reduceByKey(_ + _)




    //将品类进行排序，取前十名（点击数量排序，下单数量排序，支付数量排序）
    //元组排序（品类ID，（点击数量，下单数量，支付数量））

    //第一种方法
    /*val cogroupRDD: RDD[(String, (Iterable[Int], Iterable[Int], Iterable[Int]))] =
      clickCountRDD.cogroup(orderCountRDD,payCountRDD)

    val analysisRDD: RDD[(String, (Int, Int, Int))] = cogroupRDD.mapValues {
      case (clickiter, orderiter, payiter) => {
        var clickCnt = 0
        val iter = clickiter.iterator
        if (iter.hasNext) {
          clickCnt = iter.next()
        }
        var orderCnt = 0
        val iter2 = orderiter.iterator
        if (iter2.hasNext) {
          orderCnt = iter2.next()
        }
        var payCnt = 0
        val iter3 = payiter.iterator
        if (iter3.hasNext) {
          payCnt = iter3.next()
        }

        (clickCnt, orderCnt, payCnt)
      }
    }
*/


    //第二种方法
    val click = clickCountRDD.mapValues {
      case cnt => {
        (cnt, 0, 0)
      }
    }
    val order = orderCountRDD.mapValues {
      case cnt => {
        (0, cnt, 0)
      }
    }
    val pay = payCountRDD.mapValues {
      case cnt => {
        (0, 0, cnt)
      }
    }
    val sourceRDD: RDD[(String, (Int, Int, Int))] = click.union(order).union(pay)

    val analysisRDD: RDD[(String, (Int, Int, Int))] = sourceRDD.reduceByKey(
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
