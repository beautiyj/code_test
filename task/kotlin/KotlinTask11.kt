package task.kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    println("점수를 입력해주세요.")
    val n = sc.nextInt()
    println("점수를 입력해주세요.")
    val m = sc.nextInt()

    // 고정값의 경우 (자바의 첫 번째 switch와 동일)
    // 인자(n)가 있는 when문
    when (n) {
        90 -> println("A학점")
        80 -> println("B학점")
        70 -> println("C학점")
        60 -> println("D학점")
        else -> println("F학점")
    }

    // 범위 판별 (자바의 n / 10 편법이 필요 없음)
    // 코틀린은 'in' 키워드로 범위를 바로 넣을 수 있어서 편함!!!!!!!자바도제발...
    when (m) {
        in 90..100 -> println("A학점")
        in 80..89 -> println("B학점")
        in 70..79 -> println("C학점")
        in 60..69 -> println("D학점")
        else -> println("F학점")
    }
}