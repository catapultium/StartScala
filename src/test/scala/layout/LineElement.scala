package layout

/* Element 를 바로 상속하도록 변경 */
class LineElement(s: String) extends Element {
  val contents = Array(s)

  override def width = s.length

  override def height = 1

}
