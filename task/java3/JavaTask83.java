package task.java3;

// 스레드 생명주기
class ThreadLife implements Runnable {
    public static void main(String[] args) {
        ThreadLife tl = new ThreadLife();

        // 첫 번째 Thread 생성
        Thread first = new Thread(tl, "first1");
        // 두 번째 Thread 생성
        Thread second = new Thread(tl, "second1");
        // 세 번째 Thread 생성
        Thread third = new Thread(tl, "third1");

        second.start();     // 실행 가능한 상태: run() 메소드가 호출됨
        first.start();
        third.start();
    }

    // 실제 실행될 로직
    @Override
    public void run() {
        for (int i = 1; i < 21; i++) {
            // thread의 이름과 정수 출력
            System.out.println(Thread.currentThread().getName() +
                    " number = " + i);
        }
    }
}

public class JavaTask83 {
    public static void main(String[] args) {
        // 스레드 메뉴얼 설정(객체 생성하고)
        ThreadLife tl = new ThreadLife();

        // 스레드 객체 생성
        Thread t1 = new Thread(tl, "First-Thread");
        Thread t2 = new Thread(tl, "Second-Thread");
        Thread t3 = new Thread(tl, "Third-Thread");

        // 각자 하나의 run() 메소드가 실행되는 스레드 시작
        t1.start();
        t2.start();
        t3.start();
        System.out.println("=== 메인 스레드 종료 ===");
    }
}