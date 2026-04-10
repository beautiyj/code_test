package task.java3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// 입출력메소드 BufferedReader
class BufferedReaderTest {
    public static void excute( String[] args ) {

        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader( is );
        BufferedReader br = new BufferedReader( isr );
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        */
        System.out.print( "Input Data : " );

        try {   //입력한 한줄을 모두읽음.
            String inputString = br.readLine();
            System.out.println();
            System.out.println("Output String = " + inputString );
        } catch ( IOException io ) {
            System.out.println( io.getMessage() );
        }
    }//main() end
}

public class JavaTask88 {
    public  static void main(String[] args) {
        BufferedReaderTest.excute( args );
    }
}
