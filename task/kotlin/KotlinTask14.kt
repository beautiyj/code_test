package task.kotlin

/*
// 반복문 - do while문 (파이썬엔 x)
    보기 불편해서 잘 쓰진 않음

    do {
        반복 실행 문장;
    } while(조건식);

*/

fun main() {
    task14T1()
    task14T2()
    task14T3()
}

// 1. 문자열 반복 출력
fun task14T1() {
    var i = 1
    do {
        println("${i}do-while문 문장출력")
        i++
    } while (i <= 10)
    println()
}

// 2. 1~100까지의 홀수 짝수 합 구하기
fun task14T2() {
    var i = 1
    var oddSum = 0
    var evenSum = 0
    do {
        if (i % 2 == 0) {
            evenSum += i
        } else {
            oddSum += i
        }
        i++
    } while (i <= 100)

    println(oddSum)
    println(evenSum)
    println()
}

// 3. 종료 키워드 q가 입력 될 때까지 사용자 입력을 반복처리하는
// 대화형태 에코 프로그램 작성하기
fun task14T3() {
    println("메시지를 입력하세요. (종료 키워드: q)")
    var input: String

    do {
        print("> ")
        input = readln()
        println("입력 메시지: $input")
    } while (input != "q")

    println("프로그램 종료")

    /* 실제로는 do-while문보단 브레이크문 자주 사용함
    while (true) {
        print("> ")
        val str = readln()
        println("입력 메시지: $str")
        if (str == "q") break
    }
    */
}