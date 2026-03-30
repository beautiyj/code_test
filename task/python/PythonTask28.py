class Calculator:
    def plus(self, a, b):
        result = a + b
        return result

    def avg(self, x, y):
        total_sum = self.plus(x, y)  # sum -> total_sum (예약어 중복 피하기 위해 추천)
        result = total_sum / 2
        return result

    def execute(self):
        result = self.avg(7, 10)
        self.print_message(f"result: {result}")

    def print_message(self, message):  # println -> print_message (실무 추천)
        print(message)

# Main execution
if __name__ == "__main__":
    calculator = Calculator()
    calculator.execute()  # result: 8.5