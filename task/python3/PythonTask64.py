# TreeSet 트리셋 : 데이터를 오름차순으로 정렬해서 저장하고 출력하는 기능 제공
# 중복된 데이터 저장 x
# 오름차순기준 - 숫자나 문자열은 문제없는데 문자형은 유니코드 작은 순으로 진행됨.

# 파이썬은 TreeSet이 없음 -> sorted set 구현은 sortedcontainers 라이브러리 사용이 실무 표준
# 입문용: 기본 set + sorted()로 대응

if __name__ == "__main__":

    # 파이썬 기본 set은 정렬 보장 없음
    # TreeSet처럼 자동 정렬 + 중복 제거를 원하면 sorted() 출력 시 적용
    hs: set = set()

    result = hs.add("korea")
    # 파이썬 set.add()는 반환값이 None -> 중복 여부는 add 전후 size 비교로 확인
    if "korea" not in hs:
        hs.add("korea")
        print("첫 번째 korea 추가 성공")
    else:
        print("첫 번째 korea 추가 실패")

    # 실무 패턴: 추가 성공/실패를 판별하는 헬퍼 함수로 Java add() 반환값 동작 재현
    def add_to_set(s: set, value) -> bool:
        # Java TreeSet.add()처럼 추가 성공 시 True, 중복 시 False 반환
        if value in s:
            return False
        s.add(value)
        return True

    if add_to_set(hs, "japan"):
        print("japan 추가 성공")
    else:
        print("japan 추가 실패")

    if add_to_set(hs, "america"):
        print("america 추가 성공")
    else:
        print("america 추가 실패")

    if add_to_set(hs, "britain"):
        print("britain 추가 성공")
    else:
        print("britain 추가 실패")

    if add_to_set(hs, "korea"):
        print("두 번째 korea 추가 성공")
    else:
        print("두 번째 korea 추가 실패")

    print()

    # Iterator 이터레이터 반복자
    # TreeSet처럼 오름차순 정렬 출력: sorted() 적용
    it = iter(sorted(hs))
    try:
        while True:
            print(next(it))
    except StopIteration:
        pass

    # 파이썬 실무: for-in + sorted() 로 간결하게 대체 가능
    # for element in sorted(hs):
    #     print(element)

"""
첫 번째 korea 추가 성공
japan 추가 성공
america 추가 성공
britain 추가 성공
두 번째 korea 추가 실패

america
britain
japan
korea


| Java                              | Kotlin                          | Python                          | 이유                                                        |
|-----------------------------------|---------------------------------|---------------------------------|-------------------------------------------------------------|
| Set s = new HashSet()             | MutableSet<Any> = HashSet()     | set()                           | 타입 안전 컬렉션                                              |
| set.remove()                      | set.remove()                    | set.discard()                   | Python discard()는 없는 값도 오류 없이 처리                    |
| TreeSet (자동정렬)                  | TreeSet<T>                      | set + sorted()                  | Python 기본 set은 정렬 미보장, sorted()로 출력 시 정렬          |
| set.add() 반환 boolean             | set.add() 반환 Boolean           | add() 반환 None → 헬퍼 함수 필요  | Python은 중복 여부 반환 없음, add_to_set() 헬퍼로 재현          |
| iterator.hasNext() / next()       | 동일 / 실무는 for-in              | iter() + next() / 실무는 for-in  | 실무에서 이터레이터 직접 다루기보다 for-in 루프 선호              |


"""