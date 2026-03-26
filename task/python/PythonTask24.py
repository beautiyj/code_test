# 1. 기본 생성자에서 메시지만 출력 (필드 기본값 0으로 초기화됨)
class MyDate1:
    def __init__(self):
        self.year = 0
        self.month = 0
        self.day = 0
        print("[MyDate1 생성자] : 객체가 생성될 때 자동 호출됩니다.")

    def print_info(self):
        print(f"MyDate1: {self.year}/{self.month}/{self.day}")

# 2. 기본 생성자에서 특정 날짜로 값을 직접 고정 (하드코딩)
class MyDate2:
    def __init__(self):
        self.year = 2023
        self.month = 4
        self.day = 1

    def print_info(self):
        print(f"MyDate2: {self.year}/{self.month}/{self.day}")

# 3. 매개변수가 있는 생성자만 만들었을 때 (파이썬은 생성자가 1개만 가능)
class MyDate3:
    def __init__(self, year, month, day):
        self.year = year
        self.month = month
        self.day = day

    def print_info(self):
        print(f"MyDate3: {self.year}/{self.month}/{self.day}")

# 4. 기본 생성자와 매개변수 생성자를 둘 다 만들었을 때 - Python ver 코드 없음 (오버로딩 불가)
# 대신 디폴트 값(None)을 사용하여 유연하게 구현함
class MyDate4:
    def __init__(self, year=0, month=0, day=0):
        self.year = year
        self.month = month
        self.day = day

    def print_info(self):
        print(f"MyDate4: {self.year}/{self.month}/{self.day}")

# 5. 기본 생성자 + 매개변수 생성자 - Python ver 코드 없음 (4번과 동일)

# 6. 변수 이름 충돌로 인한 변경 실패
class MyDate6:
    def __init__(self, year):
        self.year = year

    def set_year(self, year):
        # 파이썬은 self를 붙이지 않으면 지역 변수로 취급됨 (필드 변경 안 됨)
        year = year

    def print_info(self):
        print(f"Step 6 Year: {self.year}")

# 7. this(self) 키워드로 이름 충돌 해결
class MyDate7:
    def __init__(self, year):
        self.year = year

    def set_year(self, year):
        # self.year라고 명시해서 필드 값을 정확히 바꿈
        self.year = year

    def print_info(self):
        print(f"Step 7 Year: {self.year}")

# 8. this() 생성자로 코드 중복 제거 - Python ver 코드 없음 (생성자가 1개뿐이므로 체이닝 불필요)
# 대신 파라미터 기본값을 활용하여 기능을 대체함
class MyDate8:
    def __init__(self, year=2026, month=1, day=1):
        self.year = year
        self.month = month
        self.day = day

    def print_info(self):
        print(f"Step 8: {self.year}/{self.month}/{self.day}")

# --- 실행부 ---
if __name__ == "__main__":
    d1 = MyDate1(); d1.print_info()
    d2 = MyDate2(); d2.print_info()

    # d3 = MyDate3() # ❌ 오류 발생! (값을 반드시 넣어야 함)
    d3_fixed = MyDate3(2023, 7, 19); d3_fixed.print_info()

    d4_empty = MyDate4(); d4_empty.print_info()
    d4_data = MyDate4(2023, 7, 19); d4_data.print_info()

    d6 = MyDate6(2023); d6.set_year(2024); d6.print_info()
    d7 = MyDate7(2023); d7.set_year(2024); d7.print_info()

    d8 = MyDate8(2023, 7); d8.print_info()