package test.kotlin

// 2차원 배열 예제

// 보통 코테에서 제한사항
// ~ 의 길이보다 작다   →  인덱스 번호
// ~ 의 원소보다 작다   →  값

// ==========================================================================================

/*
1. 정수 n과 k가 주어졌을 때 1~n이하 정수 중 k의 배수를 오름차순으로 저장한 배열 return 함수
예: 1 이상 10 이하의 3의 배수는 3, 6, 9 이므로 [3, 6, 9]를 return 합니다.
입력값변수: 정수n,k     출력값변수: k의배수를 오름차순정렬한 배열[]
행위: 오름차순정렬, 조건식으로k배수확인
*/

fun solution24(n: Int, k: Int): IntArray {
    // 결과 배열의 크기를 계산하기. 1~n 이하 중 k의 배수만 들어가는 거니까 나머지 빼고 몫=크기
    // 예시처럼 n=10, k=3일때 count = 3, result[]=3개의 수만 들어감.
    val count = n / k
    val result = IntArray(count)
    var index = 0

    for (i in 1..n) {
        if (i % k == 0) {
            result[index] = i
            index++
        }
    }
    return result

    /*
    실무용 간단버전
    return (1..n).filter { it % k == 0 }.toIntArray()

    등차수열 원리로 진행할 경우
    return (k..n step k).toList().toIntArray()
    */
}

// ==========================================================================================

/*
2. 정수 l과 r가 주어졌을 때 l 이상 r 이하의 정수 중에서
숫자 0과 5로만 이루어진 모든 정수를 오름차순으로 저장한 배열 return,
정수가 없을 경우 -1 배열을 return 함수 만들기.
예:   l       r         result
      5     555     [5, 50, 55, 500, 505, 550, 555]
     10      20     [-1]

입력값변수: 정수 l r
출력값: 숫자 0과 5로만 이루어진 오름차순 배열 / 정수가 없을 경우 -1 배열
행위: 숫자 0과 5로만 이루어진 정수 &* 정수가 없을 경우를 판별

로직:
1. 배열의 크기가 어떻게 정해질 지 모르니까(배열의크기는불변) 최대크기의 임시 배열 생성.
   temp[r-l+1] 최대크기의 임시배열, count = 0 횟수.
2. l~r 사이의 숫자 반복문 (0,5면 배열에저장하는 for문) 으로 조건판별
3. 그다음 임시배열을 활용해 최종 result[] 배열을 생성, for문으로 배열 복사

% 10  →  마지막 자리 뽑기  (나머지)
/ 10  →  마지막 자리 제거  (나누기 소수점버림)
*/

fun isNum(n: Int): Boolean {    // 만약 n이 505일때
    var num = n
    while (num > 0) {
        val digit = num % 10    // 숫자의 마지막자리 체크하기. 505%10= 나머지 5
        if (digit != 0 && digit != 5) {  // 마지막 자리가 0,5가 아니면 바로 탈출
            return false
        }
        num /= 10               // 나누기로 자리 제거. 505/10 = 50
    }
    return true
}

fun solution24T2(l: Int, r: Int): IntArray {
    val temp = IntArray(r - l + 1)
    var count = 0

    // 메소드활용하여 임시배열 temp에 숫자들 저장
    for (i in l..r) {
        if (isNum(i)) {
            temp[count] = i
            count++
        }
    }

    // 메소드 활용했을 때 temp에 들어가는 게 없다면 -1 배열 리턴
    if (count == 0) return intArrayOf(-1)

    // temp임시배열을 실제 크기 배열 result에 복사해서 리턴
    val result = IntArray(count)
    for (i in 0 until count) {
        result[i] = temp[i]
    }
    return result

    /*
    실무용 간단버전
    val result = (l..r).filter { isNum(it) }.toIntArray()
    return if (result.isEmpty()) intArrayOf(-1) else result
    */
}

// ==========================================================================================

/*
3. 정수 배열 arr와 2개의 구간이 담긴 배열 intervals 주어졌을 때,
intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간이다.
닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미한다.

이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을
앞뒤로 붙여 새로운 배열을 만들어 return하는 함수 만들기.

제한사항
1 ≤ arr의 길이 ≤ 100,000
1 ≤ arr의 원소 < 100
1 ≤ a1 ≤ b1 < arr의 길이
1 ≤ a2 ≤ b2 < arr의 길이
( 여기서     1 ≤ a1 ≤ b1 < arr의 길이  <<- 인덱스번호 를 캐치해야함.
arr길이가 5일 경우, arr안의 값은 뭐든 가능한데 길이보다 작다는 제한이면 인덱스 0~4 제한사항에 맞음.
값은 아무거나 가능해서 a1=100 b1=1 도 되는데 길이 제한이 있다는 건 인덱스라는 의미.
그러니 a1 b1은 arr의 인덱스번호가 되는 거.)

예시
    arr                     intervals              result
    [1, 2, 3, 4, 5]     [[1, 3], [0, 4]]   [2, 3, 4, 1, 2, 3, 4, 5]

첫 번째 구간에 해당하는 배열은 [2, 3, 4] 입니다.
두 번째 구간에 해당하는 배열은 [1, 2, 3, 4, 5] 입니다.
따라서 이 두 배열을 앞뒤로 붙인 배열인 [2, 3, 4, 1, 2, 3, 4, 5]를 return 합니다.
( 말그대로 1,3인덱스 구간 -> arr[1,3]은 [2,3,4] )

입력값변수: 정수배열 arr, 2개의 구간이 담긴 배열 intervals(arr의 인덱스를 지정하는 배열)
출력값: arr의 첫번째,2번째 배열을 붙인 result배열(인덱스번호에 따라 구간 달라짐)
행위: 인덱스번호에 따른 배열구간 체크? 그리고 새로운 배열 생성

1. 새로운 배열 result의 크기를 먼저 계산하고
2. 인터벌의 인덱스번호에 맞게 첫번째구간을 복사,
3. 두번째 구간은 이어붙이고 결과배열 리턴
*/

fun solution24T3(arr: IntArray, intervals: Array<IntArray>): IntArray {
    val a1 = intervals[0][0]
    val b1 = intervals[0][1]
    val a2 = intervals[1][0]
    val b2 = intervals[1][1]

    val result = IntArray((b1 - a1 + 1) + (b2 - a2 + 1))
    var index = 0

    // 1구간 복사
    for (i in a1..b1) {
        result[index++] = arr[i]
    }

    // 2구간 이어붙이기
    for (i in a2..b2) {
        result[index++] = arr[i]
    }

    return result

    /*
    실무용 간단버전
    return arr.slice(a1..b1).toIntArray() + arr.slice(a2..b2).toIntArray()
    */
}

// ==========================================================================================
// 기초문제 - 배열만들기3까지 적어둠

fun main() {
    println("Solution24 결과: ${solution24(10, 3).toList()}")
    println("Solution24T2 결과: ${solution24T2(5, 555).toList()}")

    val arr = intArrayOf(1, 2, 3, 4, 5)
    val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(0, 4))
    println("Solution24T3 결과: ${solution24T3(arr, intervals).toList()}")
}