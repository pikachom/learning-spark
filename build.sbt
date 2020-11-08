name := "learning-spark-mini-example"

version := "0.1"

scalaVersion := "2.12.0"

libraryDependencies ++= {
  Seq(
    "org.apache.spark" %% "spark-core" % "3.0.0" % "provided",
    "org.apache.spark" %% "spark-sql" % "3.0.0"
  )

}
