# task/python3/python_task79.py

# 예외처리 try-except-finally 구문
# finally 구문은 주로 파일을 닫을 때나 데이터베이스 연결 끊을 때 사용되는 구문.
# finally 안의 내용은 예외가 발생하든, 발생하지 않든 무조건 실행됨


class MultiExceptionHandling1:
    @staticmethod
    def execute():
        value = 20
        # div = 0
        div = 10

        int_array = [1, 2, 3]

        try:
            result = value // div
            print(result)

            # array_value = int_array[4]
            array_value = int_array[2]
            print(array_value)

        except ZeroDivisionError as ae:         # ArithmeticException 대응
            print(repr(ae))
        except IndexError as ai:                # ArrayIndexOutOfBoundsException 대응
            import traceback; traceback.print_exc()
        finally:
            print("예외가 발생했음!")             # 이건 예외든 아니든 무조건 실행됨


if __name__ == "__main__":
    MultiExceptionHandling1.execute()


    """
    | Java                                  | Kotlin                              | Python                              | 이유                                                              |
|---------------------------------------|-------------------------------------|-------------------------------------|-------------------------------------------------------------------|
| @Getter @Setter @Builder (Lombok)     | data class                          | @dataclass                          | 생성자+게터세터+toString 자동생성, 실무 DTO 표준                    |
| boardList.removeIf(람다)               | boardList.removeIf { 람다 }          | list comprehension으로 재구성        | 조건부 삭제 실무 패턴                                              |
| stream().filter().findFirst()         | list.find { 조건 }                  | next((x for x in list ...), None)   | 조건 만족 첫 요소 찾기 실무 패턴                                   |
| switch(menu) { case "1" -> ... }      | when (menu) { "1" -> ... }          | if/elif                             | 코틀린 when = Java 최신 switch 대응                               |
| try(Scanner sc = ...) {}              | Scanner(...).use { sc -> }          | input() 자동 관리                   | 코틀린 use{} = Java try-with-resources 대응                       |
| catch (ArithmeticException ae)        | catch (ae: ArithmeticException)     | except ZeroDivisionError as ae      | 각 언어별 예외 클래스명 차이                                       |
| catch (ArrayIndexOutOfBoundsException)| catch (ai: ArrayIndexOutOfBoundsException) | except IndexError            | 각 언어별 배열 인덱스 예외명 차이                                  |
| e.printStackTrace()                   | e.printStackTrace()                 | traceback.print_exc()               | 에러종류 + 위치 + 이유 출력                                        |
| e.getMessage()                        | e.message                           | str(e)                              | 에러 이유만 출력                                                   |
| e.toString()                          | e.toString()                        | repr(e)                             | 에러종류 + 이유 출력                                               |
| finally {}                            | finally {}                          | finally:                            | 예외 발생 여부 무관하게 무조건 실행                                 |
| class GenericClass<T>                 | class GenericClass<T>               | class GenericClass(Generic[T])      | 제네릭 클래스 선언 방식 차이, 파이썬은 TypeVar 필요                 |
    
    """