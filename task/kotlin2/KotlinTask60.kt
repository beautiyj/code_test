package task.kotlin2

// 레퍼런스 형변환 - 업캐스팅(자동형변환) 다운캐스팅(강제형변환)

/*

자동 형변환(업 캐스팅): 자식클래스에서 부모클래스로 형변환.
참조 가능한 영역이 축소 & 컴파일러에 의해서 자동 형변환

강제 형변환(다운 캐스팅): 부모클래스에서 자식클래스로 형변환.
참조 가능한 영역이 확대 & 강제 형변환 필요, 강제 형변환시 자료형을 생략할 수 없음.

 */

open class ParentClass {
    fun parentPrn() {
        println("슈퍼 클래스 : ParentPrn 메서드")
    }
}

class ChildClass : ParentClass() {
    fun childPrn() {
        println("서브 클래스 : ChildPrn 메서드")
    }
}

// ----------------------------------------------------------------------------------

fun main() {

    // [RefTest01 케이스] - 업 캐스팅 (Upcasting)
    println("=== RefTest01: 업 캐스팅 테스트 ===")
    val c = ChildClass()
    c.parentPrn()
    c.childPrn()

    val p: ParentClass
    p = c   // 암시적으로 업 캐스팅이 일어남(자식->부모 형변환)
    // 자동형변환이라 타입 생략 가능. val p: ParentClass = c 도 가능.
    // 보통은 val p: ParentClass = ChildClass() 선언과 생성을 동시에.

    p.parentPrn()   // 업 캐스팅 후에는 부모로부터 상속받은 메서드만 호출할 수 있다.

    // 오류: 부모(Parent) 타입 레퍼런스에는 childPrn() 가 존재하지 않기 때문입니다.
    // p.childPrn()

// ---------------------------------------------------------------------------------------------------------

    // [RefTest02 케이스] - 잘못된 다운 캐스팅 (Downcasting Fail)
    // 다운캐스팅은 부모->자식 (강제형변환)
    println("\n=== RefTest02: 잘못된 다운 캐스팅 테스트 ===")
    val p2: ParentClass = ParentClass() // 실제 알맹이가 부모인 객체 생성

    // 오류: 처음부터 부모(Parent)로 태어난 객체는 자식(Child) 타입으로 강제 형변환이 불가능
    // val c2 = p2 as ChildClass  -> 런타임 ClassCastException 발생!

    // 코틀린 실무 안전 캐스팅: as? 사용 -> 실패 시 null 반환 (예외 없음)
    val c2 = p2 as? ChildClass
    println("안전 캐스팅 결과(실패 시 null): $c2")  // null 출력
    // c2?.childPrn()  // null이므로 호출되지 않음

    /*
        // 오류 해결하려면 업캐스팅을 1회 한 뒤 다운캐스팅이 되어야한다
        val p2: ParentClass = ChildClass()      // 업캐스팅 상태로 생성
        p2.parentPrn()
        val c2 = p2 as ChildClass               // 이제 다운캐스팅 가능
        c2.parentPrn()
        c2.childPrn()
     */

// ---------------------------------------------------------------------------------------------------------

    // [RefTest03 케이스] - 올바른 다운 캐스팅 (Downcasting Success)
    println("\n=== RefTest03: 올바른 다운 캐스팅 테스트 ===")

    // 업캐스팅을 먼저 하고 그다음 다운캐스팅 진행.
    val p3: ParentClass = ChildClass()
    p3.parentPrn()

    // 오류: 실제 객체가 Child일지라도 현재 타입이 Parent이므로 자식 전용 메서드는 보이지 않습니다.
    // p3.childPrn()

    println("---------------->> 강제 형변환 후")

    // 코틀린 강제 캐스팅: as 사용 (본래 자식이었으므로 성공!)
    val c3 = p3 as ChildClass   // 강제 형변환으로 다운 캐스팅

    c3.parentPrn()
    c3.childPrn()   // 이제 자식 전용 메서드 호출 가능

    // 코틀린 실무: is로 타입 체크 후 스마트 캐스트 활용
    println("\n=== [실무 보너스] 스마트 캐스트(Smart Cast) ===")
    val p4: ParentClass = ChildClass()
    if (p4 is ChildClass) {
        // is 체크 이후 블록 안에서는 자동으로 ChildClass로 스마트 캐스트됨
        // as 없이도 자식 메서드 바로 호출 가능!
        p4.childPrn()
    }
}

//          업캐스팅                                  다운캐스팅(업캐스팅 후 다운캐스팅)
//          val p: ParentClass = ChildClass()        val p: ParentClass = ChildClass()
//                                                   val c = p as ChildClass
//
// 혹은      val c = ChildClass()
//          val p: ParentClass = c
//
// 결과      p.parentMethod() 호출가능                c.parentMethod() 호출가능
//                                                   c.childMethod() 호출가능
//
// 실무      if (p is ChildClass) { p.childMethod() } // 스마트 캐스트 (as 불필요)

/*
Java 코드                        Kotlin 대체                                이유
(ChildClass) p              p as ChildClass                       코틀린 캐스팅 연산자
실패 시 ClassCastException   p as? ChildClass (null 반환)           안전 캐스팅, 실무에서 as 단독보다 선호
instanceof 후 캐스팅         if (p is ChildClass) { p.childPrn() }  스마트 캐스트 - is 체크 후 자동 캐스팅, 실무 표준
 */