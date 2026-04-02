# Python String 활용 예제

def string_test_0():
    # 파이썬은 문자열 리터럴을 자동으로 인터닝(Interning)하여 같은 주소를 참조하게 함
    str1 = str("Java Programming")
    str2 = str("Java Programming")
    # 파이썬에서 'is'는 주소 비교, '=='는 값 비교
    print("같은주소" if str1 is str2 else "다른주소")

    str3 = "Java Programming"
    str4 = "Java Programming"
    print("같은주소" if str3 is str4 else "다른주소")
    print("같은 값" if str1 == str3 else "다른 값")

def string_test_1():
    str1 = "Java Programming"
    str1.upper() # 결과값을 할당하지 않으면 원본 유지 (가비지 발생 가능성)
    print(str1)
    print(str1.upper()) # 대문자 출력

    str2 = str1.upper()
    print(str2)
    str3 = str1.lower()
    print(str3)

def string_test_2():
    gemini = "gemini"
    johnharu = "johnharu"
    temp_string1 = gemini + johnharu
    print(temp_string1)

    # 파이썬은 문자열 + 정수 연산 시 강제 형변환(str())이 필요함
    temp_string2 = temp_string1 + str(100)
    print(temp_string2)

def string_test_3():
    message = "Java program creates many objects."
    length = len(message)
    print(length)

    # 인덱스로 접근하여 공백 찾기
    for i in range(length):
        if message[i] == ' ':
            print(f"index = {i}")

def string_test_4():
    message = "Java program creates many objects."
    # find()나 index() 사용 (없으면 -1 혹은 에러)
    print(message.find('a'))
    print(message.find(chr(97))) # 아스키 코드는 chr() 사용

    # 13번째 인덱스 이후부터 찾기
    print(message.find('a', 13))
    print(message.find("av"))
    print(message.find("man", 12))
    print(message.find("java")) # 없으면 -1 반환

def string_test_5():
    str1 = "gemini   "
    str2 = "   gemini "
    print(str1 == str2) # False
    # trim() 대신 strip() 사용
    print(str1.strip() == str2.strip()) # True

def string_test_6():
    message = "Java program creates many objects."
    # substring 대신 슬라이싱 [start:end] 사용 (end 미포함)
    print(message[13:])
    print(message[13:16])

    jumin = "950101-1234567"
    num = int(jumin[7])
    if num in [1, 3]: print("남")
    elif num in [2, 4]: print("여")
    else: print("x")

def string_test_7():
    old_str = "자바는 객체지향 언어 입니다."
    # 파이썬 replace는 모든 대상을 바꿈
    new_str = old_str.replace("자바", "Python")
    print(new_str)

    phone = "010-1234-1234"
    # replace(old, new, count)로 첫 번째만 변경 가능
    print(phone.replace("-", " ", 1))

    import re
    data = "가격은 50,000원 입니다!!!"
    # 정규표현식으로 숫자만 남기기
    clean_data = re.sub(r'[^0-9]', '', data)
    print(clean_data)

def string_test_8():
    jumin = "950101-1234567"
    j = jumin.split("-")
    print(f"앞자리: {j[0]}, 뒷자리: {j[1]}")

    import re
    text = "홍길동&이수홍,박연수,김자바-최명호"
    # 여러 구분자로 쪼개기
    names = re.split(r'[&,-]', text)
    for name in names:
        print(name, end="\t")

# 실행부
if __name__ == "__main__":
    string_test_0()
    string_test_1()
    string_test_2()
    string_test_3()
    string_test_4()
    string_test_5()
    string_test_6()
    string_test_7()
    string_test_8()