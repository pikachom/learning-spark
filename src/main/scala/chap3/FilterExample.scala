package chap3

import org.apache.spark.{SparkConf, SparkContext}

object FilterExample {
  val conf = new SparkConf().setAppName("filter")
  val sc = new SparkContext(conf)

  val inputRDD = sc.textFile("log.txt")
  val errorRDD = inputRDD.filter(line => line.contains("error"))
  val warningRDD = inputRDD.filter(line => line.contains("warning"))

  val badLinesRDD = errorRDD.union(warningRDD)

  println("input had " + badLinesRDD.count() + " concerning lines")
  println("here are 10 examples : ")
  badLinesRDD.take(10).foreach(println)
}
