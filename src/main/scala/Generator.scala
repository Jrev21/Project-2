import org.apache.spark.sql.SparkSession

object Generator {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("data_cleanup")
      .config("spark.master", "local")
      .getOrCreate()

    val df = spark.read.csv("src/input/Dataset.csv").toDF(
      "Order_ID","Customer_ID","Name","Product_ID","Product_name",
      "Product_type","Qty","Price","Datetime","Country","City","Ecommerce_website_name",
      "Payment_txn_id","Payment_txn_success","Failure_reason")
    df.show(2)
  }
}
