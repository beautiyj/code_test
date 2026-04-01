package task.java2;

// 0401과제
/*
키보드로 주민번호를 입력 받아서 유효한 주민등록번호 판별하는 프로그램.
단, 유효하지 않는 주민번호의 경우에는 메시지 출력

유효성 검사      // (111111 - 11111118 로 예시 확인해보기)
1. 주민번호 앞자리 6자리가 아니면 메시지 출력
2. 주민번호 뒷자리 7자리가 아니면 메시지 출력
3. 유효한 주민번호 아니면 메시지 출력

■ 주민 등록 번호 타당성 검사법
1. 주민 번호 각 자리에 해당 숫자를 곱한다.
              예)  9  5  0  1  0  1   -   1  2  3  4  5  6  7
                                                          7은 체크용 번호
각 자리마다 곱하기 ) 2  3  4  5  6  7        8  9  2  3  4  5
                (9*2)+(9*3)+(0*4)+(1*5)+(0*6)+(1*7)+(1*8)+(2*9)+(3*2)+(4*3)+(5*4)+(6*5) = 151

2. 1번의 연산 결과를 11로 나누어서 나머지를 구한다.
   151 ／ 11 = 13 ............ 8
                  (몫)         (나머지)

3. 11에서 나머지 값을 뺀후 “체크용 번호와”와 비교해서 같으면 올바른 주민번호, 그렇지 않으면 틀린 주민번호
   11 - 8 =    3(연산결과)      ≠       7(체크용 번호)   : 틀린 주민번호
   만약 연산결과가 10이상이면 다시 10으로 나누어서 그 나머지를 체크용 번호와 비교 한다.
    10 / 10 = 1 .........  0      ≠      7              : 틀린 주민번호
                (몫)     (나머지)        (체크용 번호)
 */

import java.util.Scanner;

class Solution37 {

    // 주민번호 유효 여부를 먼저 메소드로 구분하고 (boolean)
    // 배열+반복문
    public static boolean checkJumin(String jumin) {
        int total = 0;
//        int total2 = 0;
        int n = 2;

        // 체크용 번호
        String index = jumin.substring(12, 13);
        Integer id = Integer.parseInt(index);

        String j1 = jumin.substring(0, 9);
        String j2 = jumin.substring(9, 12);

        String[] jumin1 = j1.split("");
        String[] jumin2 = j2.split("");

//        Integer jumin1 = Integer.parseInt(jumin.substring(0,9));
//        Integer jumin2 = Integer.parseInt(jumin.substring(9,12));

        // 인덱스는 0~11 체크. 123456 12  3456 7에서 7은 체크용 번호
        // 인덱스 8까지는 n=9 이후는 n=2초기화
         /*
            total = (jumin[0]*2)
            total = (jumin[1]*3)
            total = (jumin[2]*4)
            ...
            total = (jumin[9]*2)
            total = (jumin[11]*5)
        */

        int[] r = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
        for (int i = 0; i <= 11; i++) {
            total += Integer.parseInt(jumin.substring(i, i + 1)) * r[i];
        }

//        int sum = total + total2;

        // 몫
//        int num1 = sum / 11;
        // 나머지
        total = total % 11;

        int total2 = 11 - total;

        if (total2 >= 10) {
            total2 = total2 % 10;
        }
        if (total2 == Integer.parseInt(jumin.substring(12,13))) {
            return true;
        } else {
            return false;
        }

    }


    // 이후 체크
    public void solution37() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주민번호를 입력하시오. (예: 9901011234567)");

        try {
            System.out.println("주민번호 앞자리를 입력하세요");
            String jumin1 = sc.nextLine();
            System.out.println("주민번호 뒷자리를 입력하세요");
            String jumin2 = sc.nextLine();

            // 유효성 검사
            if (jumin1.equals("")) {
                System.out.println("주민번호 앞자리가 입력되지 않았습니다. 주민번호 앞자리를 입력하세요.");
            } else if (jumin1.length() != 6) {
                System.out.println("주민번호 앞자리 6자리가 입력되지 않았습니다.");
            } else if (jumin2.equals("")) {
                System.out.println("주민번호 뒷자리가 입력되지 않았습니다. 주민번호 뒷자리를 입력하세요.");
            } else if (jumin2.length() != 7) {
                System.out.println("주민번호 뒷자리 7자리가 입력되지 않았습니다.");
            } else if (!checkJumin(jumin1 + jumin2)) {
                System.out.println("잘못된 주민번호");
            } else {
                System.out.println("올바른 주민번호 입니다");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}


public class JavaTask37 {
    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        solution37.solution37();
    }
}
