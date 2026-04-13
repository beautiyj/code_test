package task.kotlin3

// 예외처리
// try-catch 구문

// 1. 산술 예외 처리 (특정 예외 지정)
class DivideZeroExceptionHandling1 {
    companion object {
        fun execute() {
            var b = 20; var a = 0; var c = 0

            try {
                c = b / a               // 예외 발생. 무한대돼서 에러
            } catch (ae: ArithmeticException) {     // 산술예외
                println("ArithmeticException - 0으로 나눌 수 없습니다.")
                println("Log: ${ae.message}")
                a = 2
                c = b / a
            }
            println("결과 1: $c")
        }
    }
}

// 2. 모든 예외 처리 (부모 클래스 Exception 사용)
class DivideZeroExceptionHandling2 {
    companion object {
        fun execute() {
            var b = 20; var a = 0; var c = 0
            try {
                c = b / a
            } catch (e: Exception) {
                println("Exception - 0으로 나눌 수 없습니다.")
                println("Log: ${e.message}")    // / by zero 라고 정해진 메시지 출력됨
                a = 2
                c = b / a
            }
            println("결과 2: $c")
        }
    }
}

// 3. 예외 정보 상세 출력 (printStackTrace 등)
class DivideZeroExceptionHandling3 {
    companion object {
        fun execute() {
            var b = 20; var a = 0; var c = 0
            try {
                c = b / a
            } catch (e: Exception) {
                e.printStackTrace()     // printStackTrace()는 빨간글씨의 에러부분 표시
                println("getMessage() 메시지: ${e.message}")
                println("toString 메시지: ${e.toString()}")
                println("printStackTrace() 메시지: ")
                /*
                printStackTrace는 에러종류 + 위치 + 이유
                toString()은 에러종류 + 이유
                getMessage는 에러 이유만 출력해준다.
                */
            }
        }
    }
}

fun main() {
//  DivideZeroExceptionHandling1.execute()
//  DivideZeroExceptionHandling2.execute()
    DivideZeroExceptionHandling3.execute()
}