# 스레드의 우선순위
# 파이썬 threading은 우선순위 직접 설정 기능 없음
# 실무: 우선순위 제어가 필요하면 queue.PriorityQueue 또는 concurrent.futures 활용

import threading


class ThreadPriority:
    def run(self):
        for i in range(1, 21):
            print(f"{threading.current_thread().name} number = {i}")


class ThreadPriorityControl:
    def run(self):
        for i in range(1, 11):
            print(f"{threading.current_thread().name} number = {i}")


if __name__ == "__main__":
    print("=== 1. ThreadPriority (기본 우선순위 확인) ===")
    tp = ThreadPriority()

    first1 = threading.Thread(target=tp.run, name="tp-first1")
    second1 = threading.Thread(target=tp.run, name="tp-second1")
    third1 = threading.Thread(target=tp.run, name="tp-third1")

    # 파이썬 threading은 우선순위 직접 조회/설정 불가 -> 없음을 명시
    print("tp-first priority = 설정 불가 (파이썬 threading 미지원)")
    print("tp-second priority = 설정 불가 (파이썬 threading 미지원)")
    print("tp-third priority = 설정 불가 (파이썬 threading 미지원)")

    print("\n========================================================================")
    print("\n=== 2. ThreadPriorityControl (우선순위 직접 제어) ===")

    tpc = ThreadPriorityControl()

    # 파이썬은 우선순위 설정 불가. 순서 제어가 필요하면 PriorityQueue 사용
    first2 = threading.Thread(target=tpc.run, name="first1")
    second2 = threading.Thread(target=tpc.run, name="second1")
    third2 = threading.Thread(target=tpc.run, name="third1")

    print("first priority = 설정 불가")
    print("second priority = 설정 불가")
    print("third priority = 설정 불가")

    print("\n=== 스레드 실행 시작 ===")
    first2.start()
    second2.start()
    third2.start()

"""
💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| thread.setPriority(Thread.MAX_PRIORITY)| 직접 설정 불가                           | 파이썬 threading 모듈은 우선순위 설정 미지원                     |
| Thread.MIN_PRIORITY / MAX_PRIORITY     | queue.PriorityQueue 활용                 | 우선순위 제어가 필요하면 PriorityQueue로 작업 순서 조정           |
| 우선순위로 스레드 제어                  | concurrent.futures.ThreadPoolExecutor    | 파이썬 실무 스레드 풀 관리 표준                                  |
"""