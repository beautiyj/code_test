package task.kotlin3

// 과제 - 스레드를 이용해서 현재 시간을 1초에 1번씩 출력하는 프로그램 만들기
// 단, 연 월 일 시 분 초 형태로 출력하기

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ClockThread : Thread() {
    override fun run() {
        // Java의 SimpleDateFormat 대신 코틀린 실무: DateTimeFormatter 사용
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        while (true) {
            val now = LocalDateTime.now()
            println(now.format(formatter))
            try {
                sleep(1000)         // 1초 대기
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}

fun main() {
    val t1 = ClockThread()
    t1.start()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| new SimpleDateFormat("yyyy-MM-dd ...")  | DateTimeFormatter.ofPattern(...)        | Java 8+ / 코틀린 실무 표준 날짜 포맷터                           |
| new Date()                             | LocalDateTime.now()                      | Java 8+ 날짜 API, thread-safe하고 불변 객체                      |
| sdf.format(now)                        | now.format(formatter)                    | 코틀린/Java 8+ 포맷 방식                                         |
| Thread.sleep(1000)                     | sleep(1000) (Thread 내부)                | Thread 상속 내부에서는 sleep() 바로 호출 가능                    |
*/