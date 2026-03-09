package test.kotlin

/*
문자열 str과 정수 n이 주어집니다.
str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.

** 예시 **
입력
string 5

출력
stringstringstringstringstring

 */

fun main(args: Array<String>) {
    val input = readln().split(' ')
    val s1 = input[0]   //문자열의인덱스0번 = s1부분
    val n = input[1].toInt()  // 정수부분

    val result = s1.repeat(n)   //문자열메소드
    println(result)
}