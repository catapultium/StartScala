package rational

/* 주 생성자 */
class Rational(n: Int, d: Int) {
  /* n, d 는 클래스 파라미터 지칭한다. */

  /* 분모가 0이면 IllegalArgumentException 발생
  * Predef 독립 객체에 들어있음 */
  require(d != 0)

  /* 메소드 스코프에 바로 접근할 수 없기 떄문에 필드를 추가한다. */
  val numer: Int = n
  val denom: Int = d

  /* 지정하지 않으면 클래스이름@16진수숫자 */
  override def toString: String = n + "/" + d

  def add(that: Rational): Rational = new Rational(
    numer * that.denom + that.numer * denom,
    denom * that.denom)
}
