package task.kotlin2

/*
특징                   Java                           Python                Kotlin
기본 도구     split() (배열), StringTokenizer    split() (리스트)          split() (리스트)
메모리 절약형     StringTokenizer (일회용)        generator / iterator     Sequence (Lazy 처리)
함수/메소드 참조   :: (Method Reference)         함수 이름 그 자체          :: (Callable Reference)
 */

import java.util.*

// [Test 1] (StringTokenizerTest1 대응)
class StringTokenizerTest1 {
    fun stringTokenizerTest1() {
        val source1 = "111-111|강원도|춘천시|퇴계동"
        val st1 = StringTokenizer(source1, "|")

        val zip = st1.nextToken()
        val dou = st1.nextToken()
        val si = st1.nextToken()
        val dong = st1.nextToken()

        println("우편번호:$zip")
        println("도:$dou")
        println("시:$si")
        println("동:$dong")
    }
}

// [Test 2 & 3] (StringTokenizerTest2, 3 대응)
class StringTokenizerTest2And3 {
    fun runTests() {
        val str = StringTokenizer("이순신#을지문덕#강감찬#광개토대왕", "#")

        println("파싱할 문자열의 총갯수-> ${str.countTokens()}")
        println(str.nextToken()) // 이순신 소모

        while (str.hasMoreTokens()) {
            print("${str.nextToken()} ")
        }
        println()
    }
}

// [Split & Stream] (StringSplit 대응)
class StringSplit {
    fun stringSplit() {
        val str = "이순신#을지문덕#강감찬#광개토대왕"

        // 1. split 결과는 List로 반환됨 (불변 활용 용이)
        val arr = str.split("#")

        // 2. 향상된 for문 (코틀린 스타일)
        for (name in arr) {
            println(name)
        }

        // 3. 배열 전체 출력 (Arrays.toString 대응)
        println(arr)

        // 4. 메소드 참조 출력 (::println) - 자바와 동일!
        arr.forEach(::println)
    }
}

fun main() {
    StringTokenizerTest1().stringTokenizerTest1()
    println("--------------------")
    StringTokenizerTest2And3().runTests()
    println("--------------------")
    StringSplit().stringSplit()
}