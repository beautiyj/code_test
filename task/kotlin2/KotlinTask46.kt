package task.kotlin2

// ---------------------------------------------------------
// [첫 번째 예제: super 키워드와 필드 재정의]
// ---------------------------------------------------------

// 코틀린은 상속을 허용하려면 open 키워드가 필수임
open class Point2D04 {
    open var x: Int = 10      // 은닉 변수
    open var y: Int = 20
}

class Point3D04 : Point2D04() {
    // 부모의 필드를 재정의할 때 override 사용
    override var x: Int = 40
    override var y: Int = 50

    var z: Int = 30

    // 자식 클래스에서 새로 정의한 x, y만 사용된다.
    fun print() {
        println("$x, $y, $z") // 40, 50, 30
    }

    // super 활용
    fun print02() {
        // super.x는 부모 클래스의 멤버에 접근할 때 사용
        println("${super.x}, ${super.y}, $z")
    }
}

class SuperTest04 {
    companion object {
        fun main() {
            val pt = Point3D04()
            pt.print()
            pt.print02()
        }
    }
}

// ---------------------------------------------------------
// [두 번째 예제: 상속과 생성자 호출 순서]
// ---------------------------------------------------------

open class Point2D05 {
    var x: Int = 10
    var y: Int = 20

    init {
        println("슈퍼 클래스인 Point2D 생성자 호출")
    }
}

// 자식 클래스 선언 시 부모 생성자 호출 명시 : Point2D05()
class Point3D05(a: Int) : Point2D05() {
    var z: Int = 30

    init {
        println("서브 클래스인 Point3D 생성자 호출")
    }

    fun print() {
        println("$x, $y, $z")
    }
}

class SuperTest05 {
    companion object {
        fun main() {
            val pt = Point3D05(30)
            pt.print()
        }
    }
}

fun main() {
    println("--- SuperTest04 실행 ---")
    SuperTest04.main()

    println("\n--- SuperTest05 실행 ---")
    SuperTest05.main()
}