"""
중첩 for문을 활용해 주어진 배열의 전체 항목 합, 평균값 구하기 (+2차원 배열)

주어진 배열은 다음과 같다.

int[][] array = {
    {95,86},
    {83,92,96},
    {78,83,93,87,88}
};

"""

array = [
    [95, 86],
    [83, 92, 96],
    [78, 83, 93, 87, 88]
]

sum_val = 0
count = 0

for row in array:           # i 루프 (행)
    for item in row:        # j 루프 (열)
        sum_val += item     # 누적 합계
        count += 1          # 데이터 개수 카운트

avg = sum_val / count       # 평균 구하기

print(sum_val)
print(avg)

"""
플래튼 방식 사용하면 간편함

array = [[95, 86], [83, 92, 96], [78, 83, 93, 87, 88]]

# 2차원을 1차원으로 쫙 펴버리기 (Flatten방식. 파이썬엔 따로 함수가 없기땜시)
flat_list = [item for row in array for item in row]

# 펴진 리스트에서 바로 합계와 평균 구하기
total_sum = sum(flat_list)
avg = total_sum / len(flat_list)

print(f"sum: {total_sum}, avg: {avg}")
"""