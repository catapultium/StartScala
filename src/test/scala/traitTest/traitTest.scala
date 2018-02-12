package traitTest

object traitTest {
  def main(args: Array[String]): Unit = {
    val frog = new Frog
    frog.philosophize()

    val phil: Philosophical = frog
    phil.philosophize()
  }
}
