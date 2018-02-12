package layout

/* 그래서 contents 를 파라미터 필드로 정의했다.
 * () 안에 private 같은 수식자 등도 추가 가능하다. */
class ArrayElement(val contents: Array[String]) extends Element {

  /* 단순히 contents 필드로 복사하기 위해 conts 라는 이름이 나왔다.
   * def contents: Array[String] = conts */
}
