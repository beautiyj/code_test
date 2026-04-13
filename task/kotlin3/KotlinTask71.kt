package task.kotlin3

// 큐(Queue) 인터페이스
// 순수하게 순서대로만 처리할 때는 LinkedList, 우선순위가 중요한 스케줄링에선 PriorityQueue
// 가장 많이 쓰이는 멀티스레드의 블로킹 계열 ArrayBlockingQueue / LinkedBlockingQueue
// 큐는 FIFO(First Input First Output) 구조임.
// 먼저 입력된 자료가 먼저 출력되는 구조, offer() 넣고 poll() 뺀다

import java.util.*

fun main() {

    val myQue: Queue<Any> = LinkedList()        // 업캐스팅

    myQue.offer("1-자바")
    myQue.offer("2-C++")
    myQue.offer("3-API")
    myQue.offer("4-MFC")

    // peek()는 데이터 사라지지 않고 체크만 하는 거. 유효성 검사용
    // poll()은 데이터를 완전 꺼내옴
    while (myQue.peek() != null)                // 큐가 비어있지 않다면
        println(myQue.poll())                   // 큐에서 데이터를 꺼내온다.

    // 코틀린 실무: ArrayDeque 사용 (Queue 대응, 더 빠름)
//  val myQue2: ArrayDeque<String> = ArrayDeque()
//  myQue2.addLast("1-자바")    // offer() 대응
//  while (myQue2.isNotEmpty()) println(myQue2.removeFirst())  // poll() 대응
}