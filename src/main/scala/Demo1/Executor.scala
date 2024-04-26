package Demo1

import java.io.ObjectInputStream
import java.net.ServerSocket
//import org.apache.hadoop.hbase
object Executor {
  def main(args: Array[String]): Unit = {
    //  启动服务器,接受数据
    val server = new ServerSocket(9999)
    println("服务器启动,等待客户端连接")
    val client = server.accept()
    //  获取客户端发送的数据
    val input = client.getInputStream
    val objInput = new ObjectInputStream(input)
    //  读取客户端发送的数据
    val task:SubTask = objInput.readObject().asInstanceOf[SubTask]
    println("计算结果为", task.compute())
    objInput.close()
    client.close()
    server.close()
  }
}
