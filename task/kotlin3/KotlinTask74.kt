package task.kotlin3

// 콘솔로 게시판 만들기

import java.util.*

// VO(Value Object) / DTO(Data Transfer Object) 클래스
// 코틀린 실무: data class = Java 게터/세터/생성자/toString 한번에 해결
data class BoardVO(
    var register: String,
    var subject: String,
    var email: String,
    var content: String,
    var passwd: String
) {
    override fun toString(): String {
        return "작성자:$register,이메일:$email,제목:$subject,글내용:$content"
    }
}

class BoardSVC {
    val boardList: MutableList<BoardVO> = mutableListOf()

    // 글 입력 처리 메소드
    fun writeArticle(sc: Scanner) {
        println("게시판에 글을 작성 하세요?")
        print("작성자:"); val register = sc.next()
        print("이메일:"); val email = sc.next()
        print("비밀번호:"); val passwd = sc.next()
        print("제목:"); val subject = sc.next()
        print("글내용:"); val content = sc.next()
        addArticle(BoardVO(register, subject, email, content, passwd))
    }

    // 글 작성
    private fun addArticle(boardVO: BoardVO) {
        boardList.add(boardVO)
    }

    // 글목록 출력
    fun listArticles() {
        if (boardList.isNotEmpty()) {
            boardList.forEach { println(it.toString()) }
        } else {
            println("등록된 글이 없습니다.")
        }
    }

    // 삭제할 글의 작성자 및 비밀번호 입력하는 메소드
    fun removeArticle(sc: Scanner) {
        println("저장할 글의 작성자와 비밀번호를 입력 하세요?")
        print("작성자:"); val register = sc.next()
        print("비밀번호:"); val passwd = sc.next()
        removeArticle(register, passwd)
    }

    // 글 삭제
    fun removeArticle(register: String, passwd: String) {
        if (boardList.isNotEmpty()) {
            var index = -1
            for (i in 0 until boardList.size) {
                if (boardList[i].register == register) {
                    if (boardList[i].passwd == passwd) {
                        boardList.removeAt(i)
                        index = i
                    }
                }
            }
            if (index == -1) {
                println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
                return
            }
        } else {
            println("작성된 글이 존재하지 않습니다.")
        }
    }

    // 글 수정
    fun modifyArticle(sc: Scanner) {
        println("수정할 글의 작성자와 비밀번호 입력 하세요?")
        print("작성자:"); val register = sc.next()
        print("비밀번호:"); val passwd = sc.next()

        if (boardList.isNotEmpty()) {
            var index = -1
            for (i in 0 until boardList.size) {
                if (boardList[i].register == register && boardList[i].passwd == passwd) {
                    index = i
                }
            }
            if (index == -1) {
                println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
                return
            } else {
                println("수정할 글의 제목과 내용을 입력 하세요?")
                print("제목:"); val subject = sc.next()
                print("글내용:"); val content = sc.next()
                boardList[index].subject = subject
                boardList[index].content = content
            }
        } else {
            println("작성된 글이 존재하지 않습니다.")
        }
    }

    // 게시글의 비밀번호 변경하기
    fun modifyPw(sc: Scanner) {
        println("비밀번호 변경하기: 작성자와 비밀번호 입력 하세요?")
        print("작성자:"); val register = sc.next()
        print("비밀번호:"); val passwd = sc.next()

        if (boardList.isNotEmpty()) {
            var index = -1
            for (i in 0 until boardList.size) {
                if (boardList[i].register == register && boardList[i].passwd == passwd) {
                    index = i
                }
            }
            if (index == -1) {
                println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.")
                return
            } else {
                print("새 비밀번호:"); val newPasswd = sc.next()
                boardList[index].passwd = newPasswd
                println("비밀번호가 성공적으로 변경되었습니다.")
            }
        } else {
            println("작성된 글이 존재하지 않습니다.")
        }
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val boardSVC = BoardSVC()
    var isStop = false

    do {
        println("메뉴를 입력 하세요?")
        println("1.게시판 글쓰기")
        println("2.글 목록 보기")
        println("3.글 삭제")
        println("4.글 수정")
        println("5.종료")
        println("6.게시글 비밀번호 변경")

        when (sc.next()) {
            "1" -> boardSVC.writeArticle(sc)
            "2" -> boardSVC.listArticles()
            "3" -> boardSVC.removeArticle(sc)
            "4" -> boardSVC.modifyArticle(sc)
            "6" -> boardSVC.modifyPw(sc)
            "5" -> isStop = true
        }
    } while (!isStop)
}