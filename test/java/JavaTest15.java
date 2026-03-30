package test.java;
// 2차원 배열 예제

/* 보통 코테에서 제한사항
~ 의 길이보다 작다   →  인덱스 번호
~ 의 원소보다 작다   →  값
 */

// 1. 정수 n과 k가 주어졌을 때 1~n이하 정수 중 k의 배수를 오름차순으로 저장한 배열 return 함수
// 예: 1 이상 10 이하의 3의 배수는 3, 6, 9 이므로 [3, 6, 9]를 return 합니다.
// 입력값변수: 정수n,k     출력값변수: k의배수를 오름차순정렬한 배열[]
// 행위: 오름차순정렬, 조건식으로k배수확인

import java.util.Arrays;

class Solution24 {
    public int[] solution24(int n, int k) {

        // 결과 배열의 크기를 계산하기. 1~n 이하 중 k의 배수만 들어가는 거니까 나머지 빼고 몫=크기
        // 예시처럼 n=10, k=3일때 count = 3, result[]=3개의 수만 들어감.
        int count = n / k;
        int[] result = new int[count];

        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (i % k == 0) {
                result[index] = i;
                index++;
            }
        }
        return result;

        //등차수열 원리로 진행할 경우 (if문필요x kx1=k, kx2=k+k, kx3=k+k+k니까");
        /*
        // i = 3부터 시작해서 10까지 진행될 때, i=i+k로 증가하니 3, i=3+3으로 6, 그다음은 9
        for (int i = k; i <= n; i += k) {
            result[index++] = i;
            // result[0] = i = 3        등차수열 진행될때 인덱스에도 동시에 데이터 주입
            // result[1] = i = 6
        }
        // 자동으로 오름차순 정렬된 3 6 9 순차로 확인해서 담았으니까
        return result;
         */
    }
}

//==========================================================================================

/*
    2. 정수 l과 r가 주어졌을 때 l 이상 r 이하의 정수 중에서
    숫자 0과 5로만 이루어진 모든 정수를 오름차순으로 저장한 배열 return,
    정수가 없을 경우 -1 배열을 return 함수 만들기.
    예:   l	     r	        result
          5 	555	    [5, 50, 55, 500, 505, 550, 555]
         10 	20	    [-1]

      입력값변수: 정수 l r
      출력값: 숫자 0과 5로만 이루어진 오름차순 배열 / 정수가 없을 경우 -1 배열
      행위: 숫자 0과 5로만 이루어진 정수 &* 정수가 없을 경우를 판별

      로직:
      1. 배열의 크기가 어떻게 정해질 지 모르니까(배열의크기는불변) 최대크기의 임시 배열 생성.
         temp[r-l+1] 최대크기의 임시배열, count = 0 횟수.
      2. l~r 사이의 숫자 반복문 (0,5면 배열에저장하는 for문) 으로 조건판별
      3. 그다음 임시배열을 활용해 최종 result[] 배열을 생성, for문으로 배열 복사

      % 10  →  마지막 자리 뽑기  (나머지)
      / 10  →  마지막 자리 제거  (나누기 소수점버림)
*/

class Solution24T2 {

    boolean isNum(int n) {      // 만약 n이 505일때
        while (n > 0) {
            int digit = n % 10;   // 숫자의 마지막자리 체크하기. 505%10= 나머지 5

            if (digit != 0 && digit != 5) {       // 마지막 자리가 0,5가 아니면 바로 탈출
                return false;
            }

            n /= 10;      // 나누기로 자리 제거. 505/10 = 5
        }
        return true;
    }

    public int[] solution24T2(int l, int r) {

        int[] temp = new int[r - l + 1];
        int count = 0;

        // 메소드활용하여 임시배열 temp에 숫자들 저장
        for (int i = l; i <= r; i++) {
            if (isNum(i)) {
                temp[count] = i;
                count++;
            }
        }

        // 메소드 활용했을 때 temp에 들어가는 게 없다면 -1 배열 리턴
        if (count == 0) {
            return new int[]{-1};
        }

        // temp임시배열을 실제 크기 배열 return에 복사해서 리턴
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {  // 수정: 1→0 시작, <=→
            result[i] = temp[i];
        }
        return result;
    }

