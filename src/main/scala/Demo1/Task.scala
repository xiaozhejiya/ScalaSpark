package Demo1

class Task extends Serializable {
  val data: List[Int] = List(2, 4, 5, 7)
  val logic: Int => Int = _ * 2


}
