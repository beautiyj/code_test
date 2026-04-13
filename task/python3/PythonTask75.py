# 콘솔로 게시판 만들기 - 실무 패턴 버전
# 보통은 인터페이스(ABC)로 규칙 -> 구현체에서 상속받아서 커스텀 제작
# from abc import ABC, abstractmethod
# class BoardService(ABC):
#     @abstractmethod
#     def write_article(self): pass
#     @abstractmethod
#     def list_articles(self): pass
# class BoardServiceImpl(BoardService):
#     def write_article(self): 로직 생략

from dataclasses import dataclass


# 코틀린 data class / Java @Builder @AllArgsConstructor @NoArgsConstructor 대응
@dataclass
class BoardVO75:
    register: str = ""
    subject: str = ""
    email: str = ""
    content: str = ""
    passwd: str = ""

    def __str__(self) -> str:
        return f"작성자:{self.register},이메일:{self.email},제목:{self.subject},글내용:{self.content}"


class BoardSVC75:
    def __init__(self):
        self.__board_list: list[BoardVO75] = []     # __ = Java private 대응

    def write_article(self):
        print("게시판에 글을 작성 하세요?")
        register = input("작성자:")
        email = input("이메일:")
        passwd = input("비밀번호:")
        subject = input("제목:")
        content = input("글내용:")
        self.__board_list.append(BoardVO75(register, subject, email, content, passwd))

    def list_articles(self):
        if not self.__board_list:
            print("등록된 글이 없습니다.")
            return
        for article in self.__board_list:
            print(article)

    def remove_article(self):
        if not self.__board_list:
            print("작성된 글이 존재하지 않습니다.")
            return
        print("저장할 글의 작성자와 비밀번호를 입력 하세요?")
        register = input("작성자:")
        passwd = input("비밀번호:")

        # removeIf 대응 - 조건 만족 항목 제거
        before = len(self.__board_list)
        self.__board_list = [a for a in self.__board_list
                             if not (a.register == register and a.passwd == passwd)]
        if len(self.__board_list) == before:
            print("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")

    def modify_article(self):
        if not self.__board_list:
            print("작성된 글이 존재하지 않습니다.")
            return
        print("수정할 글의 작성자와 비밀번호를 입력 하세요?")
        register = input("작성자:")
        passwd = input("비밀번호:")

        # find {} 대응 - next() + generator
        article = next((a for a in self.__board_list
                        if a.register == register and a.passwd == passwd), None)
        if article is None:
            print("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
            return
        article.subject = input("새 제목:")
        article.content = input("새 글내용:")
        print("글이 수정되었습니다.")

    def modify_pw(self):
        print("비밀번호 변경하기: 작성자와 비밀번호 입력 하세요?")
        register = input("작성자:")
        passwd = input("비밀번호:")

        article = next((a for a in self.__board_list
                        if a.register == register and a.passwd == passwd), None)
        if article is None:
            print("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
            return
        article.passwd = input("새 비밀번호:")
        print("비밀번호 수정되었습니다.")


if __name__ == "__main__":
    board_svc = BoardSVC75()

    while True:
        print("메뉴를 입력 하세요?")
        print("1.게시판 글쓰기")
        print("2.글 목록 보기")
        print("3.글 삭제")
        print("4.글 수정")
        print("5.비밀번호 변경")
        print("6.종료")

        menu = input()
        if menu == "6":
            break

        if   menu == "1": board_svc.write_article()
        elif menu == "2": board_svc.list_articles()
        elif menu == "3": board_svc.remove_article()
        elif menu == "4": board_svc.modify_article()
        elif menu == "5": board_svc.modify_pw()
        else: print("잘못된 메뉴입니다. 다시 입력해주세요.")