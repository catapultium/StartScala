package layout

import Element.elem

object Layout {
  def main(args: Array[String]): Unit = {

    val space = elem(" ")
    val corner = elem("+")

    def spiral(nEdges: Int, direction: Int): Element = {
      if (nEdges == 1)
        elem("+")
      else {
        val sp = spiral(nEdges - 1, (direction + 3) % 4)

        def verticalBar = elem('|', 1, sp.height)

        def horizontalBar = elem('-', sp.width, 1)

        if (direction == 0)
          (corner beside horizontalBar) above (sp beside space)
        else if (direction == 1)
          (sp above space) beside  (corner above verticalBar)
        else if (direction == 2)
          (space beside sp) above (horizontalBar beside corner)
        else
          (verticalBar above corner) beside (space above sp)
      }
    }

    println(spiral(17, 0))


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
