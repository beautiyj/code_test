/*
역순출력
학생들의 점수 배열을 뒤에서부터 하나씩 출력할 때

kotlin
 */

fun main() {
    println("기본 정석 출력 시\n")

    val scores = intArrayOf(80, 90, 100)
    for (i in scores.size - 1 downTo 0) {
        println("인덱스 ${i}번 점수: ${scores[i]}")
    }

    println("\n리버스 메서드(확장함수) 사용\n")

    for (score in scores.reversed()) {
        println(score)
    }
}

/*
** 출력 결과 **
기본 정석 출력 시

인덱스 2번 점수: 100
인덱스 1번 점수: 90
인덱스 0번 점수: 80

리버스 메서드(확장함수) 사용

100
90
80
 */