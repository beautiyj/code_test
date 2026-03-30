package task.kotlin

class Calculator {
    fun plus(a: Int, b: Int): Int {
        val result = a + b
        return result
    }

    fun avg(x: Int, y: Int): Double {
        val totalSum = plus(x, y).toDouble() // sum -> totalSum (실무 추천)
        val result = totalSum / 2
        return result
    }

    fun execute() {
        val result = avg(7, 10)
        println("result: $result")
    }

    fun println(message: String) {
        System.out.println(message)
    }
}

fun main() {
    val calculator = Calculator()
    calculator.execute() // result: 8.5
}