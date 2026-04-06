import math

# 반지름 r이 5인 경우 다음을 구하는 프로그램을 포맷팅을 이용하여 작성하기
# 파이썬은 모든 것이 객체이므로 별도의 Wrapper 클래스 구분이 없음

class Task42:
    def task42(self):
        r = 5

        # 원 둘레
        r1 = 2 * math.pi * r
        # 원 면적
        r2 = math.pi * r * r
        # 구 표면적
        r3 = 4 * math.pi * r * r
        # 구 부피
        r4 = (4 / 3) * math.pi * r * r * r

        # 파이썬의 소수점 둘째자리 포맷팅 방식 (DecimalFormat 역할)
        print(f"{r1:.2f}")
        print(f"{r2:.2f}")
        print(f"{r3:.2f}")
        print(f"{r4:.2f}")

class Task43Class2:
    def task43_class2(self):
        # 파이썬은 모든 변수가 참조형(객체)이므로 자바의 박싱된 상태와 비슷함
        r = 5

        r1 = 2 * math.pi * r
        r2 = math.pi * r * r
        r3 = 4 * math.pi * r * r
        r4 = (4 / 3) * math.pi * r * r * r

        # format 함수 사용 예시
        print("{:.2f}".format(r1))
        print("{:.2f}".format(r2))
        print("{:.2f}".format(r3))
        print("{:.2f}".format(r4))

if __name__ == "__main__":
    t42 = Task42()
    t42.task42()

    t42_class2 = Task43Class2()
    t42_class2.task43_class2()