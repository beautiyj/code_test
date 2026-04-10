package task.java3;

// 과제 - 스레드를 이용해서 현재 시간을 1초에 1번씩 출력하는 프로그램 만들기
// 단, 연 월 시 분 초 형태로 출력하기

import java.util.Calendar;

class ClockThread extends Thread {
    @Override
    public void run() {
        while (true) {
            Calendar now = Calendar.getInstance();
            int year = now.get(java.util.Calendar.YEAR);
            int month = now.get(java.util.Calendar.MONTH) + 1; // 월은 0부터 시작하므로 +1
            int day = now.get(java.util.Calendar.DAY_OF_MONTH);
            int hour = now.get(java.util.Calendar.HOUR_OF_DAY);
            int minute = now.get(java.util.Calendar.MINUTE);
            int second = now.get(java.util.Calendar.SECOND);

            System.out.printf("%04d-%02d-%02d %02d:%02d:%02d\n", year, month, day, hour, minute, second);

            try {
                Thread.sleep(1000); // 1초 대기. 1/1000 초
                if (minute == 11) break;            // 코드 실행할 때 시간 체크해보고 분 숫자 변경하기
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
