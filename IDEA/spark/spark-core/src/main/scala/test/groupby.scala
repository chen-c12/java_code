package test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: groupby
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2021/12/1111:38
  */
object groupby {
  def main(args: Array[String]): Unit = {
    val glom: SparkConf = new SparkConf().setMaster("local[*]").setAppName("glom")
    val sc = new SparkContext(glom)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)





    sc.stop()
  }
}
