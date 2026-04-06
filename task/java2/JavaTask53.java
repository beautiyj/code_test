package task.java2;

// p341~342
class Calculator53 {
    double areaCircle(double r) {
        System.out.println("Calculator 객체의 areaCircle() 실행");
        return 3.14159 * r * r;
    }
}

class Computer53 extends Calculator53 {
    //메소드 오버라이드
    @Override
    double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }
}

// p342
class Airplane {
    public void land() {
        System.out.println("착륙합니다");
    }
    public void fly() {
        System.out.println("일반비행합니다");
    }
    public void takeoff() {
        System.out.println("이륙합니다");
    }
}

/*
부모클래스의 fly() 메소드를 자식 클래스에서 메소드 오버라이딩하면 자식클래스에서 메소드 오버라이딩된 메소드만 호출됨.
그럼 부모클래스의 fly() 메소드는 은닉메소드가 됨, 호출하려면 super.fly()로 호출 필요.
 */
class SupersoicAirplane extends Airplane {
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;

    public int flyMode = NORMAL;

    @Override
    public void fly() {
        if (flyMode == NORMAL) {
            System.out.println("초음속비행합니다");
        } else {
            super.fly();
        }
    }
}


public class JavaTask53 {
    public static void main(String[] args) {
        int r = 10;
        // 부모클래스 안의 메소드만 호출됨
        Calculator53 calculator = new Calculator53();
        System.out.println("원면적: " + calculator.areaCircle(r));

        // 재정의된 메소드 호출
        Computer53 computer = new Computer53();
        System.out.println("원면적: " + computer.areaCircle(r));

        System.out.println();

        SupersoicAirplane supersoicAirplane = new SupersoicAirplane();
        supersoicAirplane.takeoff();        // 이륙합니다
        supersoicAirplane.fly();            // 초음속비행합니다
        supersoicAirplane.flyMode = SupersoicAirplane.SUPERSONIC;
        supersoicAirplane.fly();            // 일반비행합니다
        supersoicAirplane.flyMode = SupersoicAirplane.NORMAL;
        supersoicAirplane.fly();            // 초음속비행합니다
        supersoicAirplane.land();           // 착륙합니다
    }
}
