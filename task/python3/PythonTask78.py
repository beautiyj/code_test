# 예외처리 try-except-except 구문 (멀티처리)
# 예외가 발생하지 않으면 try 구문의 블록만 실행된다.
# try 실행에 따라 except 실행도 달라짐 (except 구문 동시실행되는 경우는 없음!)

import sys


class MultiExceptionHandling:
    @staticmethod
    def execute():
        value = 20
        div = 0
        int_array = [1, 2, 3]

        try:
            # arrayValue = int_array[4]   # 이거 실행하면 IndexError 실행됨

            result = value // div           # 예외 발생 (ZeroDivisionError)
            print(result)

            array_value = int_array[4]      # 위에서 예외 발생하면 이건 실행 X
            print(array_value)

        except ZeroDivisionError as ae:     # ArithmeticException 대응
            print("result 계산 중 예외 발생")
            print(repr(ae))
        except IndexError as ai:            # ArrayIndexOutOfBoundsException 대응
            print("array_value 인덱스 예외 발생")
            import traceback; traceback.print_exc()


class ExceptionEx3:
    @staticmethod
    def execute(args: list[str]):
        v = 50
        try:
            # data = int(args[0])         # IndexError 실행됨
            # data = int("abc")           # ValueError (NumberFormatException 대응) 실행됨
            data = int("0")              # ZeroDivisionError (ArithmeticException 대응) 실행됨

            print(v // data)

            # Exception이 하위 예외 클래스들을 모두 포함하므로 먼저 정의해서는 안된다.
        except ValueError:              # NumberFormatException 대응
            print("숫자가 아닙니다.")
        except ZeroDivisionError:       # ArithmeticException 대응
            print("0으로 나눌순 없죠?")
        except Exception:               # Exception 대응 (최상위, 반드시 마지막에)
            print("Exception !!")
            print("프로그램 종료!")


if __name__ == "__main__":
    # MultiExceptionHandling.execute()
    ExceptionEx3.execute(sys.argv[1:])