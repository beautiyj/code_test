# Wrapper 클래스 응용 1 & 2 (파이썬은 원래 모든 타입을 수용하므로 구분이 없음)

# Wrapper 클래스는 따로 없지만 그냥 파이썬으로 다르게 풀어보는 예제.

class TestClass:
    """정수 전용으로 설계하려고 노력한 클래스"""
    def __init__(self):
        self.__member = 0
    def get_value(self): return self.__member
    def set_value(self, value):
        if isinstance(value, int): # 정수 체크 (자바의 제약을 흉내냄)
            self.__member = value
        else:
            print(f"에러발생: {type(value)}는 정수가 아닙니다.")

class TestClass2:
    """모든 타입을 다 받는 클래스 (자바의 Object 활용 예제와 비슷)"""
    def __init__(self):
        self.__member = None
    def get_value(self): return self.__member
    def set_value(self, value): self.__member = value

class JavaTask41:
    def run_generic_test01(self):
        obj01 = TestClass()
        obj01.set_value(3)
        print(f"되돌리는 값은->{obj01.get_value()}")

        # 파이썬은 실행 중에 타입을 체크해야 에러를 낼 수 있음
        obj01.set_value(3.4)
        print("GenericTest01 실행 완료 (제약 시뮬레이션)")

    def run_generic_test02(self):
        obj01 = TestClass2()

        # 파이썬은 모든 것이 객체이므로 박싱 과정이 눈에 보이지 않음
        obj01.set_value(3)
        print(f"되돌리는 값은->{obj01.get_value()}")

        # 다운 캐스팅 과정 없이 바로 사용 가능
        n = int(obj01.get_value())

        obj01.set_value(3.4)
        print(f"되돌리는 값은->{obj01.get_value()}")

        # 문자열 저장
        obj01.set_value("이해할 수 있다.")
        print(f"되돌리는 값은->{obj01.get_value()}")
        print("GenericTest02 실행 완료 (범용)")

if __name__ == "__main__":
    task = JavaTask41()
    print("--- Test 01 시작 ---")
    task.run_generic_test01()
    print("\n--- Test 02 시작 ---")
    task.run_generic_test02()