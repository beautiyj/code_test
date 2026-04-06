# 상속 + Getter/Setter
#파이썬은 기본적으로 모든 멤버가 public이며,
# 진정한 의미의 private은 없지만 관례적으로 _나 __를 붙여 캡슐화를 흉내
# 실무에서는 @property 데코레이터를 사용하여 Getter/Setter를 구현

class Point2D:                       # 부모 클래스
    def __init__(self):
        self._x = 0                  # 필드 (관례상 _는 보호된 멤버를 의미)
        self._y = 0

    @property
    def x(self): return self._x      # Getter
    @x.setter
    def x(self, value): self._x = value # Setter

    @property
    def y(self): return self._y
    @y.setter
    def y(self, value): self._y = value

# 부모 클래스(Point2D)의 필드와 메소드를 상속 받아서 사용할 수 있다.
class Point3D(Point2D):              # 자식 클래스
    def __init__(self):
        super().__init__()           # 부모 생성자 호출 필수
        self._z = 0

    @property
    def z(self): return self._z
    @z.setter
    def z(self, value): self._z = value

if __name__ == "__main__":
    pt = Point3D()
    pt.x = 10  # 상속받아 사용 (Setter 호출)
    pt.y = 20  # 상속받아 사용
    pt.z = 30  # 자신의 것 사용

    print(f"{pt.x}, {pt.y}, {pt.z}") # Getter 호출