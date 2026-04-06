package task.kotlin2

import java.awt.Button
import java.awt.Color
import java.awt.FlowLayout
import java.awt.Frame
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

// AWT(Abstract Window Toolkit) 예제
// 버튼을 클릭하면 창의 배경색이 바뀌는 간단한 이벤트 처리 프로그램
// RED 버튼을 누르면 창이 빨개지고 BLUE 버튼을 누르면 파래지는 GUI(그래픽 사용자 인터페이스) 예제

// 코틀린은 자바 AWT/Swing을 그대로 쓸 수 있지만,
// ActionListener 인터페이스를 구현하는 대신 람다식을 사용

class ColorEvent : ActionListener {

    var f: Frame
    var redBtn: Button
    var blueBtn: Button

    init {
        f = Frame("Event Test")

        // 익명 클래스 대신 object를 사용하여 리스너 구현
        f.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent) {
                System.exit(0) // [포인트1] 프로세스를 완전히 종료시켜 메모리 점유를 막음
            }
        })

        redBtn = Button("RED")
        blueBtn = Button("BLUE")

        f.layout = FlowLayout() // [포인트2] 컴포넌트를 물 흐르듯 왼쪽->오른쪽으로 배치하는 레이아웃
        f.add(redBtn)
        f.add(blueBtn)

        f.setSize(300, 200)
        f.isVisible = true // [포인트3] 이 코드가 없으면 창이 메모리에는 떠 있지만 화면엔 안 보임

        // 코틀린은 인터페이스를 직접 구현하는 대신 람다로 연결하는 것이 더 실무적이지만,
        // 자바 로직 유지를 위해 인터페이스 방식을 유지함
        redBtn.addActionListener(this)
        blueBtn.addActionListener(this)
    } // 생성자 끝

    override fun actionPerformed(e: ActionEvent) {
        // [포인트4] 주소값 비교(==)를 통해 클릭된 버튼 객체를 정확히 판별
        if (e.source === redBtn) {
            f.background = Color(255, 0, 0)
        } else if (e.source === blueBtn) {
            f.background = Color.blue
        }

        /* if(e.actionCommand == "빨간색"){
           f.background = Color.red
        } else {
           f.background = Color.blue
        }
        */
    }
}

fun main(args: Array<String>) {
    ColorEvent()
}