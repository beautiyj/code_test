package task.kotlin3

// Vector 벡터 클래스
// vector 클래스는 동기화된 메소드로 구성되어 있어서 스레드에 안전
// 하지만 전부 동기화 되어있어서 무거움. 잘 안쓴다
// 요즘은 멀티스레드 방식으로 Collections.synchronizedList()나 CopyOnWriteArrayList 씀

import java.util.*

data class Board(           // 코틀린 실무: data class로 선언 (toString/equals/copy 자동 생성)
    val subject: String,
    val contect: String,
    val writer: String
)

fun main() {

    // 클래스 객체를 제네릭 처리. 여기선 Board 클래스로 만든 객체만 저장 가능.
    val list: MutableList<Board> = Vector()      // 업캐스팅

    list.add(Board("제목1", "내용1", "글쓴이1"))
    list.add(Board("제목2", "내용2", "글쓴이2"))
    list.add(Board("제목3", "내용3", "글쓴이3"))
    list.add(Board("제목4", "내용4", "글쓴이4"))
    list.add(Board("제목5", "내용5", "글쓴이5"))

    list.removeAt(2)
    list.removeAt(3)

    for (i in 0 until list.size) {
        val board: Board = list[i]
        println("${board.subject}\t${board.contect}\t${board.writer}")
    }

    // 코틀린 실무: for-in 루프로 간결하게 대체 가능
//  for (board in list) {
//      println("${board.subject}\t${board.contect}\t${board.writer}")
//  }
}