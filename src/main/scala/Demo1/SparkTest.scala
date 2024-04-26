package Demo1

import org.apache.spark.sql.SparkSession

object SparkTest {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("spark://node5:7077")
      .config("spark.driver.host", "10.100.40.88")
      .config("spark.driver.port", "9999")
      .appName("sparkTest")
      .getOrCreate()
    val numDS = spark.range(5, 100, 5)
    numDS.show(5)
    spark.close()
  }
}
