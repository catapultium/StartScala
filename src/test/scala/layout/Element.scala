package layout

/* 추상맴버를 데리고 있어서 추상 클래스. 그래서 바로 인스턴스로 못 만듬. new Element 이런거 안됨. */
abstract class Element {

  /* 추상맴버. 구현없음. 따로 abstract 를 붙이지 않더라도 구현이 없으면 추상맴버. */
  def contents: Array[String]

  /* ()가 없는 파라미터 없는 메소드이다.
  * val height: Int = contents.length
  * 이렇게 사용할 수도 있으며, 차이점은
  * 필드를 사용하면 클래스가 초기화시에 값을 미리 계산해 두며 각 필드를 저장할 별도 메모리 공간이 필요하다 */
  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  /* 스칼라는 빈 괄호를 모두 생략할 수 있지만 부수효과가 있는 경우에는 사용하기를 권장
   * "hello".length
   * println() */

  def above(that: Element): Element = new ArrayElement(this.contents ++ that.contents)

  def beside(that: Element): Element = {
    val contents = new Array[String](this.contents.length)
    for (i <- 0 until this.contents.length)
      contents(i) = this.contents(i) + that.contents(i)
    new ArrayElement(contents)
  }

}
