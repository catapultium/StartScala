package traitTest

class Animal

class Frog extends Animal with Philosophical {
  override def toString = "green"

  override def philosophize(): Unit = {
    println("It ain't easy being " + toString + "!")
  }
}
