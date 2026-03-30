package task.java;

// p282
// 같은 클래스 내에서 메소드 호출 자유롭게 가능.

class Calculator{
    int plus(int a,int b){
        int result = a+b;
        return result;
    }

    double avg(int x, int y) {
        double sum = plus(x,y);
        double result = sum/2;
        return result;
    }
    void execute() {
        double result = avg(7,10);      // avg()  그대로 호출
        println("result: "+result);
    }

    void println(String message) {
        System.out.println(message);
    }
}

public class JavaTask28 {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();       // 다른클래스에선 객체생성 후 호출
        calculator.execute();       // result: 8.5

    }
}
