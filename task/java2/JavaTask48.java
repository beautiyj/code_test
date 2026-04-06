package task.java2;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class FrameTest {
    private Frame f;
    public FrameTest() {
        // 클래스 내부에서 다른 객체를 직접 생성해서 보관.(인스턴스화) Has-a(포함)방식.
        // 실행부에서는 FrameTest ft = new FrameTest(); 만 하면 된다.
        // 왜냐! 객체의 생성과 초기화(화면 출력)가 캡슐화되어있어서
        f = new Frame("Frame Test");
        f.setSize(400, 300);
        f.setLocation(100, 100);
        f.setBackground(Color.green);
        f.setVisible(true);
        f.setResizable(false);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class FrameTestEx extends Frame {
    public FrameTestEx() {
        // f = new Frame( "Frame Test" );
        super("Frame Test");  // 부모 클래스의 생성자 호출

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(400, 300);
        setLocation(100, 100);
        setBackground(Color.green);
        setVisible(true);
    }
}

public class JavaTask48 {
    public static void main(String[] args) {
        FrameTest ft = new FrameTest();

        FrameTestEx ftex = new FrameTestEx();
    }
}