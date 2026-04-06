import calendar

# 파이썬은 덕 타이핑(Duck Typing) 언어라 명시적인 형변환(Casting) 개념이 자바와는 다른 개념
# 표준 라이브러리인 calendar 모듈을 활용하여 동일한 기능을 구현할 수는 있음

def main():
    try:
        year_input = input("연도를 입력하세요(ex. 2020): ")
        year = int(year_input)

        # 파이썬은 상속 구조를 따지기보다 모듈의 함수를 직접 활용하는 경우가 많음
        # calendar.isleap(year)는 자바의 isLeapYear()와 동일한 역할을 함

        if calendar.isleap(year):
            print(f"{year}년은 윤년(366일)입니다.")
        else:
            print(f"{year}년은 평년(365일)입니다.")

    except ValueError:
        print("숫자 형식으로 입력해주세요.")

if __name__ == "__main__":
    main()