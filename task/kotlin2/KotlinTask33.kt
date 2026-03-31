package task.kotlin2

import task.java.T33        // 자바 클래스를 바로 불러올 수 있음!


fun main() {
    val t33 = T33() // 자바 클래스지만 코틀린 객체처럼 생성
    t33.printSuccess()  // 메소드 호출
}