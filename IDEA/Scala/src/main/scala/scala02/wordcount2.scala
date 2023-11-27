package scala02

/**
  * @title: wordcount2
  * @projectName Scala
  * @description: TODO
  * @author ����
  * @date 2021/12/99:58
  */
object wordcount2 {
  def main(args: Array[String]): Unit = {
    val word = List(
      ("hello world",3),
      ("hello scala",4),
      ("hello flink",1),
      ("hello spark from scala",2),
      ("big",5)
    )
    /*ʹ��������ÿһ�Եĵ�һ��ʹ��split�ָ�����ʹ��map���������������*/
    val tuples: List[(String, Int)] = word.flatMap(
      w => {
        val strings: Array[String] = w._1.split(" ")
        strings.map(word => (word, w._2))
      }
    )
    println(tuples)

    /*��tuples���з��飬�Լ�ֵ�Ե�һ��Ϊ��׼*/
    val stringToTuples: Map[String, List[(String, Int)]] = tuples.groupBy(_._1)
    println(stringToTuples)

    /*��mapValues���valueֵ���������value�������*/
    val stringToInt: Map[String, Int] = stringToTuples.mapValues(
      ww => ww.map(_._2).sum
    )
    println(stringToInt)

    /*ת��list��������*/
    val list: List[(String, Int)] = stringToInt.toList
    println(list)
    val tuple1: List[(String, Int)] = list.sortWith(_._2>_._2)
    println(tuple1)

  }
}
