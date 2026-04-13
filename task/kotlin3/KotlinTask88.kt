package task.kotlin3

// 입출력메소드 BufferedReader
// 과제: 키보드로 숫자 입력 받아서 해당 구구단 출력

import java.io.BufferedReader
import java.io.InputStreamReader

class BufferedReaderTest {
    companion object {
        fun execute() {
            val br = BufferedReader(InputStreamReader(System.`in`))
            print("Input Data : ")
            try {
                val inputString = br.readLine()
                println()
                println("Output String = $inputString")
            } catch (io: Exception) {
                println(io.message)
            }
        }
    }
}

// 키보드로 숫자 입력 받아서 해당 구구단 출력하는 프로그램
class BufferedReaderEx {
    companion object {
        fun execute() {
            val br = BufferedReader(InputStreamReader(System.`in`))
            try {
                print("Input data 숫자: ")
                val inputString = br.readLine()
                val dan = inputString.toInt()
                println("${dan}단 출력")
                for (i in 1..9) {
                    println("%d x %d = %d".format(dan, i + 1, dan * (i + 1)))
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}

fun main() {
//  BufferedReaderTest.execute()
    BufferedReaderEx.execute()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                       |
|----------------------------------------|------------------------------------------|------------------------------------------------------------|
| new BufferedReader(new InputStreamReader(System.in)) | BufferedReader(InputStreamReader(System.\`in\`)) | new 불필요, in 백틱 처리  |
| Integer.parseInt(str)                  | str.toInt()                              | 코틀린 확장함수                                             |
| System.out.printf("%d x %d = %d\n")   | "%d x %d = %d".format(...)              | 코틀린 문자열 format 함수                                   |
| BufferedReader 직접 사용               | 실무: readLine() 내장함수                | 코틀린 표준 라이브러리 readLine()이 더 간결                  |
*/