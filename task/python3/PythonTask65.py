# set 자료구조를 활용한 과제
# 1~45 사이의 정수 중에서 6개의 숫자를 추출하는 로또 프로그램
# 단, set 자료구조를 사용해서 중복 숫자가 나오지 않도록 하고
#     추출된 6개의 숫자를 오름차순으로 정렬해서 출력하기

import random

if __name__ == "__main__":

    # 오름차순 정렬해주는 TreeSet 대응 -> set + sorted()
    treeSet: set = set()

    # random.random() 활용 (Java Math.random() 대응)
    while len(treeSet) < 6:
        num = int(random.random() * 45) + 1
        treeSet.add(num)
    print(sorted(treeSet))
    print()

    # ------------------------------------------------------------------------------------

    # random.randint() 활용 (Java Random().nextInt() 대응)
    treeSet2: set = set()

    while len(treeSet2) < 6:
        n = random.randint(1, 45)
        treeSet2.add(n)
    print(sorted(treeSet2))

    # ------------------------------------------------------------------------------------

    # 파이썬 실무 한줄 버전
    lotto = sorted(random.sample(range(1, 46), 6))  # sample() - 중복 없는 추출
    print(f"한줄 로또: {lotto}")