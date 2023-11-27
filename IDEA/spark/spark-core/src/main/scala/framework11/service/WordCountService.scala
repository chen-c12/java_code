package framework11.service

import framework11.dao.WordCountDao
import org.apache.spark.rdd.RDD

/**
  * @title: WordCountService
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/1321:52
  */
class WordCountService {
  private val wordCountDao = new WordCountDao()


  //数据分析
  def dataAnalysis() = {

    val lines =  wordCountDao.readFile("data/word.txt")

    val words: RDD[String] = lines.flatMap(_.split(" "))

    val value: RDD[(String, Int)] = words.map((_,1))

    val wordcount1: RDD[(String, Int)] = value.reduceByKey(_+_)

    val array: Array[(String, Int)] = wordcount1.collect()

    array
  }
}
