# 역순출력
# 학생들의 점수 배열을 뒤에서부터 하나씩 출력할 때

# python

print("기본 정석 출력 시\n")

scores = [80, 90, 100]

for i in range(len(scores)-1,-1,-1):
    print("인덱스 %d번 점수: %s"%(i, scores[i]))


print("\n리버스 내장함수 사용\n")

for score in reversed(scores):
    print(score)

print("\n슬라이싱 사용\n")

for score in scores[::-1]:    # 순서대로는 [:] = [::] = [::1]
    print(score)


"""
** 출력 결과 **
기본 정석 출력 시

인덱스 2번 점수: 100
인덱스 1번 점수: 90
인덱스 0번 점수: 80

리버스 내장함수 사용

100
90
80

슬라이싱 사용

100
90
80
"""