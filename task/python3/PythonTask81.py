# throw, throws 예외처리 예제
# raise 키워드로 예외 발생시킬 시점 조절 가능.

import importlib


class ThrowException:
    @staticmethod
    def execute(args: list[str]):
        te = ThrowException()
        try:
            te.exception_method()
        except IndexError as ab:        # ArrayIndexOutOfBoundsException 대응
            print("배열의 index를 초과했습니다.")
            import traceback; traceback.print_exc()

    def exception_method(self):
        """
        :raises IndexError: i == 2 일 때 강제 발생
        """
        int_a = [1, 2, 3, 4]
        for i in range(10):
            # 예외를 던짐 - 예외가 발생할 시점을 조절할 수 있음
            #           if i == 4: raise IndexError()
            if i == 2: raise IndexError()
            print(int_a[i])


class CatchOrderEx:
    @staticmethod
    def execute(args: list[str]):
        try:
            data1 = args[0]
            data2 = args[1]
            value1 = int(data1)
            value2 = int(data2)
            result = value1 + value2
            print(f"{data1}+{data2}={result}")
        except IndexError:              # ArrayIndexOutOfBoundsException 대응
            print("실행 매개값의 수가 부족합니다.")
        except Exception:
            print("실행에 문제가 있습니다.")
        finally:
            print("다시 실행하세요.")


class ThrowsEx:
    @staticmethod
    def execute():
        try:
            ThrowsEx.find_class()       # 메소드 호출
        except ImportError:             # ClassNotFoundException 대응
            print("클래스가 존재하지 않습니다.")

    @staticmethod
    def find_class():
        """
        :raises ImportError: 존재하지 않는 모듈 로딩 시 발생 (ClassNotFoundException 대응)
        """
        # 파이썬 동적 클래스 로딩 - Class.forName() 대응
        importlib.import_module("java.lang.String81")   # 존재하지 않는 모듈
#       importlib.import_module("os")                   # 에러 없이 완료됨


if __name__ == "__main__":
    #   ThrowException.execute(sys.argv[1:])
    #   CatchOrderEx.execute(sys.argv[1:])
    ThrowsEx.execute()

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                       |
|----------------------------------------|------------------------------------------|------------------------------------------------------------|
| throws XxxException                    | 선언 불필요 / 독스트링 :raises 명시       | 파이썬은 throws 없음, 독스트링 관례                         |
| throw new XxxException()               | raise XxxException()                     | 파이썬 예외 발생 키워드                                    |
| Class.forName("java.lang.String81")    | importlib.import_module()                | 파이썬 동적 클래스 로딩 대응                               |
| finally { }                            | finally:                                 | 예외 여부 무관 무조건 실행                                  |
"""