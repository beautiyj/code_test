# 레퍼런스 형변환 - 업캐스팅(자동형변환) 다운캐스팅(강제형변환)

"""
자동 형변환(업 캐스팅): 자식클래스에서 부모클래스로 형변환.
참조 가능한 영역이 축소 & 컴파일러에 의해서 자동 형변환

강제 형변환(다운 캐스팅): 부모클래스에서 자식클래스로 형변환.
참조 가능한 영역이 확대 & 강제 형변환 필요, 강제 형변환시 자료형을 생략할 수 없음.
"""


class ParentClass:
    def parent_prn(self):
        print("슈퍼 클래스 : ParentPrn 메서드")


class ChildClass(ParentClass):
    def child_prn(self):
        print("서브 클래스 : ChildPrn 메서드")


# ----------------------------------------------------------------------------------

if __name__ == "__main__":

    # [RefTest01 케이스] - 업 캐스팅 (Upcasting)
    print("=== RefTest01: 업 캐스팅 테스트 ===")
    c = ChildClass()
    c.parent_prn()
    c.child_prn()

    p: ParentClass  # 타입 힌트로 부모 타입임을 명시 (실제 강제는 아님)
    p = c           # 암시적으로 업 캐스팅이 일어남(자식->부모 형변환)
    # 파이썬은 동적 타입이라 자동 형변환 개념이 없지만
    # 타입 힌트로 의도를 명시하는 것이 실무 관례

    p.parent_prn()  # 업 캐스팅 후에는 부모로부터 상속받은 메서드만 호출하는 것이 원칙.

    # 파이썬은 동적 타입이라 실제로는 막히지 않지만, 타입 힌트 기준으론 호출하지 않는 것이 원칙
    # p.child_prn()

    # ---------------------------------------------------------------------------------------------------------

    # [RefTest02 케이스] - 잘못된 다운 캐스팅 (Downcasting Fail)
    # 다운캐스팅은 부모->자식 (강제형변환)
    print("\n=== RefTest02: 잘못된 다운 캐스팅 테스트 ===")
    p2: ParentClass = ParentClass() # 실제 알맹이가 부모인 객체 생성

    # 파이썬은 문법상 막히지 않지만 실제로 부모 객체를 자식 타입으로 쓰면 AttributeError 발생
    # c2: ChildClass = p2           # 타입 힌트상 불가
    # c2.child_prn()                # AttributeError: 'ParentClass' has no attribute 'child_prn'

    # 실무 안전 캐스팅: isinstance() 로 타입 체크 후 사용
    c2 = p2 if isinstance(p2, ChildClass) else None
    print(f"안전 캐스팅 결과(실패 시 None): {c2}")  # None 출력

    """
    # 오류 해결하려면 업캐스팅을 1회 한 뒤 다운캐스팅이 되어야한다
    p2: ParentClass = ChildClass()      # 업캐스팅 상태로 생성
    p2.parent_prn()
    c2: ChildClass = p2                 # 이제 다운캐스팅 가능 (실제 알맹이가 ChildClass이므로)
    c2.parent_prn()
    c2.child_prn()
    """

    # ---------------------------------------------------------------------------------------------------------

    # [RefTest03 케이스] - 올바른 다운 캐스팅 (Downcasting Success)
    print("\n=== RefTest03: 올바른 다운 캐스팅 테스트 ===")

    # 업캐스팅을 먼저 하고 그다음 다운캐스팅 진행.
    p3: ParentClass = ChildClass()
    p3.parent_prn()

    # 타입 힌트상 부모 타입이므로 자식 전용 메서드는 호출하지 않는 것이 원칙
    # p3.child_prn()

    print("---------------->> 강제 형변환 후")

    # 파이썬 다운캐스팅: isinstance() 확인 후 타입 힌트 재지정 (본래 자식이었으므로 성공!)
    c3: ChildClass = p3     # 실제 알맹이가 ChildClass이므로 정상 동작

    c3.parent_prn()
    c3.child_prn()          # 이제 자식 전용 메서드 호출 가능

    # 파이썬 실무: isinstance()로 타입 체크 후 안전하게 사용
    print("\n=== [실무 보너스] isinstance() 안전 캐스트 ===")
    p4: ParentClass = ChildClass()
    if isinstance(p4, ChildClass):
        # isinstance 체크 이후 자식 메서드 바로 호출 가능 (Kotlin의 스마트 캐스트와 동일 개념)
        p4.child_prn()


#          업캐스팅                                    다운캐스팅(업캐스팅 후 다운캐스팅)
#          p: ParentClass = ChildClass()              p: ParentClass = ChildClass()
#                                                     c: ChildClass = p
#
# 혹은      c = ChildClass()
#          p: ParentClass = c
#
# 결과      p.parent_method() 호출가능                 c.parent_method() 호출가능
#                                                     c.child_method() 호출가능
#
# 실무      if isinstance(p, ChildClass): p.child_method()  # 안전 캐스트


"""
Java 코드                         Python 대체                            이유
(ChildClass) p                  타입 힌트 재지정 c: ChildClass = p     파이썬은 런타임 캐스팅 연산자 없음, 동적 타입
instanceof                      isinstance(p, ChildClass)           파이썬 타입 체크 표준 함수
캐스팅 실패 → ClassCastException  isinstance() 체크 후 None 처리        실무에서 AttributeError 방지
타입 무관 동작                    typing 모듈 + 타입 힌트                실무에서 mypy, IDE 정적 분석 활용

"""