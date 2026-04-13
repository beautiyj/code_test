# 스레드
# 1. threading.Thread 클래스를 상속 받아서 만드는 방법
# 2. Runnable 인터페이스 구현 방식 -> Thread(target=함수)로 대응

import threading


class ThreadEnd(threading.Thread):  # Thread 상속 방식
    def run(self):
        # thread가 시작되면 실행되는 문장
        for i in range(1, 21):
            print(f"run number = {i}")


class RunnableTest:                 # Runnable 구현 방식 -> target 함수로 전달
    def print_number(self):
        for i in range(1, 21):
            print(f"number = {i}")

    def run(self):
        self.print_number()


# 멀티스레드로 진행할 때와 싱글스레드 2개 따로 실행할 때랑 차이가 있음
if __name__ == "__main__":
    print("=== 전체 테스트 시작 - 싱글스레드 2개 넣어서 해당 로직은 멀티스레드임 ===")

    # 1번 예제 실행 (Thread 상속 방식)
    tt = ThreadEnd()
    tt.start()

    # 2번 예제 실행 (Runnable 구현 방식)
    rt = RunnableTest()
    t2 = threading.Thread(target=rt.run)    # Thread(target=) = new Thread(runnable) 대응
    t2.start()

    print("=== 메인 스레드 작업 완료 (서브 스레드들은 계속 도는 중) ===")

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| class X extends Thread                 | class X(threading.Thread)                | 파이썬 Thread 상속 방식                                          |
| class X implements Runnable            | threading.Thread(target=함수)            | 파이썬은 Runnable 없음, target 파라미터로 대응                   |
| thread.start()                         | thread.start()                           | 동일                                                             |
| Thread / Runnable 직접 사용            | 실무: concurrent.futures.ThreadPoolExecutor 권장 | 파이썬 실무 스레드 풀 관리 표준                          |
"""