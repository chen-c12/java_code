package RDDcenter

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

/**
  * @title: Part
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2021/12/1217:29
  */
object Part {
  def main(args: Array[String]): Unit = {
    val rdd: SparkConf = new SparkConf().setMaster("local[*]").setAppName("rdd")
    val sc = new SparkContext(rdd)

    val rddpart: RDD[(String, String)] = sc.makeRDD(List(
      ("nba", "xxxxxxx"),
      ("cba", "xxxxxxx"),
      ("wnba", "xxxxxxx"),
      ("nba", "xxxxxxx")
    ))
    val partRDD: RDD[(String, String)] = rddpart.partitionBy(new MyPartitioner)

    partRDD.saveAsTextFile("output")

    sc.stop()
  }
  class MyPartitioner extends Partitioner{
    //��������
    override def numPartitions: Int = 3

    //�������ݵ�keyֵ���ط������ڵ��������������ݵķ������������㿪ʼ��
    override def getPartition(key: Any): Int = {

      key match {
        case "nba" => 0
        case  "wnba" =>1
        case  _ => 2
      }

//      if(key == "nba"){
//        0
//      }else if(key == "wnba"){
//        1
//      }else if(key == "cba"){
//        2
//      }else {
//        2
//      }
    }
  }
}
