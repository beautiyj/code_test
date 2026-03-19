# 파이썬은 별도의 import 없이 기본 input() 사용

print("점수를 입력해주세요.")
n = int(input())
print("점수를 입력해주세요.")
m = int(input())

# 고정값의 경우
match n:
    case 90:
        print("A학점")
    case 80:
        print("B학점")
    case 70:
        print("C학점")
    case 60:
        print("D학점")
    case _: # 자바의 default와 동일
        print("F학점")

# 범위 판별 (조건식 활용)
# 파이썬은 case n if 조건식: 형태로 사용 가능. 자바와 달리 조건식 사용이 가능하다.
match m:
    case val if val >= 90:
        print("A학점")
    case val if val >= 80:
        print("B학점")
    case val if val >= 70:
        print("C학점")
    case val if val >= 60:
        print("D학점")
    case _:
        print("F학점")