package task.kotlin2

// Wrapper 클래스 응용 1 (기본형 제약 확인용)
class TestClass {
    private var member: Int = 0           // 필드
    fun getValue(): Int { return member }
    fun setValue(value: Int) { member = value }
}

// Wrapper 클래스 응용 2 (Any를 이용한 범용성 확인용 - 자바의 Object 역할)
class TestClass2 {
    private var member: Any? = null       // Any는 자바의 Object와 대응됨
    fun getValue(): Any? { return member }
    fun setValue(value: Any?) { member = value }
}

class JavaTask41 {
    fun runGenericTest01() {
        val obj01 = TestClass()
        obj01.setValue(3)               // 정상적인 호출가능
        println("되돌리는 값은->${obj01.getValue()}")     // 3

        // 아래 코드는 컴파일 에러 발생
        // obj01.setValue(3.4)             // 에러발생. 변수는 Int 선언이라.
        // obj01.setValue("이해할 수 있다.")  // 에러발생 변수는 Int 선언이라.
        println("GenericTest01 실행 완료 (Int 전용)")
    }

    fun runGenericTest02() {
        val obj01 = TestClass2()

        // Any value = 3                  자동박싱 과정으로 전개된다~
        obj01.setValue(3)
        println("되돌리는 값은->${obj01.getValue()}")     // 3

        // 다운 캐스팅(자료형 복구) + 언박싱
        // 코틀린은 as Int로 형변환하면 자동으로 언박싱됨
        val n = obj01.getValue() as Int

        // Any value = 3.4                자동박싱
        obj01.setValue(3.4)
        println("되돌리는 값은->${obj01.getValue()}")       // 3.4

        // 다운 캐스팅 + 언박싱
        val d = obj01.getValue() as Double

        // Any value = "이해할 수 있다."
        obj01.setValue("이해할 수 있다.")
        println("되돌리는 값은->${obj01.getValue()}")       // 이해할 수 있다.

        // 다운 캐스팅
        val str = obj01.getValue() as String
        println("GenericTest02 실행 완료 (Any 범용)")
    }
}

fun main() {
    val task = JavaTask41()
    println("--- Test 01 시작 ---")
    task.runGenericTest01()
    println("\n--- Test 02 시작 ---")
    task.runGenericTest02()
}