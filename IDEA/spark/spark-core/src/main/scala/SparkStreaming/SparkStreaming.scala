package SparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @title: SparkStreaming
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/168:28
  */
object SparkStreaming {
  def main(args: Array[String]): Unit = {

    //TODO:创建环境对象
    //Streaming创建时，需要传递两个参数
    //第一个参数表示环境配置
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")

    //第二个参数表示批量处理的周期(采集周期)
    val ssc = new StreamingContext(sparkConf,Seconds(3))


    //TODO:逻辑处理
    //获取端口数据
    val lines: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val word: DStream[String] = lines.flatMap(_.split(" "))

    val wordToOne: DStream[(String, Int)] = word.map((_,1))

    val wordCount: DStream[(String, Int)] = wordToOne.reduceByKey(_+_)

    wordCount.print()

   // 由于SparkStreaming采集器是长期执行的任务，所有不能直接关闭
    //如果main方法执行完毕，所以程序也会自动结束。所以不能让main执行完毕
//    ssc.stop()
    //1.启动采集器
    ssc.start()
    //2.等待采集器的关闭
    ssc.awaitTermination()
    //

  }
}
