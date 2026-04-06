package task.kotlin2

// 메소드 오버라이딩(Method Overriding)
// : 부모 클래스로부터 상속받은 메소드를 자식 클래스에서 재정의 해서 사용하는 것.
// 1. 자식 클래스로 객체를 생성한 다음에 메소드를 호출하면, 오버라이딩된 메소드만 호출된다.
// 2. 부모 클래스에서 상속 해주는 메소드는 더 이상 사용할 수 없는 은닉 메소드가 된다.
// 3. 부모 클래스의 은닉 메소드를 자식 클래스에서 사용할 때는 super.parentPrn()으로 호출할 수 있다.

open class Parent05 {
    open fun parentPrn() {
        println("슈퍼클래싀 parentPrn 메소드")
    }
}

class Child05 : Parent05() {
    // 자바의 @Override 대신 override 키워드 사용 (필수)
    override fun parentPrn() {
        super.parentPrn() // 부모 클래스의 은닉 메소드 호출
        println("서브클래스: parentPrn 메소드")
    }

    fun childPrn() {
        // super.childPrn() // [오류] 부모에게 없는 메소드임
        println("서브클래스: childPrn 메소드")
    }
}

// 두 번째 예제 구조 대응
open class Parent52 {
    open fun parentPrn() {
        println("부모 클래스 : ParentPrn 메서드")
    }
}

class Child52 : Parent52() {
    override fun parentPrn() { // 메서드 오버라이딩
        println("자식 클래스 : ParentPrn 메서드")
    }

    fun childPrn() {
        println("자식 클래스 : ChildPrn 메서드")
    }
}

fun main() {
    val c = Child52()
    c.parentPrn() // 재정의된 자식 클래스의 메서드 호출
    c.childPrn()

    val p = Parent52()
    p.parentPrn() // 부모 클래스 자기 자신의 메서드 호출

    println("----------------------------------------------------------------")

    println("--- 자식 객체(Child05) 생성 및 호출 ---")
    val cc = Child05()

    // 오버라이딩된 메소드 호출 (부모 기능 + 자식 기능이 차례로 실행됨)
    cc.parentPrn()
    // 자식만의 새로운 메소드 호출
    cc.childPrn()

    println("\n--- 부모 객체(Parent05) 생성 및 호출 ---")
    val pp = Parent05()
    // 부모는 오직 자신의 원본 로직만 수행함
    pp.parentPrn()
}