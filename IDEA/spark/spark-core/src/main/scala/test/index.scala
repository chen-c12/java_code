package test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: index
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1021:59
  */
object index {

  def main(args: Array[String]): Unit = {
    val sparkconf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("index")
    val sc = new SparkContext(sparkconf)

    val value: RDD[Any] = sc.makeRDD(List(3,List(1,"chen",6,3,4),4,53,3))
      val v: RDD[List[Int]] = sc.makeRDD(List(List(2,5,3,6,3),List(2,5,2,6)))



    val dataRDD1 = value.flatMap(
      _ match {
          case list: List[_] => list
          case dat => List(dat)
        }
    )

     val map: RDD[Int] = v.flatMap(list =>list )

    dataRDD1.collect().foreach(println)
    map.collect().foreach(println)

    sc.stop()


  }

}
