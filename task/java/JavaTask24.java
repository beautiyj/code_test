package task.java;

// 클래스, 생성자, 메소드

// 1. 기본 생성자에서 메시지만 출력 (필드는 기본값 0으로 초기화됨)
class MyDate1 {
    private int year;
    private int month;
    private int day;

    public MyDate1() {
        System.out.println("[MyDate1 생성자] : 객체가 생성될 때 자동 호출됩니다.");
    }

    public void print() {
        System.out.println("MyDate1: " + year + "/" + month + "/" + day);
    }
    // 결과: 0/0/0
}

// 2. 기본 생성자에서 특정 날짜로 값을 직접 고정 (하드코딩)
class MyDate2 {
    private int year;
    private int month;
    private int day;

    public MyDate2() { // 기본 생성자
        year = 2023;
        month = 4;
        day = 1;
    }

    public void print() {
        System.out.println("MyDate2: " + year + "/" + month + "/" + day);
    }
    // 결과: 2023/4/1
}

// 3. 매개변수가 있는 생성자만 만들었을 때 (가장 중요한 오류 포인트!)
class MyDate3 {
    int year;
    int month;
    int day;

    // 매개변수가 있는 생성자를 직접 정의함
    public MyDate3(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void print() {
        System.out.println("MyDate3: " + year + "/" + month + "/" + day);
    }
    // 데이터 주입 출력해야함
}

// 4. 기본 생성자와 매개변수 생성자를 둘 다 만들었을 때
class MyDate4 {
    private int year;
    private int month;
    private int day;

    public MyDate4() { // 기본 생성자 수동 추가
    }

    public MyDate4(int new_year, int new_month, int new_day) {
        year = new_year;
        month = new_month;
        day = new_day;
    }

    public void print() {
        System.out.println("MyDate4: " + year + "/" + month + "/" + day);
    }
    // 결과: 0/0/0  데이터 주입 시 주입한 데이터대로 출력됨
}


public class JavaTask24 {
    public static void main(String[] args) {

        // --- MyDate1 테스트 ---
        MyDate1 d1 = new MyDate1();
        d1.print(); // 결과: 0/0/0

        // --- MyDate2 테스트 ---
        MyDate2 d2 = new MyDate2();
        d2.print(); // 결과: 2023/4/1

        // --- MyDate3 테스트 (오류 주의!) ---
        // MyDate3 d3 = new MyDate3(); // ❌ 오류 발생! (기본 생성자가 자동 생성되지 않음)
        // d3.print();

        MyDate3 d3_fixed = new MyDate3(2023, 7, 19); // 값을 넣어서 호출해야 함
        d3_fixed.print();

        // --- MyDate4 테스트 (가장 유연함) ---
        MyDate4 d4_empty = new MyDate4(); // 빈 괄호 가능
        d4_empty.print(); // 결과: 0/0/0

        MyDate4 d4_data = new MyDate4(2023, 7, 19); // 데이터 주입 가능
        d4_data.print();
    }
}
