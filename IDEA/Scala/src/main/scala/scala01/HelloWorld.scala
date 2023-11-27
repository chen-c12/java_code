package scala01

import scala.annotation.tailrec

/**
  * @title: HelloWorld
  * @projectName Scala
  * @description: TODO
  * @author ����
  * @date 2021/11/249:20
  */
object HelloWorld {
  def main(args: Array[String]): Unit = {
      println(tailFact(10))
     var n=10
    myWhile2(n>=1){
      println(n)
      n-=1
    }
  }
    val fun = (i: Int, s: String, c: Char) => {
      if (i == 0 && s == "" && c == "0") false else true
    }

  /*β�ݹ�*/
    def tailFact(n: Int): Int = {
      @tailrec
      def loop(n: Int, currRes: Int): Int = {
        if (n == 0) return currRes
        loop(n - 1, currRes * n)
      }
      loop(n, 1)
    }

  /*���Ƴ���*/
    def myWhile(condition: => Boolean):(=>Unit)=>Unit = {
      def doLoop(op: =>Unit):Unit = {
        if (condition){
          op
          myWhile(condition)(op)
        }
      }
      doLoop _
    }

  /*lambda���ʽ������������*/
  def myWhile1(condition: => Boolean):(=>Unit)=>Unit = {
     op => {
      if (condition){
        op
        myWhile1(condition)(op)
      }
    }
  }

/*  ���ﻯ ��*/
  def myWhile2(condition: =>Boolean)(op: =>Unit):Unit = {
    if (condition){
      op
      myWhile2(condition)(op)
    }
  }
}
