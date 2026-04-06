package task.java2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// AWT(Abstract Window Toolkit) 예제
// 버튼을 클릭하면 창의 배경색이 바뀌는 간단한 이벤트 처리 프로그램
// RED 버튼을 누르면 창이 빨개지고 BLUE 버튼을 누르면 파래지는 GUI(그래픽 사용자 인터페이스) 예제

class ColorEvent implements  ActionListener {

    Frame f;
    Button redBtn, blueBtn;

    public ColorEvent( ) {

        f = new Frame("Event Test");

        f.addWindowListener(new WindowAdapter( ){
            public void windowClosing(WindowEvent e) {
                System.exit(0); // [포인트1] 프로세스를 완전히 종료시켜 메모리 점유를 막음
            }
        });

        redBtn = new Button("RED");
        blueBtn = new Button("BLUE");

        f.setLayout(new FlowLayout()); // [포인트2] 컴포넌트를 물 흐르듯 왼쪽->오른쪽으로 배치하는 레이아웃
        f.add(redBtn);
        f.add(blueBtn);

        f.setSize(300,200);
        f.setVisible(true); // [포인트3] 이 코드가 없으면 창이 메모리에는 떠 있지만 화면엔 안 보임

        redBtn.addActionListener(this);
        blueBtn.addActionListener(this);
    }//생성자 끝

    public void actionPerformed(ActionEvent e){
        // java.util.EventObject;
        if(e.getSource() == redBtn){ // [포인트4] 주소값 비교(==)를 통해 클릭된 버튼 객체를 정확히 판별
            f.setBackground(new Color(255,0,0));
        } else if(e.getSource() == blueBtn){
            f.setBackground(Color.blue);
        }

// java.awt.event.ActionEvent;
/* if(e.getActionCommand()=="빨간색"){
          f.setBackground(Color.red);
       } else {
          f.setBackground(Color.blue);
       }*/
    }
}

public class JavaTask45 {
    public static void main(String[] args) {
        ColorEvent ce = new ColorEvent( );
    }
}