package task.kotlin

/*
과제7
키보드를 통해서 각 회원들의 정보를 입력받는 클래스(MemberInput)를 작성한다.
이때 입력받는 회원의 정보는 성명, 나이, 이메일, 주소를 입력받는다.
그리고 키보드로 입력한 회원의 정보는 새로운 회원정보를 저장하는
클래스(MemberInfo)의 멤버변수에 저장시킨 후 출력하는 프로그램을 작성하시오.

제한 사항
MemberInfo 클래스의 멤버변수 초기화 방법은 생성자를 이용하세요.
1명의 회원정보를 입력받아서 처리한다. (가능하면 2명 이상의 회원 정보도 입력받아서 처리해 보자.)
 */

class MemberInfo(
    val name: String,
    val age: Int,
    val email: String,
    val address: String
) {
    fun displayInfo() {
        println("회원 정보:")
        println("성명: $name")
        println("나이: $age")
        println("이메일: $email")
        println("주소: $address")
    }
}

// null이 들어오지 않는다는 가정 하에 readln()으로 간략 기재.
// 안정성을 위해서는 readLine() 널허용코드로 진행 필요.
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

    val memberInfo = MemberInfo(name, age, email, address)
    memberInfo.displayInfo()
}

/*
자바와 코틀린의 "생성자" 비교

자바 (노가다 버전)
class MemberInfo {
    String name; // 1. 변수 선언

    public MemberInfo(String name) { // 2. 생성자 작성
        this.name = name; // 3. 값 대입 (초기화)
    }
}

코틀린 (치트키 버전)
class MemberInfo(val name: String)
// 끝! 변수 선언 + 생성자 + 값 대입이 이 한 줄에 다 들어있음.


1. 자바: 생성자는 하나의 '함수(메서드) 전체'다
자바에서 생성자는 클래스 이름과 똑같은 이름을 가진 특별한 함수 블록 전체를 말합니다.
파라미터는 그냥 "재료"일 뿐이고, 실제 **"요리(대입/초기화)"**는
{ } 중괄호 안에서 직접 손으로 다 해줘야 합니다.
그래서 사용자님이 말씀하신 것처럼 { } 블록 전체가 생성자라는 느낌이 강합니다.

2. 코틀린: 파라미터가 곧 '변수이자 생성자'다
코틀린의 주 생성자(Primary Constructor)는 클래스 선언 바로 옆 괄호 ( )에 붙어 있죠.
여기서 val이나 var을 붙여주면, 코틀린은 **"이 괄호 안의 명단(파라미터)이
곧 이 클래스의 뼈대(멤버 변수)고, 동시에 조립 지침서(생성자)다"**라고 선언하는 겁니다.
즉, 파라미터 선언이 곧 생성자 그 자체가 되어버립니다.
 */