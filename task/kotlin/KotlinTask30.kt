package task.kotlin

class Lotto {
    fun isTrue(result: IntArray, count: Int, num: Int): Boolean {
        for (i in 0 until count) {
            if (result[i] == num) return true
        }
        return false
    }

    fun lotto(): IntArray {
        val result = IntArray(6)
        var count = 0
        while (count < 6) {
            val num = (Math.random() * 45).toInt() + 1
            if (!isTrue(result, count, num)) {
                result[count] = num
                count++
            }
        }
        result.sort()
        return result
    }
}


fun main() {
    val lotto = Lotto()
    println(lotto.lotto().contentToString())

    // 코틀린 더 간단하게 활용하는 방법 - 컬렉션함수 활용.
    // 1부터 45까지 숫자를 섞은(shuffled) 후 6개를 뽑아(take) 정렬(sorted)하는 방식
    val lottoNumbers = (1..45).shuffled().take(6).sorted()
    println(lottoNumbers)

}