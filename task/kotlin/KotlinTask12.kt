package task.kotlin

// 반복문 - for문

fun main() {
    main12T1()
    main12T2()
    main12T3()
    main12T4()
}

// 1. 메시지 10번 숫자+문자열 반복출력
// for문 없이 사용하는 경우 단일식으로 작성 가능
// (1..10).forEach { println("${it}문자열반복출력") }
fun main12T1() {
    for (i in 1..10) {
        println("${i}문자열반복출력")
    }
    println("출력종료\n")
}

// 2. 1~10까지의 합을 구하기
// 단일식 println((1..10).sum()) 가능
fun main12T2() {
    var result = 0
    for (i in 1..10) {
        result += i
    }
    println(result)
    println()
}

// 3. 1~100까지의 홀수, 짝수의 합 구하기
fun main12T3() {
    var oddSum = 0 //홀
    var evenSum = 0 //짝

    for (i in 1..100) {
        if (i % 2 == 0) evenSum += i else oddSum += i
    }
    println("$oddSum, $evenSum\n")

    /* for문 없이 - 대부분은 sum으로 가능. 스트림(컬렉션) 방식.
    val oddSum = (1..100 step 2).sum()
    val evenSum = (2..100 step 2).sum()
    println("$oddSum\n$evenSum\n")
     */
}

// 4. 키보드로 입력한 숫자의 단을(구구단. ex 3 입력 시 3단 출력) 출력하기
fun main12T4() {
    println("정수 하나 입력")
    val num = readln().toInt()

    // (1..9).forEach { println("$n * $it = ${n * it}") }
    for (i in 1..9) {
        println("$num * $i = ${num * i}")
    }
    println()
}