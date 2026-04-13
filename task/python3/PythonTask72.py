# 스택 클래스 - 기능 자체는 중요한데 무거워서 잘 안쓰고
# 요즘은 양방향 자료구조인 deque 위주로 사용함
# LIFO(Last Input First Output) 구조
# 마지막으로 입력된 자료가 가장 먼저 출력되는 구조

from collections import deque
from datetime import datetime

if __name__ == "__main__":

    # 예제1
    # 파이썬은 list가 Stack에 대응 (append=push, pop=pop)
    s: list = []
    print(len(s) == 0)      # empty() 대응

    # push() 대응: append()
    s.append("gemini")
    s.append(datetime.now())    # new Date() 대응
    s.append(10)
    s.append("johnharu")

    # Stack의 값을 출력
    print(len(s) == 0)      # empty() 대응
    print(s[-1])            # peek() 대응 - 마지막 요소 확인 (제거 없음)
    print(s.pop())          # pop() 대응
    print(s.pop())
    print(s.pop())
    print(s.pop())
    print(len(s) == 0)
    print()

    # 예제2
    my_stack: list = []
    my_stack.append("1-자바")
    my_stack.append("2-C++")
    my_stack.append("3-API")
    my_stack.append("4-MFC")

    # 스택이 비어있으면 IndexError 발생하므로 체크 필요
    while my_stack:             # 비어있지 않으면 (isEmpty() 대응)
        print(my_stack.pop())   # 값을 가져온다

    print()

    # 스택 자체는 잘 쓰지 않고 deque 사용 (더 빠름, Java ArrayDeque 대응)
    stack: deque[str] = deque()

    # 데이터 push
    stack.append("1-자바")      # push() / addLast() 대응
    stack.append("2-C++")
    stack.append("3-API")
    stack.append("4-MFC")

    # 유효성 검사 후 반복 처리
    while stack:
        # peek()으로 확인하고 pop()으로 꺼내는 습관이 실무적
        print(f"현재 상단 데이터: {stack[-1]}")     # peek() / last() 대응
        print(f"꺼낸 데이터: {stack.pop()}")        # pop() / removeLast() 대응