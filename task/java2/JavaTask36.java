package task.java2;

// 문자열 클래스 String
/*
키보드로 주민번호를 입력 받아서 남녀 성별 판별하는 프로그램
단, 앞자리 6자리, 뒷자리 7자리 유효성 검사하기
 */

import java.util.Scanner;

class Solution36 {
    // 리턴값 없이 진행이라 정적메소드 static 제외. void있으면 리턴 없어도 됨.
    public void solution36() {
        Scanner sc = new Scanner(System.in);

        System.out.println("주민번호를 입력하시오. (예: 990101-1234567)");
//        String jumin = sc.nextLine();
//        String[] j = jumin.split("-");
//
//        if ( (j[0].length() != 6) && (j[1].length() != 7) ) {
//            System.out.println("서식 오류");
//        }

        // 예외처리 try-catch 구문 사용 시
        /*
        try {
            System.out.println("주민번호 앞자리를 입력하세요");
            String jumin1 = sc.nextLine();
            System.out.println("주민번호 뒷자리를 입력하세요");
            String jumin2 = sc.nextLine();

            // 젠더 판별용 인덱싱
            String g = jumin2.substring(0,1);

            // 유효성 검사
            if (jumin1.equals("")) {
                System.out.println("주민번호 앞자리가 입력되지 않았습니다. 주민번호 앞자리를 입력하세요.");
            } else if (jumin1.length() != 6) {
                System.out.println("주민번호 앞자리 6자리가 입력되지 않았습니다.");
            } else if (jumin2.equals("")) {
                System.out.println("주민번호 뒷자리가 입력되지 않았습니다. 주민번호 뒷자리를 입력하세요.");
            } else if (jumin2.length() != 7) {
                System.out.println("주민번호 뒷자리 7자리가 입력되지 않았습니다.");
            } else if (g.equals("1") || g.equals("3")) {
                System.out.println("남자");
            } else if (g.equals("2") || g.equals("4")) {
                System.out.println("여자");
            } else {
                System.out.println("서식 오류. 재입력하세요");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        */

        // 생년월일 등까지 체크하는 예외처리 유효성검사라면

        try {
            System.out.println("주민번호 앞자리를 입력하세요 (6자리)");
            String jumin1 = sc.nextLine();
            System.out.println("주민번호 뒷자리를 입력하세요 (7자리)");
            String jumin2 = sc.nextLine();

            // 유효성 검사 시작
            if (jumin1.length() != 6) {
                System.out.println("주민번호 앞자리 6자리가 아닙니다.");
            } else if (jumin2.length() != 7) {
                System.out.println("주민번호 뒷자리 7자리가 아닙니다.");
            } else {

                // 생년월일 상세 유효성 검사 (월: 1~12, 일: 1~31)
                int month = Integer.parseInt(jumin1.substring(2, 4));
                int day = Integer.parseInt(jumin1.substring(4, 6));

                if (month < 1 || month > 12) {
                    System.out.println("서식 오류. 유효하지 않은 월입니다.");
                } else if (day < 1 || day > 31) {
                    System.out.println("서식 오류. 유효하지 않은 일입니다.");
                } else {
                    // 성별 판별
                    String g = jumin2.substring(0, 1);
                    if (g.equals("1") || g.equals("3")) {
                        System.out.println("결과: 남자");
                    } else if (g.equals("2") || g.equals("4")) {
                        System.out.println("결과: 여자");
                    } else {
                        System.out.println("서식 오류. 성별 코드 오류입니다. (성별코드 1,2,3,4 유효)");
                    }
                }

            }
        } catch (NumberFormatException e) {
            System.out.println("오류: 숫자만 입력 가능합니다.");
        } catch (Exception e) {
            System.out.println("알 수 없는 오류가 발생했습니다.");
        }
    }
}

public class JavaTask36 {
    public static void main(String[] ar) {
        Solution36 solution36 = new Solution36();
        solution36.solution36();
    }
}
