package task.java3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// 입출력스트림 Input

// InputStreamTest - 읽는 단위 1바이트, 1글자만 읽음
class InputStreamTest {
    public static void excute() {
        // InputStream 객체 생성
        //System.in은 표준입력 장치인 키보드로 부터 입력 받는것을 의미함.
        InputStream is = System.in;
        int inputValue = 0;
        System.out.print( "Input Data : " );
        try {
            // 키보드로부터 값을 입력 받음
            //read() 메소드는 1바이트를 읽어들여서 ascii 코드(0~127)값으로 casting함.
            // 예) 'A' 입력 → 65 반환, '1' 입력 → 49 반환
            inputValue = is.read();
        } catch ( IOException io ) {        // 입출력 관련 오류 발생 시 잡아주는 예외처리
            //	System.out.print(io.toString());    // 오류 클래스명 + 메시지 전체 출력
            System.out.print(io.getMessage());      // 오류 메시지만 출력
        } //한글 처리를 못함. 한글은 2~3바이트라서 깨져서 출력됨

        System.out.println( "InputData is " + inputValue );
        System.out.println( "InputData is " + (char)inputValue );
    }
}

// InputStreamReaderTest - 읽는 단위 2바이트, 한글은 1글자만 읽음
class InputStreamReaderTest {
    public static void excute() {

        // byte Stream인 is 선언
        InputStream is = System.in;
        // InputStreamReader 객체 선언
        InputStreamReader isr = new InputStreamReader( is );
//		InputStreamReader isr =	InputStreamReader(System.in); 이건한줄코드임 위에 2줄을 한줄로 줄인것. 보통은 위에 2줄로 선언과 생성을 따로 하는 편임.

        int inputValue = 0;
        System.out.print( "Input Value : " );
        try {
            // 키보드로 부터 데이터를 입력. 2바이트씩 읽어들이기 때문에 한글은 1자 밖에 입력이 안됨.
            // 키보드로 입력한 문자를 10진수 유니코드 변환함(아스키는 0~127이고)
            inputValue = isr.read();
        } catch ( IOException io ) {
            System.out.print(io.getMessage());
        }
        // 입력받은 데이타를 출력
        System.out.println( "Input Result : " + inputValue );
        System.out.println( "Input Result : " + (char)inputValue );
    }
}

// InputStreamReaderTest2 - 2바이트 × 배열크기, char[] 배열 크기만큼 읽음
class InputStreamReaderTest2 {
    public static void excute() {
        // byte Stream인 is 선언
        InputStream is = System.in;
        // InputStreamReader 객체 선언
        InputStreamReader isr = new InputStreamReader( is );

        int inputValue = 0;
        //배열의 크기:10, char형 2byte
        char[] temp = new char[10];
        System.out.print( "Input Value : " );

        try {
            // 키보드로부터 데이터를 입력
            inputValue = isr.read( temp );
        } catch ( IOException io ) {
        }

        System.out.println( "InputValue : " + inputValue );
        // char[]의 값을 출력
        for( int i=0 ; i<inputValue ; i++ ) {
            System.out.print( temp[i] );
        }
        // char[]을 String type으로 변환
        System.out.println( "char[] -> String : " +
                new String( temp ));
    }
}

// 3개의 테스트를 순서대로 실행하는 메인 클래스
public class JavaTask87 {
    public static void main( String[] args ) {
//        InputStreamTest.excute();
//        InputStreamReaderTest.excute();
        InputStreamReaderTest2.excute();
    }
}
