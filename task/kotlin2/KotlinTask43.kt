package task.kotlin2

import java.text.DecimalFormat
import kotlin.math.PI

/*
    반지름 r이 5인 경우 다음을 구하는 프로그램을 DecimalFormat클래스를 이용하여 작성하기
    (단, 결과는 소수둘째자리까지 출력할 것)
 */

// 출력부에서만 박싱하는 경우 (코틀린은 기본적으로 최적화된 Primitive 사용)
class Task42 {
    fun task42() {
        val r: Int = 5

        // 원 둘레
        val r1: Double = 2 * PI * r
        // 원 면적
        val r2: Double = PI * r * r
        // 구 표면적
        val r3: Double = 4 * PI * r * r
        // 구 부피 (4.0 / 3.0 처럼 실수 나눗셈 명시)
        val r4: Double = (4.0 / 3.0) * PI * r * r * r

        // DecimalFormat 사용
        val df = DecimalFormat("#.##")
        println(df.format(r1))
        println(df.format(r2))
        println(df.format(r3))
        println(df.format(r4))
    }
}

// 처음부터 객체 타입으로 다루는 경우 (코틀린은 Nullable 설정 시 내부적으로 박싱됨)
class Task43Class2 {
    fun task43Class2() {
        // 객체 생성 (Nullable 타입은 자바의 Wrapper 객체처럼 동작)
        val r: Int? = 5

        // 계산 결과 (자동 박싱/언박싱 발생)
        val r1: Double? = 2 * PI * r!!
        val r2: Double? = PI * r * r
        val r3: Double? = 4 * PI * r * r
        val r4: Double? = (4.0 / 3.0) * PI * r * r * r

        val df = DecimalFormat("#.##")
        println(df.format(r1))
        println(df.format(r2))
        println(df.format(r3))
        println(df.format(r4))
    }
}

fun main() {
    val t42 = Task42()
    t42.task42()

    val t42Class2 = Task43Class2()
    t42Class2.task43Class2()
}