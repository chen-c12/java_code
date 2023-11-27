package test

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * @title: dis
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1115:20
  */
object dis {
  def main(args: Array[String]): Unit = {
    val glom: SparkConf = new SparkConf().setMaster("local[*]").setAppName("dis")
    val sc = new SparkContext(glom)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,2,6,1))



   val value: RDD[Int] = rdd.distinct()
    value.collect().foreach(println)

    sc.stop()
  }
}
