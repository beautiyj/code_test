"""
과제7
키보드를 통해서 각 회원들의 정보를 입력받는 클래스(MemberInput)를 작성한다.
이때 입력받는 회원의 정보는 성명, 나이, 이메일, 주소를 입력받는다.
그리고 키보드로 입력한 회원의 정보는 새로운 회원정보를 저장하는
클래스(MemberInfo)의 멤버변수에 저장시킨 후 출력하는 프로그램을 작성하시오.

제한 사항
MemberInfo 클래스의 멤버변수 초기화 방법은 생성자를 이용하세요.
1명의 회원정보를 입력받아서 처리한다. (가능하면 2명 이상의 회원 정보도 입력받아서 처리해 보자.)
"""


class MemberInfo:
    # 생성자
    def __init__(self, name, age, email, address):
        # 값 대입(초기화)
        self.name = name
        self.age = age
        self.email = email
        self.address = address

    # 회원 정보 출력 메서드
    def display_info(self):
        print(f"Name: {self.name}")
        print(f"Age: {self.age}")
        print(f"Email: {self.email}")
        print(f"Address: {self.address}")

# 실행코드 (직접실행의 경우 이프 네임 메인 아래의 코드 실행하기)
if __name__ == "__main__":
    print("회원정보 입력하기")

    name = input("Name: ")
    age = int(input("Age: "))
    email = input("Email: ")
    address = input("Address: ")

# 객체생성(생성자 호출)
    member = MemberInfo(name,age,email,address)

#출력 메소드 호출
    member.display_info()