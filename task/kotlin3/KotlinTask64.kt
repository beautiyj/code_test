package task.kotlin3

// TreeSet 트리셋 : 데이터를 오름차순으로 정렬해서 저장하고 출력하는 기능 제공
// 중복된 데이터 저장 x
// 오름차순기준 - 숫자나 문자열은 문제없는데 문자형은 유니코드 작은 순으로 진행됨.

import java.util.*

fun main() {

    val hs: TreeSet<String> = TreeSet()

    if (hs.add("korea")) {
        println("첫 번째 korea 추가 성공")
    } else {
        println("첫 번째 korea 추가 실패")
    }

    if (hs.add("japan")) {
        println("japan 추가 성공")
    } else {
        println("japan 추가 실패")
    }

    if (hs.add("america")) {
        println("america 추가 성공")
    } else {
        println("america 추가 실패")
    }

    if (hs.add("britain")) {
        println("britain 추가 성공")
    } else {
        println("britain 추가 실패")
    }

    if (hs.add("korea")) {
        println("두 번째 korea 추가 성공")
    } else {
        println("두 번째 korea 추가 실패")
    }

    println()

    // Iterator 이터레이터 반복자
    val it: Iterator<String> = hs.iterator()
    while (it.hasNext()) {
        println(it.next())
    }

    // 코틀린 실무: for-in 루프로 간결하게 대체 가능
//  for (element in hs) {
//      println(element)
//  }
}

/*
첫 번째 korea 추가 성공
japan 추가 성공
america 추가 성공
britain 추가 성공
두 번째 korea 추가 실패

america
britain
japan
korea
*/