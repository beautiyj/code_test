package task.kotlin3

// 입출력스트림 Input

import java.io.InputStream
import java.io.InputStreamReader

// InputStreamTest - 읽는 단위 1바이트, 1글자만 읽음
class InputStreamTest {
    companion object {
        fun execute() {
            val IS: InputStream = System.`in`
            var inputValue: Int
            print("Input Data : ")
            try {
                // read()는 1바이트를 읽어들여 아스키 코드값으로 반환
                inputValue = IS.read()
                println("InputData is $inputValue")
                println("InputData is ${inputValue.toChar()}")
            } catch (io: Exception) {
                print(io.message)
            }
        }
    }
}

// InputStreamReaderTest - 읽는 단위 2바이트
class InputStreamReaderTest {
    companion object {
        fun execute() {
            val IS: InputStream = System.`in`
            val isr = InputStreamReader(IS)
            print("Input Value : ")
            try {
                val inputValue = isr.read()
                println("Input Result : $inputValue")
                println("Input Result : ${inputValue.toChar()}")
            } catch (io: Exception) {
                print(io.message)
            }
        }
    }
}

// InputStreamReaderTest2 - char[] 배열 크기만큼 읽음
class InputStreamReaderTest2 {
    companion object {
        fun execute() {
            val IS: InputStream = System.`in`
            val isr = InputStreamReader(IS)
            val temp = CharArray(10)
            print("Input Value : ")
            try {
                val inputValue = isr.read(temp)
                println("InputValue : $inputValue")
                for (i in 0 until inputValue) {
                    print(temp[i])
                }
                println("char[] -> String : ${String(temp)}")
            } catch (io: Exception) { }
        }
    }
}

fun main() {
//  InputStreamTest.execute()
//  InputStreamReaderTest.execute()
    InputStreamReaderTest2.execute()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| System.in                              | System.\`in\`                            | in이 코틀린 예약어라서 백틱으로 감싸야 함                        |
| (char) inputValue                      | inputValue.toChar()                      | 코틀린 명시적 형변환 함수                                        |
| new String(temp)                       | String(temp)                             | new 키워드 불필요                                                |
| InputStream / InputStreamReader        | 실무: BufferedReader + use {}            | 실무에서 한 줄씩 읽기 표준 패턴                                  |
*/