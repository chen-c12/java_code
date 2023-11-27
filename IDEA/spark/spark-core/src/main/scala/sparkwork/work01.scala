package sparkwork

import org.apache.spark.{SparkConf, SparkContext}

object work01 {
  def main(args: Array[String]): Unit = {
    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("max")
    val sc = new SparkContext(sparkconf)

    /*(1)*/
    val  bigdata =sc.textFile("hdfs://hadoop001:9000/sparkwork/result_bigdata.txt")
      .map{x=>val line=x.split("\t");(line(0),line(1),line(2).toInt)}

    val  math =sc.textFile("hdfs://hadoop001:9000/sparkwork/result_math.txt")
      .map{x=>val line=x.split("\t");(line(0),line(1),line(2).toInt)}

    val  all_score=bigdata  union  math

    val score = all_score.map(x=>(x._1,x._3)).reduceByKey((a,b)=>a+b)

    score.collect.foreach(println)

    /*(2)*/
    val rdd = sc.parallelize(List("this is a test","How are you","I am fine","Can you tell me"))
    val words=rdd.map(x=>(x.split(" ")(0),x))
    words.collect.foreach(println)

    /*(3)*/
    val key=words.keys
    key.collect.foreach(println)
    val value=words.values
    value.collect.foreach(println)


    /*(4)*/
    val r_rdd=sc.parallelize(List(('a',1),('a',2),('b',1),('c',1),('c',1))).map(x=>(x._1,x._2))

    val re_rdd=r_rdd.reduceByKey((a,b)=>a+b)
    re_rdd.collect.foreach(println)

    /*(5)*/
    val g_rdd=r_rdd.groupByKey()
    g_rdd.collect.foreach(println)

    g_rdd.map(x=>(x._1,x._2.size)).collect.foreach(println)




  }
}
