package task.kotlin

fun main() {
    print("age: ")
    val age = readln().toInt()

    print("name: ")
    val name = readln()

    print("address: ")
    val address = readln()

    // readLine() 이 readlnOrNull() 로 바뀌었다고; 말그대로 널허용(널도들어가기가능)
    print("나이 입력: ")
    val ageStr = readlnOrNull() ?: "0"
    val age2 = ageStr.toIntOrNull() ?: 0

    println("결과값들: $age, $name, $address")
    println("변환된 나이: $age2")
}