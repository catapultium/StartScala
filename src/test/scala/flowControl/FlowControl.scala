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


    /* 새로운 제어 구조 */

    /* op 는 double 을 받아 double 을 리턴한다는 것 말고는 아무 내용이 없다.
    * x 로 들어온 값을 아직 정해지지 안은 op를 2번 반복한다. */
    def twice(op: Double => Double, x: Double) = op(op(x))

    /* op 함수의 내용을 넣어주었다. double 로 받은 값에 +1 후 리턴 */
    println(twice(_ + 1, 5))
    println(twice((num: Double) => num + 1, 5))

    /* 함수 자리라는 것을 알기 때문에 위치표시자를 사용하여 바로 파라미터 사용이 가능하다. */
    println(twice(Math.PI * _, 1))

  }
}
