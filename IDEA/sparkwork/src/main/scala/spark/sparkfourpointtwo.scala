package spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: sparkfourpointtwo
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2022/4/812:04
  */
object sparkfourpointtwo {
  def main(args: Array[String]): Unit = {
    //1.env/׼��sc/SparkContext/Spark������ִ�л���
    val conf: SparkConf = new SparkConf().setAppName("wc").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("WARN")

    //2.source/��ȡ����
    val lines: RDD[String] = sc.textFile("data/word.txt")

    //3.transformation/���ݲ���/ת��
    //�и�:RDD[һ�����ĵ���]
    val words: RDD[String] = lines.flatMap(_.split(" "))
    //��Ϊ1:RDD[(����, 1)]
    val wordAndOnes: RDD[(String, Int)] = words.map((_,1))
    val result: RDD[(String, Int)] = wordAndOnes.reduceByKey(_+_)
    //ֱ�����
    result.foreach(println)
    //�����ָ��path(�������ļ�/��)
    result.repartition(1).saveAsTextFile("data/result")

    //Ϊ�˱��ڲ鿴Web-UI�����ó���
    Thread.sleep(1000 * 60)
    //5.�ر���Դ
    sc.stop()
  }
}
