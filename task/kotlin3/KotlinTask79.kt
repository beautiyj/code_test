package task.kotlin3

// 예외처리 try-catch-finally 구문
// finally 구문은 주로 파일을 닫을 때나 데이터베이스 연결 끊을 때 사용되는 구문.
// finally 안의 내용은 예외가 발생하든, 발생하지 않든 무조건 실행됨

class MultiExceptionHandling1 {
    companion object {
        fun execute() {
            val value = 20
//          val div = 0
            val div = 10

            val intArray = intArrayOf(1, 2, 3)

            try {
                val result = value / div
                println(result)

//              val arrayValue = intArray[4]
                val arrayValue = intArray[2]
                println(arrayValue)

            } catch (ae: ArithmeticException) {
                println(ae.toString())
            } catch (ai: ArrayIndexOutOfBoundsException) {
                ai.printStackTrace()
            } finally {
                println("예외가 발생했음!")     // 이건 예외든 아니든 무조건 실행됨
            }
        }
    }
}

fun main() {
    MultiExceptionHandling1.execute()
}