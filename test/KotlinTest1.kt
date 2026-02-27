fun main() {
    println("기본 정석 출력 시\n")

    val scores = intArrayOf(80,90,100)
    for (i in scores.size -1 downTo 0) {
        println("인덱스 ${i}번 점수: ${scores[i]}")
    }

    println("\n리버스 메서드(확장함수) 사용\n")

    for (score in scores.reversed()) {
        println(score)
    }
}