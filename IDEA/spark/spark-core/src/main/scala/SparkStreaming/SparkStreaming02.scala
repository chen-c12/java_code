package SparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable
import scala.util.Random

/**
  * @title: SparkStreaming
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2021/12/168:28
  */
object SparkStreaming02 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("diy").setMaster("local[*]")
    val streaming = new StreamingContext(conf,Seconds(5))

    val messageDS: ReceiverInputDStream[String] = streaming.receiverStream(new MyReceiver())
    messageDS.print()

    streaming.start()
    streaming.awaitTermination()
  }

  //�Զ������ݲɼ���
  //1.�̳�Receiver�����巺��,���ݲ���
  //��д����
  //

  class MyReceiver extends Receiver[String](StorageLevel.MEMORY_ONLY){
    private var flg = true

    override def onStart(): Unit = {

      new Thread(new Runnable {
        override def run(): Unit = {
          while (flg) {

            val message = "�ɼ�������Ϊ��"+new Random().nextInt(10).toString

            store(message)

            Thread.sleep(500)
          }
        }
      }).start()

    }

    override def onStop(): Unit = {

      flg = false;

    }
  }
}



