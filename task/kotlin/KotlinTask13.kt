package task.kotlin

// 반복문 - while문
// 간략 형태 단일식은 12와 동일함

fun main() {
    main3T1()
    main3T2()
    main3T3()
    main3T4()
}

// 1. 문자열 반복 출력
fun main3T1() {
    var i = 1
    while (i<=10) {
        println("${i} 문자출력")
        i++
    }
    println()
}

// 2. while문과 if-else문을 활용해 1~100까지의 홀.짝수 합 구하기
fun main3T2() {
    var i = 0
    var oddSum = 0
    var evenSum = 0

    while(i<=100) {
        if (i % 2 == 0) evenSum += i else oddSum += i
        i++
    }
    println("$evenSum,$oddSum\n")
}

// 3. 키보드로 입력받은 숫자의 구구단을 출력하기
fun main3T3() {
    println("정수하나입력")
    var n = readln().toInt()

    var i = 1
    while (i<=9) {
        println("$n * $i = ${n*i}")
        i++
    }
    println()
}

// 4. 구구단 2~9단 출력하기
fun main3T4() {
    var n = 2
    while(n <=9) {
        var i = 1
        while (i<=9) {
            println("$n * $i = ${n*i}")
            i++
        }
        println()
        n++
    }
}