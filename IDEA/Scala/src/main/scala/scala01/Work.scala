package scala01

/**
  * @title: Work
  * @projectName Scala
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/610:51
  */
object Work {
  def main(args: Array[String]): Unit = {
    val work = new Worker
    work.printinfo()
  }
}


class Worker extends Person {
  override def printinfo(): Unit = {
    age = 28
    id = 40
    sex = "ХЎ"
    println(s"Worker: $age , $id , $sex")

  }
}
