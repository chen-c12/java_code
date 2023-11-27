package all

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * @title: hive
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2022/1/117:23
  */
object hive {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("hive-mysql")
    val spark: SparkSession = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    spark.sql("use chen")

    /*mysql连接*/
    spark.read.format("jdbc").option("url", "jdbc:mysql://127.0.0.1:3306/book")//指定本地mysql下的text数据库
      .option("driver", "com.mysql.jdbc.Driver")//driver指定mysql驱动形式为jdbc
      .option("user", "root")//mysql用户
      .option("password", "123456")//mysql的密码
      .option("dbtable", "t_user").load()//指定表格

    spark.sql("show databases").show()

    spark.close()

  }
}

