package task.kotlin2

import kotlin.math.PI

// p341~342 대응
open class Calculator53 {
    open fun areaCircle(r: Double): Double {
        println("Calculator 객체의 areaCircle() 실행")
        return 3.14159 * r * r
    }
}

class Computer53 : Calculator53() {
    // 메소드 오버라이드
    override fun areaCircle(r: Double): Double {
        println("Computer 객체의 areaCircle() 실행")
        return PI * r * r
    }
}

// p342 대응
open class Airplane {
    fun land() = println("착륙합니다")
    open fun fly() = println("일반비행합니다")
    fun takeoff() = println("이륙합니다")
}

class SupersoicAirplane : Airplane() {
    // 자바의 static final 상수 대응
    companion object {
        const val NORMAL = 1
        const val SUPERSONIC = 2
    }

    var flyMode = NORMAL

    override fun fly() {
        if (flyMode == SUPERSONIC) {
            println("초음속비행합니다")
        } else {
            // 부모클래스의 은닉메소드 호출
            super.fly()
        }
    }
}

fun main() {
    val r = 10.0
    // 부모클래스 안의 메소드만 호출됨
    val calculator = Calculator53()
    println("원면적: ${calculator.areaCircle(r)}")

    // 재정의된 메소드 호출
    val computer = Computer53()
    println("원면적: ${computer.areaCircle(r)}")

    println()

    val sa = SupersoicAirplane()
    sa.takeoff()                                // 이륙합니다
    sa.fly()                                    // 일반비행합니다 (기본 NORMAL)
    sa.flyMode = SupersoicAirplane.SUPERSONIC
    sa.fly()                                    // 초음속비행합니다
    sa.flyMode = SupersoicAirplane.NORMAL
    sa.fly()                                    // 일반비행합니다
    sa.land()                                   // 착륙합니다
}