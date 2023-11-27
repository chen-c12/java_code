package test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: glom
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1111:18
  */
object glom {
  def main(args: Array[String]): Unit = {
    val glom: SparkConf = new SparkConf().setMaster("local[*]").setAppName("glom")
    val sc = new SparkContext(glom)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

    val glomrdd: RDD[Array[Int]] = rdd.glom()

    val unit: RDD[Int] = glomrdd.map(
      array => array.max
    )
    println(unit.collect().sum)

    sc.stop()
  }
}
