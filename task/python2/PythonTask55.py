from abc import ABC, abstractmethod

# abc(Abstract Base Classes) 모듈을 사용하여 추상 클래스를 구현
# 자바처럼 인스턴스화를 강제로 막으려면 ABC를 상속받아야함

# [예제 1] 추상클래스의 기본 구조
class AbstractClass01(ABC):
    @abstractmethod
    def method01(self):
        pass

    def method02(self):
        print("Method02: 추상클래스에서 구현")

class SubClass01(AbstractClass01):
    def method01(self):
        print("Method01: 서브클래스에서 구현된 추상메소드")

# [예제 2] 추상클래스를 활용한 다형성
class ShapeClass(ABC):
    @abstractmethod
    def draw(self):
        pass

class Circ(ShapeClass):
    def draw(self): print("원을 그린다")

class Rect(ShapeClass):
    def draw(self): print("사각형을 그린다")

class Tria(ShapeClass):
    def draw(self): print("삼각형을 그린다")

# [예제 3 & 4 통합 계층 구조]
class Hello(ABC):
    @abstractmethod
    def say_hello(self, name):
        pass

class SubClass03(Hello):
    def say_hello(self, name): print(f"{name}씨 안녕하세요!")
    def say_good_bye(self, name): print(f"{name}씨 안녕히 가세요!")

class AbstractClass04(ABC):
    @abstractmethod
    def method01(self): pass
    def method02(self): print("Method02: 추상클래스에서 구현")

class MiddleClass04(AbstractClass04):
    def method01(self): print("Method01: 중간 클래스에서 구현된 추상메소드")
    def method03(self): print("Method03: 추상클래스에서 구현")

class SubClass04(MiddleClass04):
    pass

# 메인 실행부
def main():
    print("=== 예제 1 실행 ===")
    obj1 = SubClass01()
    obj1.method01()
    obj1.method02()

    print("\n=== 예제 2 실행 (다형성) ===")
    shapes = [Circ(), Rect(), Tria()]
    for s in shapes:
        s.draw()

    print("\n=== 예제 3 실행 ===")
    test = SubClass03()
    test.say_hello("홍길동")
    test.say_good_bye("홍길동")

    print("\n=== 예제 4 실행 ===")
    obj4 = SubClass04()
    obj4.method01()
    obj4.method02()
    obj4.method03()

if __name__ == "__main__":
    main()