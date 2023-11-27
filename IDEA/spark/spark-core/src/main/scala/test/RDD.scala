package test

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: RDD
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1014:54
  */
object RDD {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(
      List(1,5,23,7)
    )

    rdd.saveAsObjectFile("output")

    sc.stop()

  }
}
