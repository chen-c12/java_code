package Spark_SQL.sql_base

import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * @title: Hive
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/1510:11
  */
object Hive {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("MySQL").setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    //读取mysql数据
    val  df = spark.read
      .format("jdbc")
      .option("url","jdbc:mysql://hadoop001:3306/test")
      .option("driver","com.mysql.jdbc.Driver")
      .option("user","root")
      .option("password","123456")
      .option("dbtable","chen")
      .load()

    //df.show

    df.write
      .format("jdbc")
      .option("url","jdbc:mysql://hadoop001:3306/test")
      .option("driver","com.mysql.jdbc.Driver")
      .option("user","root")
      .option("password","123456")
      .option("dbtable","user")
      .mode(SaveMode.Append)
      .save()



    spark.close()
  }
}
