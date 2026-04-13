# 입출력메소드 BufferedReader 대응
# 파이썬은 input()이 Java BufferedReader.readLine()에 대응
# 과제: 키보드로 숫자 입력 받아서 해당 구구단 출력


class BufferedReaderTest:
    @staticmethod
    def execute():
        print("Input Data : ", end="")
        try:
            # input() = Java BufferedReader.readLine() 대응
            input_string = input()
            print()
            print(f"Output String = {input_string}")
        except Exception as io:
            print(io)


# 키보드로 숫자 입력 받아서 해당 구구단 출력하는 프로그램
class BufferedReaderEx:
    @staticmethod
    def execute():
        try:
            input_string = input("Input data 숫자: ")
            dan = int(input_string)
            print(f"{dan}단 출력")
            for i in range(1, 10):
                print(f"{dan} x {i + 1} = {dan * (i + 1)}")
        except Exception as e:
            print(e)


if __name__ == "__main__":
    #   BufferedReaderTest.execute()
    BufferedReaderEx.execute()

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                       |
|----------------------------------------|------------------------------------------|------------------------------------------------------------|
| BufferedReader.readLine()              | input()                                  | 파이썬 표준 한 줄 입력 함수                                 |
| Integer.parseInt(str)                  | int(str)                                 | 파이썬 정수 변환                                            |
| System.out.printf("%d x %d = %d\n")   | f"{dan} x {i} = {dan * i}"              | 파이썬 f-string 포맷팅                                      |
| new BufferedReader(new InputStreamReader(System.in)) | input()              | 파이썬은 input() 하나로 동일한 기능                         |
"""