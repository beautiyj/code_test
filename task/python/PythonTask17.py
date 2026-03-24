import sys

def main():

# ============================================================================

    # 예제 1. 확장 for문
    score = [95, 71, 84, 93, 87]

    # 기본 for문의 경우 (인덱스 사용)
    total_sum = 0
    for i in range(len(score)):
        total_sum += score[i]
    print(total_sum)

    # 확장 for문의 경우 (파이썬의 기본 스타일)
    sum1 = 0
    for s in score:
        sum1 += s
    print(sum1)

# ============================================================================

    # 예제 2. 배열 복사
    old_array = [10, 20, 30]
    new_array = [0] * 5 # 크기 5인 리스트 초기화

    for i in range(len(old_array)):
        new_array[i] = old_array[i]

    for i in new_array:
        print(f"{i}\t", end="")
    print()

# ============================================================================

    # 예제 3. 사용자 정의 메소드를 활용한 문자열 숫자 변환, 절대값 구하기
    # 파이썬에서 sys.argv[0]은 파일명이므로 [1], [2]를 사용
    if len(sys.argv) >= 3:
        print(sys.argv[1])    # "-10"
        print(sys.argv[2])    # "-20"

        num = int(sys.argv[1])
        print(abs_func(num))

# 음수->양수 변환 절대값 구하기 메소드
def abs_func(data):
    if data < 0:
        data = -data
    return data

if __name__ == "__main__":
    main()