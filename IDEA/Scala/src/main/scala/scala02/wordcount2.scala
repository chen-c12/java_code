package scala02

/**
  * @title: wordcount2
  * @projectName Scala
  * @description: TODO
  * @author 金鱼
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
    /*使用数组中每一对的第一个使用split分隔，再使用map函数重新组成数组*/
    val tuples: List[(String, Int)] = word.flatMap(
      w => {
        val strings: Array[String] = w._1.split(" ")
        strings.map(word => (word, w._2))
      }
    )
    println(tuples)

    /*对tuples进行分组，以键值对第一个为标准*/
    val stringToTuples: Map[String, List[(String, Int)]] = tuples.groupBy(_._1)
    println(stringToTuples)

    /*用mapValues提出value值，对里面的value进行相加*/
    val stringToInt: Map[String, Int] = stringToTuples.mapValues(
      ww => ww.map(_._2).sum
    )
    println(stringToInt)

    /*转成list进行排序*/
    val list: List[(String, Int)] = stringToInt.toList
    println(list)
    val tuple1: List[(String, Int)] = list.sortWith(_._2>_._2)
    println(tuple1)

  }
}
