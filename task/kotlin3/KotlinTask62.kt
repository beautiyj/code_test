package task.kotlin3

// 컬렉션 인터페이스 - Collection set 인터페이스
// 중복을 허가하지 않아서 데이터 중복 판별에 쓰는 인터페이스

import java.util.*

fun main() {

    // set은 인터페이스라서 자체적으로 객체 생성 불가능함 val s: Set = Set() 오류

    // 업캐스팅 방식으로 HashSet 클래스의 객체 생성
    val hs: MutableSet<Any> = HashSet()
//  val hs: HashSet<Any> = HashSet()    // 이건 일반 객체 생성

    // hs 객체에 데이터 객체 보관
    hs.add("gemini")
    hs.add("johnharu")
    hs.add(Date())

    // hs 객체가 보관하고 있는 데이터 객체 출력
    println("hs의 내용 : $hs")

    // "johnharu" 데이터 객체를 hs 객체에서 제거
    hs.remove("johnharu")
    println("hs의 내용 : $hs")

    // hs 객체에 있는 데이터 객체의 갯수를 출력
    println("hs의 데이터 갯수${hs.size}")
}