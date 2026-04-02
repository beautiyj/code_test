package task.kotlin2

// [Test 1] StringBuilder 활용
object KotlinBuilder1 {
    fun stringBuilder1() {
        val sb1 = StringBuilder("gemini")
        println("sb1.length : ${sb1.length}")
        // 자바의 capacity와 동일하게 작동
        println("sb1.capacity : ${sb1.capacity()}")

        sb1.append("A string buffer implements a mutable sequence of characters")
        println("sb1.length : ${sb1.length}")
        println("sb1.capacity : ${sb1.capacity()}")
    }
}

// [Test 2] 코틀린 실무 스타일 (buildString)
object KotlinBuilder2 {
    fun stringBuilder2() {
        // 실무에선 StringBuilder 객체를 만들고 append를 일일이 쓰기보다
        // buildString 블록을 사용하는 것이 훨씬 코틀린답습니다.
        val result = buildString {
            append("gemini")
            append(" is beautiful")
            append(1004)
        }

        println("result = $result")
        println(result.uppercase())
    }
}

// [Test 3] insert 메소드
object KotlinBuilder3 {
    fun stringBuilder3() {
        val sb1 = StringBuilder("gemini is beautiful")

        sb1.insert(10, "very")
        println(sb1)

        sb1.insert(0, 1004)
        println(sb1)
    }
}

fun main() {
    KotlinBuilder1.stringBuilder1()
    println("--------------------")
    KotlinBuilder2.stringBuilder2()
    println("--------------------")
    KotlinBuilder3.stringBuilder3()
}