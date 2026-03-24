# 2차원 배열 [][] 행(세로)과 열(가로)

# 예제 1. 이차원 배열에 5명 학생의 3과목 점수를 각기 입력했을 때
#       각 학생들의 점수를 정돈하여 출력하기 (행렬처럼)
score = [[0] * 3 for _ in range(5)]

score[0][0]=85;  score[0][1]=60;  score[0][2]=70
score[1][0]=90;  score[1][1]=95;  score[1][2]=80
score[2][0]=75;  score[2][1]=80;  score[2][2]=100
score[3][0]=80;  score[3][1]=70;  score[3][2]=95
score[4][0]=100; score[4][1]=65;  score[4][2]=80

for row in range(5):
    for col in range(3):
        print(f" {score[row][col]}", end="")
    print()

#=============================================================================

# 예제 2. 이차원 배열이 주어졌을 때, 각 과목별 총점과 학생별 총점 구하기
#        이것도 다른 예제에 비슷한 거 있는데 키보드로 입력받냐 아니냐의 차이임

scores = [
    [85, 60, 70],
    [90, 95, 80],
    [75, 80, 100],
    [80, 70, 95],
    [100, 65, 80]
]

subject = [0] * 3
student = [0] * 5

print("각 과목별 총점구하기 ")
for c in range(3):
    for r in range(5):
        subject[c] += scores[r][c]
    print(subject[c])

print("학생별 총점구하기")
for r in range(5):
    for c in range(3):
        student[r] += scores[r][c]
    print(student[r])