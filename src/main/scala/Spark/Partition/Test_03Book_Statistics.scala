package Spark.Partition

import org.apache.spark.{SparkConf, SparkContext}

object Test_03Book_Statistics {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("booksCount")
    val sc = new SparkContext(conf)
    val books = sc.parallelize(Array(("Spark", 2), ("Hadoop", 4), ("Spark", 4), ("Hadoop", 7), ("Hadoop", 0)))
    val rdd = books.mapValues((_, 1)).reduceByKey((a,b)=>((a._1 + b._1),(a._2 + b._2))).mapValues(x => x._1 / x._2).collect().foreach(println)
  }
}
