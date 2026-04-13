package task.kotlin3

// 예외처리 try-catch-catch 구문 (멀티처리)
// 예외가 발생하지 않으면 try 구문의 블록만 실행된다.
// try 실행에 따라 catch 실행도 달라짐 (캐치구문 동시실행되는 경우는 없음!)

class MultiExceptionHandling {
    companion object {
        fun execute() {
            val value = 20
            val div = 0
            val intArray = intArrayOf(1, 2, 3)

            try {
//              val arrayValue = intArray[4]    // 이거 실행하면 ArrayIndexOutOfBoundsException 실행됨

                val result = value / div        // 예외 발생
                println(result)

                val arrayValue = intArray[4]    // 위에서 예외 발생하면 이건 실행 X
                println(arrayValue)

            } catch (ae: ArithmeticException) {
                println("result 계산 중 예외 발생")
                println(ae.toString())
            } catch (ai: ArrayIndexOutOfBoundsException) {
                println("arrayValue 인덱스 예외 발생")
                ai.printStackTrace()
            }
        }
    }
}

class ExceptionEx3 {
    companion object {
        fun execute(args: Array<String>) {
            val v = 50
            try {
//              val data = args[0].toInt()      // Exception 실행됨
//              val data = "abc".toInt()        // NumberFormatException 실행됨
                val data = "0".toInt()          // ArithmeticException 실행됨

                println(v / data)

                // Exception 예외 클래스가 하위 예외 클래스들을
                // 모두 가지고 있기 때문에 먼저 정의해서는 안된다.
            } catch (e: NumberFormatException) {
                println("숫자가 아닙니다.")
            } catch (e: ArithmeticException) {
                println("0으로 나눌순 없죠?")
            } catch (e: Exception) {
                println("Exception !!")
                println("프로그램 종료!")
            }
        }
    }
}

fun main(args: Array<String>) {
//  MultiExceptionHandling.execute()
    ExceptionEx3.execute(args)
}