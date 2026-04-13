package task.kotlin3

// 제네릭 예제

import java.util.*

class GenericClass<T> {
    private var member: T? = null

    fun getValue(): T? {
        return member
    }

    fun setValue(value: T) {
        member = value
    }
}

class Collections06 {
    fun collection06() {
        val vec: Vector<String> = Vector()
        // 제네릭 사용하지 않을 경우 Vector<Any> vec2 = Vector() ++ 여러가지 자료형 넣을 수 있음
        vec.add("Apple")        // 업캐스팅
        vec.add("banana")
        vec.add("oRANGE")
        // vec.add(30)          제네릭 <String> 선언으로 Int 추가 시 컴파일 에러

        for (i in 0 until vec.size) {
            // 제네릭을 사용하지 않으면 자료형 생략 불가
            // val temp = vec[i] as String  // 다운캐스팅
            val temp: String = vec[i]       // 제네릭 처리로 다운캐스팅 불필요
            println(temp.uppercase())
        }
    }
}

fun main() {

    // GenericTest05
    val obj01 = GenericClass<Double>()
    obj01.setValue(3.4)
    println("되돌리는 값은->${obj01.getValue()}")

    val obj02 = GenericClass<Int>()
    obj02.setValue(10)
    println("되돌리는 값은->${obj02.getValue()}")

    val obj03 = GenericClass<String>()
    obj03.setValue("이해할 수 있다.")
    println("되돌리는 값은->${obj03.getValue()}")

    println("=============================================================")
    println()

    val col06 = Collections06()
    col06.collection06()
}