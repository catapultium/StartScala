package layout

abstract class ElementDemo {
  def demo(): Unit = {
    println("Element's implementation invoked")
  }
}

class ArrayElementDemo extends ElementDemo {
  override def demo(): Unit = {
    println("ArrayElement's implementation invoked")
  }
}

class LineElementDemo extends ArrayElementDemo {
  override def demo(): Unit = {
    println("LineElement's implementation invoked")
  }
}

class UniformElementDemo extends ElementDemo
