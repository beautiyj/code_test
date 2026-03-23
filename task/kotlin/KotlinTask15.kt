package task.kotlin

import java.util.*

// 보조 제어문 - break문, continue문

fun main() {
    main15T1()
    main15T2()
    main15T3()
    main15T4()
    main15T5()
    main15T6()
}

// continue 1 - 1~100까지의 정수 중 짝수만 출력하기
// (1..100).filter { it % 2 == 0 }.forEach { println(it) }
fun main15T1() {

    var i = 0
    for (i in 1..100) {
        if (i % 2 == 0) println(i) else continue
    }
    println()
}

// continue 2 - 1~10 중 5를 제외한 나머지만 출력하기
// (1..10).filter { it != 5 }.forEach { println(it) }
fun main15T2() {
    var i = 0
    for (i in 1..10) {
        if (i == 5) continue else println(i)
    }
    println()
}

// continue 3 - 1~100 정수 중 5의 배수만 출력하기
// (5..100 step 5).forEach { println(it) }
fun main15T3() {
    var i = 0
    for (i in 1..100) {
        if (i % 5 == 0) println(i) else continue
    }
    println()
}

// break 1 - 15일 때 반복문 중단하기 (for문 ver)
fun main15T4() {
    var i = 1
    for (i in 1..100) {
        print("$i ")
        if (i ==15) break
    }
    println()
}

/*
// 4 & 5. 15일 때 중단하기
(보통 while(true) + break를 쓰지만,
고급 함수형 스타일로는 이렇게 짭니다)
1부터 무한히 숫자를 만들되(generate), 15 이하일 때까지만 취함(takeWhile)
    generateSequence(1) { it + 1 }
        .takeWhile { it <= 15 }
        .forEach { println(it) }
 */
// break 2 - 15일 때 반복문 중단하기 (while문 ver)
fun main15T5() {
    var i = 1
    while(i<=100) {
        print("$i ")
        if (i==15) break
        i++
    }
    println()
}

// break 3 - random()함수에서 6이 나오면 중단하는 프로그램
fun main15T6() {
    var i = 1

    while(true) {
        i++
        val num = Random().nextInt(1,7)
        if (num == 6) break
        println(num)
    }
    println("루프횟수: ${i-1}")
}
/*
// 무한히 주사위를 굴려서 6이 아닐 때까지만 가져온 다음, 그 개수(count)를 셈
    val loopCount = generateSequence { Random.nextInt(1, 7) }
        .takeWhile { it != 6 }
        .count()
    println("루프횟수: $loopCount")

    generateSequence는 시퀀스 조작함수로
    generateSequence(1) { it + 1 }는 시작값 1로 시작하는 무한루프.
    takeWhile { 조건 } 은 break와 같은 역할의 함수.
    조건이 True인 경우에만 진행됨, False 나오는 순간 break
 */