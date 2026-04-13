# 컬렉션 인터페이스 - Collection set 인터페이스
# 중복을 허가하지 않아서 데이터 중복 판별에 쓰는 인터페이스

from datetime import datetime

if __name__ == "__main__":

    # 파이썬 set은 중괄호{} 또는 set()으로 생성
    # set()이 Java HashSet에 대응
    hs: set = set()

    # hs 객체에 데이터 객체 보관
    hs.add("gemini")
    hs.add("johnharu")
    hs.add(datetime.now())  # Java의 new Date() 대응

    # hs 객체가 보관하고 있는 데이터 객체 출력
    print(f"hs의 내용 : {hs}")

    # "johnharu" 데이터 객체를 hs 객체에서 제거
    hs.discard("johnharu")  # 실무: discard() - 없는 값 제거해도 오류 없음 (remove()는 오류 발생)
    print(f"hs의 내용 : {hs}")

    # hs 객체에 있는 데이터 객체의 갯수를 출력
    print(f"hs의 데이터 갯수{len(hs)}")