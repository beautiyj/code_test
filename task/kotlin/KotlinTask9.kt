package task.kotlin

/*
과제9

1~45사이의 숫자를 6개 추출하는 프로그램 만들기
(단, 중복된 숫자는 1번만 출력되도록 한다)

조건
Math.random() 함수를 이용
0.0 <= Math.random() < 1.0

 */

fun main() {
    // --- [방식 1] 자바 스타일 (Math.random 사용) ---
    println("=== 1. 코틀린: Math.random 방식 ===")
    val numbers = IntArray(6)
    var i = 0
    while (i < 6) {
        val randomNum = (Math.random() * 45).toInt() + 1

        if (randomNum !in numbers) { // 'in' 키워드로 중복 체크가 매우 쉬움
            numbers[i] = randomNum
            i++
        }
    }
    println(numbers.joinToString(", "))

    // --- [방식 2] 코틀린 치트키 (추천) ---
    println("\n=== 2. 코틀린: shuffle 방식 ===")
    val lotto = (1..45).shuffled().take(6).sorted()
    // 해석: 1~45 범위를 섞고(shuffled), 6개를 뽑아서(take), 정렬해라(sorted)
    println(lotto)
}