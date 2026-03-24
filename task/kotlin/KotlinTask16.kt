package task.kotlin

fun main() {

    // 배열 형식 1. 배열에 저장될 값이 정해지지 않은 경우 (자료형에 따른 초기화)
    // 서식: 자료형Array(배열크기) 또는 arrayOfNulls<자료형>(배열크기)
    val scores = IntArray(3)
    println(scores[0])      // 0        자동 0으로 초기화
    scores[0] = 10
    println(scores[0])      // 10

    val d = DoubleArray(3)
    println(d[0])           // 0.0      자동 0.0으로 초기화

    val c = CharArray(3)               // char형은 자동 초기화가 없음. (코틀린도 \u0000으로 세팅됨)
    println(c[0])           // 아무것도 안뜸. null아니고 공백인데 다름

    val b = BooleanArray(3)
    println(b[0])           // false    자동으로 f초기화(자바 동일)

    val str = arrayOfNulls<String>(3)  // 참조형 - 코틀린은 arrayOfNulls 사용
    println(str[0])         // null     자동으로 null로 초기화
    println()


    // 배열 형식 2. 배열 선언과 동시에 초기화하는 경우 (배열에 할당될 값 정해진 게 대다수)
    val s = intArrayOf(80, 90, 100)
    println("배열 크기: " + s.size)
    for (i in 0 until s.size) {
        println(s[i].toString() + "\t")
    }
    println()

    val dd = doubleArrayOf(3.14, 10.5, 42.195, 50.0)    // 코틀린은 50 대신 50.0으로 명확히 써야 함
    for (i in 0 until dd.size) {
        println(dd[i].toString() + "\t")
    }

    val cc = charArrayOf('j', 'a', 'v', 'a', 'c', 'd')
    for (i in 0 until cc.size) {
        println(cc[i].toString() + "\t")
    }

    val bb = booleanArrayOf(true, false, true)
    for (i in 0 until bb.size) {
        println(bb[i].toString() + "\t")
    }

    val str1 = arrayOf("aa", "bb", "cc", "dd")      // 코틀린은 arrayOf로 통일
    for (i in 0 until str1.size) {
        println(str1[i] + "\t")
    }
    println()

// ============================================================================

    // 예제1 - 점수의 평균값을 소수점 둘째 자리까지 출력하기
    println("예제1")
    val score = intArrayOf(83, 90, 87)
    var sum = 0
    for (i in 0 until score.size) {
        sum += score[i]
    }
    val avg = sum.toDouble() / 3.0
    println("총합: " + sum + " 평균: " + avg)
    System.out.printf("총합: %d, 평균: %.2f\n", sum, avg)
    println()

// ============================================================================

    // 예제2 - 키보드로 5과목 점수 입력받아 총점 & 평균 구하기
    println("예제2")
    val subjectScores = IntArray(5)
    println("5과목 점수 입력하기")

    var sum2 = 0
    for (i in 0 until subjectScores.size) {
        print("${i + 1}번째 점수 입력: ")
        subjectScores[i] = readln().toInt()
        sum2 += subjectScores[i]
    }
    val avg2 = sum2.toDouble() / subjectScores.size
    System.out.printf("총점: %d, 평균: %.2f\n", sum2, avg2)
    println()

// ============================================================================

    // 예제3 - 배열에 저장된 데이터 중 최대 최소 구하기 (실수 ver)
    println("예제3")
    val data = doubleArrayOf(9.5, 7.0, 13.6, 7.5, 10.5)

    var max = data[0]
    var min = data[0]

    for (i in 0 until data.size) {
        if (data[i] > max) {
            max = data[i]
        }
        if (data[i] < min) {
            min = data[i]
        }
    }
    println(max)
    println(min)
    println()

// ============================================================================

    // 예제4. 사용자 정의 메소드를 활용하여 누적합계 구하기
    println("예제4")

    var sss: IntArray
    sss = intArrayOf(83, 90, 87)

    // 기본 for문으로 구하면 이거고
    var sum1 = 0
    for (i in 0 until sss.size) {
        sum1 += sss[i]
    }
    println(sum1)

    // 사용자 정의 메소드 add를 사용하는 경우
    val sum22 = add(intArrayOf(83, 90, 87))
    println(sum22)

}

fun add(sss: IntArray): Int {
    var sum = 0

//          범위 3으로 지정도 ㅇㅋ긴 함. 데이터 증가 대비해서 until 사용
    for (i in 0 until sss.size) {
        sum += sss[i]
    }
    return sum
}