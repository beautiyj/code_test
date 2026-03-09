package test.kotlin

/*
정수 a와 b가 주어집니다.
각 수를 입력받아 입출력 예와 같은 형식으로 출력하는 코드를 작성해 보세요.

**예시**
입력
4 5

출력
a = 4
b = 5
*/

fun main() {
    val (a, b) = readln()
        .split(" ") // 공백을 기준으로 문자열 분리, 리스트화
        .map { it.toInt() } // 리스트의 각 요소들을 설정대로 변환
    println("a = $a")
    println("b = $b")
}