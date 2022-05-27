ThisBuild / version := "0.1.0-SNAPSHOT"

// Commenting this out as it does not work with my configuration, but works for other
ThisBuild / scalaVersion := "2.13.8"

// Build that works for this configuration
ThisBuild / scalaVersion := "2.12.11"

libraryDependencies ++= Seq (
  // Commenting this out as it broke my project, but works for others
  // "org.scala-lang" % "scala-library" % "2.13.8",

  // Scala library that works for this configuration
  "org.scala-lang" % "scala-library" % "2.12.11",

  // https://mvnrepository.com/artifact/org.apache.spark/spark-core
  "org.apache.spark" % "spark-core" % "2.4.6",

  // https://mvnrepository.com/artifact/org.apache.spark/spark-sql
  "org.apache.spark" % "spark-sql" % "2.4.6",

  // https://mvnrepository.com/artifact/org.apache.spark/spark-sql
  "org.apache.spark" % "spark-hive" % "2.4.6",

  // https://mvnrepository.com/artifact/org.apache.poi/poi-scratchpad
  "org.apache.poi" % "poi-scratchpad" % "5.2.0",

  // https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-full
  "org.apache.poi" % "poi-ooxml-full" % "5.2.0",

  // https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-lite
  "org.apache.poi" % "poi-ooxml-lite" % "5.2.0"
)

lazy val root = (project in file("."))
  .settings(
    name := "ScalaSpark"
  )