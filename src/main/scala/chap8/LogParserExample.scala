package chap8

import org.apache.spark.{SparkConf, SparkContext}

object LogParserExample {
  val conf = new SparkConf().setAppName("logParser")
  val sc = new SparkContext(conf)

}
