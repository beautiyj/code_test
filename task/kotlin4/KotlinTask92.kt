package task.kotlin4

// 기본 타입 입출력 스트림 DataInputStream, DataOutputStream

import java.io.*

class DataIOTest {
    companion object {
        fun main(args: Array<String>) {
            try {
                val fos = FileOutputStream("iodata.txt")
                val dos = DataOutputStream(fos)

                // 각 데이터 타입에 맞는 write 메소드로 파일에 저장
                dos.writeBoolean(true)
                dos.writeChar('j'.code)
                dos.writeInt(1234)
                dos.writeFloat(3.14F)
                dos.writeDouble(123.5423)
                dos.writeUTF("gemini")

                val fis = FileInputStream("iodata.txt")
                val dis = DataInputStream(fis)

                // 각 데이터 타입에 맞게 read()로 파일에서 읽어 화면 출력
                println(dis.readBoolean())
                println(dis.readChar())
                println(dis.readInt())
                println(dis.readFloat())
                println(dis.readDouble())
                println(dis.readUTF())

                dos.close(); dis.close()
            } catch (io: IOException) {
                println(io.toString())
            }
        }
    }
}

fun main(args: Array<String>) {
    DataIOTest.main(args)
}

/*
💡 Kotlin 실무 포인트
| Java 코드                                      | Kotlin 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| dos.writeChar('j')                             | dos.writeChar('j'.code)                 | 코틀린 Char는 Int로 명시적 변환 필요                        |
| DataInputStream / DataOutputStream            | 실무: ObjectOutputStream + Serializable  | 타입 유지 직렬화는 객체 직렬화로 대체하는 경우 많음         |
| DataInputStream / DataOutputStream            | 실무: JSON (Gson/Jackson) 활용           | 실무에서 데이터 타입 유지 입출력은 JSON/Protobuf 선호       |
*/