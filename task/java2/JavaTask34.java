package task.java2;

// final

class FinalMember {
    final int a = 10;        // 상수. final처리돼서 수정 불가함
    final int b;             // 값을 지정하지 않은 경우는 생성자를 통해 값 1회 지정 가능.

    // 클래스 이름과 동일하게 생성자 이름을 FinalMember로 일치시킴
    public FinalMember(int b) {
        this.b = b;
    }

    /*
    public void setA(int a) {
        this.a = a;     // 상수는 값을 수정할 수 없는데 수정하려고 해서 오류
    }
     */
}

//==============================================================================================


class FinalMethod{
    String str="Java ";

    //public void setStr(String s) {

    //final 붙이면 서브 클래스에서 오버라이딩이 불가.
    public final void setStr(String s) {
        str=s;
        System.out.println(str);
    }
}
class FinalEx extends FinalMethod{
    int a=10; // final 붙이면 밑에서 a값 대입 불가.
    public void setA(int a) {
        this.a=a;
    }

    /*  final 사용한 클래스는 오버라이딩 불가하니까
    public void setStr(String s) { // 메소드 오버라이딩
        str+=s;
        System.out.println(str);
    }
     */

}

//==============================================================================================


// 상속을 허용하지 않는다.
final class FinalClass{				// 부모 클래스
    String str="Java ";
    public void setStr(String s){
        str=s;
        System.out.println(str);
    }
}

/*      상속불가라서 자식 클래스 자체가 오류.
class FinalEx34 extends FinalClass {   // 자식 클래스
    int a = 10;

    public void setA(int a) {
        this.a = a;
    }

    public void setStr(String s) {
        str += s;
        System.out.println(str);
    }
}
 */

public class JavaTask34 {
    public static void main(String[] args) {
        // 기본 생성자가 없고 'int b'를 받는 생성자만 있으므로 값을 넣어야 함
        FinalMember ft = new FinalMember(10);

        final int a = 1000;
        // ft.setA(100);       // 이건 원래 불가한 기능임.
        System.out.println(a);

        // 객체를 만들 때 b의 값을 50으로 결정
        FinalMember ft1 = new FinalMember(50);
        System.out.println("ft1의 b: " + ft1.b); // 50

        // 다른 객체는 b를 100으로 결정할 수 있음 (하지만 한 번 정하면 끝)
        FinalMember ft2 = new FinalMember(100);
        System.out.println("ft2의 b: " + ft2.b); // 100


        System.out.println("==============================================================");
        System.out.println();


        FinalEx ftex= new FinalEx( );
        ftex.setA(100);

        // FinalEx에서 setStr을 오버라이딩 못하므로, 부모의 setStr이 실행됨
        ftex.setStr("hi");// 슈퍼 클래스의 setStr을 실행.

        FinalMethod ftex1=new FinalMethod( );
        ftex1.setStr("hi");// 자신의 클래스의 setStr을 실행.


        System.out.println("==============================================================");
        System.out.println();


        // 상속 불가
        // FinalEx34 fe= new FinalEx34( );

        // 대신 부모인 FinalClass는 직접 생성해서 사용할 수 있음
        FinalClass fc = new FinalClass();
        System.out.println(fc.str);
        fc.setStr("Direct Call");

    }
}