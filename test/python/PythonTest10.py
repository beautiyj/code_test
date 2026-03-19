"""
양의 정수 n이 매개변수로 주어질 때,
n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고
n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는
solution 함수를 작성해 주세요.


    n	result
  -------------
    7	16
    10	220

예제 1번의 n은 7로 홀수입니다.
7 이하의 모든 양의 홀수는 1, 3, 5, 7이고
이들의 합인 1 + 3 + 5 + 7 = 16을 return 합니다.

예제 2번의 n은 10으로 짝수입니다.
10 이하의 모든 양의 짝수는 2, 4, 6, 8, 10이고
이들의 제곱의 합인 22 + 42 + 62 + 82 + 102 = 4 + 16 + 36 + 64 + 100 = 220을 return 합니다.

"""

def solution(n):
    answer = 0

    if n%2 == 1:
        for i in range(1,n+1):
            if i%2 == 1:
                answer += i
    else:
        for i in range(1,n+1):
            if i%2 == 0:
                answer += i**2

    return answer

# 간략버전1
def solution10(n):
    if n % 2 == 1:
        return sum(range(1, n + 1, 2))
    else:
        return sum(i**2 for i in range(2, n + 1, 2))

# 간략버전2
def sol(n):
    return sum(range(1, n + 1, 2))\
        if n % 2 == 1\
        else sum(i**2 for i in range(2, n + 1, 2))

print(solution(7))
print(solution(10))

print(solution10(2))
print(solution10(3))

print(sol(4))
print(sol(5))