    /*
    list를 사용하면 더 간단하게 활용 가능함(가변이니까)

    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (String.valueOf(i).matches("[05]+")) { // 0과 5로만 구성됐는지 정규식 체크
                list.add(i);
            }
        }
        if (list.isEmpty()) return new int[]{-1};

        // List를 int[]로 변환 (자바의 고질적인 노가다)
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

    혹은 이진법 활용해서 더 간단하게 진행도 가능
    public int[] solutionRefined(int l, int r) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; ; i++) {
            // 이진수 문자열을 만들고 1을 5로 치환
            long num = Long.parseLong(Integer.toBinaryString(i)) * 5;
            if (num > r) break;
            if (num >= l) result.add((int) num);
        }
        return result.isEmpty() ? new int[]{-1} : result.stream().mapToInt(Integer::intValue).toArray();
    }
     */
}

//==========================================================================================

/*
3. 정수 배열 arr와 2개의 구간이 담긴 배열 intervals 주어졌을 때,
 intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간이다.
 닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미한다.

 이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을
 앞뒤로 붙여 새로운 배열을 만들어 return하는 함수 만들기.

    제한사항
    1 ≤ arr의 길이 ≤ 100,000
    1 ≤ arr의 원소 < 100
    1 ≤ a1 ≤ b1 < arr의 길이
    1 ≤ a2 ≤ b2 < arr의 길이
    ( 여기서     1 ≤ a1 ≤ b1 < arr의 길이  <<- 인덱스번호 를 캐치해야함.
    arr길이가 5일 경우, arr안의 값은 뭐든 가능한데 길이보다 작다는 제한이면 인덱스 0~4 제한사항에 맞음.
    값은 아무거나 가능해서 a1=100 b1=1 도 되는데 길이 제한이 있다는 건 인덱스라는 의미.
    그러니 a1 b1은 arr의 인덱스번호가 되는 거.)

    예시
        arr	                    intervals	            result
        [1, 2, 3, 4, 5]	    [[1, 3], [0, 4]]	[2, 3, 4, 1, 2, 3, 4, 5]

    첫 번째 구간에 해당하는 배열은 [2, 3, 4] 입니다.
    두 번째 구간에 해당하는 배열은 [1, 2, 3, 4, 5] 입니다.
    따라서 이 두 배열을 앞뒤로 붙인 배열인 [2, 3, 4, 1, 2, 3, 4, 5]를 return 합니다.
    ( 말그대로 1,3인덱스 구간 -> arr[1,3]은 [2,3,4] )

    입력값변수: 정수배열 arr, 2개의 구간이 담긴 배열 intervals(arr의 인덱스를 지정하는 배열)
    출력값: arr의 첫번째,2번째 배열을 붙인 result배열(인덱스번호에 따라 구간 달라짐)
    행위: 인덱스번호에 따른 배열구간 체크? 그리고 새로운 배열 생성

    1. 새로운 배열 result의 크기를 먼저 계산하고
    2. 인터벌의 인덱스번호에 맞게 첫번째구간을 복사,
    3. 두번째 구간은 이어붙이고 결과배열 리턴
 */

class Solution24T3 {
    public int[] solution24T3(int[] arr, int[][] intervals) {

        int a1 = intervals[0][0];
        int b1 = intervals[0][1];
        int a2 = intervals[1][0];
        int b2 = intervals[1][1];

        int[] result = new int[(b1 - a1 + 1) + (b2 - a2 + 1)];
        int index = 0;

        // 1구간 복사
        for (int i = a1; i <= b1; i++) {
            result[index++] = arr[i];
        }

        // 2구간 이어붙이기
        for (int i = a2; i <= b2; i++) {
            result[index++] = arr[i];
        }
        return result;
    }
}

//==========================================================================================

// 기초문제 - 배열만들기3까지 적어둠
public class JavaTest15 {
    public static void main(String[] args) {

        Solution24 s1 = new Solution24();
        int[] result1 = s1.solution24(10, 3);
        System.out.print("Solution24 결과: ");
        for (int n : result1) {
            System.out.print(n + " ");
        }
        System.out.println();

        Solution24T2 s2 = new Solution24T2();
        int[] result2 = s2.solution24T2(5, 555);
        System.out.print("Solution24T2 결과: ");
        for (int n : result2) {
            System.out.print(n + " ");
        }
        System.out.println();

        Solution24T3 s3 = new Solution24T3();
        int[] arr = {1, 2, 3, 4, 5};
        int[][] intervals = {{1, 3}, {0, 4}};
        int[] result3 = s3.solution24T3(arr, intervals);
        System.out.print("Solution24T3 결과: ");
        for (int n : result3) {
            System.out.print(n + " ");
        }
        System.out.println(Arrays.toString(result3));
        System.out.println();
    }
}