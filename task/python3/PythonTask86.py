# 스레드 동기화: Lock 동기화

import threading


class Toilet:
    def __init__(self):
        self.__lock = threading.Lock()  # synchronized 대응 - 실무 표준

    def open_door(self, name: str, b: bool):
        # with lock = Java synchronized 블록 대응. 블록 종료 시 자동 해제
        with self.__lock:
            if not b:
                print(name)
                self.using_time()
                print("아~~~~! 시원해")
            else:
                print("사용중")

    def using_time(self):
        for i in range(100000000):
            if i == 10000:
                print("끄으응")


class Family(threading.Thread):
    def __init__(self, who: str, toilet: Toilet):
        super().__init__()
        self.who = who
        self.toilet = toilet
        self.key = False

    def run(self):
        self.toilet.open_door(self.who, self.key)


if __name__ == "__main__":
    t = Toilet()

    father = Family("아버지", t)
    mother = Family("어머니", t)
    sister = Family("누나", t)
    brother = Family("형", t)
    me = Family("나", t)

    father.start()
    mother.start()
    sister.start()
    brother.start()
    me.start()

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| public synchronized void method()      | with threading.Lock():                   | 파이썬 동기화 블록 방식, with문으로 자동 해제                    |
| synchronized(this) { }                 | with self.__lock:                        | 인스턴스 락 동기화                                               |
| synchronized 직접 사용                 | 실무: asyncio.Lock() (비동기 내부)        | 비동기 환경에서는 asyncio.Lock() 사용                            |
"""