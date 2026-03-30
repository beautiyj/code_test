package task.kotlin

class Car27 {
    var fuelLevel: Int = 0 // gas -> fuelLevel (실무 추천 변수명)

    fun setFuel(fuel: Int) {
        this.fuelLevel = fuel
    }

    fun isLeftFuel(): Boolean {
        if (fuelLevel == 0) {
            println("gas가 없습니다")
            return false
        }
        println("gas가 있습니다")
        return true
    }

    fun run() {
        while (true) {
            if (fuelLevel > 0) {
                println("gas잔량: $fuelLevel")
                fuelLevel -= 1
            } else {
                println("gas잔량: $fuelLevel")
                return
            }
        }
    }
}

fun main() {
    val myCar = Car27()
    myCar.setFuel(5)

    val gasState = myCar.isLeftFuel()
    if (gasState) {
        println("출발합니다")
        myCar.run()
    }

    if (myCar.isLeftFuel()) {
        println("gas를 주입할 필요가 없습니다")
    } else {
        println("gas를 주입하세요")
    }
}