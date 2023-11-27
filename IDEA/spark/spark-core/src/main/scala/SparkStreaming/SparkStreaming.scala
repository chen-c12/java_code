package SparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @title: SparkStreaming
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2021/12/168:28
  */
object SparkStreaming {
  def main(args: Array[String]): Unit = {

    //TODO:������������
    //Streaming����ʱ����Ҫ������������
    //��һ��������ʾ��������
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")

    //�ڶ���������ʾ�������������(�ɼ�����)
    val ssc = new StreamingContext(sparkConf,Seconds(3))


    //TODO:�߼�����
    //��ȡ�˿�����
    val lines: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)

    val word: DStream[String] = lines.flatMap(_.split(" "))

    val wordToOne: DStream[(String, Int)] = word.map((_,1))

    val wordCount: DStream[(String, Int)] = wordToOne.reduceByKey(_+_)

    wordCount.print()

   // ����SparkStreaming�ɼ����ǳ���ִ�е��������в���ֱ�ӹر�
    //���main����ִ����ϣ����Գ���Ҳ���Զ����������Բ�����mainִ�����
//    ssc.stop()
    //1.�����ɼ���
    ssc.start()
    //2.�ȴ��ɼ����Ĺر�
    ssc.awaitTermination()
    //

  }
}
