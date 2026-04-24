package task.java4;

// 입출력스트림 writer() OutputStream()

import java.io.*;

class FileOutputStreamTest {
    public static void excute() {
        try {
            // * 첫째 인수로 지정된 파일 객체에서 읽어서 둘째 인수로 지정된 파일 객체에 출력함
            // (즉, 동일한 파일이 생성됨), File에서 데이터를 읽어오는 FileInputStream 객체 생성
            FileInputStream fis = new FileInputStream("read.txt");
            // File에 데이터를 전송하기 위한 FileOutputStream 객체 생성
            FileOutputStream fos = new FileOutputStream("read1.txt");

            int input = 0;

// File에 저장된 모든 데이터를 스트림을 통해 읽어 들여 File에 저장, 파일의 내용을 끝까지 다 읽으면 -1이 반환됨.
            while ((input = fis.read()) != -1) {
                System.out.print((char) input); //화면에 출력 부분
                fos.write(input); // 다른 파일에 쓰는 부분
            }
            // FileInputStream, FileOutputStream을 해제
            fos.close();
            fis.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//main() end
}

class FileWriterTest {
    public static void main(String[] args) {
        try {
            // 명령행 첫번째 인수로 들어오는 값을 인수로 받아 들여 FileReader 객체 생성
            FileReader fr = new FileReader(args[0]);
            // 명령행 두번째 인수를 생성자의 argument로 받아 들여 FileWriter 객체 생성
            FileWriter fw = new FileWriter(args[1]);

            int input = 0;

            // File에 저장된 모든 데이터를 스트림을 통해 읽어 들여 다른File에 저장
            while ((input = fr.read()) != -1) {
                System.out.print((char) input); //화면에 출력 부분
                fw.write(input); // 다른 파일에 쓰는 부분
            }
            // FileInputStream, FileOutputStream을 해제
            fr.close();
            fw.close();
        } catch (IOException io) {
            System.out.println(io);
        }
    }//main() end
}

// BufferedReader, BufferedWriter - 읽는 단위 2바이트, 한글은 1글자만 읽음
// 실제로 자주 쓰이는 버퍼활용 버전
class FileWriterTest91 {
    public static void execute(String source, String target) {
        // try() 안에 선언하면 close()를 자동으로 호출해줍니다.
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter bw = new BufferedWriter(new FileWriter(target))) {

            String line;
            // 한 줄씩 읽어서 복사 (속도가 훨씬 빠름)
            while ((line = br.readLine()) != null) {
                System.out.println(line); // 콘솔 출력
                bw.write(line);           // 파일 쓰기
                bw.newLine();             // 줄바꿈 추가 (readLine은 줄바꿈을 버리기 때문)
            }
            System.out.println("복사 완료!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class JavaTask91 {
    public static void main(String[] args) {
        // FileOutputStreamTest.execute();
        FileWriterTest.main(new String[]{"read.txt", "read2.txt"});
//        FileWriterTest91.execute("read.txt", "read2.txt");
    }
}
