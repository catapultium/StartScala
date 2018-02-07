package rational

/* 주 생성자 */
class Rational(n: Int, d: Int) {
  /* n, d 는 클래스 파라미터 지칭한다. */

  /* 분모가 0이면 IllegalArgumentException 발생
  * Predef 독립 객체에 들어있음 */
  require(d != 0)

  /* 메소드 스코프에 바로 접근할 수 없기 떄문에 필드를 추가한다. */
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  /* 보조 생성자. 분모가 1일 경우 분자만 입력하면 되도록 */
  def this(n: Int) = this(n, 1)

  /* 지정하지 않으면 클래스이름@16진수숫자 */
  override def toString: String = numer + "/" + denom

  def add(that: Rational): Rational = new Rational(
    numer * that.denom + that.numer * denom,
    denom * that.denom)

  def lessThen(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this.lessThen(that)) that else this

  /* 비공개 메소드. 최대 공약수를 구한다. */
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
