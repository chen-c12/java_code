package Sparksql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * @title: Top3
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1511:38
  */
object Top {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("MySQL").setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    spark.sql("use chen")

    spark.sql(
      """
        |select
        |			area,
        |			product_name,
        |			count(*) as clickCnt
        |		from(
        |				select
        |					a.*,
        |					p.product_name,
        |					c.area,
        |					c.city_name
        |				from user_visit_action a
        |					join product_info p on a.click_product_id = p.product_id
        |					join city_info c on a.city_id = c.city_id
        |					where a.click_product_id > -1
        |		) t1 group by area,product_name
      """.stripMargin).show



    spark.close()
  }
}
