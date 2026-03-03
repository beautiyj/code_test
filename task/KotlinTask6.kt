/*
 * 6. 2차원 배열을 이용해 5명 학생들의 국어, 영어, 수학 점수를 저장했을 때 과목별 총점과 학생별 총점을 출력하는 프로그램
 *
 * 조건: 과목명(국어, 영어, 수학)과 학생번호 출력
 *
 */

fun main() {
    val subjects = arrayOf("Korean", "English", "Math")
    val scores = Array(5) { IntArray(3) }   //3열 5행

    for (i in scores.indices) { // .indices : 인덱스들 안에서만 돌려라
        println("Student number: ${i + 1}")
        for (j in scores[i].indices) {
            print("${subjects[j]}: ")
            scores[i][j] = readln().toInt()
        }
    }

    println("Total Score (Student)")
    for (i in scores.indices) {
        val studentTotal = scores[i].sum() // IntArray의 내장함수 사용
        println("Student No.${i + 1}: $studentTotal")
    }

    println("Total Score (Subject)")
    for (j in 0 until 3) {
        var scoreTotal = 0
        for (i in 0 until 5) {
            scoreTotal += scores[i][j]
        }
        println("Subject ${subjects[j]}: $scoreTotal")
    }
}

/*
코틀린에서는 인덱스 번호가 필요한 경우와 값만 꺼내서 쓸 경우,
그리고 인덱스 번호 & 값 꺼내기 둘 다 필요한 경우로 나눠볼 수 있다.

1. 인덱스 번호가 필요한 경우
for (i in ar.indices)

// 0부터 마지막 인덱스 번호까지 라는 의미의 프로퍼티라서 (3)배열이면 0..2 의미함!
val ar = IntArray(3) // [0, 0, 0]
for (i in ar.indices) {
    ar[i] = i * 10
} // 결과: [0, 10, 20]



2. 값만 꺼내서 쓸 경우
for (score in ar)

val scores = intArrayOf(80, 90, 100)
var sum = 0
for (score in scores) {
    sum += score // 인덱스 값이 필요 없는 합계 구하기에 자주 쓰는 타입.
}


3. 둘 다
for ((i, score) in ar.withIndex())

val subjects = arrayOf("국어", "영어", "수학")
for ((i, name) in subjects.withIndex()) {
    println("${i + 1}번째 과목은 ${name}입니다.")
} // 결과: 1번째 과목은 국어입니다...

예제처럼 인덱스 번호와 데이터를 모두 동시출력해야하는 경우 사용.
코틀린의 withIndex() 메소드는 인덱스와 데이터를 동시에 출력해주는 역할을 함.
예를 들어 ["Korean", "English"] 배열이 있을 때,
withIndex() 사용 시 [(index=0, value="Korean"), (index=1, value="English")].
이는 구조 분해 기능이라고도 함.
(= 파이썬의 enumerate() )
*/