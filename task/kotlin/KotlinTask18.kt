package task.kotlin

fun main(){
    val s = intArrayOf(30,20,75,29,80,12)
    s.sort()

    println(s)  // 이러면 주소가 나옴
    println(s.joinToString())
    println(s.joinToString(",","[","]"))

    s.sortDescending()
    println(s.joinToString())
}