package task.java;

import java.util.Calendar;

/*
과제10
Calender 클래스 이용해서 오늘날짜시간요일 출력
 */
public class JavaTask10 {
    public static void main(String[] args) {
        // Calendar 객체 생성 (현재 날짜와 시간)
        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; // 0부터 시작하므로 +1
        int date = cal.get(Calendar.DATE);

        // 요일이 기본적으로 숫자 매칭된 상태라 배열로 문자열 변환하기
        //              인덱스제거용"". 7까지니까 사실상 0,1,2,... 7로 8개 맨 앞의 인덱스 0은 ""
        String[] week = {"", "일", "월", "화", "수", "목", "금", "토"};
        String day = week[cal.get(Calendar.DAY_OF_WEEK)];   // = 7

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        System.out.printf("오늘 날짜: %d년 %d월 %d일 (%s요일)\n", year, month, date, day);
        System.out.printf("현재 시간: %d시 %d분 %d초\n", hour, minute, second);
    }
}
