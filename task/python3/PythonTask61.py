# 레퍼런스 형변환 예제 + 박싱언박싱
# 레퍼런스 형변환 : 2개의 클래스 사이에 상속 관계가 있어야 가능

# 파이썬은 동적 타입 언어라 박싱/언박싱 개념이 없음.
# 업캐스팅/다운캐스팅은 타입 힌트 + isinstance()로 표현

from __future__ import annotations

import calendar
from typing import Any

if __name__ == "__main__":

    #   예시 1 추상 클래스와 상속
    #   파이썬 calendar 모듈로 윤년 확인 (Java Calendar/GregorianCalendar 대응)

    # Java: Calendar c2 = new GregorianCalendar()  -> 업캐스팅
    # 파이썬은 동적 타입이라 별도 업캐스팅 없이 isleap() 함수로 바로 확인
    year = 2026
    if calendar.isleap(year):
        print("윤년")
    else:
        print("평년")

    # --------------------------------------------------------------------------------------------------------------

    #   예시 2 - 인터페이스와 업캐스팅
    #   파이썬은 list가 Java ArrayList에 해당. 인터페이스/업캐스팅 개념 없이 바로 사용.
    #   타입 힌트로 의도를 명시하는 것이 실무 관례.

    list_any: list[Any] = []    # Java: List list = new ArrayList() 에 대응
    al: list[Any] = []          # Java: ArrayList al = new ArrayList() 에 대응

    # --------------------------------------------------------------------------------------------------------------

    #   예시 3 - 자동 박싱과 업캐스팅
    #   파이썬은 모든 값이 객체라 박싱/언박싱 자동처리. Any = object (최상위 타입)

    list_any.append(10)         # 이미 객체라 박싱 불필요
    list_any.append(3.14)
    list_any.append('j')
    list_any.append(True)
    list_any.append("자바")

    print(list_any)

    # --------------------------------------------------------------------------------------------------------------

    #   예시 4 - 객체의 값 비교 (==)
    #   파이썬 == 은 Java equals()와 동일하게 내용 비교. 참조 비교는 is

    str1 = "java"
    str2 = "java"
    if str1 == str2:            # 파이썬 실무버전 (내용 비교)
        print("같은값")
    else:
        print("다른값")

    if 10 == 10:                # 파이썬은 기본형/객체 구분 없이 == 로 비교
        print("같은값")
    else:
        print("다른값")

    if 3.14 == 3.14:            # 실수 비교 (실무에서 부동소수점 주의)
        print("같은 실수 값")
    else:
        print("다른값")

    # 실무: 부동소수점 비교는 math.isclose() 권장
    import math
    if math.isclose(3.14, 3.14):
        print("같 (안전한 실수 비교)")

    # --------------------------------------------------------------------------------------------------------------

    #   예시 5 - 리스트 데이터 추출과 형변환
    #   파이썬 list에서 꺼내면 Any(object) 타입. 원래 타입으로 쓰려면 isinstance() 체크 후 사용.

    l: list[Any] = []           # 업캐스팅 (요즘은 제네릭 타입 힌트로 쓰고)
    l.append("자바")
    l.append("오라클")
    l.append("문자들을저장하기")

    obj: Any = l[0]
    print(obj)                  # list [0] 인덱스인 자바 출력됨

    # s: str = l[0]             타입 힌트상 Any라 IDE 경고 발생
    s: str = str(l[0])          # 명시적 형변환 (다운캐스팅 대응)

    for i in range(len(l)):
        string = str(l[i])      # 명시적 형변환 방식
        print(string)

    # --------------------------------------------------------------------------------------------------------------

    #   예시 6 - 반복문과 다운캐스팅, 언박싱
    #   리스트 순회 시 Any를 int로 바꾸는 과정. 파이썬은 언박싱 불필요.

    ls: list[Any] = []

    ls.append(10)               # 파이썬은 박싱/언박싱 자동처리
    ls.append(200)
    ls.append(3000)
    ls.append(40000)
    ls.append(500000)

    for i in range(len(ls)):
        num: int = ls[i]        # 타입 힌트로 의도 명시 (실제 강제 아님)
        n: int = num            # 파이썬은 언박싱 자동처리 (intValue() 불필요)

        nn: int = int(ls[i])    # 명시적 형변환 한줄로 끝내기

    # 향상된 for문
    for j in ls:
        print(s)

    # 연산 진행하려면 타입 확인 후 사용
    for k in ls:
        # Any 타입을 int로 확인 후 사용 (파이썬은 언박싱 자동처리)
        value: int = int(k)     # 명시적 형변환
        print(value + 100)

    # 파이썬 실무: isinstance() 안전 캐스트 활용
    for k in ls:
        if not isinstance(k, int):  # int가 아니면 스킵 (Kotlin의 as? ?: continue 대응)
            continue
        print(k + 100)