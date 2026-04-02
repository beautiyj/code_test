# 문자열 클래스 String
# 키보드로 주민번호를 입력 받아서 남녀 성별 판별하는 프로그램
# 단, 앞자리 6자리, 뒷자리 7자리 유효성 검사하기

# [방법 1] 기본 유효성 검사 및 성별 판별
def solution_basic():
    try:
        jumin1 = input("주민번호 앞자리를 입력하세요: ")
        jumin2 = input("주민번호 뒷자리를 입력하세요: ")

        g = jumin2[0:1] # 성별 판별용

        if not jumin1:
            print("주민번호 앞자리가 입력되지 않았습니다.")
        elif len(jumin1) != 6:
            print("주민번호 앞자리 6자리가 입력되지 않았습니다.")
        elif not jumin2:
            print("주민번호 뒷자리가 입력되지 않았습니다.")
        elif len(jumin2) != 7:
            print("주민번호 뒷자리 7자리가 입력되지 않았습니다.")
        elif g in ("1", "3"):
            print("남자")
        elif g in ("2", "4"):
            print("여자")
        else:
            print("서식 오류. 재입력하세요")
    except Exception as e:
        print(f"오류 발생: {e}")

# [방법 2] 생년월일 등까지 체크하는 예외처리 유효성검사라면
def solution_detail():
    try:
        jumin1 = input("주민번호 앞자리(6자리): ")
        jumin2 = input("주민번호 뒷자리(7자리): ")

        if len(jumin1) != 6:
            print("주민번호 앞자리 6자리가 아닙니다.")
        elif len(jumin2) != 7:
            print("주민번호 뒷자리 7자리가 아닙니다.")
        else:
            # int 변환 시 숫자가 아니면 ValueError 발생 (try-except로 처리)
            month = int(jumin1[2:4])
            day = int(jumin1[4:6])

            if not (1 <= month <= 12):
                print("서식 오류. 유효하지 않은 월입니다.")
            elif not (1 <= day <= 31):
                print("서식 오류. 유효하지 않은 일입니다.")
            else:
                g = jumin2[0]
                if g in ('1', '3'):
                    print("결과: 남자")
                elif g in ('2', '4'):
                    print("결과: 여자")
                else:
                    print("서식 오류. 성별 코드 오류입니다.")
    except ValueError:
        print("오류: 숫자만 입력 가능합니다.")
    except Exception:
        print("알 수 없는 오류 발생")

# [방법 3] 실무 방식 (초간결 간단하게 조건 충족)
def solution_pro():
    # 하이픈 포함 여부와 상관없이 숫자만 추출하여 판별
    jumin = input("주민번호 입력: ").replace("-", "")

    # Early Return 패턴: 조건 안 맞으면 바로 종료
    if len(jumin) != 13 or not jumin.isdigit():
        return print("잘못된 형식입니다.")

    # 성별 코드 위치(index 6) 확인 및 출력
    gender_code = jumin[6]
    mapping = {"1": "남", "3": "남", "2": "여", "4": "여"}
    print(f"결과: {mapping.get(gender_code, '오류')}")

if __name__ == "__main__":
    # 실행하고 싶은 함수를 호출하세요
    # solution_basic()
    # solution_detail()
    solution_pro()