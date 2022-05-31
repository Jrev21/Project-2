import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]): Unit = {
    println("Hello Spark Scala")

    // Spark session
    val spark = SparkSession
      .builder()
      .appName("HelloSpark")
      .config("spark.master", "local")
      .getOrCreate()

    val sampleSeq = Seq((1,"spark"),(2, "Big Data"))
    val df = spark.createDataFrame(sampleSeq).toDF()
    df.show()




  }
}

