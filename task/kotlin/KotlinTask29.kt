package task.kotlin

import kotlin.math.*

// 코틀린은 static 키워드는 없지만 companion object로 비슷하게 구현 가능.
// 컴패니언객체는 정적메소드처럼 동작하는 객체임.
// 클래스 내부에 선언된 실제 객체, 이름이 없는 객체(익명 객체)가 클래스당 하나씩 생성되는 방식.
// 실제 객체라서 변수할당,확장함수, 인터페이스 상속도 가능함.

class Calculator29 {
    companion object {
        const val pi = 3.14159

        fun plus(x: Int, y: Int): Int = x + y
        fun minus(x: Int, y: Int): Int = x - y
    }
}

fun main() {
    val result1 = 10 * 1 * Calculator29.pi
    val result2 = Calculator29.plus(10, 20)
    val result3 = Calculator29.minus(10, 20)

    println(result1)
    println(result2)
    println(result3)

    // 코틀린 math 활용
    println(E)
    println(PI)
    println(abs(-10))
    println(ceil(3.14))
    println(round(10.5))
    println(floor(10.9))
    println(max(10, 20))
    println(min(10, 20))
    println(2.0.pow(3.0))
    println(Math.random())
    println(sqrt(4.0))
}