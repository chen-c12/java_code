package RDDcenter

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: RDD
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2021/12/1210:47
  */
object RDD {
  def main(args: Array[String]): Unit = {
    val rdd: SparkConf = new SparkConf().setMaster("local[*]").setAppName("rdd")
    val sc = new SparkContext(rdd)

    /*�õ�����*/
    val dataRDD: RDD[String] = sc.textFile("data/agent.log")

    /*��ȡ����*/
    val mapRDD: RDD[((String, String), Int)] = dataRDD.map(
      line => {
        val datas = line.split(" ")
        ((datas(1), datas(4)), 1)
      }
    )

    /*�����ݳ��ִ������*/
    val reduceRDD: RDD[((String, String), Int)] = mapRDD.reduceByKey(_+_)

    /*�����ݸ�ʽת��*/
    val newmapRDD: RDD[(String, (String, Int))] = reduceRDD.map {
      case (kv, nu) => (kv._1, (kv._2, nu))
    }

    /*��ʡ�ݽ��з���*/
    val groupRDD: RDD[(String, Iterable[(String, Int)])] = newmapRDD.groupByKey()

    /*�Թ��������������ȡǰ��*/
    val resultRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
      iter => {
        iter.toList.sortWith(_._2 > _._2).take(3)
      }
    )

    resultRDD.collect().foreach(println)

    sc.stop()
  }

}
