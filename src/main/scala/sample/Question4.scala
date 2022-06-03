package sample
import org.apache.spark.sql.SparkSession

object Question4 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("data_cleanup")
      .config("spark.master", "local")
      .getOrCreate()

    val df = spark.read.csv("src/input/Dataset.csv").toDF(
      "Order_ID", "Customer_ID", "Name", "Product_ID", "Product_name",
      "Product_type", "Qty", "Price", "Datetime", "Country", "City", "Ecommerce_website_name",
      "Payment_txn_id", "Payment_txn_success", "Failure_reason")
    df.createOrReplaceTempView("items")
    val sqlDF = spark.sql("SELECT SUM(Price) AS Profits, Datetime, Country FROM items " +
                                  "GROUP BY Country, Datetime " +
                                  "ORDER BY Profits DESC"
                                  )
    sqlDF.show(100)
  }
}
