package task.kotlin4

// 입출력스트림 writer() OutputStream()

import java.io.*

class FileOutputStreamTest {
    companion object {
        fun execute() {
            try {
                val fis = FileInputStream("read.txt")
                val fos = FileOutputStream("read1.txt")

                var input: Int
                while (fis.read().also { input = it } != -1) {
                    print(input.toChar())   // 화면에 출력
                    fos.write(input)        // 다른 파일에 쓰기
                }
                fos.close()
                fis.close()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}

class FileWriterTest {
    companion object {
        fun main(args: Array<String>) {
            try {
                val fr = FileReader(args[0])
                val fw = FileWriter(args[1])

                var input: Int
                while (fr.read().also { input = it } != -1) {
                    print(input.toChar())   // 화면에 출력
                    fw.write(input)         // 다른 파일에 쓰기
                }
                fr.close()
                fw.close()
            } catch (io: IOException) {
                println(io)
            }
        }
    }
}

// BufferedReader, BufferedWriter - 실제로 자주 쓰이는 버퍼 활용 버전
class FileWriterTest91 {
    companion object {
        fun execute(source: String, target: String) {
            // use {} = Java try-with-resources 대응 (자동 close)
            try {
                BufferedReader(FileReader(source)).use { br ->
                    BufferedWriter(FileWriter(target)).use { bw ->
                        var line: String?
                        while (br.readLine().also { line = it } != null) {
                            println(line)           // 콘솔 출력
                            bw.write(line!!)        // 파일 쓰기
                            bw.newLine()            // 줄바꿈 추가
                        }
                        println("복사 완료!")
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}

fun main() {
    // FileOutputStreamTest.execute()
    FileWriterTest.main(arrayOf("read.txt", "read2.txt"))
//  FileWriterTest91.execute("read.txt", "read2.txt")
}

/*
💡 Kotlin 실무 포인트
| Java 코드                                      | Kotlin 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| try(BufferedReader br = ...) {}                | BufferedReader(...).use { br -> }        | 코틀린 use{} = Java try-with-resources 대응, 자동 close     |
| while ((input = fis.read()) != -1)             | while (fis.read().also { input = it } != -1) | 코틀린 also 활용 패턴                                  |
| new FileWriter(args[1])                        | FileWriter(args[1])                      | new 키워드 불필요                                           |
| FileReader / FileWriter 직접 사용              | 실무: File("path").readText() / writeText() | 코틀린 표준 라이브러리 간결 파일 API                      |
*/