# 상속, super()

# 1. super().__init__(...)은 부모 클래스의 매개변수를 가진 생성자를 호출할 때 사용한다.
# 2. 파이썬은 super() 호출 위치가 자유롭지만, 보통 첫 번째 라인에 사용한다.
# 3. 부모의 특정 생성자를 호출하면 해당 로직만 수행된다.

class Point2D06:
    def __init__(self, xx=None, yy=None):
        # 파이썬은 생성자 오버로딩 대신 기본값 인자를 사용하여 처리함
        if xx is None and yy is None:
            self.x = 10
            self.y = 20
            print("슈퍼 클래스인 Point2D 생성자 호출")
        else:
            self.x = xx # x=50
            self.y = yy # y=60

class Point3D06(Point2D06):
    def __init__(self):
        # 부모 클래스의 매개변수가 있는 생성자(로직) 호출
        super().__init__(50, 60)
        self.z = 30
        print("서브 클래스인 Point3D 생성자 호출")

    def print_point(self):
        print(f"{self.x}, {self.y}, {self.z}")

if __name__ == "__main__":
    pt = Point3D06()
    # 생성자 호출
    pt.print_point()