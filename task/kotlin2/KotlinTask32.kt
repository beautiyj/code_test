package task.kotlin2

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

// 코틀린에서는 Scanner보다는 readln()을, Random 보다는 (1..45).random()을 선호함.
// 코틀린도 자바 기반이라 이전의 심플~ 형태도 존재하긴 했으나 현재는 단점 보완한 포매터 사용.
fun main() {

    // 날짜 및 시간
    val now = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    println("신형 포맷: ${now.format(formatter)}")

    // 입력 및 난수
    val sc = Scanner(System.`in`)

    print("메시지를 입력하세요: ")
    val input = readln()
    println("입력하신 내용: $input")

    val random = Random()
    val num = random.nextInt(45) + 1
    println(num)

    val num2 = (1..45).random()
    println(num2)

}
