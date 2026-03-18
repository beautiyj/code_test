package test.kotlin

import kotlin.math.max

/*
연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다.

예를 들면 다음과 같습니다.
12 ⊕ 3 = 123
3 ⊕ 12 = 312

양의 정수 a와 b가 주어졌을 때,
a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.


입력값: 양의정수 a, b
출력값: a ⊕ b와 b ⊕ a 중 더 큰 값
행위: 비교연산, 함수 리턴
 */


fun sol(a:Int, b:Int):Int {
    var answer = 0

    var ab = a.toString() + b.toString()
    var ba = b.toString() + a.toString()

    var abInt = ab.toInt()
    var baInt = ba.toInt()

    if (abInt >= baInt) {
        answer = abInt
    } else {
        answer = baInt
    }
    return answer
}

// 더 간략하게
fun sol2(a: Int, b: Int): Int {
    val ab = "$a$b".toInt()
    val ba = "$b$a".toInt()

    return max(ab, ba)
}

fun main() {
    println(sol(12, 3))
    println(sol(5,8))

    println(sol2(9,8))
    println(sol2(19,11))
}
