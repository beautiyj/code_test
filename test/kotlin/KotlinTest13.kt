package test.kotlin

fun main() {

    // 1. 과일 개수 세기 (데이터 카운팅)
    println("--- 1. 과일 개수 세기 ---")
    val inventory = mutableMapOf("사과" to 5, "바나나" to 10, "포도" to 3)

    println("사과 재고: ${inventory["사과"]}개")
    println("전체 자판기 상태: $inventory")
    println()


    // 2. 학생 성적 관리 (데이터 매핑)
    println("--- 2. 학생 성적 관리 ---")
    val scores = mutableMapOf("철수" to 90, "영희" to 100, "민수" to 85)

    val target = "영희"
    println("${target}의 점수: ${scores[target]}점")

}