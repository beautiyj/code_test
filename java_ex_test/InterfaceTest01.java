package java_ex_test;

interface IHello{
  void sayHello(String name);
}
class Hello implements IHello{    
  public void sayHello(String name){
//	void sayHello(String name){
      System.out.println(name+"씨 안녕하세요!");
   }
}
class InterfaceTest01{
  public static void main(String[] args) {
    Hello obj= new Hello();
    obj.sayHello("홍길동");
	obj.sayHello("홍길동");
  }   
}                
