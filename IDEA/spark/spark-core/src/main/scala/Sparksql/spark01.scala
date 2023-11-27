package Sparksql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object spark01 {
   def main(args: Array[String]): Unit = {
      System.setProperty("HADOOP_USER_NAME", "root")
     val sparkBuilder = SparkSession.builder()
     if ((args.length > 0 && args(0).equals("local")) || args.length == 0) {
       sparkBuilder.master("local[*]")
     }
     val spark = sparkBuilder.appName("demo_e")
       .config("hive.metastore.uris", "thrift://hadoop002:9083")//指定hive的metastore服务地址
       .config("spark.sql.warehouse.dir", "hdfs://hadoop001//user/hive_remote/warehouse")
       .enableHiveSupport()
       .getOrCreate()

      /**
        * 连接mysql
        **/
     val mysql: DataFrame = spark.read.format("jdbc")
       .option("url", "jdbc:mysql://hadoop001:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false") //mysql url
       .option("driver", "com.mysql.jdbc.Driver") //mysql driver
       .option("user", "root") //mysql user
       .option("password", "123456") //mysql password
       .option("dbtable", "dd").load()

     spark.sql("use chen")


    mysql.write.mode("overwrite").partitionBy("score").saveAsTable("score1")


     spark.sql("show databases").show()

     spark.close()
    }


}
