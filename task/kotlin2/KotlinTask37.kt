package task.kotlin2

import java.util.*

// [방법 1] 기본 방식 (기존 자바 Solution37 로직)
class Solution37 {
    fun run() {
        val sc = Scanner(System.`in`)
        println("주민번호 앞자리를 입력하세요")
        val j1 = sc.nextLine()
        println("주민번호 뒷자리를 입력하세요")
        val j2 = sc.nextLine()

        when {
            j1.isEmpty() -> println("앞자리가 입력되지 않았습니다.")
            j1.length != 6 -> println("앞자리 6자리가 아닙니다.")
            j2.isEmpty() -> println("뒷자리가 입력되지 않았습니다.")
            j2.length != 7 -> println("뒷자리 7자리가 아닙니다.")
            else -> {
                if (checkJumin(j1 + j2)) println("올바른 주민번호 입니다")
                else println("잘못된 주민번호")
            }
        }
    }

    private fun checkJumin(jumin: String): Boolean {
        val r = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5)
        val total = (0..11).sumOf { i ->
            jumin[i].digitToInt() * r[i]
        }
        val result = (11 - (total % 11)) % 10
        return result == jumin[12].digitToInt()
    }
}

// 방법2 앞뒤 따로 받는 방식은 코틀린에서 필요없음(바로 매핑 가능)

// [방법 3] 코틀린 실무 최적화 방식 (T3 대응)
class Solution37T3 {
    fun checkJumin(input: String): Boolean {
        // 숫자만 필터링 (전처리)
        val cleanJumin = input.filter { it.isDigit() }
        if (cleanJumin.length != 13) return false

        val weights = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5)

        // 함수형 스타일 연산
        val total = weights.indices.sumOf { i ->
            cleanJumin[i].digitToInt() * weights[i]
        }

        val checkSum = (11 - (total % 11)) % 10
        return checkSum == cleanJumin[12].digitToInt()
    }

    fun run() {
        println("주민번호를 입력하세요 (예: 990101-1234567):")
        val input = readlnOrNull() ?: ""

        if (checkJumin(input)) {
            println("결과: 올바른 주민번호입니다.")
        } else {
            println("결과: 유효하지 않은 주민번호입니다.")
        }
    }
}

fun main() {
    // Solution37().run()
    Solution37T3().run()
}