package task.java2;

/*
    반지름 r이 5인 경우 다음을 구하는 프로그램을 DecimalFormat클래스를 이용하여 작성하기
    (단, 결과는 소수둘째자리까지 출력할 것)

    원주 (원 둘레) = 2 * PI * r
    원의 면적 = PI * r * r
    구의 표면적 = 4 * PI * r * r
    구의 체적(부피) = 4/3 * PI * r * r * r

    DecimalFormat 클래스: 숫자를 원하는 형식의 문자열로 예쁘게 변환하거나
                        반대로 특정 형식의 문자열을 숫자로 바꿀 때 사용하는 클래스
    DecimalFormat은 특정 기호를 조합한 패턴을 사용하여 형식을 지정한다.

    기호          의미               설명
    0       10진수 (빈자리 0)        값이 없으면 0으로 채움 (강제 표시)
    #       10진수 (빈자리 공백)      값이 없으면 표시하지 않음 (의미 있는 숫자만)
    .       소수점                   소수점 구분자
    ,       단위 구분자              세 자리마다 콤마(,) 표시
    -       음수 기호               음수 표시
    %       퍼센트                 숫자에 100을 곱하고 % 기호 붙임
 */

import java.text.DecimalFormat;

// 출력부에서만 박싱하는 경우 (계산 빠름. 계산이 많을 때 유용)
class Task42 {
    public void task42() {
        int r = 5;

        // 원 둘레
        double r1 = 2 * Math.PI * r;
        // 원 면적
        double r2 = Math.PI * r * r;
        // 구 표면적
        double r3 = 4 * Math.PI * r * r;
        // 구 부피
        double r4 = (4.0 / 3.0) * Math.PI * r * r * r;

        // DecimalFormat.format() 메소드는 내부적으로 객체를 인자로 받음
        // 여기서 박싱 진행(double을 Double로 출력함)
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(r1));
        System.out.println(df.format(r2));
        System.out.println(df.format(r3));
        System.out.println(df.format(r4));
    }
}

// 처음부터 박싱하는 경우. 객체 지향 구조일 때 유용함(리스트 활용 시)
class Task43Class2 {
    public void task43Class2() {

        // 객체 생성
        Integer r = 5;

        // 박싱
        Double r1 = 2 * Math.PI * r;
        Double r2 = Math.PI * r * r;
        Double r3 = 4 * Math.PI * r * r;
        Double r4 = (4.0 / 3.0) * Math.PI * r * r * r;

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(r1));
        System.out.println(df.format(r2));
        System.out.println(df.format(r3));
        System.out.println(df.format(r4));
    }
}

public class JavaTask43 {
    public static void main(String[] args) {
        Task42 t42 = new Task42();
        t42.task42();

        Task43Class2 t42Class2 = new Task43Class2();
        t42Class2.task43Class2();
    }
}
