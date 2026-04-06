package task.kotlin2

// 상속, super()

open class Point2D06 {                  // 부모 클래스
    var x: Int = 10
    var y: Int = 20

    constructor() {                     // 기본 생성자
        println("슈퍼 클래스인 Point2D 생성자 호출")
    }

    constructor(xx: Int, yy: Int) {     // 매개변수가 있는 생성자
        x = xx       // x=50
        y = yy       // y=60
    }
}

// 자식 클래스에서 부모의 특정 생성자를 호출함
class Point3D06 : Point2D06(50, 60) {    // 자바의 super(50, 60) 역할
    var z: Int = 30

    init {
        // 부모 생성자가 먼저 실행된 후 init 블록이 실행됨
        println("서브 클래스인 Point3D 생성자 호출")
    }

    fun print() {
        println("$x, $y, $z")
    }
}

fun main() {
    val pt = Point3D06()
    // 생성자 호출
    pt.print()
}