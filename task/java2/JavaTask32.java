package task.java2;

import java.io.InputStream;
import java.util.Date;
import java.util.Scanner;

public class JavaTask32 {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

        // 그냥 인풋스트림은 한글이나 숫자 읽는게 어려워서 스캐너 변환을 자주 쓰는 거.
        InputStream inputStream = System.in;
        Scanner sc1 = new Scanner(System.in);   // InputStream타입의 정적필드가 in
        Scanner sc2 = new Scanner(inputStream);
//        Scanner sc3 = new Scanner(InputStream inputStream);



    }
}
