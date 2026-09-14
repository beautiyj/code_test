package java_ex_test;

interface IHello{
  public abstract void sayHello(String name);
}
interface IGoodBye{
  public abstract void sayGoodBye(String name);
}
//두 인터페이스로부터 상속을 받는 클래스 설계
class SubClass implements IHello, IGoodBye{
  public void sayHello(String name){
     System.out.println(name+"씨 안녕하세요!");
  }
  public void sayGoodBye(String name){
     System.out.println(name+"씨 안녕히 가세요!");
  }
}
class InterfaceTest02{
  public static void main(String[] args) {
    SubClass test= new SubClass();
    test.sayHello("홍길동");
    test.sayGoodBye("홍길동");
  }   
}         