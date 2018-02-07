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

    /* 함수 리터럴 */
    val increase = (x: Int) => x + 1
    println(increase(10))

    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach((x: Int) => println(x))
    someNumbers.filter((x: Int) => x > 0).foreach((x: Int) => println(x))

  }
}
