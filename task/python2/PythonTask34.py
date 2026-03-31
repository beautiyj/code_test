from typing import Final

# 파이썬은 언어 차원에서 강제하는 final이 약하지만, typing 모듈을 통해 명시합니다.
# 파이썬에서 final은 런타임 에러를 내지 않고 정적 분석기(Linter)에서만 경고를 줍니다.

# 1. 상수 (주석/힌트로만 존재)
class FinalMember:
    def __init__(self, b: int):
        self.B: Final = b # B는 상수임을 명시

# 2. 상속 및 오버라이딩 (강제성 없음, 관례상 처리)
class FinalMethod:
    def set_str(self, s: str):
        print(s)

# 파이썬은 모든 클래스가 상속 가능하고 모든 메소드가 오버라이딩 가능합니다.
# 강제하려면 @final 데코레이터를 사용합니다 (Python 3.8+)
from typing import final

@final
class FinalClass:
    pass