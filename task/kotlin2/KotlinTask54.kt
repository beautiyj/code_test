package task.kotlin2

// 상속에서의 접근 제한자 : 부모 클래스
open class KotlinTask54 {
    private val a: Int = 10     // [1] private : 클래스 내부만 가능
    internal val b: Int = 20    // [2] internal : 같은 모듈(프로젝트) 내라면 패키지 달라도 가능
    protected val c: Int = 30   // [3] protected : 자식 클래스에서만 가능 (패키지 같아도 자식 아니면 불가)
    val d: Int = 40            // [4] public (생략 시 기본) : 어디서든 가능

    fun print() {
        println("AccessTest의 print")
        println(a)
        println(b)
        println(c)
        println(d)
    }
}