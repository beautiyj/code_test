# ---------------------------------------------------------
# [첫 번째 예제: super 키워드와 필드 재정의]
# ---------------------------------------------------------

class Point2D04:
    def __init__(self):
        self.x = 10
        self.y = 20

class Point3D04(Point2D04):
    def __init__(self):
        super().__init__() # 부모의 x, y를 먼저 생성
        self.x = 40        # 부모의 필드를 자식 버전으로 덮어씀 (재정의)
        self.y = 50
        self.z = 30

    def print(self):
        # 파이썬은 인스턴스 변수에 접근할 때 self를 사용함
        print(f"{self.x}, {self.y}, {self.z}")

    def print02(self):
        # 파이썬은 super()를 통해 부모의 메소드에는 접근이 쉬우나,
        # self로 덮어씌워진 부모의 변수값 자체에 접근하려면 별도의 보관이 필요함
        # 아래는 부모 클래스의 기본값을 직접 가져오는 식으로 시뮬레이션
        print(f"{Point2D04().x}, {Point2D04().y}, {self.z}")

class SuperTest04:
    @staticmethod
    def main():
        pt = Point3D04()
        pt.print()
        pt.print02()

# ---------------------------------------------------------
# [두 번째 예제: 상속과 생성자 호출 순서]
# ---------------------------------------------------------

class Point2D05:
    def __init__(self):
        self.x = 10
        self.y = 20
        print("슈퍼 클래스인 Point2D 생성자 호출")

class Point3D05(Point2D05):
    def __init__(self, a):
        # 자식 생성자 호출 시 부모 생성자를 연쇄적으로 호출해줘야 함
        super().__init__()
        self.z = 30
        print("서브 클래스인 Point3D 생성자 호출")

    def print(self):
        print(f"{self.x}, {self.y}, {self.z}")

class SuperTest05:
    @staticmethod
    def main():
        pt = Point3D05(30)
        pt.print()

if __name__ == "__main__":
    print("--- SuperTest04 실행 ---")
    SuperTest04.main()

    print("\n--- SuperTest05 실행 ---")
    SuperTest05.main()