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
        // 가중치
        int[] r = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};

        for (int i = 0; i < 12; i++) {
            total += Integer.parseInt(jumin.substring(i, i + 1)) * r[i];
            /*
            total += Integer.parseInt(jumin.substring(0, 1)) * 2;
            total += Integer.parseInt(jumin.substring(1, 2)) * 3;
            total += Integer.parseInt(jumin.substring(2, 3)) * 4;
            ...
            total += Integer.parseInt(jumin.substring(7, 8)) * 9;
            total += Integer.parseInt(jumin.substring(8, 9)) * 2;
            ...
            total += Integer.parseInt(jumin.substring(10, 11)) * 4;
            total += Integer.parseInt(jumin.substring(11, 12)) * 5;
            */
        }

        int remainder = total % 11;
        int result = 11 - remainder;

        if (result >= 10) {
            result %= 10;
        }

        int lastDigit = Integer.parseInt(jumin.substring(12, 13));
        return result == lastDigit;
    }

    public void solution37() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주민번호를 입력하시오. (예: 9901011234567)");

        try {
            System.out.println("주민번호 앞자리를 입력하세요");
            String jumin1 = sc.nextLine();
            System.out.println("주민번호 뒷자리를 입력하세요");
            String jumin2 = sc.nextLine();

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

// 앞,뒤 나눠서 하는 경우
class Solution37T2 {
    public static boolean checkJumin(String j1, String j2) {
        int total = 0;
        int weight = 2;

        // 1. 앞자리 계산 (weight: 2 ~ 7)
        for (int i = 0; i < j1.length(); i++) {
            total += Character.getNumericValue(j1.charAt(i)) * weight++;
        }

        // 2. 뒷자리 계산 (weight: 8 ~ 9 -> 다시 2 ~ 5)
        // 마지막 숫자는 체크용이므로 j2.length() - 1 까지만 반복
        for (int i = 0; i < j2.length() - 1; i++) {
            if (weight > 9) weight = 2;
            total += Character.getNumericValue(j2.charAt(i)) * weight++;
        }

        int checkNum = (11 - (total % 11)) % 10;

        // 입력받은 마지막 자리와 비교
        int lastDigit = Character.getNumericValue(j2.charAt(6));

        return checkNum == lastDigit;
    }

    public void solution37T2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주민번호를 입력하시오. (예: 9901011234567)");

        try {
            System.out.println("주민번호 앞자리를 입력하세요:");
            String j1 = sc.nextLine();
            System.out.println("주민번호 뒷자리를 입력하세요:");
            String j2 = sc.nextLine();

            // 유효성 체크
            if (j1.length() == 6 && j2.length() == 7) {
                if (checkJumin(j1, j2)) {
                    System.out.println("올바른 주민번호 입니다.");
                } else {
                    System.out.println("잘못된 주민번호 (타당성 검사 실패)");
                }
            } else {
                System.out.println("주민번호 자릿수가 올바르지 않습니다.");
            }

        } catch (Exception e) {
            throw new RuntimeException("예상치 못한 오류 발생", e);
        }
    }
}

// 더 간결하게
class Solution37T3 {
    public static boolean checkJumin(String fullJumin) {
        // 숫자만 남기면서 전처리하기. 숫자 체크 메소드를 따로 넣어도 상관 없음
        // 전처리는 사용자 친화적이고 숫자 체크 메소드로 체크는 정확한 데이터 포맷에 좋음.
        /*  // 숫자 체크 메소드는  이런 느낌
        private boolean isNumeric(String str) {
        return str != null && str.matches("^[0-9]*$");
         */
        fullJumin = fullJumin.replaceAll("[^0-9]", "");
        if (fullJumin.length() != 13) return false;

        int total = 0;
        // 가중치 배열(상수 선언해서 재사용해도 상관없음)
        int[] weights = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};

        // charAt()을 이용한 숫자 변환 및 합산(메모리 절약)
        // 0을 빼는 이유 - ASCII 코드 값을 이용하여 문자 숫자를 실제 정수로 바꾸기 위함
        for (int i = 0; i < 12; i++) {
            total += (fullJumin.charAt(i) - '0') * weights[i];
        }

        // 타당성 검사 공식 (한 줄로 처리)
        int checkSum = (11 - (total % 11)) % 10;

        // 마지막 자리 추출 및 비교
        int lastDigit = fullJumin.charAt(12) - '0';

        return checkSum == lastDigit;
    }

    public void solution37T3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주민번호 판별 프로그램 (Optimized)");
        try {
            System.out.println("주민번호를 입력하세요 (예: 990101-1234567):");
            String input = sc.nextLine();

            if (checkJumin(input)) {
                System.out.println("결과: 올바른 주민번호입니다.");
            } else {
                System.out.println("결과: 유효하지 않은 주민번호입니다. 자릿수나 번호를 확인하세요.");
            }

        } catch (Exception e) {
            System.out.println("예상치 못한 오류가 발생했습니다.");
        }
    }
}

public class JavaTask37 {
    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        solution37.solution37();

        Solution37T2 solution37T2 = new Solution37T2();
        solution37T2.solution37T2();

        Solution37T3 solution37T3 = new Solution37T3();
        solution37T3.solution37T3();
    }
}
