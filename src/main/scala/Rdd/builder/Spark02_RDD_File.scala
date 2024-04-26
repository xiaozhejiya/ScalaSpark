package Rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object  Spark02_RDD_File {
  def main(args: Array[String]): Unit = {
    //  准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(conf)
    //  文件中创建RDD
    //  也可以使用文件夹
    //  也可以使用通配符hdfs://10.3.15.116:8020/w*.txt  //匹配w开头的文件
    val rdd = sc.textFile("hdfs://10.3.15.116:8020/word.txt")
    rdd.collect().foreach(println)
    //  关闭环境
    sc.stop()
  }
}
