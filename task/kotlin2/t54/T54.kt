package task.kotlin2.t54

import task.kotlin2.KotlinTask54

// 자식 클래스
class SubOne : KotlinTask54() {
    fun subPrn() {
        // println(a)    // [1. Sub] 에러: private 접근 불가
        println(b)       // [2. Sub] 가능: internal은 같은 모듈 내 패키지 구분 없음
        println(c)       // [3. Sub] 가능: protected는 상속 관계면 패키지 달라도 가능
        println(d)       // [4. Sub] 가능: public
    }
}

// 실행부 (T54)
fun main() {
    val at = KotlinTask54()
    at.print() // 부모의 public 메소드를 통해 내부 필드 출력

    println("main")
    // println(at.a)  // [1. main] 에러: private
    println(at.b)     // [2. main] 가능: internal (모듈 내 공유)
    // println(at.c)  // [3. main] 에러: protected는 외부 객체에서 접근 불가
    println(at.d)     // [4. main] 가능: public

    println("--- SubOne 객체 실행 ---")
    val so = SubOne()
    so.subPrn()
}