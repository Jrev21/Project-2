package ecommerce_app

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types._

class DataAnalysis() {

  //Marketing Question #1: What is the top selling category of items? Per Country?
  def getTopSellingCategoryOfItems(spark: SparkSession): Unit = {

    //Top Selling for entire data set
    val topSellerDF = spark.sql("SELECT Product_category, SUM(Qty) FROM Orders " +
      "GROUP BY Product_category")
      .toDF("Product_category","Products_sold")
      .orderBy("Products_sold" )

    topSellerDF.show()

    //top selling per Country
    val topSellerByCountryDF = spark.sql("SELECT Product_category, Country, SUM(Qty) FROM Orders " +
      "GROUP BY Product_category, Country LIMIT 20")
      .toDF("Product_category", "Country","Products_sold")
      .orderBy("Products_sold")

    topSellerByCountryDF.show()
  }

  //Marketing Question #2: How does the popularity of products change throughout the year?
  def getChangeOfPopularityThroughoutYear(spark: SparkSession): Unit = {

    //Popularity for entire data set
    val popularityChangeDF = spark.sql("SELECT Product_name, Product_category, QUARTER(Datetime), SUM(Qty) FROM Orders " +
      "WHERE Datetime LIKE '2021%'" +
      "GROUP BY Product_name, Product_category, Datetime")
      .toDF("Product_name", "Product_category", "Quarterly", "Total_sold")
      .sort("Total_sold")

    popularityChangeDF.show()

    //Popularity per country
    val popularityChangeCountryDF = spark.sql("SELECT Product_name, Product_category, Country, QUARTER(Datetime), COUNT(Qty) FROM Orders " +
      "WHERE Datetime LIKE '2021%'" +
      "GROUP BY Product_name, Product_category, Country, Datetime, Qty")
      .toDF("Product_name", "Product_category", "Country", "Quarterly", "Total_sold")
      .sort("Country", "Total_sold")

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
    val trafficSalesTimesDF = spark.sql("SELECT DAYOFWEEK(Datetime), SUM(Qty) FROM Orders " +
      "GROUP BY DAYOFWEEK(Datetime)")
      .toDF("Day", "Total_sold")
      .sort("Total_sold")

    trafficSalesTimesDF.show()

    //highest traffic per country
    val trafficSalesCountryDF = spark.sql("SELECT Country, DAYOFWEEK(Datetime), SUM(Qty) " +
      "FROM Orders GROUP BY Country, DAYOFWEEK(Datetime)")
      .toDF("Country","Datetime", "Total_Sold")
      .sort("Country")

    trafficSalesCountryDF.show()
  }
}
