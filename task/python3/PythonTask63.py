# HashSet 해시셋 : 트리셋과 달리 정렬은 x

if __name__ == "__main__":

    # 파이썬 set이 Java HashSet에 대응
    s: set = set()

    print(f"요소의 갯수->{len(s)}")         # 요소의 갯수->0
    s.add("하나")
    s.add(2)
    s.add(3.42)
    s.add("넷")
    s.add("five")
    s.add(6)
    s.add(6)

    # Set은 중복된 데이터 저장하지 못함 -> 중복데이터 판별용으로 씀, 순서 제어x
    print(f"요소의 갯수->{len(s)}")         # 요소의 갯수->6
    print(s)                               # {'하나', 2, 6, '넷', 3.42, 'five'}

    # Iterator 이터레이터 반복자
    # 파이썬은 모든 컬렉션이 기본 이터러블 -> iter() / next()로 동일하게 표현 가능
    elements = iter(s)
    try:
        while True:
            print(f"\t\t{next(elements)}")
    except StopIteration:
        pass

    # 파이썬 실무: while/next 대신 for-in 루프 사용
    # for element in s:
    #     print(f"\t\t{element}")