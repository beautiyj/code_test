"""
과제 1 키보드로 3개의 정수를 입력받았을 때 max min 구하기

제한사항: 조건연산자 활용
"""

a = int(input("정수를 입력하시오."))
b = int(input("정수를 입력하시오."))
c = int(input("정수를 입력하시오."))

max_val = a if (a > b and a > c) else (b if (b > c) else c)
min_val = a if (a < b and a < c) else (b if (b < c) else c)
print(max_val, min_val)

# 조건연산자 없이 파이썬에서는 간략하게 구할 수 있다
max_f = max(a, b, c)
min_f = min(a, b, c)
print(max_f, min_f)