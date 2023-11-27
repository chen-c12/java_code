package Spark_SQL.sql_base

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.{DataFrame, Dataset, Encoder, Encoders, Row, SparkSession, TypedColumn, functions}

/**
  * @title: UDAF
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/1416:02
  */
object UDAF1 {
  def main(args: Array[String]): Unit = {
    val udf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("udf")
    val spark: SparkSession = SparkSession.builder().config(udf).getOrCreate()
    import spark.implicits._
    val df: DataFrame = spark.read.json("data/user.json")
   //SQL & DSL
    //早期的UDAF强类型聚合函数使用DSL语法操作

    val ds: Dataset[User] = df.as[User]

    //将UDAF函数转换为查询的列对象
    val udafCol: TypedColumn[User, Long] = new MyAvgUDAF().toColumn

    ds.select(udafCol).show()

    spark.close()

  }
  /*
  自定义聚合函数类：计算年龄的平均值
  继承Aggregator,定义泛型
  IN：输入的数据类型User
  BUF：缓冲区的
  OUT：输出的数据类型Long
  重写方法(6)
  * */
  case class User(username:String,age:Long)

  case class Buff(var total:Long,var count:Long)

 class MyAvgUDAF extends Aggregator[User,Buff,Long]{
   //初始值或零值
   //缓冲区的初始化
   override def zero: Buff = {
     Buff(0L,0L)
   }
   //根据输入的数据跟新缓冲区的数据
   override def reduce(buff: Buff, in: User): Buff = {
     buff.total = buff.total+in.age
     buff.count = buff.count + 1
     buff
   }
  //合并缓冲区
   override def merge(buff1: Buff, buff2: Buff): Buff = {
     buff1.total = buff1.total + buff2.total
     buff1.count = buff1.count + buff2.count
     buff1
   }
  //计算结果
   override def finish(buff: Buff): Long = {
     buff.total/buff.count
   }
  //缓冲区的编码操作
   override def bufferEncoder: Encoder[Buff] = Encoders.product
  //输出的编码操作
   override def outputEncoder: Encoder[Long] = Encoders.scalaLong
 }
}



