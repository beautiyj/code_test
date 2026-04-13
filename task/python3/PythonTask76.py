# 제네릭 예제
# 파이썬은 TypeVar로 제네릭 표현

from typing import TypeVar, Generic

T = TypeVar('T')    # Java의 <T> 선언 대응


class GenericClass(Generic[T]):
    def __init__(self):
        self.__member: T | None = None

    def get_value(self) -> T | None:
        return self.__member

    def set_value(self, value: T):
        self.__member = value


class Collections06:
    def collection06(self):
        # 파이썬은 list[str] 타입 힌트로 제네릭 효과 표현
        vec: list[str] = []
        # 제네릭 사용하지 않을 경우 list[Any] ++ 여러가지 자료형 넣을 수 있음
        vec.append("Apple")     # 업캐스팅 개념 없음, 바로 추가
        vec.append("banana")
        vec.append("oRANGE")
        # vec.append(30)        타입 힌트상 str만 허용 (실제 강제는 아님, mypy로 검사)

        for i in range(len(vec)):
            # 제네릭(타입 힌트) 처리로 다운캐스팅 불필요
            temp: str = vec[i]
            print(temp.upper())     # toUpperCase() 대응


if __name__ == "__main__":

    # GenericTest05
    obj01: GenericClass[float] = GenericClass()
    obj01.set_value(3.4)
    print(f"되돌리는 값은->{obj01.get_value()}")

    obj02: GenericClass[int] = GenericClass()
    obj02.set_value(10)
    print(f"되돌리는 값은->{obj02.get_value()}")

    obj03: GenericClass[str] = GenericClass()
    obj03.set_value("이해할 수 있다.")
    print(f"되돌리는 값은->{obj03.get_value()}")

    print("=============================================================")
    print()

    col06 = Collections06()
    col06.collection06()