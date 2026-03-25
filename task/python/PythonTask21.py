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

if __name__ == "__main__":
    print("예제1")
    print(sum_func())

    print("예제2")
    max_val, min_val = maxmin_func()
    print(max_val, min_val)
    print(f"최대: {max_val}, 최소: {min_val}")
