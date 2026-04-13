package task.kotlin3

// 콘솔로 게시판 만들기 - 실무 패턴 버전
/* 보통은 인터페이스로 규칙 -> 구현체에서 상속받아서 커스텀 제작
interface BoardService {
    fun writeArticle(sc: Scanner)
    fun listArticles()
    fun removeArticle(sc: Scanner)
    fun modifyArticle(sc: Scanner)
}
class BoardServiceImpl : BoardService {
    private val boardList: MutableList<BoardVO75> = mutableListOf()
    override fun writeArticle(sc: Scanner) { 로직 생략 }
    override fun listArticles() { 로직 생략 }
    // 실행부: 인터페이스 타입으로 변수 선언 (다형성)
    val boardService: BoardService = BoardServiceImpl()
}
*/

import java.util.*

// 코틀린 실무: data class = Java @Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor 한번에 해결
data class BoardVO75(
    var register: String = "",
    var subject: String = "",
    var email: String = "",
    var content: String = "",
    var passwd: String = ""
) {
    override fun toString(): String {
        return "작성자:$register,이메일:$email,제목:$subject,글내용:$content"
    }
}

class BoardSVC75 {
    private val boardList: MutableList<BoardVO75> = mutableListOf()

    fun writeArticle(sc: Scanner) {
        println("게시판에 글을 작성 하세요?")
        print("작성자:"); val register = sc.next()
        print("이메일:"); val email = sc.next()
        print("비밀번호:"); val passwd = sc.next()
        print("제목:"); val subject = sc.next()
        print("글내용:"); val content = sc.next()
        boardList.add(BoardVO75(register, subject, email, content, passwd))
    }

    fun listArticles() {
        if (boardList.isEmpty()) {
            println("등록된 글이 없습니다.")
            return
        }
        boardList.forEach { println(it) }
    }

    fun removeArticle(sc: Scanner) {
        if (boardList.isEmpty()) {
            println("작성된 글이 존재하지 않습니다.")
            return
        }
        println("저장할 글의 작성자와 비밀번호를 입력 하세요?")
        print("작성자:"); val register = sc.next()
        print("비밀번호:"); val passwd = sc.next()

        // removeIf 대응 - 코틀린 실무
        val removed = boardList.removeIf { it.register == register && it.passwd == passwd }
        if (!removed) println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
    }

    fun modifyArticle(sc: Scanner) {
        if (boardList.isEmpty()) {
            println("작성된 글이 존재하지 않습니다.")
            return
        }
        println("수정할 글의 작성자와 비밀번호를 입력 하세요?")
        print("작성자:"); val register = sc.next()
        print("비밀번호:"); val passwd = sc.next()

        // find {} = Java stream().filter().findFirst() 대응
        val article = boardList.find { it.register == register && it.passwd == passwd }
        if (article == null) {
            println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
            return
        }
        print("새 제목:"); article.subject = sc.next()
        print("새 글내용:"); article.content = sc.next()
        println("글이 수정되었습니다.")
    }

    fun modifyPw(sc: Scanner) {
        println("비밀번호 변경하기: 작성자와 비밀번호 입력 하세요?")
        print("작성자:"); val register = sc.next()
        print("비밀번호:"); val passwd = sc.next()

        val article = boardList.find { it.register == register && it.passwd == passwd }
        if (article == null) {
            println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
            return
        }
        print("새 비밀번호:"); article.passwd = sc.next()
        println("비밀번호 수정되었습니다.")
    }
}

fun main() {
    val boardSVC = BoardSVC75()

    Scanner(System.`in`).use { sc ->        // use {} = Java try-with-resources 대응
        while (true) {
            println("메뉴를 입력 하세요?")
            println("1.게시판 글쓰기")
            println("2.글 목록 보기")
            println("3.글 삭제")
            println("4.글 수정")
            println("5.비밀번호 변경")
            println("6.종료")

            val menu = sc.next()
            if (menu == "6") break

            when (menu) {
                "1" -> boardSVC.writeArticle(sc)
                "2" -> boardSVC.listArticles()
                "3" -> boardSVC.removeArticle(sc)
                "4" -> boardSVC.modifyArticle(sc)
                "5" -> boardSVC.modifyPw(sc)
                else -> println("잘못된 메뉴입니다. 다시 입력해주세요.")
            }
        }
    }
}