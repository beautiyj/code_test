package task.kotlin2

// 상속 + Getter/Setter
// 코틀린은 property 개념을 사용하므로
// 별도의 Getter/Setter 메소드를 만들지 않아도 내부적으로 자동 생성됨


// 코틀린은 상속을 허용하려면 open 키워드가 필수임
open class Point2D {                       // 부모 클래스
    // private 필드와 public Getter/Setter가 자동으로 생성됨
    var x: Int = 0
    var y: Int = 0
}

// 부모 클래스(Point2D)의 필드와 메소드를 상속 받아서 사용할 수 있다.
class Point3D : Point2D() {                // 자식 클래스
    var z: Int = 0
}

fun main() {
    val pt = Point3D()

    // .x = 10 이라고 쓰면 내부적으로 setter가 호출됨 (상속받아 사용)
    pt.x = 10
    pt.y = 20
    pt.z = 30

    // pt.x 라고 쓰면 내부적으로 getter가 호출됨
    println("${pt.x}, ${pt.y}, ${pt.z}")
}