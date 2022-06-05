package ecommerce_app

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types._

class DataAnalysis() {

  //Marketing Question #1: What is the top selling category of items? Per Country?
  def getTopSellingCategoryOfItems(spark: SparkSession): Unit = {

    //Top Selling for entire data set
    val topSellerDF = spark.sql("SELECT Product_name, Product_category, SUM(Qty) FROM Orders " +
      "GROUP BY Product_name, Product_category")
      .toDF("Product_name","Product_category","Products_sold")
      .orderBy("Products_sold" )

    topSellerDF.show()

    //top selling per Country
    val topSellerByCountryDF = spark.sql("SELECT Product_category, Country, SUM(Qty) FROM Orders " +
      "GROUP BY Product_category, Country")
      .toDF("Product_category", "Country","Products_sold")
      .orderBy("Products_sold")

    topSellerByCountryDF.show()
  }

  //Marketing Question #2: How does the popularity of products change throughout the year?
  def getChangeOfPopularityThroughoutYear(spark: SparkSession): Unit = {

    //Popularity for entire data set
    val popularityChangeDF = spark.sql("SELECT Product_category, Datetime, SUM(Qty) FROM Orders " +
      "WHERE Datetime LIKE '2021%'" +
      "GROUP BY Product_category, Datetime")
      .toDF("Product_category", "Quarter", "Total_sold")
      .sort("Product_category", "Total_sold")

    popularityChangeDF.show()

    //Popularity per country
    val popularityChangeCountryDF = spark.sql("SELECT Product_name, Product_category, Country, Datetime, COUNT(Qty) FROM Orders " +
      "WHERE Datetime LIKE '2021%'" +
      "GROUP BY Product_name, Product_category, Country, Datetime, Qty")
      .toDF("Product_name", "Product_category", "Country", "Quarterly", "Total_sold")
      .sort("Product_category")

    popularityChangeCountryDF.show()
  }

  //Marketing Question #3: Which locations see the highest traffic of sales?
  def getLocationsForHighestTrafficOfSales(spark: SparkSession): Unit = {
    val trafficSalesLocationsDF = spark.sql("SELECT Country, SUM(Qty) FROM Orders " +
      "GROUP BY Country")
      .toDF("Country","Highest_traffic_by_quantity")
      .sort("Highest_traffic_by_quantity")

    trafficSalesLocationsDF.show()
  }

  //Marketing Question #4: What times have the highest traffic of sales? Per Country?
  def getTimesForHighestTrafficOfSales(spark: SparkSession): Unit = {

    //Highest traffic for entire data set
    val trafficSalesTimesDF = spark.sql("SELECT dayofweek(Datetime), SUM(Qty) FROM Orders " +
      "GROUP BY dayofweek(Datetime)")
      .toDF("Day", "Total_sold")
      .sort("Total_sold")

    trafficSalesTimesDF.show()

    //highest traffic per country
    val trafficSalesCountryDF = spark.sql("SELECT Country, Datetime, SUM(Qty) " +
      "FROM Orders GROUP BY Country, Datetime")
      .toDF("Country","Datetime", "Total_Sold")
      .orderBy("Country", "Datetime")

    trafficSalesCountryDF.show()
  }
}
