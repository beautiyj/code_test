# 파이썬은 모든 데이터가 객체(Object)이므로 별도의 Wrapper 클래스 구분이 없음
# 모든 변수가 힙(Heap) 메모리에 생성되는 참조형이라고 생각하면 됨

# Wrapper 클래스는 따로 없지만 그냥 파이썬으로 다르게 풀어보는 예제.


class WrapperTest1:
    def wrapper_test1(self):
        import sys
        # int형 변수의 최대 최소 (파이썬3는 정수 크기 제한이 없으나 시스템 한계값 확인 가능)
        print(sys.maxsize)

        # String형을 int형으로 형변환
        n = int("20")
        print(n)        # 20
        print(n + 10)   # 30 산술연산 가능

        # 10진수 -> 2, 8, 16진수 변환
        print(bin(10))  # 0b1010
        print(oct(10))  # 0o12
        print(hex(10))  # 0xa
        print()

class WrapperTest3:
    def wrapper_test3(self):
        # 파이썬은 모든 것이 객체이므로 박싱/언박싱 과정이 코드상에 드러나지 않음
        obj1 = 10
        obj2 = int("200")

        value1 = obj1
        value2 = obj2

        print(value1)
        print(value2)
        print()

class WrapperTest6:
    def wrapper_test6(self):
        # 파이썬의 형변환 및 논리값 처리
        value1 = int("10")
        value2 = float("3.14")
        # 파이썬의 bool()은 비어있지 않으면 True를 반환하므로 주의!
        value3 = "true".lower() == "true"
        value4 = "TRUE".lower() == "true"
        value5 = "test".lower() == "true" # "true" 문자열과 직접 비교

        print(f"value1 = {value1}")
        print(f"value2 = {value2}")
        print(f"value3 = {value3}")
        print(f"value4 = {value4}")
        print(f"value5 = {value5}")
        print()

if __name__ == "__main__":
    w1 = WrapperTest1()
    w1.wrapper_test1()
    w3 = WrapperTest3()
    w3.wrapper_test3()
    w6 = WrapperTest6()
    w6.wrapper_test6()