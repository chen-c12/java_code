package all

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * @title: hive
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2022/1/117:23
  */
object hive {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("hive-mysql")
    val spark: SparkSession = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    spark.sql("use chen")

    /*mysql����*/
    spark.read.format("jdbc").option("url", "jdbc:mysql://127.0.0.1:3306/book")//ָ������mysql�µ�text���ݿ�
      .option("driver", "com.mysql.jdbc.Driver")//driverָ��mysql������ʽΪjdbc
      .option("user", "root")//mysql�û�
      .option("password", "123456")//mysql������
      .option("dbtable", "t_user").load()//ָ�����

    spark.sql("show databases").show()

    spark.close()

  }
}

