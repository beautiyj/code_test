# 파이썬은 자바의 은닉 변수와 개념이 다름
# self.x로 값을 덮어쓰면 부모의 값이 사라진 것처럼 보이지만
# 클래스 이름을 직접 참조하여 부모의 초기값을 확인할 수 있습니다.


# [예제 1] 상속에서의 필드 (기본 상속)
class Point2D_01:                            # 부모 클래스
    def __init__(self):
        self.x = 10
        self.y = 20

class Point3D_01(Point2D_01):                # 자식 클래스
    def __init__(self):
        super().__init__()
        self.z = 30

    def print_point(self):
        print(f"{self.x}, {self.y}, {self.z}") # x와 y는 상속 받아 사용하는 필드
        # 10, 20, 30

# [예제 2 & 3] 상속에서의 필드 (은닉 변수 및 super 이용)
class Point2D_02:                            # 부모 클래스
    def __init__(self):
        self.x = 10 # 자식에서 재정의하면 은닉변수가 됨
        self.y = 20

class Point3D_02(Point2D_02):                # 자식 클래스
    def __init__(self):
        super().__init__()
        self.x = 40 # 부모 멤버변수를 자식에서 다시 정의
        self.y = 50
        self.z = 30

    def print_point(self):
        print(f"{self.x}, {self.y}, {self.z}") # 자식의 재정의된 x,y 출력
        # 40, 50, 30

    def print02(self):
        # 파이썬은 인스턴스에서 부모 변수값이 덮어씌워지므로 클래스 원본 값을 참조함
        print(f"{Point2D_02().x}, {Point2D_02().y}, {self.z}")
        # 10, 20, 30

# [예제 4] 상속에서의 메소드
class Parent_04:                            # 부모 클래스
    def parent_prn(self):
        print("부모 클래스의 메서드는 상속된다.")

class Child_04(Parent_04):                  # 자식 클래스
    def child_prn(self):
        print("자식 클래스의 메서드는 부모가 사용할 수 없다.")

if __name__ == "__main__":
    print("=== [예제 1] 기본 상속 테스트 ===")
    pt1 = Point3D_01()
    pt1.print_point()

    print("\n=== [예제 2 & 3] 은닉 변수 및 super 테스트 ===")
    pt2 = Point3D_02()
    print("자식 변수 출력: ", end="")
    pt2.print_point()
    print("부모 변수(super) 출력: ", end="")
    pt2.print02()

    print("\n=== [예제 4] 메소드 상속 및 접근 제한 테스트 ===")
    c = Child_04()
    c.parent_prn() # 상속받은 부모 메소드 호출
    c.child_prn()  # 자신의 메소드 호출

    p = Parent_04()
    p.parent_prn() # 부모 자신의 메소드 호출
    # p.child_prn() # [AttributeError] 부모는 자식의 메소드에 접근할 수 없음
    print("부모 객체는 자식 메소드(child_prn)를 호출할 수 없음을 확인했습니다.")