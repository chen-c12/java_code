package Sparksql

import org.apache.spark.SparkConf
import org.apache.spark.api.java.function
import org.apache.spark.sql.{Encoder, Encoders, SparkSession}
import org.apache.spark.sql.expressions.Aggregator

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * @title: Top3
  * @projectName spark
  * @description: TODO
  * @author 金鱼
  * @date 2021/12/1511:38
  */
object Top3Max {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("MySQL").setMaster("local[*]")
    val spark: SparkSession = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    spark.sql("use chen")

    //查询基本数据
    spark.sql(
      """
        |select
        |		a.*,
        |		p.product_name,
        |		c.area,
        |		c.city_name
        |from user_visit_action a
        |		join product_info p on a.click_product_id = p.product_id
        |		join city_info c on a.city_id = c.city_id
        |		where a.click_product_id > -1
      """.stripMargin).createOrReplaceTempView("t1")



    //根据区域，商品进行基本聚合
//    spark.udf.register("cityRemark",function.udf(CityRemarkUDAF))
      spark.sql(
        """
          |select
          |		area,
          |		product_name,
          |		count(*) as clickCnt，
          |   cityRemark(city_name) as city_remark
          |from group by area,product_name
        """.stripMargin).createOrReplaceTempView("t2")

    //区域内对点击数量进行排行
    spark.sql(
      """
        |	select
        |	*,
        |	rank() over( partition by area order by clickCnt desc) as rank
        |	from t2
      """.stripMargin).createOrReplaceTempView("t3")


    //取前三名
    spark.sql(
      """
        |select
        |	*
        |from t3 where rank <= 3
      """.stripMargin).show(false)


    spark.close()
  }

  case class Buffer(var total:Long,var cityMap:mutable.Map[String,Long])

  //自定义聚合函数，实现城市备注功能
  //继承
  //IN:城市名称
  //BUF:（总的点击数量，Map[（city,cnt）,(city,cnt)]）
  //OUT:备注信息
  class CityRemarkUDAF extends Aggregator[String,Buffer,String]{
    override def zero: Buffer = {
      Buffer(0,mutable.Map[String,Long]())
    }

    override def reduce(buff: Buffer, city: String): Buffer = {
      buff.total += 1
      val newCount = buff.cityMap.getOrElse(city,0L)+1
      buff.cityMap.update(city,newCount)
      buff
    }

    override def merge(buff1: Buffer, buff2: Buffer): Buffer = {
      val map1 = buff1.cityMap
      val map2 = buff2.cityMap

      /*map1.foldLeft(map2){
        case (map,(city,cnt)) => {
          val newCount = map.getOrElse(city,0L) + cnt
          map.update(city,newCount)
          map
        }
      }*/

      map2.foreach{
        case (city,cnt) =>{
          val newCount = map1.getOrElse(city,0L) + cnt
          map1.update(city,newCount)
        }
      }
      buff1.cityMap = map1
      buff1
    }

    //将统计结果生成字符串信息
    override def finish(buff: Buffer): String = {
      val remarkList = ListBuffer[String]()

      val totalcnt = buff.total
      val cityMap = buff.cityMap
      val cityCntList = cityMap.toList.sortWith(
        (left,rigjt) => {
          left._2 > rigjt._2
        }
      ).take(2)

      val hasMore = cityMap.size > 2
      var rsum = 0L
      cityCntList.foreach{
        case (city,cnt) => {
          val r = cnt * 100 /totalcnt
          remarkList.append(s"${city} ${r}%")
          rsum += r
        }
      }
      if (hasMore){
        remarkList.append(s"其他 ${100 - rsum}")
      }

      remarkList.mkString(",")

    }

    override def bufferEncoder: Encoder[Buffer] = Encoders.product

    override def outputEncoder: Encoder[String] = Encoders.STRING
  }
}
