"""
6. 2차원 배열을 이용해 5명 학생들의 국어, 영어, 수학 점수를 저장했을 때 과목별 총점과 학생별 총점을 출력하는 프로그램

조건: 과목명(국어, 영어, 수학)과 학생번호 출력
"""

subjects = ["Korean", "English", "Math"]
scores = []

for i in range(5):
    print(f"{i+1}번 학생 점수 입력하기")
    student_scores=[]   #입력받은 점수를 배열화
    for j in range(3):
        score = int(input(f"{subjects[j]}: "))
        student_scores.append(score)
    scores.append(student_scores)   #2차원 배열 조립하기

print("Total Score (Student)")
for i in range(len(scores)):
    student_total = sum(scores[i])
    print(f"Student No.{i+1}: {student_total}")

print("Total Score (Subject)")
for j in range(3):
    score_total = 0
    for i in range(5):
        score_total += scores[i][j]
    print(f"Subject {subjects[j]}: {score_total}")