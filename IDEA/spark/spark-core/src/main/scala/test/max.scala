package test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: max
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1017:08
  */
object max {
  def main(args: Array[String]): Unit = {
    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("max")
    val sc = new SparkContext(sparkconf)

    val unit: RDD[Int] = sc.makeRDD(List(1,2,4,6,7,8),2)

    val value: RDD[Int] = unit.mapPartitions(
      iterator => {
        List(iterator.max).iterator
      }
    )
    value.collect().foreach(println)

    sc.stop()
  }

}
