package scala02

/**
  * @title: wordcount
  * @projectName Scala
  * @description: TODO
  * @author ½ğÓã
  * @date 2021/12/98:54
  */
object wordcount {
  def main(args: Array[String]): Unit = {
    val word = List(
      "hello world",
      "hello scala",
      "hello flink",
      "hello spark from scala"
    )

    val strings: List[String] = word.flatMap(_.split(" "))
    val stringToStrings: Map[String, List[String]] = strings.groupBy(word => word)
    val stringToInt: Map[String, Int] = stringToStrings.map(kv => (kv._1,kv._2.length))
    val list: List[(String, Int)] = stringToInt.toList
      .sortWith(_._2>_._2)
      .take(3)

    println(list)
  }
}
