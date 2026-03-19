package test.kotlin

/*
양의 정수 n이 매개변수로 주어질 때,
n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고
n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는
solution 함수를 작성해 주세요.


    n	result
  -------------
    7	16
    10	220

예제 1번의 n은 7로 홀수입니다.
7 이하의 모든 양의 홀수는 1, 3, 5, 7이고
이들의 합인 1 + 3 + 5 + 7 = 16을 return 합니다.

예제 2번의 n은 10으로 짝수입니다.
10 이하의 모든 양의 짝수는 2, 4, 6, 8, 10이고
이들의 제곱의 합인 22 + 42 + 62 + 82 + 102 = 4 + 16 + 36 + 64 + 100 = 220을 return 합니다.

 */

fun sol10 (n: Int): Int {
    var answer = 0

    if (n % 2 == 1) {
        for (i in 1..n step 2) {
            answer += i
        }
    } else {
        for (i in 2..n step 2) {
            answer += i
        }
    }
    return answer
}

// 간략버전 1 - sum, sumOf 사용하기
fun test10(n: Int): Int {
    return if (n % 2 == 1) {
        (1..n step 2).sum()
    } else {
        (2..n step 2).sumOf { it * it }
    }
}

// 간략버전 2 - 그마저도귀찮을때 리턴생략 단일식으로 쓰
fun t10(n: Int) =
    if (n % 2 == 1) (1..n step 2).sum()
    else (2..n step 2).sumOf { it * it }

fun main() {
    println(sol10(7))
    println(sol10(10))

    println(test10(5))
    println(test10(4))

    println(t10(3))
    println(t10(6))
}

/*
 .sum()
    서식 - 리스트나 범위.sum()
    리스트 범위 등에 쓰는 확장함수. 모두 더하기
    대신 .sum()은 같은 자료형끼리 더할 때만 사용 가능

 .sumOf()
    서식 - 리스트나 범위.sumOf { it(람다인자) * it(규칙) }
    여기서 람다인자의 규칙은 it.toDouble() 변환도 가능,
                         it * it 제곱도 가능, (1*1 + 2*2 + 3*3...같은의미임)
                         it * 10 이나 it * 2.5 등등 자료형 다른 숫자끼리도 연산 가능.
    리스트 범위 등에 쓰는 확장함수. 함다함수로 인자를 받음, 객체필드합산도 가능!


+++ 숫자 형태 말고 문자열에 쓰이는 문자열 전용 확장함수
.joinToString()
    서식 - 리스트나 범위.joinToString()
    리스트 범위 등에 쓰는 확장함수. 모두 문자열로 바꿔서 하나로 합치기
         (1..5).joinToString() -> "1, 2, 3, 4, 5"
         (1..5).joinToString("-") -> "1-2-3-4-5"
         (1..5).joinToString(prefix = "<", postfix = ">") -> "<1, 2, 3, 4, 5>"
 */