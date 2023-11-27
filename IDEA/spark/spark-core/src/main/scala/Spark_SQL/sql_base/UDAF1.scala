package Spark_SQL.sql_base

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.{DataFrame, Dataset, Encoder, Encoders, Row, SparkSession, TypedColumn, functions}

/**
  * @title: UDAF
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2021/12/1416:02
  */
object UDAF1 {
  def main(args: Array[String]): Unit = {
    val udf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("udf")
    val spark: SparkSession = SparkSession.builder().config(udf).getOrCreate()
    import spark.implicits._
    val df: DataFrame = spark.read.json("data/user.json")
   //SQL & DSL
    //���ڵ�UDAFǿ���;ۺϺ���ʹ��DSL�﷨����

    val ds: Dataset[User] = df.as[User]

    //��UDAF����ת��Ϊ��ѯ���ж���
    val udafCol: TypedColumn[User, Long] = new MyAvgUDAF().toColumn

    ds.select(udafCol).show()

    spark.close()

  }
  /*
  �Զ���ۺϺ����ࣺ���������ƽ��ֵ
  �̳�Aggregator,���巺��
  IN���������������User
  BUF����������
  OUT���������������Long
  ��д����(6)
  * */
  case class User(username:String,age:Long)

  case class Buff(var total:Long,var count:Long)

 class MyAvgUDAF extends Aggregator[User,Buff,Long]{
   //��ʼֵ����ֵ
   //�������ĳ�ʼ��
   override def zero: Buff = {
     Buff(0L,0L)
   }
   //������������ݸ��»�����������
   override def reduce(buff: Buff, in: User): Buff = {
     buff.total = buff.total+in.age
     buff.count = buff.count + 1
     buff
   }
  //�ϲ�������
   override def merge(buff1: Buff, buff2: Buff): Buff = {
     buff1.total = buff1.total + buff2.total
     buff1.count = buff1.count + buff2.count
     buff1
   }
  //������
   override def finish(buff: Buff): Long = {
     buff.total/buff.count
   }
  //�������ı������
   override def bufferEncoder: Encoder[Buff] = Encoders.product
  //����ı������
   override def outputEncoder: Encoder[Long] = Encoders.scalaLong
 }
}



