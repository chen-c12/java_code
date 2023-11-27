package scala01

import scala.collection.mutable

/**
  * @title: map
  * @projectName Scala
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/814:56
  */
object map {
  def main(args: Array[String]): Unit = {
    val map = List(22,42,63,87,11,63,66,67)

    val map1 = map.filter((elem :Int) => (elem % 2 ==0))
    val map2 = map.filter(_ % 2 == 0)
    println(map1)
    println(map2)


    val strings = List("Hello World","Hello Scala","Hello string")
    val string1 = strings.map(String => (String.split(" ")))
    val string2 = strings.map(_ .split(" "))
    val flatten = string2.flatten
    println(flatten)

    val string3 = strings.flatMap(_.split(" "))
    println(string3)

    val map3 = map.groupBy(_%2)
    println(map3)

    val map4 = Map(("a",1),("b",2),"c"->3,"d"->4)
    var map5 = mutable.Map(("a",1),("b",4),"c"->3,"d"->4,"e"->1)

    val map7 = map4.foldLeft(map5)(
      (memap, kv) => {
        val key = kv._1
        val value = kv._2
        memap(key) = memap.getOrElse(key,0) + value
        memap
      }
    )
    println(map7)

  }
}
