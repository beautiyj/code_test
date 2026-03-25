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

// 예제 3. 값 비교, 주소 비교 메소드
fun compareString(s1: String, s2: String) {
    if (s1 === s2) {
        println("결과: 같주소")
    } else {
        println("결과: 다른주소")
    }

    if (s1 == s2) {
        println("결과: 같값")
    } else {
        println("결과: 다른값")
    }

    val n1 = s1.toInt()
    val n2 = s2.toInt()
    println("MAX: ${maxOf(n1, n2)}")
    println("MIN: ${minOf(n1, n2)}")
}


fun main() {
    println(sum(3))
    println(sum(100))
    println(sum((10000)))

    task21()

    println("예제3")
    val str1 = "30"
    // 코틀린에서 강제로 다른 주소를 만들려면 자바의 생성자를 빌려 써야 함
    val str2 = java.lang.String("30").toString()
    compareString(str1, str2)
}