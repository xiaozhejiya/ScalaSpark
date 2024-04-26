package Rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory_Partition {
  def main(args: Array[String]): Unit = {
    //  准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    //  设置参数
    conf.set("spark.default.parallelism", "5")
    val sc = new SparkContext(conf)
    //  创建RDD
    //  parallelize:并行
    //  val rdd = sc.parallelize(seq)
    //  如果不指定分区数,则会获取scheduler.conf.getInt("spark.default.parallelism", totalCores)
    //  spark默认情况下,从配置对象中获取配置参数,spark.default.parallelism
    //  如果获取不到,那么使用totalCores属性,这个属性取值为当前环境的最大核数
    val rdd = sc.makeRDD(1 to 4, 2)

    //  将处理数据保存为分区文件
    rdd.saveAsTextFile("file:///C:/Users/30778/Desktop/partition")

    //  关闭环境
    sc.stop()
  }
}
