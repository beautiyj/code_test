package task.kotlin2

object Singleton {
    fun check1() = println("메소드 호출 성공1")
    fun check2() = println("메소드 호출 성공2")
}

fun main() {
    val obj1 = Singleton
    val obj2 = Singleton

    println(obj1)
    println(obj2)

    if (obj1 === obj2) { // === 는 참조 주소 비교
        println("같은 싱글톤 객체")
    }

    obj1.check1()
    obj2.check2()
}