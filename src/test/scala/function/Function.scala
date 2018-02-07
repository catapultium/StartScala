package function

import helloWorld.LongLines

object Function {
  def main(args: Array[String]): Unit = {

    def ---() {
      for (i <- 1 to 80)
        print("-")
      println()
    }

    /* run 파라미터 설정 필요
    45 .gitignore */
    val width = args(0).toInt
    for (arg <- args.drop(1)) {
      LongLines.processFile(arg, width)
      println()
      LongLines.processFile2(arg, width)
    }

    /* 함수 리터럴 */
    val increase = (x: Int) => x + 1
    println(increase(10))

    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach((x: Int) => println(x))
    someNumbers.filter((x: Int) => x > 0).foreach((x: Int) => println(x))

    /* 간단한 사용 */
    someNumbers.filter(x => x > 0).foreach(x => println(x))
    /* 명시적으로 함수가 들어가는 경우에만 사용 가능 */
    someNumbers.filter(_ > 0).foreach(println)


    ---
    /* 위치 표시자는 각 한번 사용할 수 있으며, 2개가 쓰이면 2번째 인자이다. */
    val plus = (_: Int) + (_: Int)
    println(plus(2, 5))

    ---

    /* 부분 함수 적용 */
    def sum(a: Int, b: Int, c: Int) = a + b + c

    println(sum(1, 2, 3))
    val a = sum _
    println(a(1, 2, 3))
    println(a.apply(1, 2, 3))
    val b = sum(1, _: Int, 3)
    println(b(2))

    ---

    /* 클로저 */
    var more = 1
    val addMore = (x: Int) => x + more
    println(addMore(10))
    more = 100
    println(addMore(10))

    val someNumbers2 = List(-11, -10, -5, 0, 5, 10)
    var s = 0
    someNumbers2.foreach(s += _)
    println(s)

    /* 포획된 more 값은 heap 에 남아 스택보다 오래 살아있다. */
    def makeIncreaser(more: Int) = (x: Int) => x + more
    val inc1 = makeIncreaser(1)
    val inc9999 = makeIncreaser(9999)
    println(inc1(10))
    println(inc9999(10))


  }
}