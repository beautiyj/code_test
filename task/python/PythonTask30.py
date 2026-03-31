import random

class Lotto:
    def is_true(self, result, count, num):
        for i in range(count):
            if result[i] == num:
                return True
        return False

    def lotto(self):
        result = [0] * 6
        count = 0
        while count < 6:
            num = random.randint(1, 45)
            # 중복이 아닐 때(!is_true) 넣는 것으로 논리 교정
            if not self.is_true(result, count, num):
                result[count] = num
                count += 1
        result.sort()
        return result

# 파이썬의 set(집합) 사용하면 더 간략하게 사용 가능.
# 기본적으로 set 자료구조는 중복을 허용하지 않아서 더 간단함.
def get_lotto_numbers():
    numbers = set()
    while len(numbers) < 6:
        numbers.add(random.randint(1, 45))
    return sorted(list(numbers))

if __name__ == "__main__":
    lotto_obj = Lotto()
    print(lotto_obj.lotto())
    print(get_lotto_numbers())