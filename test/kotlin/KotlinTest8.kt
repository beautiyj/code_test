package test.kotlin

/*
정수 num과 n이 매개 변수로 주어질 때,
num이 n의 배수이면 1을
return n의 배수가 아니라면 0을
return 하도록 solution 함수를 완성해주세요.
 */

fun solution(num:Int, n:Int):Int {
    return if (num % n == 0) 1 else 0
}

fun main() {
    println(solution(1, 2))
}