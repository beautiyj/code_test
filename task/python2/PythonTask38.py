import io

# [Test 1] StringIO 활용 (자바의 StringBuffer와 유사)
def string_buffer_1():
    # 파이썬은 기본 용량(capacity) 개념을 사용자가 직접 제어하진 않음
    sb1 = io.StringIO("gemini")

    # 현재 내용의 길이 확인
    print(f"sb1 length: {len(sb1.getvalue())}")

    # 문자열 추가 (append 대신 write)
    sb1.write("A string buffer implements a mutable sequence of characters")
    print(f"sb1 length: {len(sb1.getvalue())}")

# [Test 2] 값 추가 및 변환
def string_buffer_2():
    sb1 = ["gemini"] # 실무에선 리스트를 버퍼로 사용함

    # 문자열 추가
    sb1.append(" is beautiful")
    print(f"sb1 = {''.join(sb1)}")

    # 정수형 추가
    sb1.append(str(1004))

    # 최종 문자열 변환 후 대문자 출력
    full_str = "".join(sb1)
    print(full_str.upper())

# [Test 3] 특정 위치 삽입 (Insert)
def string_buffer_3():
    # 리스트를 쓰면 insert가 매우 쉬움
    text_list = list("gemini is beautiful")

    # 10번 인덱스에 "very" 삽입
    # 파이썬 리스트 insert는 한 글자씩 들어가므로 슬라이싱 권장
    text_list[10:10] = list("very")
    print("".join(text_list))

    # 0번 인덱스에 1004 삽입
    text_list[0:0] = list(str(1004))
    print("".join(text_list))