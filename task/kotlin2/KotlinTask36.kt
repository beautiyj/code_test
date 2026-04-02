package task.kotlin2

import java.util.*

class Solution36 {
    // 1. 문자열 클래스 String
    // 키보드로 주민번호를 입력 받아서 남녀 성별 판별하는 프로그램
    // 단, 앞자리 6자리, 뒷자리 7자리 유효성 검사하기
    fun solutionBasic() {
        val sc = Scanner(System.`in`)
        try {
            println("주민번호 앞자리 입력:")
            val j1 = sc.nextLine()
            println("주민번호 뒷자리 입력:")
            val j2 = sc.nextLine()

            val g = if (j2.isNotEmpty()) j2.substring(0, 1) else ""

            when {
                j1.isEmpty() -> println("주민번호 앞자리가 입력되지 않았습니다.")
                j1.length != 6 -> println("주민번호 앞자리 6자리가 입력되지 않았습니다.")
                j2.isEmpty() -> println("주민번호 뒷자리가 입력되지 않았습니다.")
                j2.length != 7 -> println("주민번호 뒷자리 7자리가 입력되지 않았습니다.")
                g == "1" || g == "3" -> println("남자")
                g == "2" || g == "4" -> println("여자")
                else -> println("서식 오류")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // 2. 생년월일 등까지 체크하는 예외처리 유효성검사라면
    fun solutionDetail() {
        val sc = Scanner(System.`in`)
        try {
            println("앞자리(6자리):")
            val j1 = sc.nextLine()
            println("뒷자리(7자리):")
            val j2 = sc.nextLine()

            if (j1.length != 6) {
                println("주민번호 앞자리 6자리가 아닙니다.")
            } else if (j2.length != 7) {
                println("주민번호 뒷자리 7자리가 아닙니다.")
            } else {
                val month = j1.substring(2, 4).toInt()
                val day = j1.substring(4, 6).toInt()

                when {
                    month !in 1..12 -> println("서식 오류. 유효하지 않은 월입니다.")
                    day !in 1..31 -> println("서식 오류. 유효하지 않은 일입니다.")
                    else -> {
                        when (j2[0]) {
                            '1', '3' -> println("결과: 남자")
                            '2', '4' -> println("결과: 여자")
                            else -> println("성별 코드 오류")
                        }
                    }
                }
            }
        } catch (e: NumberFormatException) {
            println("오류: 숫자만 입력 가능합니다.")
        }
    }

    // 3. 실무 방식 (초간결 간단하게 조건 충족)
    fun solutionPro() {
        print("주민번호 입력(- 포함 가능): ")
        val input = readln().replace("-", "")

        // 정규식 및 길이 체크 후 바로 판별
        if (input.length == 13 && input.all { it.isDigit() }) {
            val res = when(input[6]) {
                '1', '3' -> "남"
                '2', '4' -> "여"
                else -> "오류"
            }
            println("결과: $res")
        } else {
            println("잘못된 형식입니다.")
        }
    }
}

fun main() {
    val sol = Solution36()
    // sol.solutionBasic()
    // sol.solutionDetail()
    sol.solutionPro()
}