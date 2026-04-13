# 인터페이스 간의 상속 (Interface Inheritance)
# 인터페이스끼리는 다중 상속이 가능합니다.

from abc import ABC, abstractmethod


class InterfaceHello59(ABC):
    A = 10  # 파이썬에서 인터페이스 상수 표현 (관례상 대문자 상수명 사용)

    @abstractmethod
    def say_hello(self, name: str):
        pass


class InterfaceGoodBye59(ABC):
    @abstractmethod
    def say_goodbye(self, name: str):
        pass


# 인터페이스끼리 상속을 받을 때는 괄호()에 나열, 다중 상속 허용
# InterfaceTotal은 InterfaceHello59와 InterfaceGoodBye59의 모든 규격을 물려받고 자신의 규격을 추가함
class InterfaceTotal(InterfaceHello59, InterfaceGoodBye59):
    @abstractmethod
    def greeting(self, name: str):
        pass


# 인터페이스 -> 추상 클래스 -> 일반 클래스 계층 구조
class IColor(ABC):
    RED = 1     # 상수 (관례상 대문자, 실질적 불변 강제는 없음)
    GREEN = 2
    BLUE = 3

    @abstractmethod
    def get_color(self) -> int:
        pass

    @abstractmethod
    def set_color(self, c: int):
        pass


# ---------------------------------------------------------------------------------------------

# InterfaceTotal을 구현하는 클래스는 상위 인터페이스들의 모든 메소드를 오버라이딩해야 함
class SubClass59(InterfaceTotal):
    def say_hello(self, name: str):
        print(f"{name}씨 안녕하세요!")

    def say_goodbye(self, name: str):
        print(f"{name}씨 안녕히 가세요!")

    def greeting(self, name: str):
        print(f"{name}, 안녕!")


# 추상 클래스(AbsColor)는 인터페이스를 구현할 때 일부 메소드만 미리 구현할 수 있음
class AbsColor(IColor):
    def __init__(self):
        self.color = IColor.GREEN   # 추상 클래스는 일반 변수(필드)를 가질 수 있음

    def set_color(self, c: int):    # 구현된 메소드도 가질 수 있음
        self.color = c
    # get_color()는 아직 구현하지 않았으므로 추상 메소드로 남아있음


# 일반 클래스(SubClassTask59)는 남은 추상 메소드를 최종적으로 구현함
class SubClassTask59(AbsColor):
    def get_color(self) -> int:
        return self.color


# ----------------------------------------------------------------------------------

if __name__ == "__main__":

    print("=== [예제 06] 인터페이스 다중 상속 테스트 ===")
    test = SubClass59()
    test.say_hello("홍길동")
    test.say_goodbye("홍길동")
    test.greeting("홍길동")
    print(InterfaceHello59.A)       # 10
    # 인터페이스 내엔 상수라서 값 불변. 파이썬은 문법상 막을 수 없으나 관례상 수정하지 않음
    # InterfaceHello59.A = 30 -> 파이썬은 막지 않지만 실무에서 금기

    print("\n=== [예제 07] 인터페이스-추상클래스 계층 테스트 ===")
    test07 = SubClassTask59()
    test07.set_color(IColor.RED)    # 부모(추상클래스)가 구현한 메소드 호출
    print(f"현재 색상 값: {test07.get_color()}")  # 본인이 구현한 메소드 호출

    """
    [핵심 포인트]
    1. 인터페이스 간 상속: class A(B, C): ... (다중 상속 가능)
    2. 추상 클래스의 역할: 인터페이스의 모든 메소드를 구현하기 부담스러울 때,
                        일부만 미리 구현하여 자식 클래스의 부담을 덜어주는 "중간 다리" 역할.
    3. 파이썬 상수: Java/Kotlin의 final/const val과 달리 관례(대문자)로만 불변을 표현,
                  실무에서 진짜 불변이 필요하다면 @property로 getter만 노출하거나 __slots__ 활용
    """