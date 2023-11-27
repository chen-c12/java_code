package Sparksql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * @title: test
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1511:02
  */
object test {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("MySQL").setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
    import spark.implicits._

    spark.sql("use chen")

   spark.sql(
     """
       |CREATE TABLE `user_visit_action`(
       | `date` string,
       | `user_id` bigint,
       | `session_id` string,
       | `page_id` bigint,
       | `action_time` string,
       | `search_keyword` string,
       | `click_category_id` bigint,
       | `click_product_id` bigint,
       | `order_category_ids` string,
       | `order_product_ids` string,
       | `pay_category_ids` string,
       | `pay_product_ids` string,
       | `city_id` bigint)
       |row format delimited fields terminated by '\t'
     """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'datas/user_visit_action.txt' into table user_visit_action
      """.stripMargin)

    spark.sql(
      """
        |CREATE TABLE `product_info`(
        | `product_id` bigint,
        | `product_name` string,
        | `extend_info` string)
        |row format delimited fields terminated by '\t'
      """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'datas/product_info.txt' into table product_info
      """.stripMargin)

    spark.sql(
      """
        |CREATE TABLE `city_info`(
        | `city_id` bigint,
        | `city_name` string,
        | `area` string)
        |row format delimited fields terminated by '\t'
      """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'datas/city_info.txt' into table city_info

      """.stripMargin)


    spark.sql("""select * from city_info""").show

    spark.close()
  }
}
