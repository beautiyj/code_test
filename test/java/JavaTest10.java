package test.java;

/*
양의 정수 n이 매개변수로 주어질 때,
n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고
n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는
solution 함수를 작성해 주세요.


    n	result
  -------------
    7	16
    10	220

예제 1번의 n은 7로 홀수입니다.
7 이하의 모든 양의 홀수는 1, 3, 5, 7이고
이들의 합인 1 + 3 + 5 + 7 = 16을 return 합니다.

예제 2번의 n은 10으로 짝수입니다.
10 이하의 모든 양의 짝수는 2, 4, 6, 8, 10이고
이들의 제곱의 합인 22 + 42 + 62 + 82 + 102 = 4 + 16 + 36 + 64 + 100 = 220을 return 합니다.

변수
입력값: n
행위: n의 홀짝 구분 조건식, 홀수의 경우 홀수 합(누적) 반복, 짝수는 짝수 제곱 합(누적)반복, 함수
 */

class Solution10 {
    public int solution(int n) {
        int answer = 0;

        // 홀수면 홀수들의 정수 합
        if (n % 2 == 1) {
            for (int i = 1; i<=n; i++) {
                if (i % 2 == 1) {
                    answer += i;
                }
            }
        } else {
            // 짝수면 짝수들의 제곱 합
            for (int i = 1; i<=n; i++) {
                if (i % 2 == 0) {
                    answer += i * i;
                }
            }
        }
        return answer;
    }
}


public class JavaTest10 {
    public static void main(String[] args) {
        Solution10 sol = new Solution10();

        System.out.println(sol.solution(9));
        System.out.println(sol.solution(2));
    }
}
