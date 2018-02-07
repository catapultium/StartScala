package function

import helloWorld.LongLines

object Function {
  def main(args: Array[String]): Unit = {

    /* run 파라미터 설정 필요
    45 .gitignore */
    val width = args(0).toInt
    for (arg <- args.drop(1)) {
      LongLines.processFile(arg, width)
      println()
      LongLines.processFile2(arg, width)
    }
  }
}
