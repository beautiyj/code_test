package test.java;

/*
정수 num과 n이 매개 변수로 주어질 때,
num이 n의 배수이면 1을
return n의 배수가 아니라면 0을
return 하도록 solution 함수를 완성해주세요.

 */

class Solution8 {
    public int solution (int num, int n) {
        if (num % n == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

/*
이프문 없이 바로 리턴에 삼항연산자 넣어도 됨
코틀린은 리턴 뒤에 if else도 가능. 자바는 안되지만...
class Solution8 {
    public int solution(int num, int n) {
        return num % n == 0 ? 1 : 0;
    }
}
 */

public class JavaTest8 {
    public static void main(String[] args) {
        Solution8 sol = new Solution8();
        System.out.println(sol.solution(10, 5));
    }
}
