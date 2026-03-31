package task.java2;

// 싱글톤 객체

class Singleton {
    // 자신의 타입으로 정적 필드 선언 및 객체 생성. 보통은 싱글톤말고 instance 로 필드명 쓰긴 하다만...
    private static Singleton singleton = new Singleton();

    // private 생성자로 외부 new 생성자 사용 차단하기
    private Singleton() {}

    // 외부에서 객체를 얻을 수 있는 유일한 정적 메소드 제공하기(표준메소드는 아니지만 싱글톤 관례상 이름통일)
    static Singleton getInstance() {
        return singleton;
    }

    public void check1() {
        System.out.println("메소드 호출 성공1");
    }

    public void check2() {
        System.out.println("메소드 호출 성공2");
    }

}

public class JavaTask31 {
    public static void main(String[] args) {

        //private 생성자로 만든 싱글톤이라서 외부 호출 불가하다.
        /*
        System.out.println(Singleton.singleton);
        Singleton obj1 = new Singleton();
        Singleton obj2 = new Singleton();
         */

        // getInstance()를 통해서만 객체를 가져옴
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj1);
        System.out.println(obj2);

        if (obj1 == obj2) {
            System.out.println("같은 싱글톤 객체");
        } else {
            System.out.println("다른 싱글톤 객체");
        }

        // obj1, obj2가 같은 싱글톤 객체라서 둘 다 각기 메소드1 메소드2 호출메시지가 뜸.
        obj1.check1();
        obj1.check2();

        obj2.check1();
        obj2.check2();
    }
}
