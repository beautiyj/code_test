# 입출력스트림 Input
# 파이썬은 InputStream / InputStreamReader 없음
# input() 함수가 Java BufferedReader.readLine()에 대응
# sys.stdin으로 저수준 입력 처리 가능

import sys


# InputStreamTest - 읽는 단위 1바이트 대응
class InputStreamTest:
    @staticmethod
    def execute():
        print("Input Data : ", end="")
        try:
            # sys.stdin.read(1) = Java InputStream.read() 1바이트 읽기 대응
            input_char = sys.stdin.read(1)
            input_value = ord(input_char)       # 아스키/유니코드 코드값 반환 (Java (int) 캐스팅 대응)
            print(f"InputData is {input_value}")
            print(f"InputData is {input_char}")
        except Exception as io:
            print(io)


# InputStreamReaderTest - 2바이트 읽기 대응
class InputStreamReaderTest:
    @staticmethod
    def execute():
        print("Input Value : ", end="")
        try:
            # sys.stdin.read(1) = Java InputStreamReader.read() 대응
            input_char = sys.stdin.read(1)
            input_value = ord(input_char)
            print(f"Input Result : {input_value}")
            print(f"Input Result : {input_char}")
        except Exception as io:
            print(io)


# InputStreamReaderTest2 - 배열 크기만큼 읽기 대응
class InputStreamReaderTest2:
    @staticmethod
    def execute():
        print("Input Value : ", end="")
        try:
            # sys.stdin.read(10) = Java isr.read(char[10]) 대응
            temp = sys.stdin.read(10)
            input_value = len(temp)
            print(f"InputValue : {input_value}")
            for i in range(input_value):
                print(temp[i], end="")
            print(f"char[] -> String : {temp}")
        except Exception:
            pass


if __name__ == "__main__":
    #   InputStreamTest.execute()
    #   InputStreamReaderTest.execute()
    InputStreamReaderTest2.execute()

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| System.in                              | sys.stdin                                | 파이썬 표준 입력 스트림                                          |
| InputStream.read()                     | sys.stdin.read(1)                        | 1바이트(문자) 읽기 대응                                          |
| (char) inputValue / (int) inputValue   | chr() / ord()                            | 파이썬 문자↔코드값 변환 함수                                     |
| InputStream / InputStreamReader        | 실무: input()                            | 파이썬 실무 표준 입력은 input() 함수 사용                        |
"""