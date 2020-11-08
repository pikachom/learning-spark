package chap9

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, Row, SQLContext, SparkSession}

object SqlExample {

  val conf: SparkConf = new SparkConf().setAppName("tweets").setMaster("local")
  val sc: SparkContext = new SparkContext(conf)
  val sqlCtx = new SQLContext(sc)

  def main(args: Array[String]): Unit = {
    val input = sqlCtx.jsonFile("./src/main/scala/chap9/testtweet.json")
    input.registerTempTable("tweets")

    val topTweets = sqlCtx.sql("SELECT text, retweetCount FROM tweets ORDER BY retweetCount LIMIT 10")
    val topTweetText = topTweets.rdd.map(row => row.getString(0))
    topTweetText.collect()
  }

}
