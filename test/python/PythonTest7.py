"""
연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다.

예를 들면 다음과 같습니다.
12 ⊕ 3 = 123
3 ⊕ 12 = 312

양의 정수 a와 b가 주어졌을 때,
a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.

"""


def solution(a, b):

    ab = str(a) + str(b)
    mult = 2 * a * b

    if int(ab) >= mult:
        return int(ab)
    else:
        return mult

# 간략버전
def test7(a, b):
    ab = int(f"{a}{b}")
    mult = 2 * a * b

    return max(ab, mult)

print(solution(12, 3))
print(solution(1, 5))
print(test7(10, 2))
print(test7(1, 7))