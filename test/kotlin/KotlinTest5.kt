package test.kotlin

/*
문자열 my_string과 정수 k가 주어질 때,
my_string을 k번 반복한 문자열을 return 하는 함수를 작성

입출력 예시
my_string	k	    result
-------------------------------
"string"	3	   "stringstringstring"
"love"  	10	   "lovelovelovelove... 아무튼10번"
 */


fun test5(
    my_string: String,
    k: Int
): String {     // 코드블록이 있을 경우 반환값 자료형을 기재해줘야함. (안쓰면 Unit)
    var result: String = ""
    for (i in 1 .. k) {
        result += my_string
    }
    return result
}

// 단일표현식으로 쓰면 더 간단하게 가능함.(반환 String 생략가능)
// repeat() 함수는 문자열을 반복해서 붙여주는 함수
fun test6(my_string: String, k: Int) = my_string.repeat(k)

fun main() {
    println(test5("string", 3))
    println(test5("love", 10))

    println(test6("단일", 2))
}