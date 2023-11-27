package test

/**
  * @title: scala
  * @projectName spark
  * @description: Ñî»ÔÈý½Ç
  * @author chenddd
  * @date 2022/3/1817:34
  */
object scala {
  def main(args: Array[String]):Unit= {
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  def pascal(c: Int, r: Int): Int = {
    var o =c+1
    var p = r+1
    val count = (p*(p+1))/2
    var tmp = new Array[Int](count)
    for( y <- 1 to p){
      for(x <- 1 to p ) {

        if (x == 1 || y == 1 || y == x) {
          var num = (y * (y + 1)) / 2
          tmp(num - y + x - 1) = 1
        } else {
          var x1 = x - 1
          var x2 = x
          var y1 = y - 1
          var num1 = (y * (y - 1)) / 2
          var num = (y * (y + 1)) / 2
          tmp(num - y + x-1) = tmp(num1 - y1 + x2-1) + tmp(num1 - y1 + x1-1)
        }
      }

    }
    tmp(count -p+o-1)
  }
}
