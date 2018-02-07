package helloWorld

import scala.io.Source

object LongLines {

  def processFile(filename: String, width: Int): Unit = {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }

  private def processLine(filename: String, width: Int, line: String): Unit = {
    if (line.length > width)
      println(filename + ": " + line.trim)
  }


  /* 함수 안에 함수를 쓸 수 있다. private 역할을 대신할 수 도 있으며 블록 내에서만 사용하므로 깔끔하다 */
  def processFile2(filename: String, width: Int) {

    def processLine(filename: String, width: Int, line: String): Unit = {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }
}
