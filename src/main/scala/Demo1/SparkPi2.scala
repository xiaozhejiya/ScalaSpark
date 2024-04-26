package Demo1

import org.apache.spark.{SparkConf, SparkContext}

object SparkPi2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Spark Pi").set("spark.executor.memory","512m")
      .set("spark.driver.host","10.3.15.116")
      .set("spark.driver.cores","3")
      .setMaster("spark://node5:7077")

    val sc = new SparkContext(conf)
    val rdd = sc.textFile("hdfs://node5:8020/word.txt")
    rdd.flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _).collect().foreach(println)
  }
}
