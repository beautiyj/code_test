# 과제 - 키보드로 입력한 문장을 파일 result.txt에 저장하는 프로그램


class FileTest95:
    def execute(self):
        file = None
        print("JavaTask95 - 키보드로 문장 입력하기 (result.txt 파일 생성 및 저장됨)")

        try:
            # input() = Java BufferedReader.readLine() 대응
            input_string = input()
            # open("w") = Java new FileWriter() 대응
            file = open("result.txt", "w", encoding="utf-8")
            file.write(input_string)
            print(f"입력한 문장: {input_string}")
        except Exception as e:
            print(e)
        finally:
            try:
                if file:
                    file.close()            # finally에서 명시적 close
            except IOError as io:
                import traceback; traceback.print_exc()


class FileTest95T2:
    def execute(self):
        print("JavaTask95 22버전 - 키보드로 문장 입력하기 (result22.txt 파일 생성 및 저장됨)")

        # with open() 다중 = Java try-with-resources 세미콜론 다중 리소스 대응
        # 파이썬은 with 한 줄에 , 로 다중 리소스 처리 가능
        try:
            with open("result22.txt", "w", encoding="utf-8") as bw2:
                input_string = input()      # BufferedReader.readLine() 대응
                bw2.write(input_string)
                print(f"입력한 문장22: {input_string}")
        except IOError as io:
            print(io)


if __name__ == "__main__":
    obj = FileTest95()
    obj.execute()
    obj2 = FileTest95T2()
    obj2.execute()

"""
💡 Python 실무 포인트
| Java 코드                                      | Python 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| new BufferedReader(new InputStreamReader(System.in)) | input()                        | 파이썬은 input() 하나로 한 줄 입력 처리                     |
| new FileWriter("result.txt")                   | open("result.txt", "w", encoding="utf-8") | 텍스트 쓰기 모드, 인코딩 명시 권장                        |
| try(BufferedReader br; BufferedWriter bw) {}   | with open(...) as bw:                   | 파이썬은 with 한 줄에 , 로 다중 리소스 처리 가능            |
| if (file != null) file.close()                 | if file: file.close()                   | 파이썬 None 체크                                            |
| FileWriter 직접 사용                            | 실무: with open() as f: f.write()        | with 블록으로 자동 close 보장                               |
"""