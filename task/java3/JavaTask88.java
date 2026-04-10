package task.java3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// 입출력메소드 BufferedReader
// + 예제:  키보드로 숫자 입력 받아서 해당 구구단 출력하는 프로그램.
//   제한사항: 입력 받을 때 BufferedReader 클래스 사용하기

class BufferedReaderTest {
    public static void excute(String[] args) {

        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        */
        System.out.print("Input Data : ");

        try {   //입력한 한줄을 모두읽음.
            String inputString = br.readLine();
            System.out.println();
            System.out.println("Output String = " + inputString);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }//main() end
}

// 키보드로 숫자 입력 받아서 해당 구구단 출력하는 프로그램
// 예외처리 필요함
class BufferedReaderEx {
    public static void excute(String[] args) {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        try {
            System.out.print("Input data 숫자: ");
            String inputString = br.readLine();
            int dan = Integer.parseInt(inputString);
            System.out.println(dan + "단 출력");
            for (int i = 1; i <= 9; i++) {
//                System.out.println( dan + " x " + i + " = " + (dan*i) );
                System.out.printf("%d x %d = %d\n", dan, i + 1, dan * (i + 1));
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

    }
}

public class JavaTask88 {
    public static void main(String[] args) {
//        BufferedReaderTest.excute( args );
        BufferedReaderEx.excute(args);
    }
}
