package Spark_SQL.sql_base

import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * @title: MySQL
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/158:49
  */
object MySQL {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("MySQL").setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    //使用sparkSQL连接外置的hive
    //拷贝hive-site.xml到配置文件中
    //启用Hive支持
    //增加对应的依赖关系（包含MySQL驱动）

    spark.sql("show tables").show

    spark.close()
  }
}














