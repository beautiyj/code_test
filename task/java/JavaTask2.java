package task.java;

import java.util.Scanner;

/*
 * 과제 2 키보드로 3개의 정수를 입력받았을 때 max min 구하기
 *
 * 제한사항: if else문 활용
 */

public class JavaTask2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("정수 3개를 입력");

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        /*
        조건식에 삼항연산자를 추가해서 하면 if-else문 가능, 아예 삼항연산자 사용 불가면 아래처럼 나눠서 진행
        int max = 0; int min = 0; 변수 선언 후 진행하기

        if (n1 > n2) {
            max = (n1>n3)?n1:n3;
            min = (n2>n1)?n2:n1;
        } else {
            max = (n2>n3)?n2:n3;
            min = (n1>n3)?n1:n3;
        }
        */

        if (n1 > n2 && n1 > n3) {
            System.out.println("max: " + n1);
        } else if (n2 > n3) {
            System.out.println("max: " + n2);
        } else {
            System.out.println("max: " + n3);
        }

        if (n1 < n2 && n1 < n3) {
            System.out.println("min " + n1);
        } else if (n2 < n3) {
            System.out.println("min:" + n2);
        } else {
            System.out.println("min: " + n3);
        }
    }
}

