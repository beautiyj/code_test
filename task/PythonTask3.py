import math

"""
3. 키보드를 이용해서 입력한 정수의 팩토리얼 구하기

예시: 3! = 3 * 2 * 1
"""

print("양의 정수를 입력하시오")
a = int(input())
result = 1

for i in range(1, a+1):
    result *= i

print("%d! = %d"%(a,result))
# print(f"{n}! = {result}") 형태로도 가능하다


# 함수 사용 시
n = int(input("양의 정수를 입력하시오: "))
print(f"{n}! = {math.factorial(n)}")