package task.kotlin3

// 스레드 상태 제어 - sleep()

class ThreadSleep : Runnable {
    override fun run() {
        for (i in 1 until 10) {
            println("${Thread.currentThread().name} : $i")
            try {
                // 1초 동안 thread를 block 상태에 빠트림
                Thread.sleep(1000)      // (단위: 1/1000 초)
            } catch (ie: InterruptedException) {
                println(ie.toString())
            }
        }
    }
}

fun main() {
    val ts = ThreadSleep()

    // 두 개의 Thread를 생성시켜 실행시킴 (동일 우선순위 5)
    val first = Thread(ts, "first1")
    val second = Thread(ts, "second1")
    first.start()
    second.start()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                       |
|----------------------------------------|------------------------------------------|------------------------------------------------------------|
| Thread.sleep(1000)                     | Thread.sleep(1000)                       | 동일 (JVM 공유)                                            |
| catch (InterruptedException ie)        | catch (ie: InterruptedException)         | 코틀린 예외 캐치 문법                                       |
| Thread.sleep() 직접 사용               | 실무: delay() (코루틴 내부)              | 코루틴에서는 Thread.sleep() 대신 delay() 사용               |
*/