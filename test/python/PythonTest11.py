"""
배타적 논리합 ^ XOR 연산자
: 두 값이 같으면 0 (false), 다르면 1 (true)로 계산하는 연산자
둘 다 tt면 f, ff면 t 뭔가... 애매한 or+not 같다

- true ^ true = false
- true ^ false = true
- false ^ true = true
- false ^ false = false

배타적 논리합 ^ 주요 활용처 예제

"""

# 1. 짝 없는 숫자 찾기
print("1. 짝 없는 숫자 찾기")
arr = [2, 3, 2, 4, 3]
result = 0

for num in arr:
    result ^= num
print(f"혼자 남은 짝 없는 숫자: {result}\n")

# 2. temp처럼 임시 변수 쓰지 않고도 두 변수의 값을 바꾸는 swap 예제
print("2. 임시 변수 없이 값 바꾸기(Swap)")
a = 10
b = 20
print(f"바꾸기 전 -> a: {a}, b: {b}")
a = a ^ b
b = a ^ b
a = a ^ b
print(f"바꾼 후   -> a: {a}, b: {b}\n")

# 3. 암호화 및 복호화
print("3. 암호화 및 복호화")
originalData = 12345
secretKey = 999

encrypted = originalData ^ secretKey
print(f"원본 데이터: {originalData}")
print(f"암호화된 데이터 (알 수 없는 값): {encrypted}")

decrypted = encrypted ^ secretKey
print(f"복호화된 데이터 (원상복구): {decrypted}")