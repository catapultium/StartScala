package layout

object Layout {
  def main(args: Array[String]): Unit = {
    val e1: Element = new ArrayElement(Array("hello", "world"))
    val ae: ArrayElement = new LineElement("hello")
    var e2: Element = ae
    var e3: Element = new UniformElement('x', 2, 3)


    /* 슈퍼클래스 상속 테스트 */
    def invokedDemo(e: ElementDemo): Unit = {
      e.demo()
    }

    /* 오버라이드 하지 않으면 슈퍼클래스 구현을 물려받는다. */
    invokedDemo(new ArrayElementDemo)
    invokedDemo(new LineElementDemo)
    invokedDemo(new UniformElementDemo)
  }
}
