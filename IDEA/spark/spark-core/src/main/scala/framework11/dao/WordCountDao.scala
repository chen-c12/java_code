package framework11.dao

import framework11.application.WordCount.sc

/**
  * @title: WordCountDao
  * @projectName spark
  * @description: TODO
  * @author Н№гу
  * @date 2021/12/1321:53
  */
class WordCountDao{

  def readFile(path:String)  ={
    sc.textFile(path)

  }
}
