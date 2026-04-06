package task.java2;

// 상속에서의 접근 제한자 : 부모 클래스
// 자식클래스는 package task.java2.t54;
public class JavaTask54 {
    public int d = 40;     // [4] public : 어디서든 접근 가능
    protected int c = 30;  // [3] protected : 같은 패키지 + 자식 클래스에서 접근 가능
    int b = 20;             // [2] 기본 접근 지정자 (default) : 같은 패키지 내에서만 접근 가능
    private int a = 10;     // [1] private : 해당 클래스 내에서만 접근 가능

    public void print() {
        System.out.println("AccessTest의 print");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
