import math

# p341~342 대응
class Calculator53:
    def area_circle(self, r):
        print("Calculator 객체의 area_circle() 실행")
        return 3.14159 * r * r

class Computer53(Calculator53):
    # 메소드 오버라이드
    def area_circle(self, r):
        print("Computer 객체의 area_circle() 실행")
        return math.pi * r * r

# p342 대응
class Airplane:
    def land(self):
        print("착륙합니다")
    def fly(self):
        print("일반비행합니다")
    def takeoff(self):
        print("이륙합니다")

class SupersonicAirplane(Airplane):
    # 클래스 변수 (상수처럼 활용)
    NORMAL = 1
    SUPERSONIC = 2

    def __init__(self):
        self.fly_mode = self.NORMAL

    def fly(self):
        if self.fly_mode == self.SUPERSONIC:
            print("초음속비행합니다")
        else:
            # 부모클래스의 fly() 메소드 호출 (은닉 메소드 호출)
            super().fly()

if __name__ == "__main__":
    r = 10

    calculator = Calculator53()
    print(f"원면적: {calculator.area_circle(r)}")

    computer = Computer53()
    print(f"원면적: {computer.area_circle(r)}")

    print()

    sa = SupersonicAirplane()
    sa.takeoff()
    sa.fly()        # 일반비행합니다
    sa.fly_mode = SupersonicAirplane.SUPERSONIC
    sa.fly()        # 초음속비행합니다
    sa.fly_mode = SupersonicAirplane.NORMAL
    sa.fly()        # 일반비행합니다
    sa.land()