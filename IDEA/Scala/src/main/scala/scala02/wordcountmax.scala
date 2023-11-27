package scala02

/**
  * @title: wordcountmax
  * @projectName Scala
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/99:32
  */
object wordcountmax {
  def main(args: Array[String]): Unit = {
    val word = List(
      ("hello world",3),
      ("hello scala",4),
      ("hello flink",1),
      ("hello spark from scala",2)
    )

    val tuples: List[(String, Int)] = word.flatMap(
      tuple => {
        val t1 = tuple._1.split(" ")
        t1.map(word => (word, tuple._2))
      }
    )
    val stringToTuples: Map[String, List[(String, Int)]] = tuples.groupBy(_._1)

    val stringToInt: Map[String, Int] = stringToTuples.mapValues(
      tupleList => tupleList.map(_._2).sum
    )
    val wordcount1: List[(String, Int)] = stringToInt.toList.sortWith(_._2 > _._2)
    val wordcount: List[(String, Int)] = stringToInt.toList.sortWith(_._2 > _._2).take(3)

    println(wordcount)
    println(wordcount1)

  }
}
