package task.java3;

// 예외처리 throw - 예외 발생시키기. 강제로 예외를 발생시킴! throw 키워드를 사용하여 예외를 명시적으로 발생시킬 수 있다.

// 예외처리 throws - 예외 떠넘기기. 메서드 선언부에 throws 키워드를 사용하여 해당 메서드에서 발생할 수 있는 예외를 명시적으로 선언할 수 있다.
//                 에러를 처리할 적임자에게 책임을 넘기기에 가깝다


// 구성편집 -> 프로그램인수에 적어서 실행하면됨
// run configuration -> 구성편집누르고 arguments
class ThrowsEx1 {
    public static void excute(String[] args){
        ThrowsEx1 t1 = new ThrowsEx1();

        try{
            t1.setData(args[0]);
        }catch(Exception e){
            System.out.println("첫문자가 숫자가 아닙니다.");
        }
    }//main() end

    public void setData(String n) throws NumberFormatException{
        if(n.length() >= 1){
            String str = n.substring(0,1);
            printData(str);
        }
    }

    private void printData(String n) throws NumberFormatException{
        int dan = Integer.parseInt(n);
        System.out.println(dan+"단");
        System.out.println("-----------");
        for(int i=1 ; i<10 ; i++)
            System.out.println(dan+"*"+i+"="+(dan*i));
    }
}

// 기본 예외처리 구문 (직접 해결)
class ThrowsException {
    public static void excute() {
        // 객체를 생성
        ThrowsException te = new ThrowsException();
        // 메소드 호출
        te.occurException();
    }
    // 나눗셈을 구하는 메소드
    public void occurException() {
//        int result = 3/0;     // 이것만 있으면 예외처리없어서 터짐 트라이캐치문 추가해야함

        try {
            int result = 3/0;
            System.out.println("result : " + result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다. 예외 메시지: " + e.getMessage());
        }

    }
}

// 2번 ThrowsException예제를 throws 처리하여 예외를 양도한 형태
class ThrowsExceptionHandling1 {
    public static void executeMain() {
        // 객체를 생성
        ThrowsExceptionHandling1 te = new ThrowsExceptionHandling1();
        // try-catch 블록으로 예외 처리
        try {
            // 예외처리를 try구문에서 직접 하지 않겠다
            te.occurException();
        } catch ( ArithmeticException ae ) {
            System.out.println( "Exception이 발생 : " + ae.toString() );
            System.out.println( "0으로 나눌 수 없습니다." );
        }
    }

    //occurException()를 호출한 곳으로 예외처리를 양도 하겠다는 의미임 (관례상 어떤 예외가 발생될 예정인지 명시해줘야함)
    // 예외처리되는 구문 자체를 여기에 기재함(try구문에서 진행되는 문장을 여기 적어둠)
    public void occurException() throws ArithmeticException {
        // ArithmethicException 발생
        int result = 3/0;
        System.out.println( result );
    }
}

public class JavaTask80 {
    public static void main(String[] args) {
         ThrowsEx1.excute(args);
        // ThrowsException.excute();
//        ThrowsExceptionHandling1.executeMain();
    }
}