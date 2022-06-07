version in ThisBuild := "0.1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.12"

libraryDependencies ++=Seq(
  // https://mvnrepository.com/artifact/org.apache.spark/spark-core
  "org.apache.spark" %% "spark-core" % "2.4.6",
  // https://mvnrepository.com/artifact/org.apache.spark/spark-sql
  "org.apache.spark" %% "spark-sql" % "2.4.6",
  // https://mvnrepository.com/artifact/org.apache.spark/spark-hive
  "org.apache.spark" %% "spark-hive" % "2.4.6",
  // https://mvnrepository.com/artifact/org.vegas-viz/vegas
  "org.vegas-viz" %% "vegas" % "0.3.11",
  // https://mvnrepository.com/artifact/org.vegas-viz/vegas-viz
  "org.vegas-viz" %% "vegas-spark" % "0.3.11"
)

lazy val root = (project in file("."))
  .settings(
    name := "RevatureGroup2_Project1"
  )
