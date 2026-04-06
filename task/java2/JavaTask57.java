package task.java2;

/*
과제
   키보드를 통해서 연도(ex) 2020)를  입력 받는다.
   이때 입력 받은 연도가 윤년인지 평년인지를 판별하는
   프로그램을 작성하세요?
   (단, GregorianCalendar 클래스를 이용해서 처리 하세요.)

    // 1년 365.242374
    // 평년 = 365일 (2월달 - 28일까지)
    // 윤년 = 366일 (2월달 - 29일까지)

GregorianCalendar 레퍼런스 형변환으로 응용하기

 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class JavaTask57 {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("연도를 입력하세요(ex. 2020): ");
        int year = sc.nextInt();

        // GregorianCalendar - 그레고리력 클래스
        // 레퍼런스 형변환 활용

        // 자동형변환(업캐스팅)  : 레퍼런스 형변환 필요 없으면 업캐스팅만 활용해도 상관없음
        Calendar cal = new GregorianCalendar();
        // 강제형변환(다운캐스팅)
        GregorianCalendar gcal = (GregorianCalendar) cal;

        // isLeapYear() - 그레고리캘린더 클래스의 윤년 평년 구분 로직
        if (gcal.isLeapYear(year)) {
            System.out.println(year + "년은 윤년(366일)입니다.");
        } else {
            System.out.println(year + "년은 평년(365일)입니다.");
        }

    }
}
