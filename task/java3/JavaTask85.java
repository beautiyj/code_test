package task.java3;

// 스레드 상태 제어
class ThreadSleep implements Runnable {

    public void run() {
        for (int i = 1; i < 10; i++) {
            // 현재 CPU를 점유한 Thread 출력
            System.out.println(Thread.currentThread().getName()
                    + " : " + i);

            try {
                //sleep() 메소드를 사용해 프로그래머가 강제로
                // block 상태로 만듦.
                // 1초 동안 thread을 block 상태에 빠트림
                Thread.sleep(1000); //(단위: 1/1000 초)
            } catch (InterruptedException ie) {
                System.out.println(ie.toString());
            }
        }//for end
    }// run() end
}

public class JavaTask85 {
    public static void main(String[] args) {
        ThreadSleep ts = new ThreadSleep();

        // 두 개의 Thread를 생성시켜 실행시킴
        // 2개의 Thread가 동일한 우선 순위로 실행됨.(5인 상태)
        Thread first = new Thread(ts, "first1");
        Thread second = new Thread(ts, "second1");
        first.start();     // 실행 가능 상태: run() 메소드 호출
        second.start();
    }
}
/*
second1 : 1
first1 : 1
second1 : 2
first1 : 2
second1 : 3
first1 : 3
second1 : 4
first1 : 4
second1 : 5
first1 : 5
second1 : 6
first1 : 6
second1 : 7
first1 : 7
second1 : 8
first1 : 8
second1 : 9
first1 : 9
 */