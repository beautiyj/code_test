package task.java;

// 보조 제어문 - break문, continue문

public class JavaTask15 {

    // continue 1 - 1~100까지의 정수 중 짝수만 출력하기
    public static void main(String[] ar) {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1)
                continue;
            System.out.println(i);
        }
        System.out.println();
        main2(ar);
    }

    // continue 2 - 1~10 중 5를 제외한 나머지만 출력하기
    public static void main2(String[] ar) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5)
                continue;
            System.out.println(i);
        }
        System.out.println();
        main3(ar);
    }

    // continue 3 - 1~100 정수 중 5의 배수만 출력하기
    public static void main3(String[] ar) {
        for (int i = 1; i <= 100; i++) {
            if (i % 5 != 0)
                continue;
            System.out.println(i);
        }
        System.out.println();
        main4(ar);
    }

    // break 1 - 15일 때 반복문 중단하기 (for문 ver)
    public static void main4(String[] ar) {

        //          ;; 란 조건을 비워둔다는 의미임.(=언제나 true, 무한루프)
        for (int i = 1; ; i++) {
            System.out.println(i);
            if (i == 15)
                break;
        }
        System.out.println();
        main5(ar);
    }

    // break 2 - 15일 때 반복문 중단하기 (while문 ver)
    public static void main5(String[] ar) {
        int i = 1;
        while (true) {
            System.out.println(i);
            if (i == 15)
                break;
            i++;
        }
        System.out.println();
        main6(ar);
    }

    // break 3 - random()함수에서 6이 나오면 중단하는 프로그램
    public static void main6(String[] ar) {
        int i = 1;
        while (true) {
            i++;
            int num = (int) (Math.random() * 6) + 1;
            if (num == 6)
                break;
            System.out.println(num);
        }
        System.out.println("루프횟수: " + (i - 1));
    }
}
