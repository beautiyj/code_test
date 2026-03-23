# 반복문 - for문

# 1. 메시지 10번 숫자+문자열 반복출력
def t12():
    for i in range(1, 11):
        print("%d+문자열반복출력" % i)
    print("출력종료\n")


# 2. 1~10까지의 합을 구하기
# print(sum(range(1, 11)))
def t12_1():
    result = 0
    for i in range(1, 11):
        result += i
    print(result)
    print()


# 3. 1~100까지의 홀수, 짝수의 합 구하기
# oddSum = sum(range(1, 101, 2))
# evenSum = sum(range(2, 101, 2))
def t12_2():
    oddSum = 0
    evenSum = 0

    for i in range(1, 101):
        if i % 2 == 0:
            evenSum += i
        else:
            oddSum += i

    print("oddSum: %d, evenSum: %d\n" % (oddSum, evenSum))


# 4. 키보드로 입력한 숫자의 단을(구구단. ex 3 입력 시 3단 출력) 출력하기
def t12_3():
    n = int(input("정수 하나 입력"))

    for i in range(1, 10):
        print("%d * %d = %d" % (n, i, n * i))

t12()
t12_1()
t12_2()
t12_3()