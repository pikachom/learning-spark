package chap2

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  val conf = new SparkConf().setAppName("wordCount")
  val sc = new SparkContext(conf)

  val input = sc.textFile("inputFile")

  val words = input.flatMap(line => line.split(" "))

  val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}

  counts.saveAsTextFile("outputFile")
}
