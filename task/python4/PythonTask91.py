# 입출력스트림 writer() OutputStream()
# 파이썬은 FileOutputStream / FileWriter 없음
# open() 내장함수로 파일 입출력 처리


class FileOutputStreamTest:
    @staticmethod
    def execute():
        try:
            fis = open("read.txt", "rb")            # FileInputStream 대응
            fos = open("read1.txt", "wb")           # FileOutputStream 대응

            input_byte = fis.read(1)
            while input_byte != b"":
                print(input_byte.decode("utf-8", errors="replace"), end="")  # 화면 출력
                fos.write(input_byte)               # 다른 파일에 쓰기
                input_byte = fis.read(1)

            fos.close()
            fis.close()
        except Exception as e:
            print(e)


class FileWriterTest:
    @staticmethod
    def main(args: list[str]):
        try:
            fr = open(args[0], "r", encoding="utf-8")   # FileReader 대응
            fw = open(args[1], "w", encoding="utf-8")   # FileWriter 대응

            input_char = fr.read(1)
            while input_char != "":
                print(input_char, end="")               # 화면 출력
                fw.write(input_char)                    # 다른 파일에 쓰기
                input_char = fr.read(1)

            fr.close()
            fw.close()
        except IOError as io:
            print(io)


# BufferedReader, BufferedWriter - 실제로 자주 쓰이는 버퍼 활용 버전
class FileWriterTest91:
    @staticmethod
    def execute(source: str, target: str):
        # with open() = Java try-with-resources + BufferedReader/Writer 대응 (자동 close)
        try:
            with open(source, "r", encoding="utf-8") as br, \
                    open(target, "w", encoding="utf-8") as bw:
                for line in br:                         # 한 줄씩 읽기 (readLine() 대응)
                    print(line, end="")                 # 콘솔 출력
                    bw.write(line)                      # 파일 쓰기 (newLine() 자동 포함)
            print("복사 완료!")
        except IOError as e:
            import traceback; traceback.print_exc()


if __name__ == "__main__":
    # FileOutputStreamTest.execute()
    FileWriterTest.main(["read.txt", "read2.txt"])
#   FileWriterTest91.execute("read.txt", "read2.txt")

"""
💡 Python 실무 포인트
| Java 코드                                      | Python 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| new FileOutputStream("read1.txt")              | open("read1.txt", "wb")                 | 바이너리 쓰기 모드                                          |
| new FileWriter("read2.txt")                    | open("read2.txt", "w", encoding="utf-8") | 텍스트 쓰기 모드, 인코딩 명시 권장                         |
| try(BufferedReader br = ...) {}                | with open(...) as br:                   | 파이썬 컨텍스트 매니저, 자동 close                          |
| bw.newLine()                                   | 불필요 (for line in br가 줄바꿈 포함)    | 파이썬 이터레이션은 줄바꿈 포함해서 읽음                    |
| FileReader / FileWriter 직접 사용              | 실무: with open() as f: f.read/write()  | 파이썬 실무 표준 파일 입출력 패턴                           |
"""