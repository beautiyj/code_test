# 과제 - 스레드를 이용해서 현재 시간을 1초에 1번씩 출력하는 프로그램 만들기
# 단, 연 월 일 시 분 초 형태로 출력하기

import threading
import time
from datetime import datetime


class ClockThread(threading.Thread):
    def run(self):
        while True:
            now = datetime.now()
            # strftime() = Java SimpleDateFormat.format() 대응
            print(now.strftime("%Y-%m-%d %H:%M:%S"))
            time.sleep(1)           # 1초 대기 (Thread.sleep(1000) 대응)


if __name__ == "__main__":
    t1 = ClockThread()
    t1.start()

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| new SimpleDateFormat("yyyy-MM-dd ...")  | datetime.strftime("%Y-%m-%d ...")       | 파이썬 날짜 포맷 함수                                            |
| new Date()                             | datetime.now()                           | 파이썬 현재 시각 반환                                            |
| sdf.format(now)                        | now.strftime(format)                     | 파이썬 날짜 포맷팅                                               |
| Thread.sleep(1000)                     | time.sleep(1)                            | 파이썬은 초 단위, Java는 밀리초 단위                             |
"""