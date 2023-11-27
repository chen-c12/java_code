package scala01

import scala.collection.mutable.ArrayBuffer

/**
  * @title: Sep
  * @projectName Scala
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/716:01
  */
object Sep {
  def main(args: Array[String]): Unit = {
    val sep = new Array[Int](5)
    val arr = Array(10,22,44,55,26)

    for (i <- arr)println(i)
    println(arr.mkString(","))

    val arr1 = 30 +: arr :+ 10
    println(arr1.mkString(" "))

    val arr2 = ArrayBuffer(22,545,25)
    println(arr2.mkString(","))
    for (i <- arr2)
    print(i)


    val array: Array[Array[Int]] = Array.ofDim[Int](2,3)
  }
}




