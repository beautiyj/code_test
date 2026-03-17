package task.kotlin

/*
과제8
키보드를 통해서 각 회원들의 정보를 입력받는 클래스(MemberInput)를 작성한다.
이때 입력받는 회원의 정보는 성명, 나이, 이메일, 주소를 입력받는다.
그리고 키보드로 입력한 회원의 정보는 새로운 회원정보를 저장하는
클래스(MemberInfo)의 멤버변수에 저장시킨 후 출력하는 프로그램을 작성하시오.

제한 사항
MemberInfo 클래스의 멤버변수 초기화 방법: 생성자x setter메소드 이용하기.
1명의 회원정보를 입력받아서 처리한다. (가능하면 2명 이상의 회원 정보도 입력받아서 처리해 보자.)
 */

class MemberInfo2 {
    // var 선언 시 세터 정의됨(자동생성, 세터 정의는 생략)
    var name: String = ""
    var age: Int = 0
    var email: String = ""
    var address: String = ""

    fun displayInfo() {
        println("회원 정보:")
        println("성명: $name")
        println("나이: $age")
        println("이메일: $email")
        println("주소: $address")
    }
}

fun main() {
    println("회원 정보를 입력하세요.")

    print("성명: ")
    val name = readln()

    print("나이: ")
    val age = readln().toInt()

    print("이메일: ")
    val email = readln()

    print("주소: ")
    val address = readln()

    val memberInfo = MemberInfo2()
    // 세터실행
    memberInfo.name = name
    memberInfo.age = age
    memberInfo.email = email
    memberInfo.address = address

    memberInfo.displayInfo()
}