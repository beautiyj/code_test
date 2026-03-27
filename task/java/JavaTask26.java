package task.java;

// 오버로딩


import lombok.*;

class CarClass{
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    public CarClass(){
    }

    public CarClass(String model) {
        this.model = model;
    }

    public CarClass(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public CarClass(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

}

class Car{
    String company;
    String model;
    String color;
    int maxSpeed;

    public Car(){
        this("회사 미정", "모델 미정", null, 0);
    }

    public Car(String company, String model, String color, int maxSpeed) {
        this.company = company;
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}

@Getter
@Setter
@ToString
@NoArgsConstructor  // 빈 생성자 자동 생성
@AllArgsConstructor // 모든 필드 주입 생성자 자동 생성
class RealWorldCar {
    private String company = "현대자동차";
    private String model;
    private String color;
    private int maxSpeed;

    // 빌더 패턴 활용
    @Builder
    public RealWorldCar(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}

public class JavaTask26 {
    public static void main(String[] args) {
        CarClass car1 = new CarClass();
        System.out.println("car1.company " + car1.company);
        System.out.println();

        CarClass car2 = new CarClass("모델: 자가용");
        System.out.println("car2.company " + car2.company);
        System.out.println("car2.model " + car2.model);
        System.out.println();

        CarClass car3 = new CarClass("모델: 자가용","컬러: 빨강");
        System.out.println("car3.model " + car3.model);
        System.out.println("car3.color " + car3.color);
        System.out.println();

        CarClass car4 = new CarClass("모델: 택시", "컬러: 검정", 200);
        System.out.println("car4.color " + car4.color);
        System.out.println("car4.maxSpeed " + car4.maxSpeed);
        System.out.println();

        System.out.println("this 활용하기");
        Car car = new Car();
        System.out.println(car);    // 주소만나오기땜시 원하면 toString() 클래스내에서 로직처리
        System.out.println(car.company);    // 이건노가다방식...

        System.out.println("lombok 활용하기");
        RealWorldCar realCar = new RealWorldCar("제네시스", "블랙", 250);
        System.out.println(realCar);

        // 빌더 패턴 활용
        RealWorldCar builderCar = RealWorldCar.builder()
                .model("아이오닉")
                .maxSpeed(180)
                .build();
        System.out.println("빌더 활용: " + builderCar);

    }
}