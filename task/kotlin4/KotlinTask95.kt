package task.kotlin4

// 과제 - 키보드로 입력한 문장을 파일 result.txt에 저장하는 프로그램

import java.io.*

class FileTest95 {
    fun execute() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var file: FileWriter? = null
        println("JavaTask95 - 키보드로 문장 입력하기 (result.txt 파일 생성 및 저장됨)")

        try {
            val inputString = br.readLine()
            file = FileWriter("result.txt")
            file.write(inputString)
            println("입력한 문장: $inputString")
        } catch (e: Exception) {
            println(e.message)
        } finally {
            try {
                file?.close()               // ?. 안전호출 - null이면 close() 호출 안함
            } catch (io: IOException) {
                io.printStackTrace()
            }
        }
    }
}

class FileTest95T2 {
    fun execute() {
        println("JavaTask95 22버전 - 키보드로 문장 입력하기 (result22.txt 파일 생성 및 저장됨)")

        // use {} 중첩 = Java try-with-resources 세미콜론 다중 리소스 대응
        BufferedReader(InputStreamReader(System.`in`)).use { br2 ->
            BufferedWriter(FileWriter("result22.txt")).use { bw2 ->
                try {
                    val inputString = br2.readLine()
                    bw2.write(inputString)
                    println("입력한 문장22: $inputString")
                } catch (io: IOException) {
                    println(io.message)
                }
            }
        }
    }
}

fun main() {
    val obj = FileTest95()
    obj.execute()
    val obj2 = FileTest95T2()
    obj2.execute()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                                      | Kotlin 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| try(BufferedReader br; BufferedWriter bw) {}   | br.use { bw.use { } } 중첩              | 코틀린은 use{} 중첩으로 다중 리소스 처리                    |
| if (file != null) file.close()                 | file?.close()                           | 코틀린 안전호출 연산자로 null 체크 간결화                   |
| new BufferedReader(new InputStreamReader(System.in)) | BufferedReader(InputStreamReader(System.\`in\`)) | in은 코틀린 예약어라 백틱 처리     |
| FileWriter("result.txt")                       | 실무: File("result.txt").writeText()    | 코틀린 표준 라이브러리 간결 파일 쓰기 API                   |
*/