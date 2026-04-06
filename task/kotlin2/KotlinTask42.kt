package task.kotlin2

// 롬복 사용 시 간략하게 가능 -> 코틀린은 'data class'로 더 간략하게 가능!
// data class는 자동으로 Getter, Setter(var일 때), ToString, Equals 등을 만들어줌
data class Task42Class(
    var member: Int = 0
)

data class Task42Class2(
    var member: Any? = null // Any는 자바의 Object 역할
)

class JavaTask42 {
    fun runGenericTest01() {
        val obj01 = Task42Class()
        // 코틀린은 .member = 3 이라고 쓰면 내부적으로 setter를 호출함 (롬복과 동일 원리)
        obj01.member = 3
        println("값 확인: ${obj01.member}")
    }

    fun runGenericTest02() {
        val obj01 = Task42Class2()

        // Object 기반이므로 롬복을 써도 넣고 뺄 때 박싱/캐스팅 원리는 동일합니다.
        obj01.member = 3.14

        // 롬복 덕분에 코드가 비즈니스 로직에만 집중할 수 있게 됩니다.
        // 코틀린은 'as Double'로 캐스팅하면 자동 언박싱됨
        val result = obj01.member as Double
        println("롬복으로 꺼낸 실수: $result")

        obj01.member = "롬복은 편리하다"
        println("롬복으로 확인한 문자열: ${obj01.member}")
    }
}

fun main() {
    val task = JavaTask42()
    println("--- 코틀린(롬복내장) 기반 테스트 시작 ---")
    task.runGenericTest01()
    task.runGenericTest02()
}