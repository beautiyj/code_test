package test.kotlin

/*
배타적 논리합 ^ XOR 연산자
: 두 값이 같으면 0 (false), 다르면 1 (true)로 계산하는 연산자
둘 다 tt면 f, ff면 t 뭔가... 애매한 or+not 같다

- true ^ true = false
- true ^ false = true
- false ^ true = true
- false ^ false = false

배타적 논리합 ^ 주요 활용처 예제
 */

fun main() {
    // 1. 짝 없는 숫자 찾기
    println("1. 짝 없는 숫자 찾기")
    val arr = intArrayOf(2, 3, 2, 4, 3)
    var result = 0

    for (num in arr) {
        result = result xor num
    }
    println("혼자 남은 짝 없는 숫자: $result\n")

    // 2. temp처럼 임시 변수 쓰지 않고도 두 변수의 값을 바꾸는 swap 예제
    println("2. 임시 변수 없이 값 바꾸기(Swap)")
    var a = 10
    var b = 20
    println("바꾸기 전 -> a: $a, b: $b")
    a = a xor b
    b = a xor b
    a = a xor b
    println("바꾼 후   -> a: $a, b: $b\n")

    // 3. 암호화 및 복호화
    println("3. 암호화 및 복호화")
    val originalData = 12345
    val secretKey = 999

    val encrypted = originalData xor secretKey
    println("원본 데이터: $originalData")
    println("암호화된 데이터 (알 수 없는 값): $encrypted")

    val decrypted = encrypted xor secretKey
    println("복호화된 데이터 (원상복구): $decrypted")
}