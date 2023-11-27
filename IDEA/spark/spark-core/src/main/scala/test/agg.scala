package test

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * @title: agg
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1122:25
  */
object agg {
  def main(args: Array[String]): Unit = {
    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("max")
    val sc = new SparkContext(sparkconf)

     val value = sc.makeRDD(List(
      ("a",1),("w",2),("a",3),("c",3),("w",3),("a",2)
      ),2)

    val w = value.aggregateByKey((0,0))(
      (t,v) => {
        (t._1+v,t._2+1)
      },
      (t1,t2) => {
        (t1._1+t2._1,t2._2+t1._2)
      }
    )
    val qq = w.mapValues{
      case (nu,ss) => {
        nu / ss
      }
    }

    qq.collect().foreach(println)

    sc.stop()
  }
}
