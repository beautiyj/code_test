# Vector 벡터 클래스 대응
# 파이썬은 Vector 없음 -> 스레드 안전이 필요하면 queue.Queue 또는 list + threading.Lock 사용
# 입문용: 일반 list로 대응, 실무용: dataclass 활용

from dataclasses import dataclass   # 실무: dataclass = Java의 data class / Lombok @Data 대응


@dataclass
class Board:
    subject: str
    contect: str
    writer: str


if __name__ == "__main__":

    # 클래스 객체를 타입 힌트로 제네릭 처리. Board 객체만 저장하는 의도 명시.
    list_board: list[Board] = []    # 파이썬 list = Java Vector/ArrayList 대응

    list_board.append(Board("제목1", "내용1", "글쓴이1"))
    list_board.append(Board("제목2", "내용2", "글쓴이2"))
    list_board.append(Board("제목3", "내용3", "글쓴이3"))
    list_board.append(Board("제목4", "내용4", "글쓴이4"))
    list_board.append(Board("제목5", "내용5", "글쓴이5"))

    list_board.pop(2)
    list_board.pop(3)

    for i in range(len(list_board)):
        board: Board = list_board[i]
        print(f"{board.subject}\t{board.contect}\t{board.writer}")

    # 파이썬 실무: for-in 루프로 간결하게 대체 가능
    # for board in list_board:
    #     print(f"{board.subject}\t{board.contect}\t{board.writer}")