package task.kotlin

// 중첩 for문을 활용해 주어진 배열의 전체 항목 합, 평균값 구하기 (+2차원 배열)

/*
주어진 배열은 다음과 같다.

int[][] array = {
    {95,86},
    {83,92,96},
    {78,83,93,87,88}
};


변수: 입력값은 배열, 출력값은 배열의 sum avg,
행위: 중첩for문을 이용해서 sum, avg구하기
 */

fun main() {
    val array = arrayOf(
        intArrayOf(95, 86),
        intArrayOf(83, 92, 96),
        intArrayOf(78, 83, 93, 87, 88)
    )

    var sum = 0
    var count = 0

    for (i in array.indices) {             // i 루프
        for (j in array[i].indices) {      // j 루프
            sum += array[i][j]
            count++
        }
    }

    val avg = sum.toDouble() / count

    println(sum)
    println(avg)
}

/*

플래튼 함수 사용하면 간단하게 활용 가능

fun main() {
    val array = arrayOf(
        intArrayOf(95, 86),
        intArrayOf(83, 92, 96),
        intArrayOf(78, 83, 93, 87, 88)
    )

    // 플래튼으로 1차원으로 만든 뒤 바로 계산
    // flatten()은 2차원 -> 1차원으로만 변경이고
    // flatMap()은 변환 후 2차원 -> 1차원
    val allNumbers = array.flatMap { it.toList() }
    println("sum: ${allNumbers.sum()}")
    println("avg: ${allNumbers.average()}")
}

*/