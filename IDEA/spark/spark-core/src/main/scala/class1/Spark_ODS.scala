package class1

import org.apache.spark.sql.{Dataset, Row, SaveMode, SparkSession}

object Spark_ODS {

  def extract(spark: SparkSession, from: String): Dataset[Row] = {
    val DB_URL = "jdbc:mysql://localhost:3306/olist?useSSL=false" // 数据库连接url
    val jdbcMap = Map(
      "url" -> DB_URL, // jdbc url
      "dbtable" -> from, // 要读取的数据表
      "user" -> "root", // mysql账号
      "password" -> "admin" // mysql密码
    )

    // 读取JDBC数据源，创建DataFrame
    val df = spark.read.format("jdbc").options(jdbcMap).load()
    df
  }

  def load(spark: SparkSession, db: String, to: String, df: Dataset[Row], partitionCol: String) = {
    spark.sql(s"use $db")
    // saveAsTable()方法：会将DataFrame数据保存到Hive表中
    df.write
      .mode(SaveMode.Overwrite)
      .partitionBy(partitionCol)
      .format("hive")
      .saveAsTable(to) // 覆盖
    // 使用DataFrameWriter的saveAsTable()方法，它会将DataFrame数据保存到Hive表中，并在Hive metastore中注册
  }

  // 1）使用Spark抽取MySQL指定数据表中的新增的商品数据到ODS层的指定的分区表中
  def task0201(spark: SparkSession) = {
    // 1.1 从mysql表中抽取数据
    val productsDF = extract(spark, "products")

    // 1.2 加载到hive表中
    load(spark, "olist", "products", productsDF, "product_category_name")

    // 1.3 测试etl是否成功
    spark.table("products").show(5)

    // 也可以这样测试etl是否成功
    // spark.sql("select * from olist.products limit 5").show(5)
  }

}
