package task.kotlin

import java.util.*

fun main() {
    val cal = Calendar.getInstance()

    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH) + 1
    val date = cal.get(Calendar.DATE)

    val week = listOf("", "일", "월", "화", "수", "목", "금", "토")
    val day = week[cal.get(Calendar.DAY_OF_WEEK)]

    val hour = cal.get(Calendar.HOUR)
    val min = cal.get(Calendar.MINUTE)
    val sec = cal.get(Calendar.SECOND)

    println("오늘 날짜: ${year}년 ${month}월 ${date}일 (${day}요일)")
    println("현재 시간: ${hour}시 ${min}분 ${sec}초")
}
