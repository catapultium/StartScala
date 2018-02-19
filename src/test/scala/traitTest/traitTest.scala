package traitTest

object traitTest {
  def main(args: Array[String]): Unit = {
    val frog = new Frog
    frog.philosophize()

    val phil: Philosophical = frog
    phil.philosophize()

    /* 쌓을 수 있는 변경 */
    val queue = new BasicIntQueue

    queue.put(10)
    queue.put(20)
    println(queue.get())
    println(queue.get())

    val queue2 = new MyQueue
    queue2.put(10)
    println(queue2.get())

    /* 가장 오른쪽에 있는 트레이트 효과를 먼저 적용한다. */
    val queue3 = new BasicIntQueue with Incrementing with Filtering
    val queue4 = new BasicIntQueue with Filtering with Incrementing

    queue3.put(-1)
    queue3.put(0)
    queue3.put(1)

    queue4.put(-1)
    queue4.put(0)
    queue4.put(1)

    println(queue3.get())
    println(queue3.get())

    println(queue4.get())
    println(queue4.get())
    println(queue4.get())


  }
}
