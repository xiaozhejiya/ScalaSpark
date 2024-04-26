package Spark.Partition

import org.apache.spark
import org.apache.spark.{Partition, Partitioner, SparkConf, SparkContext}
class MyPartitioner(numParts: Int) extends Partitioner {
  override def numPartitions: Int = numParts

  override def getPartition(key: Any): Int = key.toString.toInt % 10
}

object MyPartitioner {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    //  模拟5个分区
    val data = sc.parallelize(1 to 10, 5)
    //  预存入内存中,当第一次执行计算操作时存入内存

    data.cache()
    //  从内存中去除
    data.unpersist()
    //  因为spark分区只支持键值对
    data.map((_,1)).partitionBy(new MyPartitioner(10)).map(_._1).saveAsTextFile("hdfs://10.3.15.116:8020/partitioner")
  }
}
