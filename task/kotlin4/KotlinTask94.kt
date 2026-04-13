package task.kotlin4

// 입출력 스트림 - 객체 직렬화
// 객체 직렬화: 객체를 파일에 저장하고 읽어오는 것

import java.io.*
import java.util.*

// 객체 직렬화를 위해 Serializable 인터페이스 구현 (마커 인터페이스, 메소드 없음)
class PersonInformation(
    private val name: String,
    private val age: Int,
    private val address: String,
    private val telephone: String
) : Serializable {
    fun getName() = name
    fun getAge() = age
    fun getAddress() = address
    fun getTelephone() = telephone

    companion object {
        // serialVersionUID: 직렬화 버전 관리 (실무 필수)
        private const val serialVersionUID: Long = 1L
    }
}

class ObjectStreamTest {
    private val gemini = PersonInformation("gemini", 10, "seoul", "02-321-3234")
    private val johnharu = PersonInformation("johnharu", 20, "seoul", "02-473-4232")
    private val d = Date()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val ost = ObjectStreamTest()
            ost.writeObjectFile()
            ost.readObjectFile()
        }
    }

    fun writeObjectFile() {
        try {
            // use {} = Java try-with-resources 대응
            ObjectOutputStream(FileOutputStream("person.dat")).use { oos ->
                oos.writeObject(gemini)
                oos.writeObject(johnharu)
                oos.writeObject(d)
            }
        } catch (e: Exception) {
            println(e.toString())
        }
    }

    fun readObjectFile() {
        try {
            ObjectInputStream(FileInputStream("person.dat")).use { ois ->
                while (true) {
                    val o = try {
                        ois.readObject()
                    } catch (e: EOFException) {
                        break                       // 파일 끝 도달 시 루프 종료
                    }
                    if (o is PersonInformation) {   // instanceof 대응 - 코틀린 스마트 캐스트
                        print("${o.getName()} : ")
                        print("${o.getAge()} : ")
                        print("${o.getAddress()} : ")
                        println(o.getTelephone())
                    } else {
                        println(o.toString())
                    }
                }
            }
        } catch (e: Exception) { }
    }
}

fun main(args: Array<String>) {
    ObjectStreamTest.main(args)
}

/*
💡 Kotlin 실무 포인트
| Java 코드                                      | Kotlin 대체                              | 이유                                                        |
|------------------------------------------------|------------------------------------------|-------------------------------------------------------------|
| implements Serializable                        | : Serializable                           | 코틀린 인터페이스 구현 문법                                 |
| private static final long serialVersionUID     | companion object { const val serialVersionUID: Long = 1L } | 코틀린 직렬화 버전 관리  |
| if (o instanceof PersonInformation)            | if (o is PersonInformation)              | 코틀린 스마트 캐스트 - is 체크 후 자동 캐스팅               |
| ((PersonInformation) o).getName()              | o.getName() (스마트 캐스트로 캐스팅 불필요) | is 체크 후 블록 안에서 자동 타입 확정                      |
| try(ObjectOutputStream oos = ...) {}           | ObjectOutputStream(...).use { oos -> }  | 코틀린 use{} = Java try-with-resources 대응                |
| Serializable 직접 사용                         | 실무: kotlinx.serialization / Gson       | 코틀린 실무 직렬화는 kotlinx.serialization 표준             |
*/