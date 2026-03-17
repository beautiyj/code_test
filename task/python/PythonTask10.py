from datetime import datetime

# 현재 날짜와 시간 가져오기
now = datetime.now()

# 요일 가공을 위한 리스트
week = ["월", "화", "수", "목", "금", "토", "일"]
day = week[now.weekday()] # 0:월, 1:화 ... 6:일

# 출력 방식 1: f-string 활용
print(f"오늘 날짜: {now.year}년 {now.month}월 {now.day}일 ({day}요일)")
print(f"현재 시간: {now.hour}시 {now.minute}분 {now.second}초")

# 출력 방식 2: strftime 활용 (더 전문적인 방식)
# print(now.strftime("%Y-%m-%d %H:%M:%S"))