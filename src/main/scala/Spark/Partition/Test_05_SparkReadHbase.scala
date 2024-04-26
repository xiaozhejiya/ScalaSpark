package Spark.Partition
import org.apache.hadoop.conf.Configuration
//import org.apache.hadoop.hbase._
//import org.apache.hadoop.hbase.client._
//import org.apache.hadoop.hbase.mapreduce
//import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

object Test_05_SparkReadHbase {
  def main(args: Array[String]): Unit = {
//    val conf = HBaseConfiguration.create()
    val sc = new SparkContext(new SparkConf())
  }
}
