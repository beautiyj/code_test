package task.kotlin3

// 입출력스트림 read() reader()

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileReader
import java.io.IOException

// FileReader - 2바이트씩 읽음
class FileReaderTest {
    companion object {
        fun execute() {
            var file: FileReader? = null
            try {
                // 상대경로: 프로젝트 최상위 루트 기준
                file = FileReader("data.txt")
                var inputValue: Int
                while (file.read().also { inputValue = it } != -1) {
                    print(inputValue.toChar())
                }
                file.close()
            } catch (e: Exception) {
                println(e.toString())
            }
        }
    }
}

// FileInputStream - 1바이트씩 읽음
class FileInputStreamTest {
    companion object {
        fun execute() {
            var file: FileInputStream? = null
            try {
                file = FileInputStream("read.txt")
                var inputValue: Int
                while (file.read().also { inputValue = it } != -1) {
                    print(inputValue.toChar())
                }
            } catch (e: Exception) {
                println(e.toString())
            } finally {
                try {
                    file?.close()       // ?. 안전 호출 - null이면 close() 호출 안함
                } catch (io: IOException) {
                    println(io.toString())
                }
            }
        }
    }
}

// 실제로 자주 쓰는 방식: use {} + BufferedReader
class FileReaderTest90 {
    companion object {
        fun execute() {
            // use {} = Java try-with-resources 대응 (자동 close)
            try {
                BufferedReader(FileReader("data.txt")).use { br ->
                    var line: String?
                    while (br.readLine().also { line = it } != null) {
                        println(line)
                    }
                }
            } catch (e: IOException) {
                println("파일 읽기 오류: ${e.message}")
            }
        }
    }
}

fun main() {
//    FileReaderTest.execute()
//    FileInputStreamTest.execute()
    FileReaderTest90.execute()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                              | Kotlin 대체                              | 이유                                                             |
|----------------------------------------|------------------------------------------|------------------------------------------------------------------|
| try(BufferedReader br = ...) {}        | BufferedReader(...).use { br -> }        | 코틀린 use{} = Java try-with-resources 대응                     |
| file.close()                           | use {} 블록 자동 처리                    | use 블록 종료 시 자동 close()                                    |
| (char) inputValue                      | inputValue.toChar()                      | 코틀린 명시적 형변환 함수                                        |
| file != null ? file.close() : ...      | file?.close()                            | 코틀린 안전 호출 연산자                                          |
| while ((line = br.readLine()) != null) | while (br.readLine().also { line = it } != null) | 코틀린 also 활용 패턴                               |
| FileReader / FileInputStream           | 실무: File("path").readText() / readLines() | 코틀린 표준 라이브러리 파일 읽기 간결 API                   |
*/