package test.kotlin
/*
 시프트 연산
 이진수에서 자릿수가 하나 올라간다는 건 2를 곱한다는 뜻이고,
 내려간다는 건 2로 나눈다는 뜻입니다.

(참고로 제곱계산은 자바코틀린 - Math.pow() 파이썬은 **)

 << (Left Shift): 비트를 왼쪽으로 밀고, 빈 오른쪽 칸은 0으로 채웁니다.
 결과적으로 숫자가 2배가 됩니다. (n * 2의 제곱)

 >> (Right Shift): 비트를 오른쪽으로 밀고, 넘치는 비트는 버립니다.
 결과적으로 숫자를 2로 나눈 몫이 됩니다. (n / 2의 제곱)

 */

// 코틀린의 경우 << : shl, >> : shr 단어로 표기한다.
fun main() {
    // shl(<< 왼쪽으로 밀기 = 곱하기), shr(>> 오른쪽으로 밀기 = 나누기)
    val n = 10

    // 왼쪽으로 1칸 밀기 (shl = Shift Left)
    val leftShift = n shl 1
    println("10 shl 1 = $leftShift") // 20

    // 오른쪽으로 1칸 밀기 (shr = Shift Right)
    val rightShift = n shr 1
    println("10 shr 1 = $rightShift") // 5
}