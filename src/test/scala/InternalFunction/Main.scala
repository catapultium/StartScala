package InternalFunction

object Main {
  def main(args: Array[String]): Unit = {
    /* if */
    val Num = 100

    /* 바로 할당 가능 */
    val style = if (Num > 50) "100" else 0
    println(style)

    /* while, do-while 은 가능한 recursive 권장
    * unit 과 "" 가 다르다는 것 기억 */

    /* for */
    val fileHere = new java.io.File(".").listFiles
    for (file <- fileHere)
      println(file)

    /* 마지막 포함 */
    for (i <- 1 to 4)
      println("Iteration " + i)

    /* 마지막 제외 */
    for (i <- 1 until 4)
      println("Iteration " + i)

    /* 필터링 */
    for (file <- fileHere if !file.getName.endsWith(".sbt"))
      println(file)

    /* 여러개 필터 */
    for (
      file <- fileHere
      if !file.getName.endsWith(".sbt")
      if file.isDirectory
    ) println(file)

    /* 중첩 루프 = */
    def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

    /* 중괄호를 사용하면 세미콜론 추론이 된다. */
    def grep(pattern: String) =
      for {
        file <- fileHere
        if file.getName.endsWith(".gitignore")
        line <- fileLines(file)
        /* for 내부에 변수 바인딩 */
        trimmed = line.trim
        if trimmed.matches(pattern)
      } println(file + ": " + trimmed)

    grep(".*idea.*")

    /* 결과를 새로운 컬렉션으로 할당 */
    def ignoreFile =
      for {
        file <- fileHere
        if file.getName.endsWith(".gitignore")
      } yield file

    for (file <- ignoreFile)
      println(file.getName)

    /* 결과를 새로운 컬렉션으로 할당2 */
    val forLineLengths =
      for {
        file <- fileHere
        if file.getName.endsWith(".gitignore")
        line <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(".*idea.*")
      } yield trimmed.length
    for (len <- forLineLengths)
      println(len)


    /* match */
    val firstArg = if (args.length > 0) args(0) else "chips"
    val friend = firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }
    println(friend)
  }
}
