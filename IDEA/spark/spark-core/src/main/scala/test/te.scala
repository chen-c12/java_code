package test

/**
  * @title: te
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2022/3/1817:37
  */
object te {
  def main(args: Array[String]) {

    val a =Array.ofDim[Int](10,10)
    for(i<- 0 until a.length){
      a(i)(0)=1
      a(i)(i)=1
    }
    for(i <-2 until a.length ){
      for(j <-1 until a(i).length){
        a(i)(j)=a(i-1)(j-1)+a(i-1)(j)
      }
    }

    for(i <-0 until a.length){
      for(j <- 0 until a(i).length  if j<=i){
        print(a(i)(j)+"\t")
      }
      println()
    }
  }

}
