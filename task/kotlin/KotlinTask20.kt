package task.kotlin

fun check() {
    println("메소드 호출 성공\n")
}

// 오버로딩: 이름은 같지만 파라미터 타입이 다름
fun check(a: Int) {
    println(a)
    println()
}

fun check(a: Int, d: Double) {
    val result = a + d
    println(result)
    println()
}

fun check(c: Char) {
    println(c)
    println()
}

fun check(b: Boolean) {
    println(b)
    println()
}

fun check(s: String) {
    println(s)
    println()
}

fun check1(): Int {
    println("return\n")
    return 50
}

fun check2(a: Int, d: Double): Double {
    val result = a + d
    println()
    return result
}

fun main(args: Array<String>) {
    check()

    // 오버로딩된 함수들 호출
    check(30)
    check(10, 20.5)
    check('A')
    check(true)
    check("java")
    check("python") // 코틀린은 String 생성자 대신 리터럴 권장

    // 리턴값 처리
    check1() // 화면엔 return만 찍힘
    val result = check1()
    println(result) // 50 출력

    val result2 = check2(50, 3.14)
    println(result2) // 53.14 출력
}