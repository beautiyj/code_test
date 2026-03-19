package test.java;

/*
    정수 number와 n, m이 주어집니다.
    number가 n의 배수이면서 m의 배수이면 1을
    아니라면 0을 return하도록 solution 함수를 완성해주세요.

    입출력 예
    number	n	m	result
    --------------------------
    60	    2	3	    1
    55	    10	5	    0
    60은 2의 배수이면서 3의 배수이기 때문에 1을 return합니다.
    55는 5의 배수이지만 10의 배수가 아니기 때문에 0을 return합니다.


변수
입력값 정수number,
상태값 n, m
출력값 1아니면0
행위 n의배수와 m의배수 확인(연산자 활용 조건문)
 */

class Solution9 {
    public int solution(int number, int n, int m) {
        if (number % 2 == 0 && number % m == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class JavaTest9 {
    public static void main(String[] args) {
        Solution9 sol = new Solution9();
        System.out.println(sol.solution(10,2,3));
        System.out.println(sol.solution(10,2,5));
    }
}
