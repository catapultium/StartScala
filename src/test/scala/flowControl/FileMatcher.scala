package flowControl

object FileMatcher {

  private def filesHere = new java.io.File(".").listFiles()

  /* matcher 는 2개의 String 을 받고 Boolean 을 리턴하는 함수 리터럴 */
  def filesMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }

  def filesEnding(query: String) =
    filesMatching(query, _.endsWith(_))

  def filesContaining(query: String) =
    filesMatching(query, _.contains(_))

  def filesRegex(query: String) =
    filesMatching(query, _.matches(_))

  /* 위 3개 모두 위치표시자를 사용했다. 아래 문장과 동치 관계이다.
  * 첫번째 인자와 두번째 인자를 _로 표기하여 단순하게 만들었다. */
  def filesRegex2(query: String) =
    filesMatching(query, (fileName: String, query: String) => fileName.matches(query))

  /* 타입이 정해져 있기 때문에 명시하지 않아도 된다. */
  def filesRegex3(query: String) =
    filesMatching(query, (fileName, query) => fileName.matches(query))



  /* 클로저를 사용하여 더 줄일 수 있다. */
  def filesMatchingC(matcher: String => Boolean) = {
    for (file <- filesHere; if matcher(file.getName))
      yield file
  }

  def filesRegexC(query: String) =
    filesMatchingC(_.matches(query))


}
