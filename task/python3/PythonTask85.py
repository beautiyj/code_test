# 스레드 상태 제어 - sleep()

import threading
import time


class ThreadSleep:
    def run(self):
        for i in range(1, 10):
            print(f"{threading.current_thread().name} : {i}")
            try:
                time.sleep(1)           # Thread.sleep(1000) 대응 (단위: 초)
            except Exception as ie:
                print(ie)


if __name__ == "__main__":
    ts = ThreadSleep()

    # 두 개의 Thread를 생성시켜 실행시킴
    first = threading.Thread(target=ts.run, name="first1")
    second = threading.Thread(target=ts.run, name="second1")
    first.start()
    second.start()

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                       |
|----------------------------------------|------------------------------------------|------------------------------------------------------------|
| Thread.sleep(1000)                     | time.sleep(1)                            | 파이썬은 초 단위, Java는 밀리초 단위                        |
| catch (InterruptedException ie)        | except Exception as ie                   | 파이썬은 InterruptedException 없음                         |
| Thread.sleep() 직접 사용               | 실무: asyncio.sleep() (비동기 내부)       | 비동기 코드에서는 asyncio.sleep() 사용                      |
"""