"""
5. 키보드를 이용해서 정수 5개를 입력 받은 후 int형 배열에 저장한다.
배열에 저장된 값 중 최댓값, 최솟값을 구하는 프로그램

"""

import array

import numpy as np

numbers = []
print("정수 5개를 하나씩 입력하시오")
for _ in range(5):        # for _ in range(n)는 반복만 하고 변수사용x 의미
    num = int(input())
    numbers.append(num)   # 리스트 메소드 .append 사용

max_value = max(numbers)
min_value = min(numbers)

print(numbers)      # [1, 2, 3, 4, 5]로 출력
print(max_value)
print(min_value)

# Numpy 활용 시 간단하게 가능!
numbers2 = np.array(numbers, dtype=int)
print(numbers2)     # [1 2 3 4 5]로 출력

# array 모듈을 활용한 정수 배열이라는 제한이 있을 경우
numbers3 = array.array('i', numbers)
print(numbers3)     # array('i', [1, 2, 3, 4, 5])로 출력