ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.11"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.6"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.6"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.4.6"
libraryDependencies += "org.apache.poi" % "poi" % "5.2.0"
libraryDependencies += "org.apache.poi" % "poi-ooxml" % "5.2.0"
libraryDependencies += "org.apache.poi" % "poi-ooxml-lite" % "5.2.0"
libraryDependencies += "com.github.mrpowers" %% "spark-daria" % "0.39.0"

lazy val root = (project in file("."))
  .settings(
    name := "RevatureGroup2_Project1"
  )