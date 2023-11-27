package RDDcenter

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: RDD
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/1210:47
  */
object RDD {
  def main(args: Array[String]): Unit = {
    val rdd: SparkConf = new SparkConf().setMaster("local[*]").setAppName("rdd")
    val sc = new SparkContext(rdd)

    /*得到数据*/
    val dataRDD: RDD[String] = sc.textFile("data/agent.log")

    /*抽取数据*/
    val mapRDD: RDD[((String, String), Int)] = dataRDD.map(
      line => {
        val datas = line.split(" ")
        ((datas(1), datas(4)), 1)
      }
    )

    /*对数据出现次数相加*/
    val reduceRDD: RDD[((String, String), Int)] = mapRDD.reduceByKey(_+_)

    /*对数据格式转换*/
    val newmapRDD: RDD[(String, (String, Int))] = reduceRDD.map {
      case (kv, nu) => (kv._1, (kv._2, nu))
    }

    /*以省份进行分类*/
    val groupRDD: RDD[(String, Iterable[(String, Int)])] = newmapRDD.groupByKey()

    /*对广告点击量进行排序取前三*/
    val resultRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      iter => {
        iter.toList.sortWith(_._2 > _._2).take(3)
      }
    )

    resultRDD.collect().foreach(println)

    sc.stop()
  }

}
