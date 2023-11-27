package test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.immutable

/**
  * @title: group
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1023:16
  */
object group {
  def main(args: Array[String]): Unit = {
    val group: SparkConf = new SparkConf().setMaster("local[*]").setAppName("group")
    val sc = new SparkContext(group)

    val gro: RDD[String] = sc.makeRDD(List("Hello", "hive", "hbase", "Hadoop"))

     val unit: RDD[(Char, Iterable[String])] = gro.groupBy(_.charAt(0))

    unit.collect().foreach(println)

  }
}
