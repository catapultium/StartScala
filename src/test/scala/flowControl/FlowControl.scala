package flowControl

object FlowControl {
  def main(args: Array[String]): Unit = {

    for (list <- FileMatcher.filesRegex(".*"))
      println(list)


    /* curring */
    def plainOldSum(x: Int, y: Int) = x + y

    def curriedSum(x: Int)(y: Int) = x + y

    /* 첫번째로 동작하는 함수의 모양 */
    def first(x: Int) = (y: Int) => x + y

    /* 이렇게 두번째 함수를 얻는다. */
    def second = first(1)

    /* 이걸 실행하면 이렇게 된다. */
    println(curriedSum(1)(2))
    println(second(2))

    val onePlus = curriedSum(1) _
    println(onePlus(2))
  }
}
