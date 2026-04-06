package task.kotlin2

// 상속에서의 메소드
// 1. 부모 클래스의 메소드는 자식 클래스로 상속된다.
// 2. 부모 클래스에서 자식 클래스의 메소드는 접근 할 수 없다.

// 코틀린은 기본적으로 클래스가 상속 불가능(final) 상태이므로
// 부모 클래스에 반드시 open 키워드를 붙여줘야 상속이 가능

open class Parent51 {                   // 부모 클래스 (상속 허용을 위해 open 사용)
    fun parentPrn() {
        println("슈퍼 클래스 메서드는 상속된다.")
    }
}

class Child51 : Parent52() {            // 자식 클래스 (Parent51 상속)
    fun childPrn() {
        println("서브 클래스 메서드는 슈퍼가 사용 못한다.")
    }
}

fun main() {
    val c = Child52()
    c.parentPrn()      // 상속 받은 메소드 사용
    c.childPrn()       // 자식 클래스의 메소드 사용

    println("-------------------------------------->> ")
    val p = Parent52()
    p.parentPrn()     // 자기 클래스(부모 클래스)의 메소드 사용
    // p.childPrn()    // [에러] 자식 클래스의 메소드는 접근 할 수 없다.
}