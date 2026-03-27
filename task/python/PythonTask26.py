from dataclasses import dataclass


# [버전 1: 학습용] 일반적인 클래스 정의
class CarClass:
    def __init__(self, model=None, color=None, maxSpeed=0):
        self.company = "현대자동차"
        self.model = model
        self.color = color
        self.maxSpeed = maxSpeed

# [버전 2: 실무용] @dataclass 활용
@dataclass
class RealWorldCar:
    company: str = "현대자동차"
    model: str = "모델 미정"
    color: str = "색상 미정"
    max_speed: int = 0

if __name__ == "__main__":
    # --- 버전 1 테스트 ---
    car1 = CarClass()
    print(f"학습용 car1.company: {car1.company}\n")

    # --- 버전 2 테스트 (실무형) ---
    print("--- 실무용(Dataclass) 테스트 ---")
    # 키워드 인자로 필요한 데이터만 주입
    real_car = RealWorldCar(model="그랜저", max_speed=220)
    print(real_car) # 자동으로 데이터 내용 출력

    # 실무에선 asdict() 등을 써서 JSON 변환을 쉽게 합니다.
    from dataclasses import asdict
    print(f"JSON 변환용: {asdict(real_car)}")