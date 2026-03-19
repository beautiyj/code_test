# 1. 과일 개수 세기 (데이터 카운팅)
print("--- 1. 과일 개수 세기 ---")
inventory = {"사과": 5, "바나나": 10, "포도": 3}

print(f"사과 재고: {inventory['사과']}개")
print(f"전체 자판기 상태: {inventory}")
print()


# 2. 학생 성적 관리 (데이터 매핑)
print("--- 2. 학생 성적 관리 ---")
scores = {"철수": 90, "영희": 100, "민수": 85}

target = "영희"
print(f"{target}의 점수: {scores[target]}점")