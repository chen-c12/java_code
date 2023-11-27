package com.ddd.spark.core

/**
  * @title: test
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/11/2922:41
  */
object test {
  def main(args: Array[String]): Unit = {
    println("hello spark!")

//    for(i <- 1 to 9 ; j <- 1 to i){
//      print(s"$j * $i = ${i*j} \t")
//      if (j==i)println()
//    }
//
//    for(i <- 1 to 9){
//      val star = 2 * i - 1
//      val spaces = 9 - i
//      println(" " * spaces + "*" * star)
//    }


      val a:Array[Int] = Array(22,44,66,88,3,2,4)

      def f(array: Array[Int],op:Int=>Int):Array[Int] = {
        for(elem <- array) yield op(elem)
      }

    /*  def s(elem:Int):Int={
        elem+1
      }*/
      val ints: Array[Int] = f(a,_+1)
      println(ints.mkString(","))


    }
}
