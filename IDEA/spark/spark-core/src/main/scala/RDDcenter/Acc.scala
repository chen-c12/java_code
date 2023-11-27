package RDDcenter

import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.OL
import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
  * @title: Acc
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2021/12/138:49
  */
object Acc {
  def main(args: Array[String]): Unit = {
    val acc: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Acc")
    val sc = new SparkContext(acc)

    val listRDD: RDD[String] = sc.makeRDD(List("Hello","Spark","Hello"))

    val myacc = new MyAcc()
    val wordcount: Unit = sc.register(myacc,"wordcount")

    listRDD.foreach(
      word => {
        myacc.add(word)
      }
    )

    println(myacc.value)

    sc.stop()
  }
class MyAcc extends AccumulatorV2[String,mutable.Map[String,Long]]{

  private var wcMap = mutable.Map[String,Long]()

  //�ж��Ƿ�Ϊ��ʼ״̬
  override def isZero: Boolean = {
    wcMap.isEmpty
  }

  override def copy(): AccumulatorV2[String, mutable.Map[String, Long]] = {
    new MyAcc()
  }

  override def reset(): Unit = {
    wcMap.clear()
  }

  //��ȡ�ۼ�����Ҫ��ֵ
  override def add(word: String): Unit = {
     val newCnt = wcMap.getOrElse(word,0L) + 1
    wcMap.update(word,newCnt)
  }

  //Driver�ϲ��ۼ���
  override def merge(other: AccumulatorV2[String, mutable.Map[String, Long]]): Unit = {

    val map1 = this.wcMap
    val map2 = other.value

    map2.foreach{
      case (word,count) => {
      val newCount = map1.getOrElse(word,0L) + count
        map1.update(word,newCount)
      }
    }
  }

  //�ۼ������
  override def value: mutable.Map[String, Long] = {
    wcMap
  }
}
}
