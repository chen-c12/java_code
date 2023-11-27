package class1

import org.apache.spark.sql.{Dataset, Row, SaveMode, SparkSession}

object Spark_ODS {

  def extract(spark: SparkSession, from: String): Dataset[Row] = {
    val DB_URL = "jdbc:mysql://localhost:3306/olist?useSSL=false" // ���ݿ�����url
    val jdbcMap = Map(
      "url" -> DB_URL, // jdbc url
      "dbtable" -> from, // Ҫ��ȡ�����ݱ�
      "user" -> "root", // mysql�˺�
      "password" -> "admin" // mysql����
    )

    // ��ȡJDBC����Դ������DataFrame
    val df = spark.read.format("jdbc").options(jdbcMap).load()
    df
  }

  def load(spark: SparkSession, db: String, to: String, df: Dataset[Row], partitionCol: String) = {
    spark.sql(s"use $db")
    // saveAsTable()�������ὫDataFrame���ݱ��浽Hive����
    df.write
      .mode(SaveMode.Overwrite)
      .partitionBy(partitionCol)
      .format("hive")
      .saveAsTable(to) // ����
    // ʹ��DataFrameWriter��saveAsTable()���������ὫDataFrame���ݱ��浽Hive���У�����Hive metastore��ע��
  }

  // 1��ʹ��Spark��ȡMySQLָ�����ݱ��е���������Ʒ���ݵ�ODS���ָ���ķ�������
  def task0201(spark: SparkSession) = {
    // 1.1 ��mysql���г�ȡ����
    val productsDF = extract(spark, "products")

    // 1.2 ���ص�hive����
    load(spark, "olist", "products", productsDF, "product_category_name")

    // 1.3 ����etl�Ƿ�ɹ�
    spark.table("products").show(5)

    // Ҳ������������etl�Ƿ�ɹ�
    // spark.sql("select * from olist.products limit 5").show(5)
  }

}
