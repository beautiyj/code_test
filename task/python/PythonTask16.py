# 배열
def main():
    # 배열 형식 1. 배열에 저장될 값이 정해지지 않은 경우 (자료형에 따른 초기화)
    # 파이썬은 고정 크기 배열 대신 리스트를 사용.
    scores = [0] * 3
    print(scores[0])      # 0        파이썬은 수동으로 0 채움
    scores[0] = 10
    print(scores[0])      # 10

    d = [0.0] * 3
    print(d[0])           # 0.0      자동 0.0으로 초기화

    c = ['\x00'] * 3      # char형 - 파이썬은 널문자나 빈 문자열로 채움.
    print(c[0])           # null이나 빈 문자열

    b = [False] * 3
    print(b[0])           # False    자동으로 False초기화

    str_arr = [None] * 3  # 참조형은 대문자로 시작 (기본값 None)
    print(str_arr[0])     # None     자동으로 None으로 초기화
    print()


    # 배열 형식 2. 배열 선언과 동시에 초기화하는 경우 (배열에 할당될 값 정해진 게 대다수)
    s = [80, 90, 100]
    print("배열 크기: " + str(len(s)))
    for i in range(len(s)):
        print(str(s[i]) + "\t")
    print()

    dd = [3.14, 10.5, 42.195, 50]
    for i in range(len(dd)):
        print(str(dd[i]) + "\t")

    cc = ['j', 'a', 'v', 'a', 'c', 'd']
    for i in range(len(cc)):
        print(str(cc[i]) + "\t")

    bb = [True, False, True]
    for i in range(len(bb)):
        print(str(bb[i]) + "\t")

    str1 = ["aa", "bb", "cc", "dd"]
    for i in range(len(str1)):
        print(str1[i] + "\t")
    print()

# ============================================================================

    # 예제1 - 점수의 평균값을 소수점 둘째 자리까지 출력하기
    print("예제1")
    score = [83, 90, 87]

    # sum은 파이썬 내장함수이므로 total_sum으로 변수명 지정
    total_sum = 0
    for i in range(len(score)):
        total_sum += score[i]

    avg = total_sum / 3.0
    print("총합: " + str(total_sum) + " 평균: " + str(avg))
    print(f"총합: {total_sum}, 평균: {avg:.2f}")
    print()

# ============================================================================

    # 예제2 - 키보드로 5과목 점수 입력받아 총점 & 평균 구하기
    print("예제2")
    subject_scores = [0] * 5
    print("5과목 점수 입력하기")

    sum2 = 0
    for i in range(len(subject_scores)):
        subject_scores[i] = int(input(f"{i + 1}번째 점수 입력: "))
        sum2 += subject_scores[i]

    avg2 = sum2 / len(subject_scores)
    print(f"총점: {sum2}, 평균: {avg2:.2f}")
    print()

# ============================================================================

    # 예제3 - 배열에 저장된 데이터 중 최대 최소 구하기 (실수 ver)
    print("예제3")
    data = [9.5, 7.0, 13.6, 7.5, 10.5]

    # max, min은 파이썬 기본 함수와 이름이 겹치므로 뒤에 _val 작성
    max_val = data[0]
    min_val = data[0]

    for i in range(len(data)):
        if data[i] > max_val:
            max_val = data[i]
        if data[i] < min_val:
            min_val = data[i]

    print(max_val)
    print(min_val)
    print()

# ============================================================================

    # 예제4. 사용자 정의 메소드를 활용하여 누적합계 구하기
    print("예제4")
    sss = [83, 90, 87]

    # 기본 for문으로 구하면 이거고
    sum1 = 0
    for i in range(len(sss)):
        sum1 += sss[i]
    print(sum1)

    # 사용자 정의 메소드 add를 사용하는 경우
    sum22 = add([83, 90, 87])
    print(sum22)

# 사용자 정의 메소드
def add(sss):
    sum = 0
    for i in range(3):
        sum += sss[i]
    return sum

if __name__ == "__main__":
    main()