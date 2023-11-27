package test

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * @title: groupbyapa
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1111:51
  */
object groupbyapa {
  def main(args: Array[String]): Unit = {
    val glom: SparkConf = new SparkConf().setMaster("local[*]").setAppName("glom")
    val sc = new SparkContext(glom)

    val value: RDD[String] = sc.textFile("data/apache.log")

    val ss = value.map(
      line =>{
        val strings: Array[String] = line.split(" ")
        val str: String = strings(3)
        val format = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss")
        val date: Date = format.parse(str)
        val sdf1 = new SimpleDateFormat("HH")
        val hour = sdf1.format(date)
        (hour,1)
      }
    ).groupBy(_._1)

    ss.map{
      case (hour ,iter) =>{
        (hour,iter.size)
      }
    }.collect().foreach(println)


    sc.stop()
  }
}
