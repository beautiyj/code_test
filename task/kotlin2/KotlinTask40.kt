package task.kotlin2

// Wrapper 랩퍼 클래스 (코틀린은 모든 것이 객체지만 내부적으로 최적화됨)
// 박싱과 언박싱 (코틀린은 컴파일러가 알아서 처리하므로 구분이 거의 없음)

class WrapperTest1 {
    fun wrapperTest1() {
        // Int형 변수의 최대 최소
        println(Int.MAX_VALUE)
        println(Int.MIN_VALUE)

        // String형을 Int형으로 형변환 (toInt() 사용)
        val n = "20".toInt()
        println(n)      // 20
        println(n + 10) // 30 산술연산 가능

        // 10진수 -> 2, 8, 16진수 변환 (toString(radix) 사용)
        println(10.toString(2))  // 1010
        println(10.toString(8))  // 12
        println(10.toString(16)) // a
        println()
    }
}

class WrapperTest3 {
    fun wrapperTest3() {
        // 자동 박싱(Auto-boxing): 코틀린은 기본적으로 객체로 취급
        val newObj1: Int = 10
        val newObj2: Int = "200".toInt()
        val newObj3: Int = Integer.valueOf("300") // 자바 클래스 호출도 가능

        // 자동 언박싱(Auto-unboxing)
        val newValue1: Int = newObj1
        val newValue2: Int = newObj2
        val newValue3: Int = newObj3

        println(newValue1)
        println(newValue2)
        println(newValue3)
        println()
    }
}

class WrapperTest6 {
    fun wrapperTest6() {
        val value1 = "10".toInt()
        val value2 = "3.14".toDouble()
        val value3 = "true".toBoolean()
        val value4 = "TRUE".toBoolean()
        val value5 = "test".toBoolean() // 논리값 아니면 false 출력

        println("value1 = $value1")
        println("value2 = $value2")
        println("value3 = $value3")
        println("value4 = $value4")
        println("value5 = $value5")
        println()
    }
}

fun main() {
    WrapperTest1().wrapperTest1()
    WrapperTest3().wrapperTest3()
    WrapperTest6().wrapperTest6()
}