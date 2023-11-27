package Sparksql

import org.apache.spark.sql.{DataFrame, SparkSession}

object spark03 {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME","root")
    val sparkbuilder: SparkSession.Builder = SparkSession.builder()
    if((args.length>0&&args(0).equals("local"))||args.length == 0){
      sparkbuilder.master("local[*]")
    }
    val spark: SparkSession = sparkbuilder.appName("hive-jdbc")
      .config("hive.metastore.uris", "thrift://hadoop002:9083")
      .config("spark.sql.warehouse.dir", "hdfs://hadoop001//user/hive_remote/warehouse")
      .enableHiveSupport()
      .getOrCreate()

    spark.read.format("jdbc")
      .option("url","jdbc:mysql://hadoop001:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false")
//      .option("driver","com.mysql.jdbc.driver")
      .option("user","root")
      .option("password","123456")
      .option("dbtable","acc").load()
      .createTempView("www")

    spark.sql("use chen")
    spark.sql("show databases")

//    spark.sql(
//      s"""
//         |create table acc(id string,date string,acc int)
//         |row format delimited fields terminated by "\t"
//       """.stripMargin)


    spark.sql(
      """
        |insert into table acc
        |select * from www
      """.stripMargin)








    spark.close()
  }


}
