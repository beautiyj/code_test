package task.kotlin3

// Map 예제
// 잘 안쓰는 방식 - Hashtable 활용
// 잘 쓰는 건 HashMap

import java.util.*

// 잘 안쓰는 방식 - Hashtable 활용
class HashtableEx {
    val map: MutableMap<String, String> = Hashtable()

    fun hashtableKeyValue() {
        map["spring"] = "12"
        map["summer"] = "123"
        map["fall"] = "1234"
        map["winter"] = "12345"
    }

    fun hashtableMethod() {
        hashtableKeyValue()
        val sc = Scanner(System.`in`)

        while (true) {
            println("아이디와 비밀번호를 입력해주세요")
            print("아이디: ")
            val id = sc.nextLine()
            print("비밀번호: ")
            val pw = sc.nextLine()

            if (map.containsKey(id)) {
                if (map[id] == pw) {
                    println("로그인 성공")
                    break
                } else {
                    println("비밀번호가 일치하지 않습니다")
                }
            } else {
                println("입력하신 아이디가 존재하지 않습니다")
            }
        }
    }
}

class HashTableTest02 {
    fun hashTableTest02() {
        val ht: Hashtable<String, String> = Hashtable()
        ht["사과"] = "Apple"
        ht["딸기"] = "StrawBerry"
        ht["포도"] = "Grapes"

        // 키 알고 있을 때
        val value: String? = ht["포도"]
        if (value != null) {
            println("포도-> $value")
        }

        // 키 모를 때
        // keys()는 Hashtable에서, keySet()은 HashMap에서 사용
        // 코틀린 실무: Enumeration 대신 for-in 루프로 순회
        val enum = ht.keys()
        while (enum.hasMoreElements()) {
            val k = enum.nextElement()
            val v = ht[k]
            println("$k : $v")
        }
    }
}

// 잘 쓰는 건 HashMap
class HashMapKeyValue {
    private val hashMap: Map<String, String> = HashMap<String, String>().apply {
        (this as HashMap)["spring"] = "12"
        this["summer"] = "123"
        this["fall"] = "1234"
        this["winter"] = "12345"
    }

    fun hashMapMethod(userId: String, userPassword: String): Int {
        if (!hashMap.containsKey(userId)) return 1
        if (hashMap[userId] != userPassword) return 2
        return 0
    }
}

// --------------------------------------------------------------------------------------------

fun main() {

    // 1. Hashtable 예제 실행
    println("Hashtable 사용 예제")
    val hashtableEx = HashtableEx()
    hashtableEx.hashtableMethod()

    println("------------------------------------------------------")

    // 2. HashMap 예제 실행
    println("HashMap 사용 예제")
    val hashMapEx = HashMapKeyValue()

    Scanner(System.`in`).use { scanner ->      // use {} = Java try-with-resources 대응
        while (true) {
            println("[HashMap 로그인]")
            println("아이디와 비밀번호를 입력해주세요")
            print("아이디: ")
            val userId = scanner.nextLine()
            print("비밀번호: ")
            val userPassword = scanner.nextLine()

            when (hashMapEx.hashMapMethod(userId, userPassword)) {
                0 -> { println("로그인 성공"); break }
                1 -> println("입력하신 아이디가 존재하지 않습니다")
                2 -> println("비밀번호가 일치하지 않습니다")
            }
        }
    }

    println("------------------------------------------------------")

    // 3. HashTable 열거형 예제 실행
    val hashTableTest02 = HashTableTest02()
    hashTableTest02.hashTableTest02()
}