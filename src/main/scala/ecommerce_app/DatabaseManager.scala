package ecommerce_app

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types._
import java.io.{File, PrintWriter}
import scala.collection.mutable.ArrayBuffer


class DatabaseManager {
  //utilize winutils.exe for running Hadoop on Windows
  System.setProperty("%HADOOP_HOME%", "C:\\Hadoop\\bin")

  //turn off log messages
  Logger.getLogger("org").setLevel(Level.ERROR)
  Logger.getLogger("akka").setLevel(Level.ERROR)

  //DataManager will utilize a new instance of the ecommerce_app.DataAnalysis class to map each query function to a specific case
  val dataAnalysis = new DataAnalysis

  //create SparkSession while also enabling Hive support
  val spark = SparkSession
    .builder ()
    .appName ("E-commerce_Big_Data_App")
    .config ("spark.master", "local")
    //.enableHiveSupport()
    .getOrCreate()

  //create a function that reads the generated Datasets.csv during an initiated SparkSession
  def createDatabase(): Unit = {

    val dfSchema = StructType(Array(
      StructField("order_id", IntegerType),
      StructField("customer_id", StringType),
      StructField("customer_name", StringType),
      StructField("product_id", StringType),
      StructField("product_name", StringType),
      StructField("product_category", StringType),
      StructField("payment_type", StringType),
      StructField("qty", IntegerType),
      StructField("price", DoubleType),
      StructField("datetime", TimestampType),
      StructField("country", StringType),
//      StructField("city", StringType),
      StructField("ecommerce_website_name", StringType),
      StructField("payment_txn_id", StringType),
      StructField("payment_txn_success", StringType),
      StructField("failure_reason", StringType)
    ))

    val df = spark.read.option("header", "true")
      .schema(dfSchema)
      .option("inferSchema", "false")
      .option("timestampFormat", "MM/dd/yyyy HH:mm")
      .csv("src/input/Dataset.csv")

    //df.schema.printTreeString()

    //printed as example
    df.printSchema()
    //    df.show(5)

    //create a lazily evaluated table for queries
    df.createOrReplaceTempView("Orders")

  }

  //function to end a SparkSession
  def closeSpark(): Unit = {
    println("Spark Session closed")
    spark.close
  }

  //queries for the data analysis questions
  def marketingQuestions(marketingQuestionNumber: String): Unit = marketingQuestionNumber match {
    //What is the top selling category of items? Per country?
    case "one" => dataAnalysis.getTopSellingCategoryOfItems(spark)
    case "two" => dataAnalysis.getChangeOfPopularityThroughoutYear(spark)
    case "three" => dataAnalysis.getLocationsForHighestTrafficOfSales(spark)
    case "four" => dataAnalysis.getTimesForHighestTrafficOfSales(spark)
  }

  // function to reestablish a SparkSession
  def returnSparkSession(): SparkSession = {
    spark
  }

}
