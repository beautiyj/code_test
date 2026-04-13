package task.kotlin3

// 컬렉션 인터페이스 - Collection 프레임워크의 list 인터페이스
// 리스트 인터페이스는 인덱스 번호(입력순) 자료형 저장, 중복저장 가능, 동적으로 크기 조절.
// ArrayList

fun main() {

    println("---------------------------------------------------------")
    println("어레이리스트 활용")

    val list: MutableList<Any> = ArrayList()        // 업캐스팅
    val arrayList: ArrayList<Any> = ArrayList()

    arrayList.add("하나")
    arrayList.add(2)
    arrayList.add(2)
    arrayList.add(3.42)
    arrayList.add("넷")
    arrayList.add("five")
    arrayList.add(6)

    println(arrayList)
    println()

// -------------------------------------------------------------------------------

    println("---------------------------------------------------------")
    println("전체 리스트 출력 & 특정 인덱스 번호 데이터 출력하기")

    val list1: MutableList<Any> = ArrayList()

    list1.add("하나")
    list1.add(2)
    list1.add(3.42)
    list1.add("넷")
    list1.add("five")
    list1.add(6)

    // 출력방법
    println(list1)
    println(list1[2])       // 특정 인덱스 번호의 데이터 출력
    println()

    println("---------------------------------------------------------")
    println("반복문 - 업캐스팅 활용하기")

    for (i in 0 until list1.size) {
        println("$i 번째 요소는 ${list1[i]}")
        val obj: Any = list1[i]     // 이건 업캐스팅이라 오류 없음
        println(obj)
    }

    println("---------------------------------------------------------")
    println("반복문 - toString 활용하기")

    for (i in 0 until list1.size) {
//      val s: String = list1[i] as String  // 리스트 안의 데이터형이 여러개라서
        val s: String = list1[i].toString() // 출력하려면 이렇게 사용하기. 모든 객체는 toString()을 가짐
        println(s)
    }

    println("---------------------------------------------------------")
    println("Iterator 반복자 활용하기")

    // 이터레이터 반복자
    val elements: Iterator<Any> = list1.iterator()
    while (elements.hasNext()) {
        println("\t\t${elements.next()}")
    }

    // 코틀린 실무: for-in 루프로 간결하게 대체 가능
//  for (element in list1) {
//      println("\t\t$element")
//  }
}