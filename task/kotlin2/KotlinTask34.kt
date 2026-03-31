package task.kotlin2

// 자바와 달리 코틀린은 모든 클래스와 메소드가 기본적으로 final.
// 상속 허용하려면 open을 붙여야 함. 하지만 코틀린 클래스는 상속보다는 구성 위주로 활용하는 편임

// 1. 상수 (val)
class FinalMember(val b: Int) {
    val a = 10 // 수정 불가
}

// 2. 상속 제한 (기본이 final)
open class FinalMethod { // 상속 가능하게 하려면 open
    val str = "Java "
    open fun setStr(s: String) { // 오버라이딩 허용하려면 open
        println(s)
    }
}

class FinalEx : FinalMethod() {
    override fun setStr(s: String) { // 반드시 override 키워드 필요
        super.setStr(s)
    }
}

// 3. 클래스 상속 제한 (open 안 붙이면 자동 final)
class FinalClass {
    fun direct() = println("Direct")
}