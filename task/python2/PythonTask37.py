import re

# [방법 1] 기본 방식 (기존 자바 Solution37 로직)
def solution_37():
    print("주민번호를 입력하시오. (예: 9901011234567)")
    try:
        jumin1 = input("주민번호 앞자리를 입력하세요: ")
        jumin2 = input("주민번호 뒷자리를 입력하세요: ")

        if not jumin1:
            print("주민번호 앞자리가 입력되지 않았습니다.")
        elif len(jumin1) != 6:
            print("주민번호 앞자리 6자리가 입력되지 않았습니다.")
        elif not jumin2:
            print("주민번호 뒷자리가 입력되지 않았습니다.")
        elif len(jumin2) != 7:
            print("주민번호 뒷자리 7자리가 입력되지 않았습니다.")
        else:
            full_jumin = jumin1 + jumin2
            weights = [2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5]

            total = sum(int(full_jumin[i]) * weights[i] for i in range(12))
            check_sum = (11 - (total % 11)) % 10

            if check_sum == int(full_jumin[12]):
                print("올바른 주민번호 입니다")
            else:
                print("잘못된 주민번호")
    except Exception as e:
        print(f"오류 발생: {e}")

# [방법 2] 앞뒤 분리 방식 (T2 로직)
def solution_37_t2():
    def check_jumin(j1, j2):
        total = 0
        weight = 2

        # 앞자리 계산
        for char in j1:
            total += int(char) * weight
            weight += 1

        # 뒷자리 계산 (마지막 제외)
        for char in j2[:6]:
            if weight > 9: weight = 2
            total += int(char) * weight
            weight += 1

        check_num = (11 - (total % 11)) % 10
        return check_num == int(j2[6])

    j1 = input("앞자리: ")
    j2 = input("뒷자리: ")
    if len(j1) == 6 and len(j2) == 7:
        if check_jumin(j1, j2): print("올바른 주민번호")
        else: print("타당성 검사 실패")
    else:
        print("자릿수 오류")

# [방법 3] 파이썬 실무 최적화 방식 (T3 대응)
def solution_37_t3():
    print("주민번호 판별 프로그램 (Optimized)")
    user_input = input("주민번호를 입력하세요 (예: 990101-1234567): ")

    # 1. 전처리 (숫자만 남기기)
    clean_jumin = re.sub(r'[^0-9]', '', user_input)

    if len(clean_jumin) != 13:
        return print("결과: 유효하지 않은 주민번호입니다. 자릿수를 확인하세요.")

    # 2. 가중치 연산 (Zip 활용)
    weights = [2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5]
    total = sum(int(n) * w for n, w in zip(clean_jumin[:12], weights))

    # 3. 공식 적용
    check_sum = (11 - (total % 11)) % 10

    if check_sum == int(clean_jumin[12]):
        print("결과: 올바른 주민번호입니다.")
    else:
        print("결과: 유효하지 않은 주민번호입니다.")

if __name__ == "__main__":
    # 실행 테스트
    # solution_37()
    # solution_37_t2()
    solution_37_t3()