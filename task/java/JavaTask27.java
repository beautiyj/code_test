package task.java;

// p278~279

class Car27{

    int gas;

    void setGas(int gas){
        this.gas=gas;
    }

    boolean isLeftGas() {
        if(gas == 0) {
            System.out.println("gas가 없습니다");
            return false;
        }
        System.out.println("gas가 있습니다");
        return true;
    }

    void run() {
        while (true) {
            if (gas >0) {
                System.out.println("gas잔량: "+gas);
                gas -= 1;
            } else {
                System.out.println("gas잔량: "+gas);
                return;
            }
        }
    }

}
public class JavaTask27 {
    public static void main(String[] args) {

        Car27 myCar = new Car27();
        myCar.setGas(5);

        boolean gasState = myCar.isLeftGas();
        if (gasState) {
            System.out.println("출발합니다");
            myCar.run();
        }

        if (myCar.isLeftGas()) {
            System.out.println("gas를 주입할 필요가 없습니다");
        } else {
            System.out.println("gas를 주입하세요");
        }

    }

}
