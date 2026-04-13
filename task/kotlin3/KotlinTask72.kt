package task.kotlin3

// 스택 클래스 - 기능 자체는 중요한데 무거워서 잘 안쓰고
// 요즘은 큐의 일종이면서도 스택의 기능까지 소화하는 양방향 자료구조인 ArrayDeque 위주로 사용함
// LIFO(Last Input First Output) 구조
// 마지막으로 입력된 자료가 가장 먼저 출력되는 구조

import java.util.Date
import java.util.Stack
import kotlin.collections.ArrayDeque
import kotlin.collections.isNotEmpty

fun main() {

    // 예제1
    // Stack 객체 생성
    val s: Stack<Any> = Stack()
    println(s.empty())

    // Stack에 값을 넣음
    // push() 넣고 pop() 빼고
    s.push("gemini")
    s.push(Date())
    s.push(10)
    s.push("johnharu")

    // Stack의 값을 출력
    println(s.empty())
    println(s.peek())
    println(s.pop())
    println(s.pop())
    println(s.pop())
    println(s.pop())
    println(s.empty())
    println()

    // 예제2
    val myStack: Stack<Any> = Stack()
    myStack.push("1-자바")
    myStack.push("2-C++")
    myStack.push("3-API")
    myStack.push("4-MFC")

    // 스택이 비어있으면 EmptyStackException 발생하므로 체크 필요
    while (!myStack.isEmpty()) {        // 비어있지 않으면
        println(myStack.pop())          // 값을 가져온다
    }

    println()

    // 스택 자체는 잘 쓰지 않고 ArrayDeque 사용 (더 빠름)
    // 코틀린 ArrayDeque는 표준 라이브러리 내장 (java.util 불필요)
    val stack: ArrayDeque<String> = ArrayDeque()

    // 데이터 push
    stack.addLast("1-자바")             // push() 대응
    stack.addLast("2-C++")
    stack.addLast("3-API")
    stack.addLast("4-MFC")

    // 유효성 검사 후 반복 처리
    while (stack.isNotEmpty()) {
        // peek()으로 확인하고 pop()으로 꺼내는 습관이 실무적
        println("현재 상단 데이터: ${stack.last()}")        // peek() 대응
        println("꺼낸 데이터: ${stack.removeLast()}")       // pop() 대응
    }
}