import math
import random

# static 정적멤버사용 예제
# 파이썬은 @staticmethod 데코레이터 사용해서 정적 메소드 정의 가능.

class Calculator29:
    pi = 3.14159  # 클래스 변수 (정적 필드 역할)

    @staticmethod
    def plus(x, y):
        return x + y

    @staticmethod
    def minus(x, y):
        return x - y

if __name__ == "__main__":
    result1 = 10 * 1 * Calculator29.pi
    result2 = Calculator29.plus(10, 20)
    result3 = Calculator29.minus(10, 20)

    print(result1)
    print(result2)
    print(result3)

    # 파이썬 math 모듈 활용
    print(math.e)
    print(math.pi)
    print(abs(-10))
    print(math.ceil(3.14))
    print(round(10.5))
    print(math.floor(10.9))
    print(max(10, 20))
    print(min(10, 20))
    print(math.pow(2, 3))
    print(random.random())
    print(math.sqrt(4))