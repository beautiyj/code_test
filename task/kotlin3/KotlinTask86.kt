package task.kotlin3

// 스레드 동기화: synchronized 동기화 메소드

class Toilet {
    // synchronized로 선언된 openDoor() 메소드는 한번 실행이 끝나야 다음 실행이 가능함.
    @Synchronized                   // Java synchronized 키워드 대응
    fun openDoor(name: String, b: Boolean) {
        if (!b) {
            println(name)
            usingTime()
            println("아~~~~! 시원해")
        } else {
            println("사용중")
        }
    }

    fun usingTime() {
        for (i in 0 until 100000000) {
            if (i == 10000) println("끄으응")
        }
    }
}

class Family(private val who: String, private val toilet: Toilet) : Thread() {
    var key: Boolean = false

    override fun run() {
        toilet.openDoor(who, key)
    }
}

fun main() {
    val t = Toilet()

    val father = Family("아버지", t)
    val mother = Family("어머니", t)
    val sister = Family("누나", t)
    val brother = Family("형", t)
    val me = Family("나", t)

    father.start()
    mother.start()
    sister.start()
    brother.start()
    me.start()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| public synchronized void method()      | @Synchronized fun method()               | 코틀린 동기화 어노테이션                                         |
| synchronized(this) { }                 | synchronized(this) { }                   | 블록 단위 동기화는 동일하게 사용 가능                            |
| synchronized 직접 사용                 | 실무: Mutex (코루틴), ReentrantLock       | 코루틴 환경에서는 Mutex, 일반 스레드는 ReentrantLock 권장        |
*/