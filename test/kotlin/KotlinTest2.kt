package test.kotlin
/*
* temp를 활용하여 두 변수 값을 교환하기
* */

fun main() {
    var a = 3
    var b = 5
    println("a=$a, b=$b")

    val temp = a
    a = b
    b = temp
    println("a=$a, b=$b")

    main2()
}

// 코틀린은 temp 말고도 사용할 수 있는 방법 .also 존재
fun main2() {
    var (a, b) = Pair(3, 5)
    println("a=$a, b=$b")
    a = b.also { b = a }    // .also 사용 시 b값을 먼저 저장-> b에 a값 저장 -> a에 원래 기억한 b값 저장
                            //  b=5 기억하고              -> b=a=3 저장 -> a=5 저장
    println("a=$a, b=$b")
}