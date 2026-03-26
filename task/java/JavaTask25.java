package task.java;

// 클래스, 생성자, 메소드

// 5. 기본 생성자 + 매개변수 생성자
class MyDate5 {
    private int year, month, day;

    public MyDate5() { } // 기본 생성자를 수동으로 써줘서 오류 방지

    public MyDate5(int new_year, int new_month, int new_day) {
        year = new_year; month = new_month; day = new_day;
    }
    public void print() { System.out.println("Step 5: " + year + "/" + month + "/" + day); }
}

// 6. 변수 이름 충돌로 인한 변경 실패
class MyDate6 {
    private int year;

    public MyDate6(int year) { this.year = year; }

    public void setYear(int year) {
        // 🚨 오류: 매개변수 year에 자기 자신을 넣음 (필드 변경 안 됨)
        year = year;
    }
    public void print() { System.out.println("Step 6 Year: " + year); }
}

// 7.  this 키워드로 이름 충돌 해결
class MyDate7 {
    private int year;

    public MyDate7(int year) { this.year = year; }

    public void setYear(int year) {
        // this.year라고 명시해서 필드 값을 정확히 바꿈
        this.year = year;
    }
    public void print() { System.out.println("Step 7 Year: " + year); }
}

// 8. this() 생성자로 코드 중복 제거
class MyDate8 {
    private int year, month, day;

    public MyDate8() { this(2026, 1, 1); } // 다른 생성자 호출
    public MyDate8(int year) { this(year, 1, 1); }
    public MyDate8(int year, int month) { this(year, month, 1); }
    public MyDate8(int year, int month, int day) {
        this.year = year; this.month = month; this.day = day;
    }
    public void print() { System.out.println("Step 8: " + year + "/" + month + "/" + day); }
}

public class JavaTask25 {
    public static void main(String[] args) {
        // 5: 빈 괄호 생성 가능 확인
        MyDate5 d5 = new MyDate5();
        d5.print(); // 0/0/0

        // 6: 변경 실패 확인 (2023 그대로 나옴)
        MyDate6 d6 = new MyDate6(2023);
        d6.setYear(2024);
        d6.print();

        // 7: 변경 성공 확인 (2024로 바뀜)
        MyDate7 d7 = new MyDate7(2023);
        d7.setYear(2024);
        d7.print();

        // 8: 생성자 돌려막기 확인
        MyDate8 d8 = new MyDate8(2023, 7); // (year, month) 생성자 없어도 this()로 응용 가능
        d8.print();
    }
}