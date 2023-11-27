package Spark_SQL.sql_base

import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * @title: MySQL
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2021/12/158:49
  */
object MySQL {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("MySQL").setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    //ʹ��sparkSQL�������õ�hive
    //����hive-site.xml�������ļ���
    //����Hive֧��
    //���Ӷ�Ӧ��������ϵ������MySQL������

    spark.sql("show tables").show

    spark.close()
  }
}














