"""
과제9

1~45사이의 숫자를 6개 추출하는 프로그램 만들기
(단, 중복된 숫자는 1번만 출력되도록 한다)

조건
Math.random() 함수를 이용
0.0 <= Math.random() < 1.0

"""

import random

# --- [방식 1] 원리 위주 (while문 사용) ---
print("=== 1. 파이썬: while & append 방식 ===")
numbers = []
while len(numbers) < 6:
    # random.randint(1, 45)는 1과 45를 모두 포함하는 정수를 줌
    num = random.randint(1, 45)

    if num not in numbers:
        numbers.append(num)

numbers.sort() # 정렬
print(numbers)


# --- [방식 2] 파이썬 치트키 (추천) ---
print("\n=== 2. 파이썬: random.sample 방식 ===")
# random.sample(범위, 개수)는 '비복원 추출'이라 중복 체크를 알아서 해줌
lotto_easy = random.sample(range(1, 46), 6)
lotto_easy.sort()
print(lotto_easy)
