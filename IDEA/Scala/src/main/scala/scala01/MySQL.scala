package scala01

/**
  * @title: MySQL
  * @projectName Scala
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/714:11
  */
object MySQL {
  def main(args: Array[String]): Unit = {
      val user = new ResgistUser("chen","123456")
    user.insert()
  }
}
class User(val name:String,val password:String)

trait UserDao{
  _:User =>

  def insert():Unit = {
    println(s"User:${name}"+"--"+s"${password}")
  }
}

class ResgistUser(name:String,password:String) extends User(name,password ) with UserDao