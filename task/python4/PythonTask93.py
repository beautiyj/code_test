# File 클래스 - 파일/디렉토리 관리
# 파이썬은 os, pathlib 모듈로 파일/디렉토리 관리

import os
from pathlib import Path    # 실무 표준: pathlib.Path = Java File 클래스 대응


class FileTest:
    @staticmethod
    def execute():
        try:
            # Path() = Java new File() 대응
            temp = Path("C:/java01/temp")
            temp_file = Path("test90")

            # 디렉토리 생성 (parents=True = Java mkdirs() 대응, exist_ok=True = 이미 있어도 오류 없음)
            temp.mkdir(parents=True, exist_ok=True)
            print(f"create directory state : {temp.exists()}")
            temp_file.mkdir(parents=True, exist_ok=True)
            print(f"create directory state : {temp_file.exists()}")

            # 디렉토리 삭제 - rmdir()는 비어있을 때만 가능 (Java delete() 대응)
            # temp_file.rmdir()
            # print(f"delete directory state : {not temp.exists()}")

            # 비어있지 않은 디렉토리 안의 내용을 삭제하려면 리스트화 -> 삭제
            if temp.exists():
                for f in temp.iterdir():    # listFiles() 대응
                    print(f.unlink())       # delete() 대응 (파일 삭제)

            # Path 클래스 정보 메소드
            print(f"temp canRead : {os.access(temp, os.R_OK)}")         # canRead() 대응
            print(f"temp canWrite : {os.access(temp, os.W_OK)}")        # canWrite() 대응
            print(f"temp absoluteFile : {temp.resolve()}")              # getAbsoluteFile() 대응
            print(f"temp name : {temp.name}")                           # getName() 대응
            print(f"temp parent : {temp.parent}")                       # getParent() 대응
            print(f"temp path : {temp}")                                # getPath() 대응
            print(f"temp isDirectory : {temp.is_dir()}")                # isDirectory() 대응
            print(f"temp isFile : {temp.is_file()}")                    # isFile() 대응

        except Exception:
            pass


if __name__ == "__main__":
    FileTest.execute()

"""
💡 Python 실무 포인트
| Java 코드                                      | Python 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| new File("C:/java01", "temp")                  | Path("C:/java01/temp")                  | 파이썬 실무 표준 파일 경로 관리                             |
| temp.mkdirs()                                  | temp.mkdir(parents=True, exist_ok=True) | 부모 디렉토리 포함 생성                                     |
| temp.delete()                                  | temp.rmdir() / f.unlink()               | 디렉토리 삭제 / 파일 삭제                                   |
| temp.listFiles()                               | temp.iterdir()                          | 디렉토리 내 파일 목록 이터레이터 반환                       |
| temp.getAbsoluteFile()                         | temp.resolve()                          | 절대경로 반환                                               |
| temp.canRead() / canWrite()                    | os.access(temp, os.R_OK/W_OK)           | 읽기/쓰기 권한 확인                                         |
"""