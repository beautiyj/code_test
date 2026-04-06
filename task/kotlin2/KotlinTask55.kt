package task.kotlin2

// 코틀린은 abstract 키워드를 자바와 동일하게 사용하지만
// 추상 클래스와 추상 메소드는 기본적으로 open 상태이므로 별도의 open 키워드가 필요 없음

// [예제 1] 추상클래스의 기본 구조와 구현
abstract class AbstractClass01 {
    abstract fun method01() // 본체가 없는 추상 메소드

    fun method02() {
        println("Method02: 추상클래스에서 구현")
    }
}

class SubClass01 : AbstractClass01() {
    override fun method01() {
        println("Method01: 서브클래스에서 구현된 추상메소드")
    }
}

// [예제 2] 추상클래스를 활용한 다형성
abstract class ShapeClass {
    abstract fun draw()
}

class Circ : ShapeClass() {
    override fun draw() = println("원을 그린다")
}

class Rect : ShapeClass() {
    override fun draw() = println("사각형을 그린다")
}

class Tria : ShapeClass() {
    override fun draw() = println("삼각형을 그린다")
}

// [예제 3] 다중 상속 불가 사례 및 계층적 상속
abstract class Hello {
    abstract fun sayHello(name: String)
}

class SubClass03 : Hello() {
    override fun sayHello(name: String) = println("${name}씨 안녕하세요!")
    fun sayGoodBye(name: String) = println("${name}씨 안녕히 가세요!")
}

// [예제 4] 계층적 상속
abstract class AbstractClass04 {
    abstract fun method01()
    fun method02() = println("Method02: 추상클래스에서 구현")
}

abstract class MiddleClass04 : AbstractClass04() {
    override fun method01() = println("Method01: 중간 클래스에서 구현된 추상메소드")
    fun method03() = println("Method03: 추상클래스에서 구현")
}

class SubClass04 : MiddleClass04()

// 메인 실행 클래스
abstract class KotlinTask55 {
    val a = 10
    abstract fun check2()
    fun check() = println("일반메소드 호출 가능")

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("=== 예제 1 실행 ===")
            val obj1 = SubClass01()
            obj1.method01()
            obj1.method02()

            println("\n=== 예제 2 실행 (다형성) ===")
            val shapes: Array<ShapeClass> = arrayOf(Circ(), Rect(), Tria())
            for (s in shapes) s.draw()

            println("\n=== 예제 3 실행 ===")
            val test = SubClass03()
            test.sayHello("홍길동")
            test.sayGoodBye("홍길동")

            println("\n=== 예제 4 실행 ===")
            val obj4 = SubClass04()
            obj4.method01()
            obj4.method02()
            obj4.method03()
        }
    }
}