package Demo1

import java.io.ObjectOutputStream
import java.net.Socket


object Driver {
  def main(args: Array[String]): Unit = {
    // 连接服务器
    val client1 = new Socket("localhost", 9999)
    val client2 = new Socket("localhost", 8888)
    val task = new Task()
    //  发送数据
    val out_put1 = client1.getOutputStream
    val objOut1 = new ObjectOutputStream(out_put1)
    //  网络传输需要序列化,因此类添加特质Serializable
    val subTask = new SubTask()
    subTask.data = task.data.take(2)
    subTask.logic = task.logic
    objOut1.writeObject(subTask)
    //  刷写
    objOut1.flush()
    //  关闭流
    objOut1.close()

    client1.close()

    //  发送数据
    val out_put2 = client2.getOutputStream
    val objOut2 = new ObjectOutputStream(out_put2)
    //  网络传输需要序列化,因此类添加特质Serializable
    val subTask1 = new SubTask()
    subTask1.data = task.data.takeRight(2)
    subTask1.logic = task.logic
    objOut2.writeObject(subTask1)
    //  刷写
    objOut2.flush()
    //  关闭流
    objOut2.close()

    client2.close()
  }
}
