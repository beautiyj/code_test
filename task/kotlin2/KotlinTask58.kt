package task.kotlin2

// 인터페이스 다중상속
// 코틀린은 클론(:) 통일, override는 어노테이션이 아닌 키워드!

// 클래스 상속(extends)과 인터페이스 구현(implements)을 동시에 사용하는 경우
interface InterfaceHello {
    fun sayHello(name: String)
}

// 두 개의 인터페이스를 동시에 구현하는 경우 (다중 구현)
interface InterfaceHello58 {
    fun sayHello(name: String)
}

interface InterfaceGoodBye58 {
    fun sayGoodBye(name: String)
}

// ----------------------------------------------------------------------------------

abstract class AbstractGoodBye {
    abstract fun sayGoodBye(name: String)
}

// 클래스 상속은 하나만 가능(:AbstractGoodBye()), 인터페이스는 추가 구현 가능(, InterfaceHello)
// 코틀린은 extends/implements 구분 없이 콜론(:)으로 통일. 단, 클래스 먼저, 인터페이스 나중에 순서 중요!
// 클래스 먼저             인터페이스 나중에. 순서 중요
class SubClass58 : AbstractGoodBye(), InterfaceHello {
    override fun sayHello(name: String) {
        println("${name}씨 안녕하세요!")
    }

    override fun sayGoodBye(name: String) {
        println("${name}씨 안녕히 가세요!")
    }
}

// 인터페이스는 콤마(,)를 이용해 여러 개를 동시에 구현할 수 있음
class SubClassTask58 : InterfaceHello58, InterfaceGoodBye58 {
    override fun sayHello(name: String) {
        println("${name}씨 안녕하세요!")
    }

    override fun sayGoodBye(name: String) {
        println("${name}씨 안녕히 가세요!")
    }
}

// ----------------------------------------------------------------------------------

fun main() {

    println("=== [사례 1] 상속 + 인터페이스 구현 ===")
    val test01 = SubClass58()
    test01.sayHello("홍길동")
    test01.sayGoodBye("홍길동")

    println("\n=== [사례 2] 다중 인터페이스 구현 ===")
    val test02 = SubClassTask58()
    test02.sayHello("임꺽정")
    test02.sayGoodBye("임꺽정")

}