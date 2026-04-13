package task.kotlin3

// HashSet 해시셋 : 트리셋과 달리 정렬은 x

fun main() {

    // set은 인터페이스라서 자체적으로 객체 생성 불가능함
    val set: MutableSet<Any> = HashSet()
//  val set: HashSet<Any> = HashSet()

    println("요소의 갯수->${set.size}")         // 요소의 갯수->0
    set.add("하나")
    set.add(2)
    set.add(3.42)
    set.add("넷")
    set.add("five")
    set.add(6)
    set.add(6)

    // Set은 중복된 데이터 저장하지 못함 -> 중복데이터 판별용으로 씀, 순서 제어x
    println("요소의 갯수->${set.size}")         // 요소의 갯수->6
    println(set)                               // [2, 6, 넷, 하나, 3.42, five]

    // Iterator 이터레이터 반복자
    val elements: Iterator<Any> = set.iterator()
    while (elements.hasNext()) {
        println("\t\t${elements.next()}")
    }

    // 코틀린 실무: for-in 루프로 간결하게 대체 가능
//  for (element in set) {
//      println("\t\t$element")
//  }
}