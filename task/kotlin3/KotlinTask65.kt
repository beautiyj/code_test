package task.kotlin3

// set 자료구조를 활용한 과제
// 1~45 사이의 정수 중에서 6개의 숫자를 추출하는 로또 프로그램
// 단, set 자료구조를 사용해서 중복 숫자가 나오지 않도록 하고
//     추출된 6개의 숫자를 오름차순으로 정렬해서 출력하기

import java.util.*

fun main() {

    // 오름차순 정렬해주는 트리셋으로 사용
    val treeSet: TreeSet<Int> = TreeSet()

    // Math.random()
    while (treeSet.size < 6) {
        val num = (Math.random() * 45).toInt() + 1
        treeSet.add(num)
    }
    println(treeSet)
    println()

// ------------------------------------------------------------------------------------

    // Random() 활용
    val treeSet2: TreeSet<Int> = TreeSet()
    val r = Random()

    // 6되는 순간 false로 로직 종료
    while (treeSet2.size < 6) {
        val n = r.nextInt(45) + 1
        treeSet2.add(n)
    }
    println(treeSet2)

// ------------------------------------------------------------------------------------

    // 코틀린 실무 버전 - kotlin.random.Random 활용
    val treeSet3: TreeSet<Int> = TreeSet()

    while (treeSet3.size < 6) {
        val num = (1..45).random()      // 코틀린 범위(IntRange) 활용
        treeSet3.add(num)
    }
    println("TreeSet 코틀린 실무 버전: $treeSet3")

    // 코틀린 실무 한줄 버전
    val lotto = (1..45).shuffled().take(6).sorted()
    println("한줄 로또: $lotto")
}