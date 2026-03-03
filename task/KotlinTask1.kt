import kotlin.math.max
import kotlin.math.min

/*
 * 과제 1 키보드로 3개의 정수를 입력받았을 때 max min 구하기
 *
 * 제한사항: 조건연산자 활용
 * 혹은
 * 제한사항: if else문 활용

 */

// 코틀린엔 조건연산자가 따로 존재하지 않는다.
// KotlinTask2 파일을 별도로 만들지 않고 if-else문 활용과 max min 함수 활용법만 같이 기재한다.

fun main() {
    println("정수 3개를 입력하시오")
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    val maxVal = if (a > b) a else (if (b > c) b else c)
    val minVal = if (a < b) a else (if (b < c) b else c)

    println(maxVal)
    println(minVal)

    main2()
}

fun main2() {
    println("정수 3개를 입력하시오")
    val n1 = readLine()?.toInt() ?: 0       // 입력값이 없을 경우를 대비한 안전빵
    val n2 = readLine()?.toInt() ?: 0
    val n3 = readLine()?.toInt() ?: 0

    val maxF = max(n1, (max(n2, n3)))
    val minF = min(n1, (min(n2, n3)))

    println("$maxF $minF")      // 코틀린은 println(a,b) 형태처럼 쉼표 사용이 불가능하다
}                               // 원한다면 $ 문자열템플릿을 사용하여 출력할 것.