package test.java;

/*
연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다.

예를 들면 다음과 같습니다.
12 ⊕ 3 = 123
3 ⊕ 12 = 312

양의 정수 a와 b가 주어졌을 때,
a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.

변수
입력값: 양의 정수 a, b
a+b, 2*a*b
결과: result a+b 큰값
행위: 문자열->정수 자료형 변환, 정수 크기 비교 연산
 */

class Solution7 {
    public int solution(int a, int b) {
        int result = 0;

        String ab = "" + a+b;
        int mul = 2*a*b;

        int abInt = Integer.parseInt(ab);

        if (abInt >= mul) {
            result = abInt;
        } else {
            result = mul;
        }
        return result;
    }
}

// 간략버전 - math.max() 사용
class Test7 {
    public int solution(int a, int b) {
        int ab = Integer.parseInt("" + a + b);
        int mult = 2 * a * b;

        return Math.max(ab, mult);
    }
}

public class JavaTest7 {

        public static void main(String[] args) {
            Solution7 sol = new Solution7();
            int answer = sol.solution(12, 3);
            System.out.println(answer);

            Test7 t7 = new Test7();
            System.out.println(t7.solution(1, 7));
        }
}
