import org.apache.spark.sql.SparkSession

object Question2 {
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
    val sqlDF = spark.sql("SELECT SUM(Qty) AS Item_Sold, Product_name, Country FROM items " +
                                  "WHERE Datetime LIKE '01%' " +
                                  "GROUP BY Country, Product_name")

sqlDF.show(1000)

  }
}
// We should probably implement different years like Normans group and
// The query used would query the information based on each month. So we should have a program that allows for use to call for each month as needed.