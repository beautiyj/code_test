# Map 예제
# 잘 안쓰는 방식 - Hashtable 활용 (파이썬 대응 없음, dict로 대체)
# 잘 쓰는 건 HashMap -> 파이썬 dict

# 잘 안쓰는 방식 - Hashtable 활용
class HashtableEx:
    def __init__(self):
        self.map: dict[str, str] = {}

    def hashtable_key_value(self):
        self.map["spring"] = "12"
        self.map["summer"] = "123"
        self.map["fall"] = "1234"
        self.map["winter"] = "12345"

    def hashtable_method(self):
        self.hashtable_key_value()

        while True:
            print("아이디와 비밀번호를 입력해주세요")
            id_ = input("아이디: ")         # id는 파이썬 내장함수명이라 id_ 사용
            pw = input("비밀번호: ")

            if id_ in self.map:
                if self.map[id_] == pw:
                    print("로그인 성공")
                    break
                else:
                    print("비밀번호가 일치하지 않습니다")
            else:
                print("입력하신 아이디가 존재하지 않습니다")


class HashTableTest02:
    def hash_table_test02(self):
        ht: dict[str, str] = {
            "사과": "Apple",
            "딸기": "StrawBerry",
            "포도": "Grapes"
        }

        # 키 알고 있을 때
        value = ht.get("포도")
        if value is not None:
            print(f"포도-> {value}")

        # 키 모를 때 - items()로 순회 (Enumeration 대응)
        for k, v in ht.items():
            print(f"{k} : {v}")


# 잘 쓰는 건 HashMap -> dict
class HashMapKeyValue:
    def __init__(self):
        self.__hash_map: dict[str, str] = {     # __ = Java private 대응
            "spring": "12",
            "summer": "123",
            "fall": "1234",
            "winter": "12345"
        }

    def hash_map_method(self, user_id: str, user_password: str) -> int:
        if user_id not in self.__hash_map:
            return 1
        if self.__hash_map[user_id] != user_password:
            return 2
        return 0


# --------------------------------------------------------------------------------------------

if __name__ == "__main__":

    # 1. Hashtable 예제 실행
    print("Hashtable 사용 예제")
    hashtable_ex = HashtableEx()
    hashtable_ex.hashtable_method()

    print("------------------------------------------------------")

    # 2. HashMap 예제 실행
    print("HashMap 사용 예제")
    hash_map_ex = HashMapKeyValue()

    # 파이썬은 try-with-resources 없음. input()은 자동 관리됨
    while True:
        print("[HashMap 로그인]")
        print("아이디와 비밀번호를 입력해주세요")
        user_id = input("아이디: ")
        user_password = input("비밀번호: ")

        result = hash_map_ex.hash_map_method(user_id, user_password)

        if result == 0:
            print("로그인 성공")
            break
        elif result == 1:
            print("입력하신 아이디가 존재하지 않습니다")
        else:
            print("비밀번호가 일치하지 않습니다")

    print("------------------------------------------------------")

    # 3. HashTable 열거형 예제 실행
    hash_table_test02 = HashTableTest02()
    hash_table_test02.hash_table_test02()