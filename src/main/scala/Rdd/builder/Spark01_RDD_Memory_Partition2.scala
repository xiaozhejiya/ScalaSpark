package Rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory_Partition2 {
  def main(args: Array[String]): Unit = {
    //  准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    //  设置参数
    conf.set("spark.default.parallelism", "5")
    val sc = new SparkContext(conf)
//    分区规则:
    //  计算偏移量
    //  14byte / 2(minPartition) = 7byte
    //  14byte / 7byte = 2(实际分区)  //如果余数大于1.1倍则分区加1
    //  偏移量
    //  [0,7] => 实际存储得看每一行的数据，如果当前行小于7byte则接着读第二行如果第一行加第二行大于7byte则,两个的数据存在同一分区（hdfs的读写机制,读取一整行）
    //  [7,14]
    val rdd = sc.textFile("data/input/word.txt", 3)
 
    //  将处理数据保存为分区文件
    rdd.saveAsTextFile("data/output/partition")

    //  关闭环境
    sc.stop()
  }
}
