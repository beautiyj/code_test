package test.java;

/*
연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다.

예를 들면 다음과 같습니다.
12 ⊕ 3 = 123
3 ⊕ 12 = 312

양의 정수 a와 b가 주어졌을 때,
a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.


입력값: 양의정수 a, b
출력값: a ⊕ b와 b ⊕ a 중 더 큰 값
행위: 비교연산, 함수 리턴

 */

// 자바에서는 문자열끼리 비교 불가, 정수 변환하여 비교 필요.
class T6{
    public int t6(int a, int b) {
        int answer = 0;

        // 문자열로 변환하고
        String ab = ""+a+b;
        String ba = ""+b+a;

        // 정수로 다시 변환해서
        int abInt = Integer.parseInt(ab);
        int baInt = Integer.parseInt(ba);

        // 정수로 비교하기
        if (abInt < baInt) {
            return baInt;
        } else {
            return abInt;
        }
    }
}

// 간략화: math.max() 사용
class Solution {
    public int t6(int a, int b) {
        int ab = Integer.parseInt("" + a + b);
        int ba = Integer.parseInt("" + b + a);

        return Math.max(ab, ba);
    }
}

public class JavaTest6 {
    public static void main(String[] args) {
        T6 test = new T6();
        int answer = test.t6(12, 3);

        Solution sol = new Solution();

        System.out.println(answer);
        System.out.println(sol.t6(16, 7));
    }
}
