# task/python3/python_task80.py

# 예외처리 throw - 예외 발생시키기. 강제로 예외를 발생시킴! raise 키워드 사용
# 예외처리 throws - 예외 떠넘기기. 파이썬은 throws 선언 없음.
#                  대신 독스트링(docstring)이나 타입 힌트로 발생 가능한 예외를 명시하는 게 관례
#                  에러를 처리할 적임자에게 책임을 넘기기에 가깝다

import sys


# 구성편집 -> 프로그램인수에 적어서 실행하면됨
# python python_task80.py 인수값
class ThrowsEx1:
    @staticmethod
    def execute(args: list[str]):
        t1 = ThrowsEx1()
        try:
            t1.set_data(args[0])
        except Exception:
            print("첫문자가 숫자가 아닙니다.")

    def set_data(self, n: str):
        # 파이썬은 throws 선언 없음. 독스트링으로 발생 가능 예외 명시가 관례
        """
        :raises ValueError: 첫 문자가 숫자가 아닐 경우 발생 (NumberFormatException 대응)
        """
        if len(n) >= 1:
            str_val = n[0:1]
            self.__print_data(str_val)

    def __print_data(self, n: str):
        """
        :raises ValueError: 숫자로 변환 불가 시 발생
        """
        # 파이썬은 throws 선언 없이 그냥 예외 발생 가능
        dan = int(n)            # ValueError 발생 가능 (NumberFormatException 대응)
        print(f"{dan}단")
        print("-----------")
        for i in range(1, 10):
            print(f"{dan}*{i}={dan * i}")


# 기본 예외처리 구문 (직접 해결)
class ThrowsException:
    @staticmethod
    def execute():
        te = ThrowsException()
        te.occur_exception()

    # 나눗셈을 구하는 메소드
    def occur_exception(self):
        # result = 3 // 0     # 이것만 있으면 예외처리 없어서 터짐

        try:
            result = 3 // 0
            print(f"result : {result}")
        except ZeroDivisionError as e:      # ArithmeticException 대응
            print(f"0으로 나눌 수 없습니다. 예외 메시지: {e}")


# ThrowsException 예제를 throws 처리하여 예외를 양도한 형태
class ThrowsExceptionHandling1:
    @staticmethod
    def execute_main():
        te = ThrowsExceptionHandling1()
        try:
            # 예외처리를 try구문에서 직접 하지 않겠다
            te.occur_exception()
        except ZeroDivisionError as ae:     # ArithmeticException 대응
            print(f"Exception이 발생 : {repr(ae)}")
            print("0으로 나눌 수 없습니다.")

    def occur_exception(self):
        """
        occur_exception()를 호출한 곳으로 예외처리를 양도하겠다는 의미
        :raises ZeroDivisionError: 0으로 나눌 때 발생 (ArithmeticException 대응)
        """
        # 파이썬은 throws 키워드 없음. 독스트링으로 발생 가능 예외 명시가 실무 관례
        result = 3 // 0                     # ZeroDivisionError 발생
        print(result)


if __name__ == "__main__":
    ThrowsEx1.execute(sys.argv[1:])
    # ThrowsException.execute()
    # ThrowsExceptionHandling1.execute_main()