# 스레드 생명주기

import threading


class ThreadLife:
    def run(self):
        for i in range(1, 21):
            # thread의 이름과 정수 출력
            print(f"{threading.current_thread().name} number = {i}")


if __name__ == "__main__":
    tl = ThreadLife()

    # 스레드 객체 생성 (target=실행함수, name=스레드이름)
    t1 = threading.Thread(target=tl.run, name="First-Thread")
    t2 = threading.Thread(target=tl.run, name="Second-Thread")
    t3 = threading.Thread(target=tl.run, name="Third-Thread")

    t1.start()
    t2.start()
    t3.start()
    print("=== 메인 스레드 종료 ===")

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                       |
|----------------------------------------|------------------------------------------|------------------------------------------------------------|
| Thread.currentThread().getName()       | threading.current_thread().name          | 파이썬 현재 스레드 이름 접근                                |
| new Thread(runnable, "이름")           | threading.Thread(target=func, name="이름") | 파이썬 스레드 생성 방식                                   |
"""