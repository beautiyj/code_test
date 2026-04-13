# map 인터페이스 대응
# 파이썬 dict가 Java HashMap에 대응
# HashMap   -> dict               (스레드 비안전, 키/값 None 허용)
# Hashtable -> 거의 안씀          (파이썬 대응 없음, 필요시 threading.Lock + dict)
# TreeMap   -> dict + sorted()    (키 기준 자동정렬)
# Properties -> configparser      (설정파일 전용)

if __name__ == "__main__":

    # HashMap 객체 생성
    hm: dict = {}

    # 키와 데이터 쌍을 삽입
    hm["woman"] = "gemini"
    hm["man"] = "johnharu"
    hm["age"] = 10          # 파이썬은 박싱 불필요
    hm["city"] = "seoul"
    hm["city1"] = "seoul"
    hm["city"] = "busan"    # 키가 중복되면 밸루는 부산만 출력됨

    # dict에 있는 객체들을 출력
    print(hm)               # {'woman': 'gemini', 'man': 'johnharu', 'age': 10, 'city': 'busan', 'city1': 'seoul'}

    # 키 값만 출력
    print(list(hm.keys()))  # ['woman', 'man', 'age', 'city', 'city1']

    # 키를 이용해 해당 데이터를 출력
    print(hm.get("woman"))
    print(hm.get("city"))
    print(hm.get("city1"))
    print()

    # ------------------------------------------------------------------------------------------

    ht: dict[str, str] = {}

    # 해시 테이블에 키/데이터를 입력한다.
    ht["딸기"] = "StrawBerry"
    ht["사과"] = "Apple"
    ht["포도"] = "Grapes"

    # 방법1 - 키 알고 있을 때
    value: str | None = ht.get("포도")  # get()은 없으면 None 반환 (KeyError 방지)
    if value is not None:
        print(f"포도-> {value}")

    # 방법2 - 키 모를 때
    # Enumeration 대응 -> 파이썬 실무: items()로 키/값 동시 순회
    for k, v in ht.items():
        print(f"{k} : {v}")