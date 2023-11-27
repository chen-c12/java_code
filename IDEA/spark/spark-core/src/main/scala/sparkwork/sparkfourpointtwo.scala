package sparkwork

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @title: sparkfourpointtwo
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2022/4/812:04
  */
object sparkfourpointtwo {
  def main(args: Array[String]): Unit = {
    //1.env/准备sc/SparkContext/Spark上下文执行环境
    val conf: SparkConf = new SparkConf().setAppName("wc").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("WARN")

    //2.source/读取数据
    val lines: RDD[String] = sc.textFile("data/word.txt")

    //3.transformation/数据操作/转换
    //切割:RDD[一个个的单词]
    val words: RDD[String] = lines.flatMap(_.split(" "))
    //记为1:RDD[(单词, 1)]
    val wordAndOnes: RDD[(String, Int)] = words.map((_,1))
    val result: RDD[(String, Int)] = wordAndOnes.reduceByKey(_+_)
    //直接输出
    result.foreach(println)
    //输出到指定path(可以是文件/夹)
    result.repartition(1).saveAsTextFile("data/result")

    //为了便于查看Web-UI可以让程序
    Thread.sleep(1000 * 60)
    //5.关闭资源
    sc.stop()
  }
}
