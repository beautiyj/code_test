package task.kotlin3

// 스레드 생명주기

class ThreadLife : Runnable {
    override fun run() {
        for (i in 1..20) {
            // thread의 이름과 정수 출력
            println("${Thread.currentThread().name} number = $i")
        }
    }
}

fun main() {
    // 스레드 메뉴얼 설정
    val tl = ThreadLife()

    // 스레드 객체 생성
    val t1 = Thread(tl, "First-Thread")
    val t2 = Thread(tl, "Second-Thread")
    val t3 = Thread(tl, "Third-Thread")

    // 각자 하나의 run() 메소드가 실행되는 스레드 시작
    t1.start()
    t2.start()
    t3.start()
    println("=== 메인 스레드 종료 ===")
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                       |
|----------------------------------------|------------------------------------------|------------------------------------------------------------|
| Thread.currentThread().getName()       | Thread.currentThread().name              | 코틀린 프로퍼티 접근 방식                                   |
| new Thread(runnable, "이름")           | Thread(runnable, "이름")                 | new 키워드 불필요                                           |
| implements Runnable + @Override run()  | : Runnable + override fun run()          | 코틀린 인터페이스 구현 문법                                 |
*/