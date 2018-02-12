val x = new String("abc")
val y = new String("abc")

/* true */
println(x == y)

/* false
 * 참조 동일성을 확인하는 메소드가 별도로 있다. */
println(x eq y)

/* true
 * eq 리버스 */
println(x ne y)


/* Null 은 값 타입과 호환성이 없다. */
val i: Int = null
