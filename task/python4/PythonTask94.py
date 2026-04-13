# 입출력 스트림 - 객체 직렬화
# 파이썬은 pickle 모듈로 객체 직렬화 처리 (Java Serializable + ObjectOutputStream 대응)

import pickle
from dataclasses import dataclass
from datetime import datetime


# 객체 직렬화를 위한 클래스 (파이썬은 별도 Serializable 인터페이스 불필요)
@dataclass
class PersonInformation:
    name: str
    age: int
    address: str
    telephone: str

    def get_name(self): return self.name
    def get_age(self): return self.age
    def get_address(self): return self.address
    def get_telephone(self): return self.telephone


class ObjectStreamTest:
    def __init__(self):
        self.gemini = PersonInformation("gemini", 10, "seoul", "02-321-3234")
        self.johnharu = PersonInformation("johnharu", 20, "seoul", "02-473-4232")
        self.d = datetime.now()

    def write_object_file(self):
        try:
            # pickle.dump() = Java ObjectOutputStream.writeObject() 대응
            # "wb" = 바이너리 쓰기 모드
            with open("person.dat", "wb") as fos:
                pickle.dump(self.gemini, fos)
                pickle.dump(self.johnharu, fos)
                pickle.dump(self.d, fos)
        except Exception as e:
            print(str(e))

    def read_object_file(self):
        try:
            # pickle.load() = Java ObjectInputStream.readObject() 대응
            with open("person.dat", "rb") as fis:
                while True:
                    try:
                        o = pickle.load(fis)
                    except EOFError:
                        break               # 파일 끝 도달 시 루프 종료

                    if isinstance(o, PersonInformation):    # instanceof 대응
                        print(f"{o.get_name()} : ", end="")
                        print(f"{o.get_age()} : ", end="")
                        print(f"{o.get_address()} : ", end="")
                        print(o.get_telephone())
                    else:
                        print(str(o))
        except Exception:
            pass


if __name__ == "__main__":
    ost = ObjectStreamTest()
    ost.write_object_file()
    ost.read_object_file()

"""
💡 Python 실무 포인트
| Java 코드                                      | Python 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| implements Serializable                        | 불필요 (pickle이 자동 처리)              | 파이썬은 대부분의 객체가 기본 직렬화 가능                   |
| ObjectOutputStream.writeObject()              | pickle.dump(obj, file)                  | 파이썬 객체 직렬화 표준 모듈                                |
| ObjectInputStream.readObject()                | pickle.load(file)                       | 파이썬 객체 역직렬화                                        |
| catch (EOFException)                           | except EOFError                         | 파일 끝 도달 예외 처리                                      |
| if (o instanceof PersonInformation)            | if isinstance(o, PersonInformation)     | 파이썬 타입 체크                                            |
| Serializable 직접 사용                         | 실무: json / pickle                     | json은 언어 호환, pickle은 파이썬 전용 직렬화 표준          |
"""