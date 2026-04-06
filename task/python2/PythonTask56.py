from abc import ABC, abstractmethod

# 파이썬은 공식적인 interface 키워드가 없다
# 대신 abc 모듈의 ABC(Abstract Base Class)를 사용하여 인터페이스처럼 동작하게는 가능
# ++ 파이썬은 클래스 다중 상속이 가능. 인터페이스의 목적을 클래스 상속으로 자연스럽게 달성 가능함

# [예제 1] 인터페이스 역할을 하는 추상 클래스
class IHello(ABC):
    @abstractmethod
    def say_hello(self, name):
        pass

class IHello2(ABC):
    @abstractmethod
    def say_hello(self, name):
        pass

class IGoodBye(ABC):
    @abstractmethod
    def say_good_bye(self, name):
        pass

# [예제 2] 인터페이스 구현 (상속 활용)
class Hello56(IHello):
    def say_hello(self, name):
        print(f"{name}씨 안녕하세요!")

# 다중 상속을 통한 다중 인터페이스 구현
class SubClass(IHello2, IGoodBye):
    def say_hello(self, name):
        print(f"{name}씨 안녕하세요!")

    def say_good_bye(self, name):
        print(f"{name}씨 안녕히 가세요!")

# 메인 실행부 (PythonTask56 역할)
def main():
    print("=== InterfaceTest01 실행 ===")
    obj = Hello56()
    obj.say_hello("홍길동")

    print("\n=== InterfaceTest02 실행 ===")
    test = SubClass()
    test.say_hello("홍길동")
    test.say_good_bye("홍길동")

if __name__ == "__main__":
    main()