package task.kotlin

fun main() {
    // 2차원 배열 [][] 행(세로)과 열(가로)

    // 예제 1. 이차원 배열에 5명 학생의 3과목 점수를 각기 입력했을 때
    //        각 학생들의 점수를 정돈하여 출력하기 (행렬처럼)
    val score = Array(5) { IntArray(3) }

    score[0][0]=85;  score[0][1]=60;  score[0][2]=70
    score[1][0]=90;  score[1][1]=95;  score[1][2]=80
    score[2][0]=75;  score[2][1]=80;  score[2][2]=100
    score[3][0]=80;  score[3][1]=70;  score[3][2]=95
    score[4][0]=100; score[4][1]=65;  score[4][2]=80

    for (row in 0 until 5) {
        for (col in 0 until 3) {
            print(" ${score[row][col]}")
        }
        println()
    }

//=============================================================================

    // 예제 2. 이차원 배열이 주어졌을 때, 각 과목별 총점과 학생별 총점 구하기
    //        이것도 다른 예제에 비슷한 거 있는데 키보드로 입력받냐 아니냐의 차이임
    val scores = arrayOf(
        intArrayOf(85, 60, 70),
        intArrayOf(90, 95, 80),
        intArrayOf(75, 80, 100),
        intArrayOf(80, 70, 95),
        intArrayOf(100, 65, 80)
    )

    val subject = IntArray(3)
    val student = IntArray(5)

    println("각 과목별 총점구하기 ")
    for (c in 0 until 3) {          // 0..5는 0부터5까지고 0 until 5는 0부터 4까지임
        for (r in 0 until 5) {
            subject[c] += scores[r][c]
        }
        println(subject[c])
    }

    println("학생별 총점구하기")
    for (r in 0 until 5) {
        for (c in 0 until 3) {
            student[r] += scores[r][c]
        }
        println(student[r])
    }
}

/*
참고로 코틀린에서 2차원 배열을 만들 때 방식!

===========================================================================================

arrayOf( intArrayOf(...), intArrayOf(...) )
arrayOf( doubleArrayOf(...), intArrayOf(...) )      - 이 경우 any타입 배열로 변경됨
arrayOf( charArrayOf(...), charArrayOf(...) )
arrayOf( arrayOf("a","b"), arrayOf("c","d") )       문자열은 전용 배열이 없음

데이터가 없어도 일단 null 등이라도 추가를 하는 경우엔 이렇게 활용 가능.
arrayOfNulls<String>(5)                             문자열 빈 배열로 만들거나 (모두 null임)
 혹은 Array(5) { "" }                                특정 문구 반복 배열로 만들어짐 (람다식 활용)

: arrayOf가 있으면 가장 큰 상자에 이미 있는 1차원 배열들을 담는다는 의미.
  문자열일 때는 무조건 사용함
  그리고 어레이오프는 수정 불가한 크기 고정 배열

===========================================================================================

Array(5) { IntArray(3) }
Array(5) { DoubleArray(3) }
Array(5) { BooleanArray(3) }
Array(String) { BooleanArray(3) }
Array(3) { arrayOfNulls<String>(2) }

: Array로 시작하는 경우 큰 상자 안에 2차원 배열들 넣는다는 소리.
  데이터 값이 지정되지 않은 빈 2차원 배열 생성.
  { } 람다식 안에 들어가는 생성자가 각기 자료형에 맞는 배열을 생성함.

===========================================================================================

listOf(listOf(1), ...)      2차원 리스트
listOf(1, 2, 3)
: 이건 리스트 생성 & 읽기 전용임 수정불가한 리스트

MutableList(5) { MutableList(3) { 0 } }         얘도 2차원리스트
mutableListOf<String>()
: 이건 가변 리스트 생성. 말그대로 수정 가능 추가도 가능.

 */