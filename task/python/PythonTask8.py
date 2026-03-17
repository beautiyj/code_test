"""
과제7
키보드를 통해서 각 회원들의 정보를 입력받는 클래스(MemberInput)를 작성한다.
이때 입력받는 회원의 정보는 성명, 나이, 이메일, 주소를 입력받는다.
그리고 키보드로 입력한 회원의 정보는 새로운 회원정보를 저장하는
클래스(MemberInfo)의 멤버변수에 저장시킨 후 출력하는 프로그램을 작성하시오.

제한 사항
MemberInfo 클래스의 멤버변수 초기화 방법: 생성자x setter메소드 이용하기.
1명의 회원정보를 입력받아서 처리한다. (가능하면 2명 이상의 회원 정보도 입력받아서 처리해 보자.)
"""

# 방식이 노가다라서 그냥 생성자 쓰는 게 최고긴 하다. 아니면 데이터클래스를 애용하자.
class MemberInfo:
    def __init__(self):
        self._name = ""
        self._age = 0
        self._email = ""
        self._address = ""

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value

    @property
    def age(self):
        return self._age

    @age.setter
    def age(self, value):
        self._age = value

    @property
    def email(self):
        return self._email

    @email.setter
    def email(self, value):
        self._email = value

    @property
    def address(self):
        return self._address

    @address.setter
    def address(self, value):
        self._address = value

    def display_info(self):
        print("\n--- 회원 정보 ---")
        print(f"성명: {self.name}")
        print(f"나이: {self.age}")
        print(f"이메일: {self.email}")
        print(f"주소: {self.address}")

if __name__ == "__main__":
    member = MemberInfo()
    member.name = input("성명: ")
    member.age = int(input("나이: "))
    member.email = input("이메일: ")
    member.address = input("주소: ")
    member.display_info()

#===============================================
# 데코레이터 노가다가 귀찮을 때: 데이터클래스 사용하기
from dataclasses import dataclass

@dataclass
class MemberInfo:
    name: str = ""
    age: int = 0
    email: str = ""
    address: str = ""

    def display_info(self):
        print("\n--- 회원 정보 ---")
        print(f"성명: {self.name}, 나이: {self.age}, 이메일: {self.email}, 주소: {self.address}")

if __name__ == "__main__":
    name = input("성명: ")
    age = int(input("나이: "))
    email = input("이메일: ")
    address = input("주소: ")

    member = MemberInfo(name, age, email, address)
    member.display_info()