package rational

object Main {
  def main(args: Array[String]): Unit = {
    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    println(oneHalf add twoThirds).toString

    /* 공개 필드이므로 접근 가능 */
    println(oneHalf.numer)
    println(oneHalf.denom)
  }
}
