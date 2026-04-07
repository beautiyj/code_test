package task.java2;

// 인터페이스
// 인터페이스는 상수와 추상 메소드만 가질 수 있음

/*
    일반적인 방식
Hello56 obj = new Hello56();            // 한국어 인사만 가능
                                        // 만약 영어 인사로 바꾸고 싶다면?
EnglishHello obj = new EnglishHello();  // 변수 타입 자체를 뜯어고쳐야 함

------------------------------------------------------------------------------
    인터페이스활용 다형성응용방식 (인터페이스를 부모로 두고 자식들이 받아가면서 쓰기)

IHello obj = new Hello56();             // "인사하는 녀석(IHello) 하나 가져와"
obj.sayHello("홍길동");
                                       // 나중에 영어 인사로 바꿔야 한다면?
obj = new EnglishHello();         // 변수 타입(IHello)은 그대로 두고, 알맹이만 갈아끼우면 끝!
obj.sayHello("Hong");

 */


public interface JavaTask56 {
    int a = 10;     // 인터페이스 안엔 일반변수가 들어갈 수 없고 기본 상수임.
    // public static final은 생략되어있음(생략가능)

    // 실행을 위한 main 메소드 (전체 실행기)
    public static void main(String[] args) {
        System.out.println("=== InterfaceTest01 실행 ===");
        InterfaceTest01.main(null);

        System.out.println("\n=== InterfaceTest02 실행 ===");
        InterfaceTest02.main(null);
    }

    public abstract void action();

    void action2();     // 추상메소드도 생략해서 코드 작성 가능
}

/*
        === InterfaceTest01 실행 ===
        홍길동씨 안녕하세요!
        홍길동씨 안녕하세요!

        === InterfaceTest02 실행 ===
        홍길동씨 안녕하세요!
        홍길동씨 안녕히 가세요!
 */



// ---------------------------------------------------------
// [예제 1]
// ---------------------------------------------------------


interface IHelloJava {                  // 부모 인터페이스
    void sayHello(String name);     // 추상메소드
}

interface InterHello {
    public abstract void sayHello(String name);
}

interface IGoodBye {
    public abstract void sayGoodBye(String name);
}

// ---------------------------------------------------------
// [예제 2]
// ---------------------------------------------------------

// 인터페이스를 상속 받을 때는 implements 사용
class Hello56 implements IHelloJava {

    // 부모 인터페이스 안에 있는 추상메소드를 자식메소드에서 사용하려면 메소드 오버라이딩 필수
    @Override
    public void sayHello(String name) {
        // void sayHello(String name){  <- 인터페이스 구현 시 public 필수라 에러남
        System.out.println(name + "씨 안녕하세요!");
    }
}

class InterfaceTest01 {
    public static void main(String[] args) {

        // 인터페이스도 추상클래스처럼 자체적으로 객체 생성 불가
//        IHello ih = new IHello();

        // 다형성 형태로(부모 이름으로) 객체 생성해서 활용하는 건 가능함
        // IHello를 구현한 어떤 클래스든 담을 수 있음, 부모가 정한 규칙만 쓸 때.
        IHelloJava objPar = new Hello56(); // 부모(인터페이스) 타입 변수에 자식 객체를 담음
        objPar.sayHello("홍길동");

        Hello56 objChild = new Hello56();
        objChild.sayHello("홍");
        objChild.sayHello("홍2");
    }
}

// 두 인터페이스로부터 상속을 받는 클래스 설계 - 인터페이스 다중 상속
class SubClass implements InterHello, InterfaceGoodBye59 {
    public void sayHello(String name) {
        System.out.println(name + "씨 안녕하세요!");
    }

    public void sayGoodBye(String name) {
        System.out.println(name + "씨 안녕히 가세요!");
    }
}

class InterfaceTest02 {
    public static void main(String[] args) {
        SubClass test = new SubClass();
        test.sayHello("홍길동");
        test.sayGoodBye("홍길동");
    }
}