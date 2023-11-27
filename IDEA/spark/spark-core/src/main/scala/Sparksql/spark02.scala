package Sparksql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * @title: spark02
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2022/1/516:52
  */
object spark02 {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME","root")
    val sparkbulider: SparkSession.Builder = SparkSession.builder()
    if ((args.length>0&&args(0).equals("local"))||args.length==0){
        sparkbulider.master("local[*]")
    }
    val spark: SparkSession = sparkbulider.appName("mysql")
      .config("hive.metastore.uris", "thrift://hadoop002:9083")
      .config("spark.sql.warehouse.dir", "hdfs://hadoop001//user/hive_remote/warehouse")
      .enableHiveSupport()
      .getOrCreate()

    spark.read.format("jdbc")
        .option("url","jdbc:mysql://hadoop001:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false")
        .option("driver","com.mysql.jdbc.driver")
        .option("user","root")
        .option("password","123456")
        .option("dbtable","dd").load().createTempView("temp")

    spark.sql("show databases").show()
    spark.sql("use chen")

//    spark.sql(
//      s"""
//         |create table if not exists score2
//         |(
//         |name string,
//         |object string
//         |)
//         |partitioned by(score int)
//         |row format delimited fields terminated by "\t"
//       """.stripMargin)

      spark.sql(
        """
          |set hive.exec.dynamic.partition.mode=nonstrict
          |set hive.exec.dynamic.partition=true
        """.stripMargin)


    //     spark.sql(
    //       s"""
    //          |create table if not exists score3
    //          |(
    //          |name string,
    //          |subject string
    //          |)
    //          |partitioned by (score int)
    //          |row format delimited fields terminated by ","
    //        """.stripMargin)




    /*数据插入*/
    //
    //     spark.sql(
    //       s"""
    //          |insert into table chen.score3 partition (score='84')
    //          |select name,object from temp_table
    //        """.stripMargin)




    spark.sql(
      """
        |insert into table score2
        |select name,object,score
        |from score
      """.stripMargin).show()


















    spark.close()
  }
}
