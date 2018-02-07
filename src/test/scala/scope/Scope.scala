package scope

object Scope {
  def main(args: Array[String]): Unit = {

    /* 변수 스코프의 기본 룰은 중괄호를 기준으로 한다. */
    def printMultiTable() {
      var i = 1
      while (i <= 10) {
        var j = 1
        while (j <= 10) {
          val prod = (i * j).toString
          var k = prod.length
          while (k < 4) {
            print(" ")
            k += 1
          }
          print(prod)
          j += 1
        }
        println()
        i += 1
      }
    }

    printMultiTable()


    /* shadow */
    /* 세미콜론 필요 */
    val a = 1;
    {
      val a = 2
      println(a)
    }
    println(a)


    /* 함수형 방식으로 위 명령형 곱셈표 리팩토링 */
    def makeRowSeq(row: Int) =
      for (col <- 1 to 10) yield {
        val prod = (row * col).toString
        val padding = " " * (4 - prod.length)
        padding + prod
      }

    def makeRow(row: Int) = makeRowSeq(row).mkString

    def multiTable() = {
      val tableSeq =
        for (row <- 1 to 10)
          yield makeRow(row)
      tableSeq.mkString("\n")
    }

    println(multiTable())

  }
}
