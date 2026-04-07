package task.java2;

// 레퍼런스 형변환 - 업캐스팅(자동형변환) 다운캐스팅(강제형변환)

/*

자동 형변환(업 캐스팅): 자식클래스에서 부모클래스로 형변환.
참조 가능한 영역이 축소 & 컴파일러에 의해서 자동 형변환

강제 형변환(다운 캐스팅): 부모클래스에서 자식클래스로 형변환.
참조 가능한 영역이 확대 & 강제 형변환 필요, 강제 형변환시 자료형을 생략할 수 없음.

 */

class ParentClass {
    public void parentPrn() {
        System.out.println("슈퍼 클래스 : ParentPrn 메서드");
    }
}

class ChildClass extends ParentClass {
    public void childPrn() {
        System.out.println("서브 클래스 : ChildPrn 메서드");
    }
}

// ----------------------------------------------------------------------------------

public class JavaTask60 {
    public static void main(String[] args) {

        // [RefTest01 케이스] - 업 캐스팅 (Upcasting)
        System.out.println("=== RefTest01: 업 캐스팅 테스트 ===");
        ChildClass c = new ChildClass();
        c.parentPrn();
        c.childPrn();

        ParentClass p;
        p = c;  // 암시적으로 업 캐스팅이 일어남(자식->부모 형변환)
                // 자동형변환이라 클래스생략가능. p = (ParentClass) c; 도 가능.
                // 한줄로는 ParentClass p = c; 보통은 ParentClass p = new ChildClass(); 선언과 생성을 동시에.

        p.parentPrn();  // 업 캐스팅 후에는 부모로부터 상속받은 메서드만 호출할 수 있다.

        // 오류: 부모(Parent) 타입 리모컨에는 childPrn() 버튼이 존재하지 않기 때문입니다.
        // p.childPrn();

//---------------------------------------------------------------------------------------------------------

        // [RefTest02 케이스] - 잘못된 다운 캐스팅 (Downcasting Fail)  - 어차피 실행하면 오류남
        // 다운캐스팅은 부모->자식 (강제형변환)
        System.out.println("\n=== RefTest02: 잘못된 다운 캐스팅 테스트 ===");
        ParentClass p2 = new ParentClass(); // 실제 알맹이가 부모인 객체 생성

        ChildClass c2;
        // 오류: 처음부터 부모(Parent)로 태어난 객체는 자식(Child) 타입으로 강제 형변환이 불가능
        // c2 = (Child) p2;
        // 한줄 다운캐스팅은 ChildClass c2 = (ChildClass) new ParentClass();

        // c2.parentPrn(); // 위 라인에서 에러가 발생하므로 호출 불가
        // c2.childPrn();

/*
        // 오류 해결하려면 업캐스팅을 1회 한 뒤 다운캐스팅이 되어야한다
        ParentClass p2 = new ChildClass();      // 업캐스팅 상태로 생성
        p2.parentPrn();
        ChildClass c2 = (ChildClass) p2;        // 이제 다운캐스팅 가능
        c2.parentPrn();
        c2.childPrn();
 */
//---------------------------------------------------------------------------------------------------------

        // [RefTest03 케이스] - 올바른 다운 캐스팅 (Downcasting Success)
        System.out.println("\n=== RefTest03: 올바른 다운 캐스팅 테스트 ===");

        // 업캐스팅을 먼저 하고 그다음 다운캐스팅 진행.
        ParentClass p3 = new ChildClass();
        p3.parentPrn();

        // 오류: 실제 객체가 Child일지라도 현재 타입이 Parent이므로 자식 전용 메서드는 보이지 않습니다.
        // p3.childPrn();

        ChildClass c3; // 서브 클래스로 레퍼런스 변수 선언
        System.out.println("---------------->> 강제 형변환 후");

        // 서브 클래스 레퍼런스 변수에 슈퍼 클래스의 레퍼런스 값이 대입됨
        c3 = (ChildClass) p3; // 강제 형변환으로 다운 캐스팅 (본래 자식이었으므로 성공!)

        c3.parentPrn();
        c3.childPrn(); // 이제 자식 전용 메서드 호출 가능
    }
}

//          업캐스팅                              다운캐스팅(업캐스팅 후 다운캐스팅)
//          Parent p = new Child();             Parent p = new Child();
//                                              Child c = (Child) p;

// 혹은      Child c = new Child();
//          Parent p = c;

// 결과      p.parentMethod() 호출가능            c.parentMethod() 호출가능
//                                              c.childMethod() 호출가능


//                             Parent               p                 = new         Child();
//                            부모클래스      부모클래스 타입의 레퍼런스변수 = new 새로 생성된 자식클래스 객체

//                             Child            c                  = (Child)             p;
//                            자식클래스 새로운 자식클래스의 레퍼런스변수 = (자식클래스) 부모클래스의 기존 레퍼런스변수