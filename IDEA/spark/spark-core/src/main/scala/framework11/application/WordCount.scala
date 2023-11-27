package framework11.application

import framework11.controller.WordCountController
import org.apache.spark.{SparkConf, SparkContext}


/**
  * @title: WordCount
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/1321:51
  */
object WordCount extends App{

  //启动应用程序
  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wc")
  val sc = new SparkContext(sparkConf)

  val controller = new WordCountController()
  controller.execute()

  sc.stop()

}
