# Python 버전: String 처리 예제

"""
특징                   Java                           Python                Kotlin
기본 도구     split() (배열), StringTokenizer    split() (리스트)          split() (리스트)
메모리 절약형     StringTokenizer (일회용)        generator / iterator     Sequence (Lazy 처리)
함수/메소드 참조   :: (Method Reference)         함수 이름 그 자체          :: (Callable Reference)

"""

# [Test 1] 특정 구분자로 나누기 (사용자 코드 StringTokenizerTest1 대응)
def test1():
    source1 = "111-111|강원도|춘천시|퇴계동"
    # 파이썬은 split후 iter를 씌우면 next()로 하나씩 소모 가능 (일회용 도구화)
    st1 = iter(source1.split("|"))

    zip_code = next(st1)
    dou = next(st1)
    si = next(st1)
    dong = next(st1)

    print(f"우편번호:{zip_code}")
    print(f"도:{dou}")
    print(f"시:{si}")
    print(f"동:{dong}")

# [Test 2] 반복문 활용 (StringTokenizerTest2 대응)
def test2():
    source1 = "한국 미국 태국 중국 이란"
    for token in source1.split(" "):
        print(f"token:{token}")

    print()

    source2 = "푸들,삽살개,풍산개,진돗개"
    # 구분자 포함 옵션(true)은 정규표현식이나 re.split을 써야 함
    import re
    tokens_with_delim = re.split(r'(,)', source2)
    for t in tokens_with_delim:
        if t: print(f"token:{t}")

# [Test 3 & Split] 리스트 활용 (StringTokenizerTest3 & StringSplit 대응)
def test3_and_split():
    str_val = "이순신#을지문덕#강감찬#광개토대왕"

    # 1. split으로 리스트(배열) 만들기 - 복사본 보관용
    arr = str_val.split("#")

    # 2. 개수 확인
    print(f"파싱할 문자열의 총갯수-> {len(arr)}") # 4

    # 3. 하나 꺼내기 (이순신)
    print(arr[0])

    # 4. 나머지 출력 (을지문덕부터)
    for name in arr[1:]:
        print(name, end=" ")
    print()

    # 5. 전체 배열 출력 (Arrays.toString 대응)
    print(arr)

    # 6. map과 print를 이용한 스트림 스타일 출력 (::println 대응)
    list(map(print, arr))

# 실행부
if __name__ == "__main__":
    test1()
    print("-" * 20)
    test2()
    print("-" * 20)
    test3_and_split()