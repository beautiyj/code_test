package task.kotlin2

// 인터페이스 간의 상속 (Interface Inheritance)
// 인터페이스끼리는 다중 상속(: A, B)이 가능합니다.
interface InterfaceHello59 {
    companion object {
        const val a = 10 // 코틀린에서 인터페이스 상수는 companion object에 선언
    }
    fun sayHello(name: String)
}

interface InterfaceGoodBye59 {
    fun sayGoodBye(name: String)
}

// 인터페이스끼리 상속을 받을 때는 콜론(:)으로 상속, 다중 상속 허용
// InterfaceTotal은 InterfaceHello59와 InterfaceGoodBye59의 모든 규격을 물려받고 자신의 규격을 추가함
interface InterfaceTotal : InterfaceHello59, InterfaceGoodBye59 {
    fun greeting(name: String)
}

// 인터페이스 -> 추상 클래스 -> 일반 클래스 계층 구조
interface IColor {
    companion object {
        const val RED = 1       // 상수 (코틀린 인터페이스 상수는 companion object에 선언)
        const val GREEN = 2
        const val BLUE = 3
    }

    fun getColor(): Int
    fun setColor(c: Int)        // 추상 메소드
}

// ---------------------------------------------------------------------------------------------

// InterfaceTotal을 구현하는 클래스는 상위 인터페이스들의 모든 메소드를 오버라이딩해야 함
class SubClass59 : InterfaceTotal {
    override fun sayHello(name: String) {
        println("${name}씨 안녕하세요!")
    }

    override fun sayGoodBye(name: String) {
        println("${name}씨 안녕히 가세요!")
    }

    override fun greeting(name: String) {
        println("${name}, 안녕!")
    }
}

// 추상 클래스(AbsColor)는 인터페이스를 구현할 때 일부 메소드만 미리 구현할 수 있음
abstract class AbsColor : IColor {
    var color = IColor.GREEN    // 추상 클래스는 일반 변수(필드)를 가질 수 있음

    override fun setColor(c: Int) { // 구현된 메소드도 가질 수 있음
        color = c
    }
    // getColor()는 아직 구현하지 않았으므로 추상 메소드로 남아있음
}

// 일반 클래스(SubClassTask59)는 남은 추상 메소드를 최종적으로 구현함
class SubClassTask59 : AbsColor() {
    override fun getColor(): Int {
        return color
    }
}

// ----------------------------------------------------------------------------------

fun main() {

    println("=== [예제 06] 인터페이스 다중 상속 테스트 ===")
    val test = SubClass59()
    test.sayHello("홍길동")
    test.sayGoodBye("홍길동")
    test.greeting("홍길동")
    println(InterfaceHello59.a)     // 10
    // 인터페이스 내엔 상수라서 값 불변. 바꿀 수 없음
    // InterfaceHello59.a = 30 -> const val이므로 컴파일 에러

    println("\n=== [예제 07] 인터페이스-추상클래스 계층 테스트 ===")
    val test07 = SubClassTask59()
    test07.setColor(IColor.RED)     // 부모(추상클래스)가 구현한 메소드 호출
    println("현재 색상 값: ${test07.getColor()}") // 본인이 구현한 메소드 호출

    /*
       [핵심 포인트]
       1. 인터페이스 간 상속: interface A : B, C { ... } (다중 상속 가능)
       2. 추상 클래스의 역할: 인터페이스의 모든 메소드를 구현하기 부담스러울 때,
                           일부만 미리 구현하여 자식 클래스의 부담을 덜어주는 "중간 다리" 역할.
       3. 코틀린 인터페이스 상수: Java의 'int a = 10'과 달리 companion object { const val }로 선언
    */
}