package task.kotlin4

// File 클래스 - 파일/디렉토리 관리

import java.io.File

class FileTest {
    companion object {
        fun execute() {
            try {
                val temp = File("C:/java01", "temp")
                val tempFile = File("test90")

                // 디렉토리 생성 (mkdirs = 부모 디렉토리 없어도 생성 가능)
                println("create directory state : ${temp.mkdirs()}")
                println("create directory state : ${tempFile.mkdirs()}")

                // 디렉토리 삭제 - 비어있을 때만 가능
//              tempFile.delete()
//              println("delete directory state : ${temp.delete()}")

                // 비어있지 않은 디렉토리 안의 내용을 삭제하려면 리스트화 -> 삭제
                val list = temp.listFiles()
                list?.forEach { f ->                // ?. 안전호출 - listFiles()가 null일 수 있음
                    println(f.delete())
                }

                // File 클래스 정보 메소드
                println("temp canRead : ${temp.canRead()}")
                println("temp canWrite : ${temp.canWrite()}")
                println("temp absoluteFile : ${temp.absoluteFile}")
                println("temp name : ${temp.name}")
                println("temp parent : ${temp.parent}")
                println("temp path : ${temp.path}")
                println("temp isDirectory : ${temp.isDirectory}")
                println("temp isFile : ${temp.isFile}")
            } catch (e: Exception) { }
        }
    }
}

fun main() {
    FileTest.execute()
}

/*
💡 Kotlin 실무 포인트
| Java 코드                                      | Kotlin 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| temp.getAbsoluteFile()                         | temp.absoluteFile                        | 코틀린 프로퍼티 접근 방식                                   |
| temp.getName() / getParent() / getPath()       | temp.name / parent / path                | 코틀린 프로퍼티 접근 방식                                   |
| temp.isDirectory() / isFile()                  | temp.isDirectory / temp.isFile           | 코틀린 프로퍼티 접근 방식                                   |
| File[] list = temp.listFiles()                 | temp.listFiles()?.forEach { }            | ?. 안전호출 - listFiles()는 null 반환 가능                  |
| for (File f : list) { f.delete() }             | list?.forEach { f -> f.delete() }        | 코틀린 forEach + 안전호출                                   |
*/