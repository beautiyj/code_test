package task.kotlin2

import java.awt.Color
import java.awt.Frame
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

// 코틀린은 자바 AWT를 그대로 사용할 수 있으며, init 블록을 통해 생성자 로직을 처리

class FrameTest {
    private var f: Frame

    init {
        // 클래스 내부에서 다른 객체를 직접 생성해서 보관.(인스턴스화) Has-a(포함)방식.
        // 실행부에서는 FrameTest ft = FrameTest() 만 하면 된다.
        // 왜냐! 객체의 생성과 초기화(화면 출력)가 캡슐화되어있어서
        f = Frame("Frame Test")
        f.setSize(400, 300)
        f.setLocation(100, 100)
        f.background = Color.green
        f.isVisible = true
        f.isResizable = false

        f.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent) {
                System.exit(0)
            }
        })
    }
}

class FrameTestEx : Frame("Frame Test") { // 부모 클래스의 생성자 호출 (Is-a 상속)
    init {
        // f = Frame( "Frame Test" ) 가 필요 없음. 내가 곧 Frame이므로.

        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent) {
                System.exit(0)
            }
        })
        setSize(400, 300)
        setLocation(100, 100)
        background = Color.green
        isVisible = true
    }
}

fun main() {
    val ft = FrameTest()
    val ftex = FrameTestEx()
}