package framework11.controller

import framework11.service.WordCountService


/**
  * @title: WordCountController
  * @projectName spark
  * @description: TODO
  * @author ����
  * @date 2021/12/1321:51
  */
class WordCountController {
    private val wordCountService = new WordCountService()

  //����
  def execute() :Unit ={
    val array = wordCountService.dataAnalysis()
    array.foreach(println)
  }

}
