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
// 최대공약수는 60을 최대로 나눌 수 있는 약수 2,3,5,7,11,13 등등
// 문제에서 60과 24의 최대공약수를 구하라고 지정했기 때문에
// 60까지 루프 돌리지 않고 해당 범위 내의 약수만 하드코딩으로 진행
class Task107T5 {
    public static void main(String[] args) {
        System.out.println("60 혹은 24 두 숫자 중 하나만 입력하기.");
        int[] num = {2,3,5,7,11,13};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result=0;
        int maxResult =0;

        for (int i=0; i<num.length; i++) {
            result = n % num[i];
            if (result == 0) {
                maxResult = Math.max(num[i],1);
            }
        }
        System.out.println(maxResult);

        sc.close();
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
