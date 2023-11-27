package RDDcenter

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
  * @title: Bc
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/139:26
  */
object Bc {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("Bc").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val list1: RDD[(String, Int)] = sc.makeRDD(List(
      ("a", 2), ("b", 4), ("c", 6)
    ))
//    val list2: RDD[(String, Int)] = sc.makeRDD(List(
//      ("a", 4), ("b", 1), ("c", 3)
//    ))
    
    val map: mutable.Map[String, Int] = mutable.Map(("a", 4), ("b", 1), ("c", 3))

    list1.map{
      case (w,c) => {
        val l: Int = map.getOrElse(w,0)
        (w,(c,l))
      }
    }.collect().foreach(println)

    sc.stop()
  }
}
