package task.kotlin3

// 스레드의 우선순위

class ThreadPriority : Runnable {
    override fun run() {
        for (i in 1..20) {
            println("${Thread.currentThread().name} number = $i")
        }
    }
}

// 스레드 우선순위 직접 제어 클래스 - 우선순위만으로 스레드 제어하는 건 어려움
class ThreadPriorityControl : Runnable {
    override fun run() {
        for (i in 1..10) {
            println("${Thread.currentThread().name} number = $i")
        }
    }
}

fun main() {
    println("=== 1. ThreadPriority (기본 우선순위 확인) ===")
    val tp = ThreadPriority()

    val first1 = Thread(tp, "tp-first1")
    val second1 = Thread(tp, "tp-second1")
    val third1 = Thread(tp, "tp-third1")

    // thread의 우선순위를 출력하는 부분 (지정하지 않으면 5)
    println("tp-first priority =${first1.priority}")
    println("tp-second priority =${second1.priority}")
    println("tp-third priority =${third1.priority}")

    println("\n========================================================================")
    println("\n=== 2. ThreadPriorityControl (우선순위 직접 제어) ===")

    val tpc = ThreadPriorityControl()

    // 최고순위(MAX_PRIORITY:10) / 순위 미지정(NORM_PRIORITY:5) / 최저순위(MIN_PRIORITY:1)

    val first2 = Thread(tpc, "first1")
    first2.priority = Thread.MIN_PRIORITY           // 최저순위(1) 설정
    println("first priority = ${first2.priority}")

    val second2 = Thread(tpc, "second1")
    second2.priority = Thread.MAX_PRIORITY          // 최고순위(10) 설정
    println("second priority = ${second2.priority}")

    val third2 = Thread(tpc, "third1")
    println("third priority = ${third2.priority}")  // 기본값 5

    println("\n=== 스레드 실행 시작 ===")
    // 우선순위가 높다고 먼저 실행되는 건 아님. CPU 점유 확률이 높을 뿐.
    first2.start()
    second2.start()
    third2.start()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| thread.getPriority()                   | thread.priority                          | 코틀린 프로퍼티 접근 방식                                        |
| thread.setPriority(Thread.MAX_PRIORITY)| thread.priority = Thread.MAX_PRIORITY    | 코틀린 프로퍼티 세터 방식                                        |
| Thread.MIN_PRIORITY / MAX_PRIORITY     | 동일                                     | 자바 상수 그대로 사용 가능 (JVM 공유)                            |
| 우선순위로 스레드 제어                  | 실무: coroutine Dispatchers 권장          | 코루틴이 더 세밀한 스레드 제어 가능                              |
*/