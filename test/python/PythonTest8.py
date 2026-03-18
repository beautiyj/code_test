"""
정수 num과 n이 매개 변수로 주어질 때,
num이 n의 배수이면 1을
return n의 배수가 아니라면 0을
return 하도록 solution 함수를 완성해주세요.

변수
입력값: 정수num, 정수 n
출력값: 1혹은0
행위: 조건문, 함수리턴

"""

def solution(num, n):
    if num % n == 0:
        return 1
    else:
        return 0

print(solution(4,3))
print(solution(6,3))
