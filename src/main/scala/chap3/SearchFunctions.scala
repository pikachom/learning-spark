package chap3

import org.apache.spark.rdd.RDD

class SearchFunctions (val query: String) {
  def isMatch(s: String): Boolean = {
    s.contains(query)
  }
  def getMatchesFunctionReference(rdd : RDD[String]): RDD[Boolean] = {
    rdd.map(isMatch)
    // 문제점 : isMatch는 this.isMatch이기 때문에 this의 모든 것이 전달됨
  }
  def getMatchesFieldReference(rdd : RDD[String]): RDD[Array[String]] = {
    rdd.map(x => x.split(query))
    // 문제점 : query는 this.query이기 때문에 this의 모든 것이 전달됨
  }
  def getMatchesNoReference(rdd: RDD[String]): RDD[Array[String]] = {
    val query_ = this.query
    rdd.map(x => x.split(query_))
    // 안전함 : 필요한 필드만 추출해서 지역변수에 저장 후 전달됨
  }

}
