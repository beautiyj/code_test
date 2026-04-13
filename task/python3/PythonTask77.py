# 예외처리
# try-except 구문 (Java try-catch 대응)

import traceback   # printStackTrace() 대응


# 1. 산술 예외 처리 (특정 예외 지정)
class DivideZeroExceptionHandling1:
    @staticmethod
    def execute():
        b, a, c = 20, 0, 0

        try:
            c = b // a              # 예외 발생. ZeroDivisionError
        except ZeroDivisionError as ae:     # ArithmeticException 대응
            print("ZeroDivisionError - 0으로 나눌 수 없습니다.")
            print(f"Log: {ae}")
            a = 2
            c = b // a
        print(f"결과 1: {c}")


# 2. 모든 예외 처리 (부모 클래스 Exception 사용)
class DivideZeroExceptionHandling2:
    @staticmethod
    def execute():
        b, a, c = 20, 0, 0
        try:
            c = b // a
        except Exception as e:
            print("Exception - 0으로 나눌 수 없습니다.")
            print(f"Log: {e}")      # division by zero 메시지 출력됨
            a = 2
            c = b // a
        print(f"결과 2: {c}")


# 3. 예외 정보 상세 출력 (printStackTrace 등)
class DivideZeroExceptionHandling3:
    @staticmethod
    def execute():
        b, a, c = 20, 0, 0
        try:
            c = b // a
        except Exception as e:
            traceback.print_exc()           # printStackTrace() 대응 - 에러종류 + 위치 + 이유
            print(f"getMessage() 메시지: {e}")          # getMessage() 대응 - 이유만
            print(f"toString 메시지: {repr(e)}")        # toString() 대응 - 에러종류 + 이유
            print("traceback.print_exc() 메시지: ")
            """
            traceback.print_exc()는 에러종류 + 위치 + 이유
            repr(e)는 에러종류 + 이유
            str(e)는 에러 이유만 출력해준다.
            """


if __name__ == "__main__":
    # DivideZeroExceptionHandling1.execute()
    # DivideZeroExceptionHandling2.execute()
    DivideZeroExceptionHandling3.execute()