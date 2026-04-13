# 제네릭<>을 활용한 리스트 예제
# 파이썬은 타입 힌트로 제네릭 효과를 표현

if __name__ == "__main__":

    # generic 제네릭: 한 가지 자료형의 데이터만 저장하도록 만들어주는 기능
    # 파이썬은 list[str] 타입 힌트로 의도 명시 (실제 강제는 아님)
    list_data: list[str] = []

    list_data.append("Java")
    list_data.append("JDBC")
    list_data.append("Servlet/JSP")
    print(f"현재 리스트: {list_data}")
    list_data.insert(2, "Database")     # insert(index, value) = Java list.add(index, value)
    print(f"현재 리스트: {list_data}")
    list_data.append("iBATIS")
    print(f"현재 리스트: {list_data}")
    print()
    print("-----------------------------------------------------------")

    size: int = len(list_data)
    print(f"총 객체 수: {size}")

    # 타입 힌트로 str 지정했으므로 바로 꺼낼 수 있음 (다운캐스팅 불필요)
    skill: str = list_data[2]
    print(f"2: {skill}")
    print()
    print("-----------------------------------------------------------")

    for i in range(len(list_data)):
        str_val: str = list_data[i]
        print(f"{i}: {str_val}")
    print()
    print("-----------------------------------------------------------")

    list_data.pop(2)        # 2번 인덱스 객체 삭제 (Database) - pop(index) = Java remove(index)
    print(f"2번 인덱스 Database 삭제 후 변경됨: {list_data[2]}")

    list_data.pop(2)        # 2번 인덱스 객체 삭제 (Servlet/JSP)
    print(f"2번 인덱스 Servlet/JSP 삭제 후 변경됨: {list_data[2]}")
    print(f"현재 리스트: {list_data}")

    list_data.remove("iBATIS")      # 값으로 삭제 = Java remove("iBATIS")
    print(f"iBATIS 데이터 삭제, 현재 리스트: {list_data}")
    print()
    print("-----------------------------------------------------------")

    for i in range(len(list_data)):
        str_val: str = list_data[i]
        print(f"{i}: {str_val}")