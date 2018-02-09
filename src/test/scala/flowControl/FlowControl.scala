package flowControl

import java.io.{File, PrintWriter}

object FlowControl {
  def main(args: Array[String]): Unit = {

    for (list <- FileMatcher.filesRegex(".*"))
      println(list)


    /* curring */
    def plainOldSum(x: Int, y: Int) = x + y

    def curriedSum(x: Int)(y: Int) = x + y

    /* 첫번째로 동작하는 함수의 모양 */
    def first(x: Int) = (y: Int) => x + y

    /* 이렇게 두번째 함수를 얻는다. */
    def second = first(1)

    /* 이걸 실행하면 이렇게 된다. */
    println(curriedSum(1)(2))
    println(second(2))

    val onePlus = curriedSum(1) _
    println(onePlus(2))


    /* 새로운 제어 구조 */

    /* op 는 double 을 받아 double 을 리턴한다는 것 말고는 아무 내용이 없다.
    * x 로 들어온 값을 아직 정해지지 안은 op를 2번 반복한다. */
    def twice(op: Double => Double, x: Double) = op(op(x))

    /* op 함수의 내용을 넣어주었다. double 로 받은 값에 +1 후 리턴 */
    println(twice(_ + 1, 5))
    println(twice((num: Double) => num + 1, 5))

    /* 함수 자리라는 것을 알기 때문에 위치표시자를 사용하여 바로 파라미터 사용이 가능하다. */
    println(twice(Math.PI * _, 1))


    /* 이렇게 하면 해당 메소드가 파일 닫기를 보장한다. loan pattern 이라 부른다. */
    def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
      val writer = new PrintWriter(file)
      try {
        op(writer)
      } finally {
        writer.close()
      }
    }

    withPrintWriter(
      new File("date.txt"),
      writer => writer.println(new java.util.Date)
    )


    /* 스칼라에서는 제어 구조처럼 보이도록 하기 위해 인자가 하나인 경우 중괄호 사용이 가능하다 */
    println("Hello world!")
    println {
      "Hello world!"
    }

    /* 커링을 이용 */
    def withPrintWriter2(file: File)(op: PrintWriter => Unit): Unit = {
      val writer = new PrintWriter(file)
      try {
        op(writer)
      } finally {
        writer.close()
      }
    }

    /* 커링을 이용해 인자를 하나로 나눴기 때문에 중괄호 사용 가능 */
    val file = new File("date.txt")
    withPrintWriter2(file) {
      writer => writer.println(new java.util.Date)
    }

  }
}
