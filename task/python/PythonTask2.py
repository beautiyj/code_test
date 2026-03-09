"""
과제 2 키보드로 3개의 정수를 입력받았을 때 max min 구하기

제한사항: if else문 활용
"""

print("정수 3개를 입력하시오")
a = int(input())
b = int(input())
c = int(input())

if a > b and a > c:
    max_val = a
elif b > c:
    max_val = b
else:
    max_val = c

if a < b and a < c:
    min_val = a
elif b < c:
    min_val = b
else:
    min_val = c

print(max_val, min_val)