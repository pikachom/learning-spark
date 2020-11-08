package chap3

import org.apache.spark.{SparkConf, SparkContext}

object RddExample {
  val conf = new SparkConf().setAppName("rddexample")
  val sc = new SparkContext(conf)

  val input = sc.parallelize(List(1,2,3,4))
  val result = input.map(x => x * x)
  println(result.collect().mkString(","))

}
