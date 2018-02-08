package flowControl

object FlowControl {
  def main(args: Array[String]): Unit = {

    for (list <- FileMatcher.filesRegex(".*"))
      println(list)
  }
}
