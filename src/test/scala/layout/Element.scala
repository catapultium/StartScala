package layout

/* elem 만 사용하여 접근 가능하도록 */

import Element.elem

/* 추상맴버를 데리고 있어서 추상 클래스. 그래서 바로 인스턴스로 못 만듬. new Element 이런거 안됨. */
abstract class Element {

  /* 추상맴버. 구현없음. 따로 abstract 를 붙이지 않더라도 구현이 없으면 추상맴버. */
  def contents: Array[String]

  /* ()가 없는 파라미터 없는 메소드이다.
  * val height: Int = contents.length
  * 이렇게 사용할 수도 있으며, 차이점은
  * 필드를 사용하면 클래스가 초기화시에 값을 미리 계산해 두며 각 필드를 저장할 별도 메모리 공간이 필요하다 */
  def height: Int = contents.length

  def width: Int = contents(0).length

  /* 스칼라는 빈 괄호를 모두 생략할 수 있지만 부수효과가 있는 경우에는 사용하기를 권장
   * "hello".length
   * println() */

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  def beside(that: Element): Element = {
    //    val contents = new Array[String](this.contents.length)
    //    for (i <- 0 until this.contents.length)
    //      contents(i) = this.contents(i) + that.contents(i)
    //    new ArrayElement(contents)

    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )

    /* zip
    * Array(1, 2, 3) zip Array("a", "b")
    * Array((1, "a"), (2, "b")) */
  }

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      var bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"

}

object Element {

  /* 그래서 contents 를 파라미터 필드로 정의했다.
 * () 안에 private 같은 수식자 등도 추가 가능하다. */
  private class ArrayElement(val contents: Array[String]) extends Element {

    /* 단순히 contents 필드로 복사하기 위해 conts 라는 이름이 나왔다.
     * def contents: Array[String] = conts */
  }

  /* Element 를 바로 상속하도록 변경 */
  private class LineElement(s: String) extends Element {
    val contents = Array(s)

    override def width = s.length

    override def height = 1

  }

  private class UniformElement(ch: Char,
                               override val width: Int,
                               override val height: Int,
                              ) extends Element {
    private val line = ch.toString * width

    def contents = Array.fill(height)(line)
  }

  /* 팩토리 메소드 추가 */
  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)

  def elem(line: String): Element = new LineElement(line)
}
