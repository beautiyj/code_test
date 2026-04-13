# 큐(Queue) 인터페이스
# 순수하게 순서대로만 처리할 때는 deque, 우선순위가 중요한 스케줄링에선 heapq
# 가장 많이 쓰이는 멀티스레드 큐는 queue.Queue
# 큐는 FIFO(First Input First Output) 구조임.
# 먼저 입력된 자료가 먼저 출력되는 구조, append() 넣고 popleft() 뺀다

from collections import deque       # 파이썬 실무 표준 큐: deque (Java LinkedList/ArrayDeque 대응)

if __name__ == "__main__":

    my_que: deque = deque()         # 업캐스팅 개념 없음, deque 바로 사용

    my_que.append("1-자바")         # offer() 대응
    my_que.append("2-C++")
    my_que.append("3-API")
    my_que.append("4-MFC")

    # peek() 대응: my_que[0] (데이터 유지)
    # poll() 대응: popleft() (데이터 꺼내옴)
    while my_que:                   # 큐가 비어있지 않다면 (peek() != null 대응)
        print(my_que.popleft())     # 큐에서 데이터를 꺼내온다.