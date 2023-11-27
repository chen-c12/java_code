package scala01

/**
  * @title: Person
  * @projectName Scala
  * @description: TODO
  * @author ½ðÓã
  * @date 2021/12/610:47
  */
class Person {
  private var name : String = "chen"
  var id:Int = 30
  var age:Int = 20
  private[scala01] var sex:String = "ÄÐ"

  def printinfo():Unit = {
    println(s"Master:$name , $age , $id , $sex")
  }
}

