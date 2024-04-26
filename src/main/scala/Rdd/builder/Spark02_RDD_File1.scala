package Rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_File1 {
  def main(args: Array[String]): Unit = {
    //  准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(conf)
    //  文件中创建RDD
    //  textFile: 以行为单位读取数据,返回数据都是字符串
    //  wholeTextFiles: 第一个元素为路径,第二个元素为文件内容
    val rdd = sc.wholeTextFiles("hdfs://10.3.15.116:8020/word.txt")
    rdd.collect().foreach(println)
    //  关闭环境
    sc.stop()
  }
}
