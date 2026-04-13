"""
키보드를 통해서 각 회원들의 정보를 입력받는 클래스(MemberInput)를 작성한다.
이때 입력받는 회원의 정보는 성명, 나이, 이메일, 주소를 입력받는다.
그리고 키보드로 입력한 회원의 정보는 새로운 회원정보를 저장하는
클래스(MemberInfo)의 멤버변수에 저장시킨 후 출력하는 프로그램을 작성하시오.
"""

from dataclasses import dataclass   # @Getter @Setter + 생성자 대응


# DTO
# 파이썬 실무: @dataclass = Java @Getter @Setter + 생성자 한번에 해결
@dataclass
class MemberInput73:
    name: str
    age: int
    email: str
    address: str


if __name__ == "__main__":
    members: list[MemberInput73] = []

    # 파이썬은 try-with-resources 없음. input()은 자동 관리됨
    while True:
        name = input("성명: ")

        # 하단 유효성 검사를 위해 1차 문자열로 입력받음
        age_str = input("나이: ")
        email = input("이메일: ")
        address = input("주소: ")

        # 유효성 검사 - 하나라도 비어있으면 재입력 요청
        if any(v == "" for v in [name, age_str, email, address]):
            print("모든 회원 정보를 입력해주세요")
            continue

        # 유효성 검사 후 정수 변환
        age = int(age_str)

        # 생성자 방식으로 추가 (dataclass라 간결)
        members.append(MemberInput73(name, age, email, address))

        print("y/n")
        user_input = input().lower()

        if user_input == "n":
            break

    # forEach 포맷팅 출력
    for m in members:
        print(f"성명: {m.name}\t나이: {m.age}\t이메일: {m.email}\t주소: {m.address}")

        """
        | Java                              | Kotlin                          | Python                          | 이유                                                             |
|-----------------------------------|---------------------------------|---------------------------------|------------------------------------------------------------------|
| hm.put(key, value)                | hm[key] = value                 | hm[key] = value                 | 코틀린/파이썬 모두 [] 연산자로 간결하게                            |
| try(Scanner sc = ...) {}          | Scanner(...).use { sc -> }      | input() 자동 관리               | 코틀린 use{} = Java try-with-resources 대응                      |
| if (result==0) else if ...        | when (result) { 0 -> ... }      | if / elif                       | 코틀린 when = Java switch/if-else 대응, 더 간결                   |
| LinkedList (Queue)                | ArrayDeque (코틀린 표준)         | collections.deque               | 실무 표준 큐 자료구조                                             |
| Stack (무거움, 비추)               | ArrayDeque.addLast/removeLast   | list.append/pop 또는 deque      | Stack 대신 ArrayDeque/deque 실무 표준                            |
| offer() / poll() / peek()         | addLast() / removeFirst() / last() | append() / popleft() / [-1]  | 각 언어별 큐/스택 메서드명 차이                                    |
| @Getter @Setter (Lombok)          | data class                      | @dataclass                      | 생성자+게터세터 자동생성, 실무 DTO 표준 패턴                       |
| Integer.parseInt(str)             | str.toInt()                     | int(str)                        | 문자열 → 정수 변환                                               |
| list.stream().anyMatch(...)       | list.any { ... }                | any(... for v in list)          | 컬렉션 하나라도 조건 만족 시 true 반환                            |
        
        """