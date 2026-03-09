/*
 * 5. 키보드를 이용해서 정수 5개를 입력 받은 후 int형 배열에 저장한다.
 * 배열에 저장된 값 중 최댓값, 최솟값을 구하는 프로그램
 */

fun main(args: Array<String>) {
    val numbers = IntArray(5)
    println("정수 5개를 하나씩 입력하시오")

    for (i in 0..4){
        numbers[i] = readln().toInt()
    }

    val maxVal = numbers.max()!!    // 최신버전은 함수명 maxOrNull()!!
    val minVal = numbers.min()!!

    println(numbers.contentToString()) // 문자열로 변경 필수!
    println("$maxVal $minVal")
}

/*
println(numbers)만 하면 자바처럼 주소만 나온다
배열 내의 데이터를 보고 싶다면 문자열로 변경 필수
 */