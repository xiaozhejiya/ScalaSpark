package operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_Operator_Transform_MapPatitions {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List(1,2,3,4),2)
    //  mapPartitions:  可以以分区为单位进行数据转换操作
    //                  但是会将整个分区的数据加载到内存进行引用
    //                  当前任务下,处理完的数据是不会被释放掉的,存在对象的引用
    //                  在内存较小,数据量较大的场合下,容易出现内存溢出
    rdd.mapPartitions(
      iter => {
        println(">>>>>>>")
        iter.map(e=>{println(e * 2); e * 2})

      }
    ).collect()
  }
}
