package task.java3;

// 입출력스트림 read() reader()

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

class FileReaderTest {
    public static void excute() {
        // FileReader 객체 선언
        FileReader file = null;
        int inputValue = 0;

        try {
            // "data.txt" File과 stream 형성
            // 상대경로로 쓰려면 인텔리제이 기준 최상위 루트 안에 넣어둬야함.
            // 이클립스는 Workspace/프로젝트명/ 폴더 바로 아래. src폴더랑 같은 레벨에 두면 상대경로 인식.
            file = new FileReader("data.txt");
//            file = new FileReader("C:/Users/admin/Downloads/java_ex_test/data.txt");

            // file의 끝을 만날 때까지 데이터를 읽어 들임
            while ((inputValue = file.read()) != -1) {
                System.out.print((char) inputValue);
            }
            file.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//main() end
}

class FileInputStreamTest {
    public static void excute() {
        // 입력을 받아들이는 변수 선언
        int inputValue = 0;

        // FileInputStream 객체 선언
        FileInputStream file = null;

        try {
            // "read.txt"와 InputStream 형성
            file = new FileInputStream("read.txt");
//            file = new FileInputStream("C:\\Users\\admin\\Downloads\\java_ex_test\\read.txt");

            // file의 끝을 만날 때까지 데이터를 읽어 들임
            // read() 메소드는 File에서 한 byte씩 데이터를 읽어옴.
            // 읽어온 데이터를 int로 변환해서 리턴,파일의 끝을
            // 만나면 -1을 반환함.
            while ((inputValue = file.read()) != -1) {
                System.out.print((char) inputValue);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // stream을 형성한 file을 닫음
        try {
            file.close();
        } catch (IOException io) {
            System.out.println(io.toString());
        }
    }//main() end
}

// 실제로 자주 쓰는 방식은 트라이위드리소수문 + 버퍼드리더
class FileReaderTest90 {
    public static void excute() {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            // 한 줄씩 읽어서 null이 아닐 때까지 반복
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}

public class JavaTask90 {
    public static void main(String[] args) {
        FileReaderTest excute = new FileReaderTest();
//        execute.execute();

        FileInputStreamTest excute2 = new FileInputStreamTest();
//        excute2.execute();

        FileReaderTest90 excute3 = new FileReaderTest90();
        excute3.excute();

    }
}
