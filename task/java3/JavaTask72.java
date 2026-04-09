package task.java3;

// 스택 클래스 - 기능 자체는 중요한데 무거워서 잘 안쓰고
// 요즘은 큐의 일종이면서도 스택의 기능까지 소화하는 양방향 자료구조인 ArrayDeque 위주로 사용함

// LIFO(Last Input First Output) 구조
// 마지막으로 입력된 자료가 가장 먼저 출력되는 구조

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.Stack;

public class JavaTask72 {
    public static void main(String[] args) {
        // 예제1

        // Stack 객체 생성
        Stack s = new Stack();
        System.out.println(s.empty());

        // Stack에 값을 넣음
        // push() 넣고 pop() 빼고
        s.push("gemini");
        Date d = new Date();
        s.push(d);
        s.push(10);
        s.push("johnharu");

        // Stack의 값을 출력
        System.out.println(s.empty());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.empty());
        System.out.println();


        // 예제2

        Stack myStack = new Stack();
        myStack.push("1-자바");
        myStack.push("2-C++");
        myStack.push("3-API");
        myStack.push("4-MFC");

        // 스택이 비어있으면 스택 비어있는 예외 뭐이런오류가 나서 체크 필요함
        while (!myStack.isEmpty()) {    // 비어있지 않으면
            System.out.println(myStack.pop());  // 값을 가져온다
        }

        System.out.println();

        // 스택 자체는 잘 쓰지 않고 ArrayDeque 사용 (더 빠름)
        // + 제네릭 <String>을 사용하여 문자열만 받도록 타입 안정성 확보
        Deque<String> stack = new ArrayDeque<>();

        // 데이터 push
        stack.push("1-자바");
        stack.push("2-C++");
        stack.push("3-API");
        stack.push("4-MFC");

        // 유효성 검사 (비어있지 않은지 확인) 후 반복 처리
        while (!stack.isEmpty()) {
            // peek()으로 확인하고 pop()으로 꺼내는 습관이 실무적입니다.
            System.out.println("현재 상단 데이터: " + stack.peek());
            System.out.println("꺼낸 데이터: " + stack.pop());
        }

    }
}

