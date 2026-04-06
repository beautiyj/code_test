package task.kotlin2

// 코틀린에서는 자바의 강제 형변환 (Type) 대신 as 키워드를 사용


import java.util.*

fun main() {
    print("연도를 입력하세요(ex. 2020): ")
    // readln()을 통해 입력을 받고 정수로 변환
    val input = readlnOrNull() ?: ""
    val year = input.toIntOrNull() ?: 0

    // 1. 업캐스팅 (자동 형변환)
    // 부모 타입인 Calendar에 자식 객체를 담음
    val cal: Calendar = GregorianCalendar()

    // 2. 다운캐스팅 (강제 형변환)
    // isLeapYear()는 GregorianCalendar에만 있으므로 'as'로 형변환 필요
    val gcal = cal as GregorianCalendar

    // 윤년 판별 로직 실행
    if (gcal.isLeapYear(year)) {
        println("${year}년은 윤년(366일)입니다.")
    } else {
        println("${year}년은 평년(365일)입니다.")
    }
}