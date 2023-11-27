package test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: apache
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1016:41
  */
object apache {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("apache")
    val sc = new SparkContext(sparkConf)

    val lines:RDD[String] =  sc.textFile("data/apache.log")
    val unit: RDD[String] = lines.map(
      line => {
        val strings = line.split(" ")
        strings(6)
      }
    )
     unit.collect().foreach(println)

  sc.stop()

  }
}
