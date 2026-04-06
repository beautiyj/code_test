package task.kotlin2

// 코틀린은 상속과 재정의에 대해 자바보다 엄격
// 부모 클래스와 멤버는 open이어야 하며, 재정의할 때는 반드시 override 키워드를 써야함

// [예제 1] 상속에서의 필드 (기본 상속)
open class Point2D_01 {                            // 부모 클래스
    var x: Int = 10
    var y: Int = 20
}

class Point3D_01 : Point2D_01() {                 // 자식 클래스
    var z: Int = 30
    fun print() {
        println("$x, $y, $z")   // x와 y는 상속 받아 사용하는 필드
        // 10, 20, 30
    }
}

// [예제 2 & 3] 상속에서의 필드 (은닉 변수 및 super 이용)
open class Point2D_02 {                            // 부모 클래스
    open var x: Int = 10 // 자식 클래스에서 x,y를 재정의하면 부모 클래스의 x,y는 은닉변수가 된다.
    open var y: Int = 20 // 은닉 변수 or 쉐도우 변수
}

class Point3D_02 : Point2D_02() {                 // 자식 클래스
    override var x: Int = 40 // 부모 클래스에 존재하는 멤버변수를 자식 클래스에 다시 한 번 정의함
    override var y: Int = 50
    var z: Int = 30

    fun print() {
        println("$x, $y, $z")   // 자식 클래스의 재정의된 x,y가 출력된다.
        // 40, 50, 30
    }

    fun print02() {
        println("${super.x}, ${super.y}, $z") // super를 이용해서 부모 클래스의 x,y출력
        // 10, 20, 30
    }
}

// [예제 4] 상속에서의 메소드
open class Parent_04 {                            // 부모 클래스
    fun parentPrn() {
        println("부모 클래스의 메서드는 상속된다.")
    }
}

class Child_04 : Parent_04() {                    // 자식 클래스
    fun childPrn() {
        println("자식 클래스의 메서드는 부모가 사용할 수 없다.")
    }
}

fun main() {
    println("=== [예제 1] 기본 상속 테스트 ===")
    val pt1 = Point3D_01()
    pt1.print()

    println("\n=== [예제 2 & 3] 은닉 변수 및 super 테스트 ===")
    val pt2 = Point3D_02()
    print("자식 변수 출력: ")
    pt2.print()   // 40, 50, 30
    print("부모 변수(super) 출력: ")
    pt2.print02() // 10, 20, 30

    println("\n=== [예제 4] 메소드 상속 및 접근 제한 테스트 ===")
    val c = Child_04()
    c.parentPrn() // 상속받은 부모 메소드 호출
    c.childPrn()  // 자신의 메소드 호출

    val p = Parent_04()
    p.parentPrn() // 부모 자신의 메소드 호출
    // p.childPrn() // [컴파일 에러] 부모는 자식의 메소드에 접근할 수 없음
    println("부모 객체는 자식 메소드(childPrn)를 호출할 수 없음을 확인했습니다.")
}