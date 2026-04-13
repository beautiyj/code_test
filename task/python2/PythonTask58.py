# 인터페이스 다중상속
# 파이썬은 interface 키워드가 없으므로 ABC(추상 기반 클래스)로 인터페이스를 표현함

from abc import ABC, abstractmethod


# 클래스 상속과 인터페이스 구현을 동시에 사용하는 경우
class InterfaceHello(ABC):
    @abstractmethod
    def say_hello(self, name: str):
        pass


# 두 개의 인터페이스를 동시에 구현하는 경우 (다중 구현)
class InterfaceHello58(ABC):
    @abstractmethod
    def say_hello(self, name: str):
        pass


class InterfaceGoodBye58(ABC):
    @abstractmethod
    def say_goodbye(self, name: str):
        pass


# ----------------------------------------------------------------------------------

class AbstractGoodBye(ABC):
    @abstractmethod
    def say_goodbye(self, name: str):
        pass


# 파이썬은 클래스/인터페이스 구분 없이 괄호()에 나열하면 다중 상속됨
# 클래스 먼저, 인터페이스(ABC) 나중에 순서 중요!
#                              클래스 먼저            인터페이스 나중에. 순서 중요
class SubClass58(AbstractGoodBye, InterfaceHello):
    def say_hello(self, name: str):
        print(f"{name}씨 안녕하세요!")

    def say_goodbye(self, name: str):
        print(f"{name}씨 안녕히 가세요!")


# 인터페이스는 콤마(,)를 이용해 여러 개를 동시에 구현할 수 있음
class SubClassTask58(InterfaceHello58, InterfaceGoodBye58):
    def say_hello(self, name: str):
        print(f"{name}씨 안녕하세요!")

    def say_goodbye(self, name: str):
        print(f"{name}씨 안녕히 가세요!")


# ----------------------------------------------------------------------------------

if __name__ == "__main__":

    print("=== [사례 1] 상속 + 인터페이스 구현 ===")
    test01 = SubClass58()
    test01.say_hello("홍길동")
    test01.say_goodbye("홍길동")

    print("\n=== [사례 2] 다중 인터페이스 구현 ===")
    test02 = SubClassTask58()
    test02.say_hello("임꺽정")
    test02.say_goodbye("임꺽정")

    """
    [핵심 포인트]
    1. 클래스 상속은 '단 하나'만 권장하지만, 파이썬은 문법상 다중 클래스 상속도 가능합니다.
    2. ABC를 이용한 추상 클래스로 인터페이스 효과를 냅니다.
    3. 구현하는 클래스에서는 부모의 추상 메소드를 반드시 오버라이딩 해야 합니다.
    """