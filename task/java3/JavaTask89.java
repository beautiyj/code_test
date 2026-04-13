package task.java3;

// 과제 - 스레드를 이용해서 현재 시간을 1초에 1번씩 출력하는 프로그램 만들기
// 단, 연 월 시 분 초 형태로 출력하기

import java.text.SimpleDateFormat;
import java.util.Date;

class ClockThread extends Thread {
    @Override
    public void run() {
        // 심플데이터포맷
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        while (true) {
            Date now = new Date();
            System.out.println(sdf.format(now));
            try {
                Thread.sleep(1000); // 1초 대기. 1/1000 초
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
public class JavaTask89 {
    public static void main(String[] args) {
        ClockThread t1 = new ClockThread();
        t1.start();
    }
}
