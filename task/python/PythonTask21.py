# 예제 1. 1~n 까지의 합을 구하는 누적합계 메소드 작성하기
def sum_func():
    n = int(input("정수 하나 입력"))
    result = 0
    for i in range (1,n+1):
        result += i
    return result

# 예제 2. 키보드로 입력한 2개의 정수 중 max min 구하기
def maxmin_func():
    a = int(input("첫 번째 정수를 입력하세요"))
    b = int(input("두 번째 정수를 입력하세요"))
    if a > b:
        max_val = a
        min_val = b
    else:
        max_val = b
        min_val = a
    return max_val, min_val

    # max_val = max(a, b)   내장함수로 처리하고 리턴 던져도 무방함
    # min_val = min(a, b)

# 예제 3. 값 비교, 주소 비교 메소드
def compare_string(s1, s2):
    if s1 is s2:
        print("결과: 같주소")
    else:
        print("결과: 다른주소")

    if s1 == s2:
        print("결과: 같값")
    else:
        print("결과: 다른값")

    n1, n2 = int(s1), int(s2)
    print(f"MAX: {max(n1, n2)}")
    print(f"MIN: {min(n1, n2)}")


if __name__ == "__main__":
    print("예제1")
    print(sum_func())

    print("예제2")
    max_val, min_val = maxmin_func()
    print(max_val, min_val)
    print(f"최대: {max_val}, 최소: {min_val}")

    print("예제3")
    # 파이썬은 리터럴을 자동으로 인터닝(String Pool)함
    str1 = "30"
    # 강제로 다른 주소를 만들기 위해 join 등을 사용
    str2 = "".join(["3", "0"])
    compare_string(str1, str2)
