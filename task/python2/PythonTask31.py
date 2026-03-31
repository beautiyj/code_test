# 모듈 자체가 싱글톤처럼 동작하거나, __new__를 오버라이딩하여 구현함.
# 파이썬에서는 클래스 기반 싱글톤보다는 모듈 단위 변수를 활용하는 편임.

class Singleton:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance

    def check1(self):
        print("메소드 호출 성공1")

    def check2(self):
        print("메소드 호출 성공2")

# 사용 예시
obj1 = Singleton()
obj2 = Singleton()

print(obj1 is obj2) # True (같은 객체)
obj1.check1()