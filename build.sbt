name := "group2ray-test"
version := "1.0"
scalaVersion := "2.11.12"
libraryDependencies ++= Seq(
"org.apache.spark" % "spark-core_2.11" % "2.4.0",
"org.apache.spark" % "spark-sql_2.11" % "2.4.0",
"org.apache.spark" % "spark-streaming_2.11" % "2.4.0",
"org.apache.spark" % "spark-mllib_2.11" % "2.4.0",
"org.jmockit" % "jmockit" % "1.34" % "test",
"au.com.bytecode" % "opencsv" % "2.4"
)
