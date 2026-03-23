# 반복문 - while문


# 1. 문자열 반복 출력
def task13_1():
    i = 1
    while i <= 10:
        print(f"{i}문자출력")
        i += 1
    print()

# 2. while문과 if-else문을 활용해 1~100까지의 홀.짝수 합 구하기
def task13_2():
    i = 0
    oddSum = 0
    evenSum = 0

    while i <= 100:
        if i % 2 == 0:
            evenSum += i
        else:
            oddSum += i
        i += 1

    print(oddSum)
    print(evenSum)
    print()

# 3. 키보드로 입력받은 숫자의 구구단을 출력하기
def task13_3():
    n = int(input("정수 하나를 입력하세요\n"))
    i = 1
    while i <= 9:
        print(f"{n} * {i} = {n * i}")
        i += 1
    print()

# 4. 구구단 2~9단 출력하기
def task13_4():
    n = 2

    while n <= 9:
        print(f"{n}단")
        i = 1
        while i <= 9:
            print(f"{n} * {i} = {n * i}")
            i += 1
        n += 1

task13_1()
task13_2()
task13_3()
task13_4()