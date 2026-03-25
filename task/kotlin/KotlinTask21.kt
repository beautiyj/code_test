package task.kotlin

// 예제 1. 1~n 까지의 합을 구하는 누적합계 메소드 작성하기
fun sum(n: Int): Int {
    var result = 0
    for (i in 1..n) {
        result += i
    }
    return result
}

// 예제 2. 키보드로 입력한 2개의 정수 중 max min 구하기
// fun max(a: Int, b: Int) = if (a > b) a else b 처럼 한줄로 구해도 됨
fun task21() {
    println("정수 2개 입력")
    val a = readln().toInt()
    val b = readln().toInt()

    println(maxOf(a, b))
    println(minOf(a, b))
}

fun main() {
    println(sum(3))
    println(sum(100))
    println(sum((10000)))

    task21()
}