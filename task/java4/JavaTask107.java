package task.java4;

// 4/16 테스트용

import java.util.*;

class Task107T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("연도 입력");
        int year = sc.nextInt();

        Calendar cal = new GregorianCalendar();
        GregorianCalendar gcal = (GregorianCalendar) cal;

        if (gcal.isLeapYear(year)) {
            System.out.printf("%d : 윤년(= 366일 (2월달 - 29일까지))", year);
        } else {
            System.out.printf("%d : 평년(= 365일 (2월달 - 28일까지))", year);
        }
    }
}

class Task107T2 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap();
    }
}

class Task107T3 {
    public static void main(String[] args) {
        String str = "Do your best";
//        String[] strArr = str.split(" ");
//        System.out.println(strArr[1]);
        System.out.println(str.substring(3, 7));
    }
}

class Task107T4 {
    public static void main(String[] args) {
        // protect 범위
        /*
        상속일 경우
        - 같은 패키지(하위 클래스)에서 접근 가능
        - 다른 패키지(하위 클래스)에서도 접근 가능.

        - 자신의 클래스에서 접근 가능
        - 같은 패키지에서 접근 가능
        - 상속 아닐 때 다른 패키지에서 접근 불가
         */
    }
}

// 최대공약수 구하기
// 60과 24의 최대 공약수 구하는 프로그램
class Task107T5 {
    public static void main(String[] args) {
        int a = 60;
        int b = 24;
        int maxResult = 1;

        // 두 수 중 작은 수까지 반복
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {  // 두 수 모두 나누어 떨어지면
                maxResult = i;                 // 최대공약수 갱신
            }
        }
        System.out.println("최대공약수: " + maxResult);  // 12
    }
}

// set 활용 로또 프로그램 만들기
class Task107T6 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        while (treeSet.size() < 6) {
            int num = (int) (Math.random() * 45) + 1;
            treeSet.add(num);
        }
        System.out.println(treeSet);
    }
}


public class JavaTask107 {
    public static void main(String[] args) {
//        Task107T1.main(args);
//        Task107T3.main(args);
//        Task107T4.main(args);
        Task107T5.main(args);
//        Task107T6.main(args);

    }
}
