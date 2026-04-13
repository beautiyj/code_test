# task/python3/python_task90.py

# 입출력스트림 read() reader()
# 파이썬은 FileReader / FileInputStream 없음
# open() 내장함수로 파일 입출력 처리


# FileReader - 문자 단위 읽기 대응
class FileReaderTest:
    @staticmethod
    def execute():
        file = None
        try:
            # open() = Java new FileReader() 대응
            # 상대경로: 실행 스크립트 기준
            file = open("data.txt", "r", encoding="utf-8")
            input_value = file.read(1)          # 1글자씩 읽기 (Java file.read() 대응)
            while input_value != "":
                print(input_value, end="")
                input_value = file.read(1)
            file.close()
        except Exception as e:
            print(str(e))


# FileInputStream - 바이트 단위 읽기 대응
class FileInputStreamTest:
    @staticmethod
    def execute():
        file = None
        try:
            # "rb" = 바이너리 읽기 모드 (Java FileInputStream 대응)
            file = open("read.txt", "rb")
            input_value = file.read(1)          # 1바이트씩 읽기
            while input_value != b"":
                print(input_value.decode("utf-8", errors="replace"), end="")
                input_value = file.read(1)
        except Exception as e:
            print(str(e))
        finally:
            try:
                if file:
                    file.close()                # finally에서 명시적 close
            except Exception as io:
                print(str(io))


# 실제로 자주 쓰는 방식: with open() + 한 줄씩 읽기
class FileReaderTest90:
    @staticmethod
    def execute():
        # with open() = Java try-with-resources + BufferedReader 대응 (자동 close)
        try:
            with open("data.txt", "r", encoding="utf-8") as br:
                for line in br:                 # 한 줄씩 읽기 (br.readLine() 대응)
                    print(line, end="")
        except IOError as e:
            print(f"파일 읽기 오류: {e}")


if __name__ == "__main__":
    execute = FileReaderTest()
    #   execute.execute()

    execute2 = FileInputStreamTest()
    #   execute2.execute()

    execute3 = FileReaderTest90()
    execute3.execute()

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| new FileReader("data.txt")             | open("data.txt", "r", encoding="utf-8") | 파이썬 파일 열기 내장함수, 인코딩 명시 권장                      |
| new FileInputStream("read.txt")        | open("read.txt", "rb")                  | 바이너리 읽기 모드                                               |
| try(BufferedReader br = ...) {}        | with open(...) as br:                   | 파이썬 컨텍스트 매니저, 자동 close                               |
| br.readLine()                          | for line in br:                          | 파이썬 파일 객체 이터레이션으로 한 줄씩 읽기                     |
| file.close() (finally)                 | with open() 자동 처리                    | with 블록 종료 시 자동 close, finally 불필요                     |
| (char) inputValue                      | input_value.decode("utf-8")             | 바이트 → 문자열 디코딩                                           |
"""