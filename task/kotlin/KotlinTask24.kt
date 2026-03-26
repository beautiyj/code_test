package task.kotlin

// 1. 기본 생성자에서 메시지만 출력 (필드는 기본값 0으로 초기화됨)
class MyDate1() {
    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0

    init {
        println("[MyDate1 생성자] : 객체가 생성될 때 자동 호출됩니다.")
    }

    fun printInfo() = println("MyDate1: $year/$month/$day")
}

// 2. 기본 생성자에서 특정 날짜로 값을 직접 고정 (하드코딩)
class MyDate2() {
    private var year: Int = 2023
    private var month: Int = 4
    private var day: Int = 1

    fun printInfo() = println("MyDate2: $year/$month/$day")
}

// 3. 매개변수가 있는 생성자만 만들었을 때
class MyDate3(private var year: Int, private var month: Int, private var day: Int) {
    fun printInfo() = println("MyDate3: $year/$month/$day")
}

// 4. 기본 생성자와 매개변수 생성자를 둘 다 만들었을 때 - Kotlin ver 코드 없음 (디폴트 인자로 해결)
class MyDate4(private var year: Int = 0, private var month: Int = 0, private var day: Int = 0) {
    fun printInfo() = println("MyDate4: $year/$month/$day")
}

// 5. 기본 생성자 + 매개변수 생성자 - Kotlin ver 코드 없음 (4번과 동일)

// 6. 변수 이름 충돌로 인한 변경 실패
class MyDate6(private var year: Int) {
    fun setYear(year: Int) {
        // 코틀린 파라미터는 기본적으로 val(상수)이라 year = year 자체가 불가능하여 자바와 동일한 오류 상황 안 나옴
        // 대신 지역 변수를 새로 선언하는 상황으로 가정
        val year = year
    }
    fun printInfo() = println("Step 6 Year: $year")
}

// 7. this 키워드로 이름 충돌 해결
class MyDate7(private var year: Int) {
    fun setYear(year: Int) {
        // this.year라고 명시해서 필드 값을 정확히 바꿈
        this.year = year
    }
    fun printInfo() = println("Step 7 Year: $year")
}

// 8. this() 생성자로 코드 중복 제거 (보조 생성자 활용)
class MyDate8(private var year: Int, private var month: Int, private var day: Int) {
    // 코틀린은 보조 생성자가 반드시 주 생성자를 호출해야 함 (this 키워드 사용)
    constructor() : this(2026, 1, 1)
    constructor(year: Int) : this(year, 1, 1)
    constructor(year: Int, month: Int) : this(year, month, 1)

    fun printInfo() = println("Step 8: $year/$month/$day")
}

fun main() {
    val d1 = MyDate1(); d1.printInfo()
    val d2 = MyDate2(); d2.printInfo()

    // val d3 = MyDate3() // ❌ 오류 발생!
    val d3_fixed = MyDate3(2023, 7, 19); d3_fixed.printInfo()

    val d4_empty = MyDate4(); d4_empty.printInfo()
    val d4_data = MyDate4(2023, 7, 19); d4_data.printInfo()

    val d6 = MyDate6(2023); d6.setYear(2024); d6.printInfo()
    val d7 = MyDate7(2023); d7.setYear(2024); d7.printInfo()

    val d8 = MyDate8(2023, 7); d8.printInfo()
}