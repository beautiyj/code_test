import random
from datetime import datetime

# 날짜 포맷팅 (strftime 사용)
now = datetime.now()
print(f"기본 출력: {now}")
print(f"포맷 결과: {now.strftime('%Y-%m-%d %H:%M:%S')}")

# 난수 (1~45 포함)
num = random.randint(1, 45)

# 입력
name = input("이름을 입력하세요: ")