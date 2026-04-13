package task.kotlin3

// 예외처리 throw - 예외 발생시키기. 강제로 예외를 발생시킴!
// 예외처리 throws - 예외 떠넘기기. 메서드 선언부에 throws 키워드를 사용하여 해당 메서드에서
//                  발생할 수 있는 예외를 명시적으로 선언할 수 있다.
//                  에러를 처리할 적임자에게 책임을 넘기기에 가깝다

// 구성편집 -> 프로그램인수에 적어서 실행하면됨
// run configuration -> 구성편집누르고 arguments
class ThrowsEx1 {
    companion object {
        fun execute(args: Array<String>) {
            val t1 = ThrowsEx1()
            try {
                t1.setData(args[0])
            } catch (e: Exception) {
                println("첫문자가 숫자가 아닙니다.")
            }
        }
    }

    fun setData(n: String) {    // 코틀린은 checked exception 없음 -> throws 선언 불필요
        if (n.length >= 1) {
            val str = n.substring(0, 1)
            printData(str)
        }
    }

    private fun printData(n: String) {
        // 코틀린은 throws 선언 없이 그냥 예외 발생 가능 (unchecked exception만 존재)
        val dan = n.toInt()     // NumberFormatException 발생 가능 (throws 불필요)
        println("${dan}단")
        println("-----------")
        for (i in 1..9)
            println("$dan*$i=${dan * i}")
    }
}

// 기본 예외처리 구문 (직접 해결)
class ThrowsException {
    companion object {
        fun execute() {
            val te = ThrowsException()
            te.occurException()
        }
    }

    // 나눗셈을 구하는 메소드
    fun occurException() {
//      val result = 3 / 0    // 이것만 있으면 예외처리 없어서 터짐

        try {
            val result = 3 / 0
            println("result : $result")
        } catch (e: ArithmeticException) {
            println("0으로 나눌 수 없습니다. 예외 메시지: ${e.message}")
        }
    }
}

// ThrowsException 예제를 throws 처리하여 예외를 양도한 형태
class ThrowsExceptionHandling1 {
    companion object {
        fun executeMain() {
            val te = ThrowsExceptionHandling1()
            try {
                // 예외처리를 try구문에서 직접 하지 않겠다
                te.occurException()
            } catch (ae: ArithmeticException) {
                println("Exception이 발생 : ${ae.toString()}")
                println("0으로 나눌 수 없습니다.")
            }
        }
    }

    // 코틀린은 throws 키워드 없음. 예외 발생 가능성은 @Throws 어노테이션으로 표현 (Java 호환용)
    // occurException()를 호출한 곳으로 예외처리를 양도하겠다는 의미
    @Throws(ArithmeticException::class)     // Java 호환용. 순수 코틀린에선 생략 가능
    fun occurException() {
        val result = 3 / 0                  // ArithmeticException 발생
        println(result)
    }
}

fun main(args: Array<String>) {
    ThrowsEx1.execute(args)
//  ThrowsException.execute()
//  ThrowsExceptionHandling1.executeMain()
}

/*

| Java 코드                          | Kotlin 대체                        | 이유                                                    |
|------------------------------------|------------------------------------|---------------------------------------------------------|
| throws NumberFormatException       | 선언 불필요                         | 코틀린은 checked exception 없음, 모든 예외가 unchecked   |
| Integer.parseInt(n)                | n.toInt()                          | 코틀린 확장함수, 실패 시 동일하게 NumberFormatException 발생 |
| public void throws XxxException    | @Throws(XxxException::class)       | 순수 코틀린에선 생략 가능, Java 코드와 혼용 시에만 필요   |
| static void execute()              | companion object { fun execute() } | 코틀린 정적 메서드 표현                                  |

 */