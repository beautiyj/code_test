package task.java3;

// 스레드
// 1. Thread 클래스를 상속 받아서 만드는 방법: 스레드 클래스를 직접 상속받아 run() 메소드를 오버라이딩
// 2. Runnable 인터페이스를 구현해서 만드는 방법: Runnable 인터페이스를 구현하여 run() 메소드를 오버라이딩한 후,
//                                          Thread 클래스의 생성자에 Runnable 객체를 전달하여 스레드 생성
// 클래스가 이미 다른 부모를 상속받고 있다면, 다중 상속이 불가능한 자바의 특성 상 Runnable 인터페이스를 구현(implements)하여 스레드 객체에 전달

class ThreadEnd extends Thread {
    public static void main(String[] args) {
        ThreadEnd tt = new ThreadEnd();
        // thread를 실행시킴
        tt.start();

        // main()내에서 화면에 101부터 120까지 출력
        for (int i = 101; i <= 120; i++) {
            System.out.println("-------> main number = " + i);
        }
    }

    @Override
    public void run() {
        // thread가 시작되면 실행되는 문장
        for (int i = 1; i <= 20; i++) {
            System.out.println("run number = " + i);
        }
    }

}

class RunnableTest implements Runnable {
    public static void main(String[] args) {
        // 객체 생성
        RunnableTest tt = new RunnableTest();
        // Thread 클래스 객체 생성
        Thread t = new Thread(tt);
        // Thread를 시작시킴
        t.start();
        System.out.println("--------> main thread end");
    }

    // 1부터 20까지 화면에 출력시키는 메소드
    public void printNumber() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("number = " + i);
        }
    }
    // 인터페이스를 상속 받을 경우, 메소드 오버라이드 필수
    @Override
    public void run() {
        printNumber();
    }
}


// 멀티스레드로 진행할 때와 싱글스레드 2개 따로 실행할 때랑 차이가 있음
public class JavaTask82 {
    public static void main(String[] args) {
        System.out.println("=== 전체 테스트 시작  - 싱글스레드 2개 넣어서 해당 로직은 멀티스레드임===");

        // 1번 예제 실행 (Thread 상속 방식)
        ThreadEnd tt = new ThreadEnd();
        tt.start();

        // 2번 예제 실행 (Runnable 구현 방식)
        RunnableTest rt = new RunnableTest();
        Thread t2 = new Thread(rt);
        t2.start();

        System.out.println("=== 메인 스레드 작업 완료 (서브 스레드들은 계속 도는 중) ===");
    }
}
/*
실행 순서는 싱글스레드 2개 따로 두면 - 뒤섞임 / JavaTask82 이용해서 멀티스레드 형태로 하면 - 뒤섞이긴 해도 규칙성 발생.
JavaTask82 안에 스레드를 넣지 않아도 스레드끼리 실행됨
 */