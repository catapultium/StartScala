package rational

object Main {
  implicit def intToRational(x:Int) = new Rational(x)

  def main(args: Array[String]): Unit = {
    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    println(oneHalf + twoThirds).toString

    /* 공개 필드이므로 접근 가능 */
    println(oneHalf.numer)
    println(oneHalf.denom)

    println(twoThirds max oneHalf).toString

    println(new Rational(5)).toString

    println(new Rational(66, 42)).toString

    /* 연산자 정의 */
    println("연산자 정의")
    val x = new Rational(5, 4)
    val y = new Rational(7, 4)
    println(x.+(y)).toString
    println(x + y).toString
    println(x * y).toString

    /* 연산자 우선순위 확인 */
    println(x + x * y)
    println((x + x) * y)
    println(x + (x * y))

    /* 정수 연산 */
    println(oneHalf - 1)
    println(oneHalf + 1)
    println(oneHalf / 2)
    println(oneHalf * 4)

    /* 암시적 타입 변환 */
    println(1 + oneHalf)

  }
}
