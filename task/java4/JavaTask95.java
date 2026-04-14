package task.java4;

// 4/13 과제
// 키보드로 입력한 문장을 파일 result.txt에 저장하는 프로그램을 작성하시오.
// 키보드 입력은 BufferedReader, 파일 출력은 FileWriter 클래스

import java.io.*;

class FileTest95 {
    public void execute() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter file = null;
        System.out.println("JavaTask95 - 키보드로 문장 입력하기 (result.txt 파일 생성 및 저장됨)");

        try {
            String inputString = br.readLine();
            file = new FileWriter("result.txt");
            file.write(inputString);

            System.out.println("입력한 문장: " + inputString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        }

    }
}

class FileTest95T2 {
    public void execute() {
        System.out.println("JavaTask95 22버전 - 키보드로 문장 입력하기 (result22.txt 파일 생성 및 저장됨)");

        // ; 세미콜론으로 2가지 리소스 조건 선언하기
        try (BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("result22.txt"))) {

            String inputString = br2.readLine();
            bw2.write(inputString);
            System.out.println("입력한 문장22: " + inputString);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}

public class JavaTask95 {
    public static void main(String[] args) {
        FileTest95 obj = new FileTest95();
        obj.execute();
        FileTest95T2 obj2 = new FileTest95T2();
        obj2.execute();
    }
}
