package task.java3;

// 스레드의 우선순위

// Thread Priority 스레드 우선순위 확인 클래스
class ThreadPriority implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 21; i++) {
            // thread의 이름과 정수 출력
            System.out.println(Thread.currentThread().getName() + " number = " + i);
        }
    }
}

// 스레드 우선순위 직접 제어 클래스 - 우선순위만으로 스레드 제어하는 건 어려움
class ThreadPriorityControl implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            // thread의 이름과 정수 출력
            System.out.println(Thread.currentThread().getName() + " number =" + i);
        }
    }
}

public class JavaTask84 {
    public static void main(String[] args) {
        System.out.println("=== 1. ThreadPriority (기본 우선순위 확인) ===");
        ThreadPriority tp = new ThreadPriority();

        // 첫번째 Thread 생성
        Thread first1 = new Thread(tp, "tp-first1");
        // 두번째 Thread 생성
        Thread second1 = new Thread(tp, "tp-second1");
        // 세번째 Thread 생성
        Thread third1 = new Thread(tp, "tp-third1");

        // thread의 우선순위를 출력하는 부분 (지정하지 않으면 5)
        System.out.println("tp-first priority =" + first1.getPriority());
        System.out.println("tp-second priority =" + second1.getPriority());
        System.out.println("tp-third priority =" + third1.getPriority());

        System.out.println("\n========================================================================");

        System.out.println("\n=== 2. ThreadPriorityControl (우선순위 직접 제어) ===");

        ThreadPriorityControl tpc = new ThreadPriorityControl();

        //최고순위(MAX_PRIORITY:10)
        //순위 미지정(NORM_PRIORITY:5)
        //최저순위(MIN_PRIORITY:1)

        // 첫 번째 Thread 생성 및 최저순위(1) 설정
        Thread first2 = new Thread(tpc, "first1");
        first2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("first priority = " + first2.getPriority());

        // 두 번째 Thread 생성 및 최고순위(10) 설정
        Thread second2 = new Thread(tpc, "second1");
        second2.setPriority(Thread.MAX_PRIORITY);
        System.out.println("second priority = " + second2.getPriority());

        // 세 번째 Thread 생성 (우선순위를 설정하지 않은 경우 - 기본 5)
        Thread third2 = new Thread(tpc, "third1");
        System.out.println("third priority = " + third2.getPriority());

        System.out.println("\n=== 스레드 실행 시작 ===");
        // 스케줄링에 따라 우선순위가 높은 second2가 기회를 더 많이 얻을 가능성이 높습니다.
        // 우선순위가 높다고 해서 먼저 실행되는 건 아님 가능성이 높을 뿐. 우선순위가 높은 게 CPU 점유할 확률이 높다 정도임
        first2.start();
        second2.start();
        third2.start();
    }
}