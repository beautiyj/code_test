def task22():
    age = int(input("age: "))
    name = input("name: ")

    address = input("address: ")

    # 안정성 - 예외 처리 포함
    user_input = input("태어난 연도를 입력하세요: ")

    # 예외처리 - 문자열 안의 내용이 모두 숫자라면 -> True처리되어 아래의 int변환코드로 이동.
    #                               숫자가 아니라면 -> False 처리, else의 에러메시지 출력
    if user_input.isdigit():
        birth_year = int(user_input)
        current_year = 2026
        age_calc = current_year - birth_year + 1
        print(f"나이: {age_calc}")
    else:
        print("숫자만 입력")

    print(f"\n입력 결과: {age}, {name}, {address}")

if __name__ == "__main__":
    task22()


    # isdigit() 매소드: 문자열 안에 있는 내용이 모두 숫자인지 확인 후 T F로 돌려주는 boolean형 메소드