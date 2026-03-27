package task.kotlin

// [버전 1: 학습용] 자바 스타일을 유지한 오버로딩
class CarClass(var model: String? = null, var color: String? = null, var maxSpeed: Int = 0) {
    val company: String = "현대자동차"
}

// [버전 2: 실무용] 코틀린의 정수 'Data Class'
// 생성자 하나로 빈 생성자부터 전체 주입까지 모두 대응 (Default Values)
data class RealWorldCar(
    val company: String = "현대자동차",
    val model: String = "모델 미정",
    val color: String = "색상 미정",
    val maxSpeed: Int = 0
)

fun main() {
    // --- 버전 1 테스트 ---
    val car1 = CarClass()
    println("학습용 car1.company: ${car1.company}\n")

    // --- 버전 2 테스트 (실무형) ---
    println("--- 실무용(Data Class) 테스트 ---")
    val realCar = RealWorldCar(model = "GV80", color = "화이트") // Named Arguments
    println(realCar) // 주소값 대신 "RealWorldCar(company=현대...)" 출력

    // 실무에선 copy() 기능을 자주 씁니다. (기존 객체 복사하며 일부만 수정)
    val updatedCar = realCar.copy(maxSpeed = 300)
    println("복사 및 수정: $updatedCar")
}