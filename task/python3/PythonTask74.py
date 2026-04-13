# 콘솔로 게시판 만들기

from dataclasses import dataclass


# VO(Value Object) / DTO(Data Transfer Object) 클래스
@dataclass
class BoardVO:
    register: str
    subject: str
    email: str
    content: str
    passwd: str

    def __str__(self) -> str:
        return f"작성자:{self.register},이메일:{self.email},제목:{self.subject},글내용:{self.content}"


class BoardSVC:
    def __init__(self):
        self.board_list: list[BoardVO] = []

    # 글 입력 처리 메소드
    def write_article(self):
        print("게시판에 글을 작성 하세요?")
        register = input("작성자:")
        email = input("이메일:")
        passwd = input("비밀번호:")
        subject = input("제목:")
        content = input("글내용:")
        self.__add_article(BoardVO(register, subject, email, content, passwd))

    # 글 작성
    def __add_article(self, board_vo: BoardVO):
        self.board_list.append(board_vo)

    # 글목록 출력
    def list_articles(self):
        if self.board_list:
            for article in self.board_list:
                print(article)
        else:
            print("등록된 글이 없습니다.")

    # 글 삭제
    def remove_article(self):
        print("저장할 글의 작성자와 비밀번호를 입력 하세요?")
        register = input("작성자:")
        passwd = input("비밀번호:")

        if self.board_list:
            index = -1
            for i in range(len(self.board_list)):
                if self.board_list[i].register == register:
                    if self.board_list[i].passwd == passwd:
                        self.board_list.pop(i)
                        index = i
                        break
            if index == -1:
                print("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
        else:
            print("작성된 글이 존재하지 않습니다.")

    # 글 수정
    def modify_article(self):
        print("수정할 글의 작성자와 비밀번호 입력 하세요?")
        register = input("작성자:")
        passwd = input("비밀번호:")

        if self.board_list:
            index = -1
            for i in range(len(self.board_list)):
                if self.board_list[i].register == register and self.board_list[i].passwd == passwd:
                    index = i
            if index == -1:
                print("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
                return
            print("수정할 글의 제목과 내용을 입력 하세요?")
            self.board_list[index].subject = input("제목:")
            self.board_list[index].content = input("글내용:")
        else:
            print("작성된 글이 존재하지 않습니다.")

    # 게시글의 비밀번호 변경하기
    def modify_pw(self):
        print("비밀번호 변경하기: 작성자와 비밀번호 입력 하세요?")
        register = input("작성자:")
        passwd = input("비밀번호:")

        if self.board_list:
            index = -1
            for i in range(len(self.board_list)):
                if self.board_list[i].register == register and self.board_list[i].passwd == passwd:
                    index = i
            if index == -1:
                print("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
                return
            self.board_list[index].passwd = input("새 비밀번호:")
            print("비밀번호가 성공적으로 변경되었습니다.")
        else:
            print("작성된 글이 존재하지 않습니다.")


if __name__ == "__main__":
    board_svc = BoardSVC()
    is_stop = False

    while not is_stop:
        print("메뉴를 입력 하세요?")
        print("1.게시판 글쓰기")
        print("2.글 목록 보기")
        print("3.글 삭제")
        print("4.글 수정")
        print("5.종료")
        print("6.게시글 비밀번호 변경")

        menu = input()

        if   menu == "1": board_svc.write_article()
        elif menu == "2": board_svc.list_articles()
        elif menu == "3": board_svc.remove_article()
        elif menu == "4": board_svc.modify_article()
        elif menu == "6": board_svc.modify_pw()
        elif menu == "5": is_stop = True