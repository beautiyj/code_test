package task.kotlin3

/*
키보드를 통해서 각 회원들의 정보를 입력받는 클래스(MemberInput)를 작성한다.
이때 입력받는 회원의 정보는 성명, 나이, 이메일, 주소를 입력받는다.
그리고 키보드로 입력한 회원의 정보는 새로운 회원정보를 저장하는
클래스(MemberInfo)의 멤버변수에 저장시킨 후 출력하는 프로그램을 작성하시오.
*/

import java.util.*

// DTO
// 코틀린 실무: data class = Java @Getter @Setter + 생성자 한번에 해결
data class MemberInput73(
    var name: String,
    var age: Int,
    var email: String,
    var address: String
)

fun main() {
    val members: MutableList<MemberInput73> = mutableListOf()

    // use {} = Java try-with-resources 대응 (자동으로 close() 호출)
    Scanner(System.`in`).use { sc ->
        while (true) {
            print("성명: ")
            val name = sc.nextLine()

            // 하단 유효성 검사를 위해 1차 문자열로 입력받음
            print("나이: ")
            val ageStr = sc.nextLine()

            print("이메일: ")
            val email = sc.nextLine()

            print("주소: ")
            val address = sc.nextLine()

            // 유효성 검사 - 하나라도 비어있으면 재입력 요청
            if (listOf(name, ageStr, email, address).any { it.isEmpty() }) {
                println("모든 회원 정보를 입력해주세요")
                continue
            }

            // 유효성 검사 후 정수 변환
            val age = ageStr.toInt()

            // 생성자 방식으로 추가 (data class라 간결)
            members.add(MemberInput73(name, age, email, address))

            println("y/n")
            val input = sc.nextLine().lowercase()

            if (input == "n") break
        }

        // forEach + 포맷팅 출력
        members.forEach { m ->
            println("성명: ${m.name}\t나이: ${m.age}\t이메일: ${m.email}\t주소: ${m.address}")
        }
    }
}