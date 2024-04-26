package Spark.Partition

import org.apache.spark.{SparkConf, SparkContext}

object Test_04Read_Write_File {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("read_write")
    val sc = new SparkContext(conf)
    //  读取HDFS文件
    val textFile = sc.textFile("hdfs://10.3.15.116:8020/partitioner")
    textFile.collect().foreach(println)
    //  写入HDFS
    textFile.saveAsTextFile("hdfs://10.3.15.116:8020/partitioner2")
    sc.stop()
  }
}
