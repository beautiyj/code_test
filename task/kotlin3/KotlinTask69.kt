package task.kotlin3

// map 인터페이스
// HashMap 해시맵은 스레드 안전성은 xx지만 키와 밸루 모두 널 허용
// Hashtable 해시테이블은 스레드 안전성은 있지만 널 비허용이고 거의 안쓴다
// TreeMap은 특수목적에만 사용함. 키를 기준으로 자동정렬해주는 사전같은 매핑
// Properties는 설정파일 전용이고 키와 값 모두 문자열만 취급해서
// 프로그램 설정값 외부 파일(.properties) 이 용도로 자주 씀

import java.util.*

fun main() {

    // HashMap 객체 생성. Map은 인터페이스라서 자체 객체 생성 불가함.
//  val hm: Map<String, Any> = HashMap()    // 업캐스팅 방식
    val hm: HashMap<String, Any> = HashMap()

    // 키와 데이터 쌍을 삽입
    hm["woman"] = "gemini"
    hm["man"] = "johnharu"
    hm["age"] = 10          // 자동박싱
    hm["city"] = "seoul"
    hm["city1"] = "seoul"
    hm["city"] = "busan"    // 키가 중복되면 밸루는 부산만 출력됨

    // HashMap에 있는 객체들을 출력
    println(hm)             // {city1=seoul, woman=gemini, city=busan, man=johnharu, age=10}

    // 키 값만 출력
    println(hm.keys)        // [city1, woman, city, man, age]

    // 키를 이용해 해당 데이터를 출력
    println(hm["woman"])
    println(hm["city"])
    println(hm["city1"])
    println()

// ------------------------------------------------------------------------------------------

    val ht: Hashtable<String, String> = Hashtable()

    // 해시 테이블에 키/데이터를 입력한다.
    ht["딸기"] = "StrawBerry"
    ht["사과"] = "Apple"
    ht["포도"] = "Grapes"

    // 방법1 - 키 알고 있을 때
    val value: String? = ht["포도"]
    if (value != null) {
        println("포도-> $value")
    }

    // 방법2 - 키 모를 때
    // Enumeration 대신 코틀린 실무: for-in 루프로 순회
    // Enumeration은 Hashtable/Vector 전용 구식 API, 코틀린에서는 entries 사용
    for ((k, v) in ht) {        // entries 구조분해 (Enumeration 대응)
        println("$k : $v")
    }
}