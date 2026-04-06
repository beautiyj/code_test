package task.kotlin2

// 코틀린의 interface는 자바와 매우 유사하지만,
// 인터페이스 내부에 프로퍼티(변수)를 선언할 수 있고
// 추상 메소드뿐만 아니라 기본 구현이 있는 메소드(Default Method)도 가질 수 있다

interface KotlinTask56 {
    // 코틀린 인터페이스 내 프로퍼티는 기본적으로 추상 상태임
    val a: Int get() = 10

    fun action()
    fun action2() // abstract 키워드 생략 가능

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("=== InterfaceTest01 실행 ===")
            val obj = Hello56()
            obj.sayHello("홍길동")

            println("\n=== InterfaceTest02 실행 ===")
            val test = SubClass()
            test.sayHello("홍길동")
            test.sayGoodBye("홍길동")
        }
    }
}

// [예제 1]
interface IHello {
    fun sayHello(name: String)
}

interface IHello2 {
    fun sayHello(name: String)
}

interface IGoodBye {
    fun sayGoodBye(name: String)
}

// [예제 2] 인터페이스 구현
// 코틀린은 상속(:) 기호 하나로 extends와 implements를 모두 처리함
class Hello56 : IHello {
    override fun sayHello(name: String) {
        println("${name}씨 안녕하세요!")
    }
}

// 다중 인터페이스 구현 (콤마로 구분)
class SubClass : IHello2, IGoodBye {
    override fun sayHello(name: String) {
        println("${name}씨 안녕하세요!")
    }

    override fun sayGoodBye(name: String) {
        println("${name}씨 안녕히 가세요!")
    }
}