package rational

/* 주 생성자 */
class Rational(n: Int, d: Int) {
  /* n, d 는 클래스 파라미터 지칭한다. */
  override def toString: String = n + "/" + d
}
