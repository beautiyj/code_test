package task.kotlin2

// [Test 0] 주소 비교와 값 비교
object StringTest0 {
    fun stringTest0() {
        val str1 = "Java Programming".let { String(it.toCharArray()) }
        val str2 = "Java Programming".let { String(it.toCharArray()) }

        if (str1 === str2) println("같주소") else println("다른주소")

        val str3 = "Java Programming"
        val str4 = "Java Programming"
        if (str3 === str4) println("같주소") else println("다른주소")
        if (str1 == str3) println("같은 값") else println("다른 값")
    }
}

// [Test 1] 대소문자 변환
object StringTest1 {
    fun stringTest1() {
        val str1 = "Java Programming"
        str1.uppercase()

        println(str1)
        println(str1.uppercase())

        val str2 = str1.uppercase()
        val str3 = str1.lowercase()
        println("$str2, $str3")
    }
}

// [Test 2] 문자열 템플릿
object StringTest2 {
    fun stringTest2() {
        val gemini = "gemini"
        val johnharu = "johnharu"

        println("$gemini$johnharu")
        println("${gemini}${johnharu}100")
    }
}

// [Test 3] 인덱스 접근과 순회
object StringTest3 {
    fun stringTest3() {
        val message = "Java program creates many objects."
        println(message.length)

        for (i in message.indices) {
            if (message[i] == ' ') {
                println("index = $i")
            }
        }
    }
}

// [Test 4] 위치 찾기
object StringTest4 {
    fun stringTest4() {
        val message = "Java program creates many objects."

        println(message.indexOf('a'))
        println(message.indexOf(97.toChar()))
        println(message.indexOf('a', 13))
        println(message.indexOf("av"))
        println(message.indexOf("java", ignoreCase = true))
    }
}

// [Test 5] 공백 제거
object StringTest5 {
    fun stringTest5() {
        val str1 = "gemini   "
        val str2 = "   gemini "
        println(str1.trim() == str2.trim())
    }
}

// [Test 6] 부분 문자열과 유효성 검사
object StringTest6 {
    fun stringTest6() {
        val message = "Java program creates many objects."
        println(message.substring(13))
        println(message.substring(13..15))

        val jumin = "950101-1234567"
        when (jumin[7].digitToInt()) {
            1, 3 -> println("남")
            2, 4 -> println("여")
            else -> println("인식 불가")
        }
    }
}

// [Test 7] 치환과 정규식
object StringTest7 {
    fun stringTest7() {
        val oldStr = "자바는 객체지향 언어 입니다."
        println(oldStr.replace("자바", "Kotlin"))

        val phone = "010-1234-1234"
        println(phone.replaceFirst("-", " "))

        val data = "가격은 50,000원 입니다!!!"
        println(data.filter { it.isDigit() })
    }
}

// [Test 8] 분리 (Split)
object StringTest8 {
    fun stringTest8() {
        val jumin = "950101-1234567"
        val (front, back) = jumin.split("-")
        println("앞: $front, 뒤: $back")

        val text = "홍길동&이수홍,박연수,김자바-최명호"
        val names = text.split("&", ",", "-")

        names.forEach { print("$it\t") }
        println()
    }
}

fun main() {
    StringTest0.stringTest0()
    StringTest1.stringTest1()
    StringTest2.stringTest2()
    StringTest3.stringTest3()
    StringTest4.stringTest4()
    StringTest5.stringTest5()
    StringTest6.stringTest6()
    StringTest7.stringTest7()
    StringTest8.stringTest8()
}