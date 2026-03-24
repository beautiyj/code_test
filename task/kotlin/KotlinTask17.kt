package task.kotlin

fun main(args: Array<String>) {

// ============================================================================

    // 예제 1. 확장 for문
    val score = intArrayOf(95, 71, 84, 93, 87)

    // 기본 for문의 경우 (indices 사용)
    var sum = 0
    for (i in score.indices) {
        sum += score[i]
    }
    println(sum)

    // 확장 for문의 경우 (코틀린의 기본 스타일)
    var sum1 = 0
    for (s in score) {
        sum1 += s
    }
    println(sum1)

// ============================================================================

    // 예제 2. 배열 복사
    val oldArray = intArrayOf(10, 20, 30)
    val newArray = IntArray(5)

    for (i in oldArray.indices) {
        newArray[i] = oldArray[i]
    }

    for (i in newArray) {
        print("$i\t")
    }
    println()

// ============================================================================

    // 예제 3. 사용자 정의 메소드를 활용한 문자열 숫자 변환, 절대값 구하기
    if (args.size >= 2) {
        println(args[0])    // "-10"
        println(args[1])    // "-20"

        val num = args[0].toInt()
        println(abs(num))
    }

}

// 음수->양수 변환 절대값 구하기 메소드
fun abs(data: Int): Int {
    var d = data
    if (d < 0) {
        d = -d
    }
    return d
}