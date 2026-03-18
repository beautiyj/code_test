"""
연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다.

예를 들면 다음과 같습니다.
12 ⊕ 3 = 123
3 ⊕ 12 = 312

양의 정수 a와 b가 주어졌을 때,
a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.


입력값: 양의정수 a, b
출력값: a ⊕ b와 b ⊕ a 중 더 큰 값
행위: 비교연산, 함수 리턴

"""

def test6(a,b):
    result = 0
    ab = str(a)+str(b)
    ba = str(b)+str(a)

    if int(ab) >= int(ba):
        result = int(ab)
    else:
        result = int(ba)
    return result

# 더 간략 버전
def t6(a, b):
    # f"{a}{b}"는 자바의 String.format("%d%d", a, b) 기능
    return max(int(f"{a}{b}"), int(f"{b}{a}"))

print(test6(12,3))
print(t6(15,18))