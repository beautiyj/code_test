from dataclasses import dataclass
from typing import Any

# 롬복 사용 시 간략하게 가능 -> 파이썬은 @dataclass 데코레이터로 가능
# @dataclass는 __init__, __repr__(ToString), Getter/Setter 역할을 자동으로 수행함
@dataclass
class Task42Class:
    member: int = 0

@dataclass
class Task42Class2:
    member: Any = None

class JavaTask42:
    def run_generic_test01(self):
        obj01 = Task42Class()
        # 파이썬은 별도의 setter 메소드 없이 속성에 직접 접근해도 안전하게 설계됨
        obj01.member = 3
        print(f"값 확인: {obj01.member}")

    def run_generic_test02(self):
        obj01 = Task42Class2()

        # Object 기반이므로 롬복을 써도 넣고 뺄 때 박싱/캐스팅 원리는 동일합니다.
        # (파이썬은 모든 것이 객체이므로 내부적으로는 항상 동일함)
        obj01.member = 3.14

        # 롬복 덕분에 코드가 비즈니스 로직에만 집중할 수 있게 됩니다.
        result = float(obj01.member)
        print(f"롬복으로 꺼낸 실수: {result}")

        obj01.member = "롬복은 편리하다"
        print(f"롬복으로 확인한 문자열: {obj01.member}")

if __name__ == "__main__":
    task = JavaTask42()
    print("--- 파이썬(dataclass) 기반 테스트 시작 ---")
    task.run_generic_test01()
    task.run_generic_test02()