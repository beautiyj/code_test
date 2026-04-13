# 기본 타입 입출력 스트림 DataInputStream, DataOutputStream 대응
# 파이썬은 struct 모듈로 기본 타입을 바이너리로 입출력 처리

import struct


class DataIOTest:
    @staticmethod
    def main(args: list[str]):
        try:
            # DataOutputStream 대응 - struct.pack()으로 각 타입을 바이너리로 직렬화
            with open("iodata.bin", "wb") as fos:
                fos.write(struct.pack("?", True))           # writeBoolean 대응
                fos.write(struct.pack(">H", ord('j')))      # writeChar 대응 (2바이트)
                fos.write(struct.pack(">i", 1234))          # writeInt 대응
                fos.write(struct.pack(">f", 3.14))          # writeFloat 대응
                fos.write(struct.pack(">d", 123.5423))      # writeDouble 대응
                # writeUTF 대응 - 길이(2바이트) + UTF-8 문자열
                utf_bytes = "gemini".encode("utf-8")
                fos.write(struct.pack(">H", len(utf_bytes)))
                fos.write(utf_bytes)

            # DataInputStream 대응 - struct.unpack()으로 각 타입 읽기
            with open("iodata.bin", "rb") as fis:
                print(struct.unpack("?", fis.read(1))[0])          # readBoolean
                print(chr(struct.unpack(">H", fis.read(2))[0]))    # readChar
                print(struct.unpack(">i", fis.read(4))[0])         # readInt
                print(struct.unpack(">f", fis.read(4))[0])         # readFloat
                print(struct.unpack(">d", fis.read(8))[0])         # readDouble
                utf_len = struct.unpack(">H", fis.read(2))[0]
                print(fis.read(utf_len).decode("utf-8"))            # readUTF

        except IOError as io:
            print(str(io))


if __name__ == "__main__":
    DataIOTest.main([])

"""
💡 Python 실무 포인트
| Java 코드                                      | Python 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| DataOutputStream.writeInt() 등                | struct.pack(">i", value)                | 파이썬 바이너리 직렬화 표준 모듈                            |
| DataInputStream.readInt() 등                  | struct.unpack(">i", fis.read(4))[0]     | 파이썬 바이너리 역직렬화                                    |
| DataInputStream / DataOutputStream            | 실무: pickle / json 모듈                 | 파이썬 실무 데이터 직렬화 표준은 pickle(바이너리) / json    |
"""