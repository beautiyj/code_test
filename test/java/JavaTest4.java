package test.java;
/*
문자열 str과 정수 n이 주어집니다.
str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.

** 예시 **
입력
string 5

출력
stringstringstringstringstring

 */

import java.util.Scanner;

public class JavaTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        String answer = str.repeat(n);
        System.out.println(answer);
    }
}

/*
public class JavaTest4 {
    public static void main(String[] args) {
        String str = "string";
        int n = 5;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(str);
        }

        System.out.println(result.toString());
    }
}
*/
