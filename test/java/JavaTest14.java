package test.java;

/*

문자열에 따라 다음과 같이 두 수의 크기를 비교하려고 합니다.

두 수가 n과 m이라면
">", "=" : n >= m
"<", "=" : n <= m
">", "!" : n > m
"<", "!" : n < m
두 문자열 ineq와 eq가 주어집니다.
ineq는 "<"와 ">"중 하나고, eq는 "="와 "!"중 하나입니다.

그리고 두 정수 n과 m이 주어질 때,
n과 m이 ineq와 eq의 조건에 맞으면 1을
아니면 0을 return하도록 solution 함수를 완성해주세요.

    입출력 예
    ineq	eq	    n	    m	    result
    "<" 	"="	    20	    50	    1
    ">"	    "!"	    41	    78	    0

    입출력 예 #1
    20 <= 50은 참이기 때문에 1을 return합니다.

    입출력 예 #2
    41 > 78은 거짓이기 때문에 0을 return합니다.

변수
입력값: 정수n과 m, 문자열 ineq와 eq
출력값: 1혹은0
행위: 조건제어, 함수

 */

// 문자열 비교에선 == 말고 .equals()
// 최신 스위치 케이스문은 문자열을 자동적으로 .equals()처리시킴

class Solution14 {
    public int solution(String ineq, String eq, int n, int m) {

        boolean result = switch (ineq + eq) {
            case "<=" -> n <= m;
            case "<!" -> n < m;
            case ">=" -> n >= m;
            case ">!" -> n > m;
            default -> false;
        };

        return result ? 1 : 0;

    }
}

/*
class Solution {
    public int solution(String ineq, String eq, int n, int m) {

        여기서 자료형을 바로 정수형태로 해서
        int answer = switch (ineq + eq) {
                            조건넣고
            case "<=" -> n<=m ? 1 : 0 ;
            case "<!" -> n<m ? 1 : 0;
            case ">=" -> n>=m ?1 :0;
            case ">!" -> n>m ?1 :0;
            default -> 0;
        };
        바로 리턴 가능함
        return answer;
    }
}
 */

public class JavaTest14 {
    public static void main(String[] args) {

        Solution14 sol = new Solution14();
        System.out.println(sol.solution(">", "=", 2, 3));
        System.out.println(sol.solution(">", "!", 2, 3));
        System.out.println(sol.solution("<", "=", 2, 3));
        System.out.println(sol.solution("<", "!", 2, 3));

    }
}
