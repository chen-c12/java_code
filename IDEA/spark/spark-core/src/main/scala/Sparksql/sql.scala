package Sparksql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * @title: sql
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1511:16
  */
object sql {
  def main(args: Array[String]): Unit = {

    val conf: SparkConf = new SparkConf().setAppName("MySQL").setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
    import spark.implicits._

    spark.sql("show databases").show()



    spark.close()
  }
}



