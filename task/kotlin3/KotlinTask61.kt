package task.kotlin3

// 레퍼런스 형변환 예제 + 박싱언박싱
// 레퍼런스 형변환 : 2개의 클래스 사이에 상속 관계가 있어야 가능

import java.util.*

fun main() {

//    예시 1 추상 클래스와 상속
//    Calendar(추상)는 직접 생성 불가. 업캐스팅 시 자식 전용 메소드(isLeapYear)는 다운캐스팅 후 사용 가능.

//    val c = Calendar()  이건 에러. 캘린더는 추상클래스니까.
    val c1: Calendar = Calendar.getInstance()

    val c2: Calendar = GregorianCalendar()          // 이게 업캐스팅
    val c3: GregorianCalendar = GregorianCalendar() // 이건 일반 객체생성

    // 업캐스팅하면 부모클래스인 캘린더가 상속해준 메소드를 사용할 수 있음.
    // 근데 isLeapYear() 메소드는 부모클래스가 준 게 아니라서 c2로는 접근 불가함! (자식클래스가 메소드 기능을 확장한 거.)
    // 부모타입 변수 c2를 바로 쓰려면 다운캐스팅인 val gc = c2 as GregorianCalendar 후 gc 써야함
    if (c3.isLeapYear(2026)) {
        println("윤년")
    } else {
        println("평년")
    }

// --------------------------------------------------------------------------------------------------------------

//  예시 2 - 인터페이스와 업캐스팅
//  코틀린은 제네릭이 기본. List(인터페이스)는 직접 생성 불가.
//  코틀린은 불변 List와 가변 MutableList를 구분함 (Java의 ArrayList = MutableList)

//  val li: List<Any> = List()  이건 에러 (인터페이스 직접 생성 불가)
    val list: MutableList<Any> = mutableListOf()    // 업캐스팅 - List 규칙만 다룰 때
    val al: ArrayList<Any> = ArrayList()            // 일반 객체 생성 - ArrayList 모든 기능 사용 가능

// --------------------------------------------------------------------------------------------------------------

//  예시 3 - 자동 박싱과 업캐스팅
//  코틀린은 박싱/언박싱이 내부적으로 자동 처리됨. Any = Java의 Object (최상위 타입)
//  fun add(element: E): Boolean
    list.add(10)        // Any e = 10  코틀린은 자동박싱 내부 처리
    list.add(3.14)      // Any e = 3.14
    list.add('j')       // Any e = 'j'
    list.add(true)      // Any e = true
    list.add("자바")     // Any e = "자바" 이미 객체라 업캐스팅만 발생

    println(list)

// --------------------------------------------------------------------------------------------------------------

//  예시 4 - 객체의 값 비교 (equals / ==)
//  코틀린은 == 가 equals()와 동일하게 동작 (내용 비교). 참조 비교는 ===

    val str1 = "java"
    val str2 = "java"
    if (str1 == str2) {         // 코틀린 실무버전 (내부적으로 equals() 호출)
        println("같은값")
    } else {
        println("다른값")
    }

    if (10 == 10) {             // 코틀린은 == 로 값 비교 (박싱 자동처리)
        println("같은값")
    } else {
        println("다른값")
    }
    // Java의 Integer.valueOf(10).equals(Integer.valueOf(10)) 와 동일한 동작
    if (Integer.valueOf(10) == Integer.valueOf(10)) {
        println("같")
    }

    if (3.14 == 3.14) {         // 실무버전
        println("같은 실수 값")
    } else {
        println("다른값")
    }

// --------------------------------------------------------------------------------------------------------------

//  예시 5 - 리스트 데이터 추출과 형변환
//  코틀린 제네릭 리스트에서는 다운캐스팅 없이 바로 사용 가능. (타입 안전)
//  비제네릭 방식은 as 키워드로 다운캐스팅.

    val l: MutableList<Any> = mutableListOf()   // 업캐스팅 (요즘은 제네릭으로 쓰고)
    l.add("자바")
    l.add("오라클")
    l.add("문자들을저장하기")

//  fun get(index: Int): E
    val obj: Any = l[0]
    println(obj)                // list [0] 인덱스인 자바 출력됨

//  val s: String = l[0]       반환값이 Any면 오류남
    val s: String = l[0] as String  // 다운캐스팅 - 근데 이 방식 잘 안씀, 제네릭으로 쓰지

    for (i in 0 until l.size) {
        val str = l[i] as String    // 이건 다운캐스팅 방식
        println(str)
    }

// --------------------------------------------------------------------------------------------------------------

//  예시 6 - 반복문과 다운캐스팅, 언박싱
//  리스트 순회 시 Any를 Int로 바꾸는 과정(다운캐스팅+언박싱). 향상된 for문 활용법.

    val ls: MutableList<Any> = mutableListOf()

    ls.add(10)          // 자동박싱과 업캐스팅들 ~
    ls.add(200)
    ls.add(3000)
    ls.add(40000)
    ls.add(500000)

    for (i in 0 until ls.size) {
        val num = ls[i] as Int      // 다운캐스팅
        val n: Int = num            // 코틀린은 언박싱 자동처리 (intValue() 불필요)

        val nn = ls[i] as Int       // 다운캐스팅+언박싱 한줄로 끝내기
    }

    // 향상된 for문
    for (j in ls) {
        println(s)
    }

    // 연산 진행하려면 다운캐스팅 필요
    for (k in ls) {
        // Any 타입을 Int로 다운캐스팅 (코틀린은 언박싱 자동처리)
        val value = k as Int        // 다운캐스팅 (언박싱 자동)
        println(value + 100)
    }

    // 코틀린 실무: as? 안전 캐스팅 활용
    for (k in ls) {
        val value = k as? Int ?: continue  // null이면 continue로 스킵
        println(value + 100)
    }
}