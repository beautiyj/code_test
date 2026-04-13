package task.kotlin3

// 제네릭<>을 활용한 리스트 예제 + ArrayList
// 제네릭은 컬렉션 프레임워크에 속하는 거의 모든 인터페이스 & 클래스에서 사용 가능함.

fun main() {

    // generic 제네릭: 한 가지 자료형의 데이터만 저장하도록 만들어주는 기능
    val list: MutableList<String> = ArrayList()

    list.add("Java")
    list.add("JDBC")
    list.add("Servlet/JSP")
    println("현재 리스트: $list")
    list.add(2, "Database")
    println("현재 리스트: $list")
    list.add("iBATIS")
    println("현재 리스트: $list")
    println()
    println("-----------------------------------------------------------")

    val size: Int = list.size
    println("총 객체 수: $size")

    // 제네릭 처리된 건 다운캐스팅 없이 바로 String으로 꺼낼 수 있음
//  val skill: String = list[2] as String  다운캐스팅 패스 가능(자동으로 처리됨)
    val skill: String = list[2]
    println("2: $skill")
    println()
    println("-----------------------------------------------------------")

    for (i in 0 until list.size) {
        val str: String = list[i]
        println("$i: $str")
    }
    println()
    println("-----------------------------------------------------------")

    list.removeAt(2)        // 2번 인덱스 객체 삭제 (Database)
    println("2번 인덱스 Database 삭제 후 변경됨: ${list[2]}")

    list.removeAt(2)        // 2번 인덱스 객체 삭제 (Servlet/JSP)
    println("2번 인덱스 Servlet/JSP 삭제 후 변경됨: ${list[2]}")
    println("현재 리스트: $list")

    list.remove("iBATIS")
    println("iBATIS 데이터 삭제, 현재 리스트: $list")
    println()
    println("-----------------------------------------------------------")

    for (i in 0 until list.size) {
        val str: String = list[i]
        println("$i: $str")
    }
}