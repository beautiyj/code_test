# 보조 제어문 - break문, continue문
import random

# continue 1 - 1~100까지의 정수 중 짝수만 출력하기
# for i in range(2, 101, 2): print(i)
def task15_main1():
    for i in range(1, 101):
        if i % 2 == 1:
            continue
        print(i)
    print()

# continue 2 - 1~10 중 5를 제외한 나머지만 출력하기
# for i in [x for x in range(1, 11) if x != 5]: print(i)
# 리스트 컴프리헨션 사용하면 간략하긴 함
def task15_main2():
    for i in range(1, 11):
        if i == 5:
            continue
        print(i)
    print()

# continue 2 - 1~10 중 5를 제외한 나머지만 출력하기
# for i in range(5, 101, 5): print(i)
def task15_main3():
    for i in range(1, 101):
        if i % 5 != 0:
            continue
        print(i)
    print()

# break 1 - 15일 때 반복문 중단하기 (for문 ver)
def task15_main4():
    i = 1
    while True:
        print(i)
        if i == 15:
            break
        i += 1
    print()

# break 2 - 15일 때 반복문 중단하기 (while문 ver)
def task15_main5():
    i = 1
    while True:
        print(i)
        if i == 15:
            break
        i += 1
    print()

# break 3 - random()함수에서 6이 나오면 중단하는 프로그램
def task15_main6():
    i = 1
    while True:
        i += 1
        num = random.randint(1, 6)  # 범위가 1~6 전부 나옴
        if num == 6:
            break
        print(num)
    print(f"루프횟수: {i - 1}")