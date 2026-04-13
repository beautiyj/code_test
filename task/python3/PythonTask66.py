# 컬렉션 인터페이스 - Collection 프레임워크의 list 인터페이스
# 리스트 인터페이스는 인덱스 번호(입력순) 자료형 저장, 중복저장 가능, 동적으로 크기 조절.

if __name__ == "__main__":

    print("---------------------------------------------------------")
    print("어레이리스트 활용")

    # 파이썬 list가 Java ArrayList에 대응
    array_list: list = []

    array_list.append("하나")
    array_list.append(2)
    array_list.append(2)
    array_list.append(3.42)
    array_list.append("넷")
    array_list.append("five")
    array_list.append(6)

    print(array_list)
    print()

    # -------------------------------------------------------------------------------

    print("---------------------------------------------------------")
    print("전체 리스트 출력 & 특정 인덱스 번호 데이터 출력하기")

    list1: list = ["하나", 2, 3.42, "넷", "five", 6]

    # 출력방법
    print(list1)
    print(list1[2])         # 특정 인덱스 번호의 데이터 출력
    print()

    print("---------------------------------------------------------")
    print("반복문 - 업캐스팅 활용하기")

    for i in range(len(list1)):
        print(f"{i} 번째 요소는 {list1[i]}")
        obj: object = list1[i]      # 파이썬 object가 Java Object(업캐스팅) 대응
        print(obj)

    print("---------------------------------------------------------")
    print("반복문 - toString 활용하기")

    for i in range(len(list1)):
        s: str = str(list1[i])      # str() = Java toString() 대응
        print(s)

    print("---------------------------------------------------------")
    print("Iterator 반복자 활용하기")

    # 이터레이터 반복자
    elements = iter(list1)
    try:
        while True:
            print(f"\t\t{next(elements)}")
    except StopIteration:
        pass

    # 파이썬 실무: for-in 루프로 간결하게 대체 가능
    # for element in list1:
    #     print(f"\t\t{element}")