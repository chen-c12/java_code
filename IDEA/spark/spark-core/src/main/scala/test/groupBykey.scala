package test

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * @title: groupBykey
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1117:30
  */
object groupBykey {
  def main(args: Array[String]): Unit = {
    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("max")
    val sc = new SparkContext(sparkconf)

    val unit: RDD[String] = sc.makeRDD(List("a","w","a","c","w","a"))

    val value: RDD[(String, Int)] = unit.map((_,1))

    val group: RDD[(String, Iterable[Int])] = value.groupByKey()


      group.collect().foreach(println)

    sc.stop()
  }
}
