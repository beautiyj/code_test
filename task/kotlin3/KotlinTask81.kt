package task.kotlin3

// throw, throws 예외처리 예제
// throw new 예외 클래스로 객체 생성, throw ArrayIndexOutOfBoundsException()로 예외 발생시킬 시점 조절 가능.

class ThrowException {
    companion object {
        fun execute(args: Array<String>) {
            val te = ThrowException()
            try {
                te.exceptionMethod()
            } catch (ab: ArrayIndexOutOfBoundsException) {
                println("배열의 index를 초과했습니다.")
                ab.printStackTrace()
            }
        }
    }

    @Throws(ArrayIndexOutOfBoundsException::class)  // Java 호환용, 순수 코틀린에선 생략 가능
    fun exceptionMethod() {
        val intA = intArrayOf(1, 2, 3, 4)
        for (i in 0 until 10) {
            // 예외를 던짐 - 예외가 발생할 시점을 조절할 수 있음
//            if (i == 4) throw ArrayIndexOutOfBoundsException()
            if (i == 2) throw ArrayIndexOutOfBoundsException()
            println(intA[i])
        }
    }
}

class CatchOrderEx {
    companion object {
        fun execute(args: Array<String>) {
            try {
                val data1 = args[0]
                val data2 = args[1]
                val value1 = data1.toInt()
                val value2 = data2.toInt()
                val result = value1 + value2
                println("$data1+$data2=$result")
            } catch (e: ArrayIndexOutOfBoundsException) {
                println("실행 매개값의 수가 부족합니다.")
            } catch (e: Exception) {
                println("실행에 문제가 있습니다.")
            } finally {
                println("다시 실행하세요.")
            }
        }
    }
}

class ThrowsEx {
    companion object {
        fun execute() {
            try {
                findClass()         // 메소드 호출
            } catch (e: ClassNotFoundException) {
                println("클래스가 존재하지 않습니다.")
            }
        }

        // 메소드 호출한 곳에 예외처리 떠넘기기
        @Throws(ClassNotFoundException::class)
        fun findClass() {
            Class.forName("java.lang.String81")     // 실제로 존재하지 않는 이름
//            Class.forName("java.lang.String")      // 에러 없이 완료됨
        }
    }
}

fun main(args: Array<String>) {
//  ThrowException.execute(args)
//  CatchOrderEx.execute(args)
    ThrowsEx.execute()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                       |
|----------------------------------------|------------------------------------------|------------------------------------------------------------|
| throws ArrayIndexOutOfBoundsException  | @Throws(XxxException::class)             | 순수 코틀린에선 생략 가능, Java 호환 시에만 필요             |
| throw new ArrayIndexOutOfBoundsException() | throw ArrayIndexOutOfBoundsException() | new 키워드 불필요                                          |
| Integer.parseInt(str)                  | str.toInt()                              | 코틀린 확장함수, 실패 시 NumberFormatException 발생         |
| catch (Exception e) 순서               | 동일 - 하위 예외를 먼저, Exception 마지막  | 상위 Exception을 먼저 쓰면 컴파일 경고                      |

💡 Python 실무 포인트
| Java 코드                              | Python 대체                              | 이유                                                       |
|----------------------------------------|------------------------------------------|------------------------------------------------------------|
| throws XxxException                    | 선언 불필요 / 독스트링 :raises 명시       | 파이썬은 throws 없음, 독스트링 관례                         |
| throw new XxxException()               | raise XxxException()                     | 파이썬 예외 발생 키워드                                    |
| Class.forName("java.lang.String81")    | importlib.import_module() / __import__() | 파이썬 동적 클래스 로딩 대응                               |
| finally { }                            | finally:                                 | 예외 여부 무관 무조건 실행                                  |
*/