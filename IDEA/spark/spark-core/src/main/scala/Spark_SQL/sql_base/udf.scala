package Spark_SQL.sql_base

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * @title: udf
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1415:46
  */
object udf {
  def main(args: Array[String]): Unit = {
    val udf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("udf")
    val spark: SparkSession = SparkSession.builder().config(udf).getOrCreate()

    val df: DataFrame = spark.read.json("data/user.json")
    df.createOrReplaceTempView("user")

    spark.udf.register("prefixname",(name:String) => {
      "Name: " + name
    })

    spark.sql("select age,prefixname(username) from user").show()





    spark.close()

  }
}
