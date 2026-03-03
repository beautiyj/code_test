/*
 * 3. 키보드를 이용해서 입력한 정수의 팩토리얼 구하기
 *
 * 예시: 3! = 3 * 2 * 1
 *
 */

fun main() {
    println("양의 정수를 입력하시오")
    val n = readln().toInt()
    var result = 1      // 반복문에서 값이 변경되므로 var 선언 필요

    for (i in 1..n) {   // 코틀린의 1..n은 영역이 1부터 n까지다
        result*=i
    }
    println("$n! = $result")
}

// readLine은 null들어올 수 있는데
// readln은 무조건 값이 존재함 기반이라서 세이프콜 등이 필요없음 = 간결한 코드