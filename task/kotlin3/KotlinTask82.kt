package task.kotlin3

// 스레드
// 1. Thread 클래스를 상속 받아서 만드는 방법
// 2. Runnable 인터페이스를 구현해서 만드는 방법

class ThreadEnd : Thread() {
    override fun run() {
        // thread가 시작되면 실행되는 문장
        for (i in 1..20) {
            println("run number = $i")
        }
    }
}

class RunnableTest : Runnable {
    // 1부터 20까지 화면에 출력시키는 메소드
    fun printNumber() {
        for (i in 1..20) {
            println("number = $i")
        }
    }

    // 인터페이스를 구현할 경우, 메소드 오버라이드 필수
    override fun run() {
        printNumber()
    }
}

// 멀티스레드로 진행할 때와 싱글스레드 2개 따로 실행할 때랑 차이가 있음
fun main() {
    println("=== 전체 테스트 시작 - 싱글스레드 2개 넣어서 해당 로직은 멀티스레드임 ===")

    // 1번 예제 실행 (Thread 상속 방식)
    val tt = ThreadEnd()
    tt.start()

    // 2번 예제 실행 (Runnable 구현 방식)
    val rt = RunnableTest()
    val t2 = Thread(rt)
    t2.start()

    println("=== 메인 스레드 작업 완료 (서브 스레드들은 계속 도는 중) ===")
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| class X extends Thread                 | class X : Thread()                       | 코틀린 상속 문법                                                 |
| class X implements Runnable            | class X : Runnable                       | 코틀린 인터페이스 구현 문법                                      |
| @Override public void run()            | override fun run()                       | 코틀린 오버라이드 키워드                                         |
| new Thread(runnable).start()           | Thread(runnable).start()                 | new 키워드 불필요                                                |
| Thread / Runnable 직접 사용            | 실무: coroutine (launch {}) 권장          | 코틀린 실무에선 코루틴이 스레드보다 경량화되어 선호됨             |
*/