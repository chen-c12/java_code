package Spark_SQL.sql_base

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

/**
  * @title: base
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1414:58
  */
object base {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("sql").setMaster("local[*]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    import  spark.implicits._



    val df: DataFrame = spark.read.json("data/user.json")

    df.createOrReplaceTempView("user")

    //SQL
    spark.sql("select * from user").show()
    spark.sql("select avg(age) from user").show()

    //DSL
    df.select("age","username").show()
    df.select('age + 1).show()

    //DataSet
    val seq = Seq(1,2,3,4)
    val ds: Dataset[Int] = seq.toDS()
    ds.show()

    val rdd = spark.sparkContext.makeRDD(List((1,"zhangsan",30),(2,"lisi",40)))

    val df1: DataFrame = rdd.toDF("id","name","age")
    val rowRDD: RDD[Row] = df1.rdd

    val ds1: Dataset[User] = df1.as[User]
    val df2: DataFrame = ds.toDF()

    val ds2: Dataset[User] = rdd.map {
      case (id, name, age) => {
        User(id, name, age)
      }
    }.toDS()

    val userRDD = df2.rdd







    spark.close()
  }

  case class User(id:Int,name:String,age:Int)
}
