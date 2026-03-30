class Car27:
    def __init__(self):
        self.fuel_level = 0  # gas -> fuel_level (실무 추천 변수명)

    def set_fuel(self, fuel):
        self.fuel_level = fuel

    def is_left_fuel(self):
        if self.fuel_level == 0:
            print("gas가 없습니다")
            return False
        print("gas가 있습니다")
        return True

    def run(self):
        while True:
            if self.fuel_level > 0:
                print(f"gas잔량: {self.fuel_level}")
                self.fuel_level -= 1
            else:
                print(f"gas잔량: {self.fuel_level}")
                return

# Main execution
if __name__ == "__main__":
    my_car = Car27()
    my_car.set_fuel(5)

    gas_state = my_car.is_left_fuel()
    if gas_state:
        print("출발합니다")
        my_car.run()

    if my_car.is_left_fuel():
        print("gas를 주입할 필요가 없습니다")
    else:
        print("gas를 주입하세요")