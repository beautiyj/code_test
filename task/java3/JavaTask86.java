package task.java3;

// 스레드 동기화: synchronized 동기화 메소드

// key를 이용해서 Thread간에 충돌이 일어나지 않도록 실행순서를 맞추는 것을
// Thread의 동기화(Synchronization)라고 한다.
class Toilet { // 화장실을 사용하는 과정을 보여주는 클래스

    // 메소드의 동기화 방법
    // synchronized로 선언된 openDoor() 메소드는 한번 실행이 끝나야 다음 실행이 가능함.
    // 다른 Thread들은 한개의 Thread가 이 메소드의 실행을 끝낼때 까지 대기함.
    public synchronized void openDoor( String name, boolean b ) {

//	public void openDoor( String name, boolean b ) {
        if( b == false ) {
            System.out.println( name );
            usingTime();
            System.out.println( "아~~~~! 시원해" );
        } else {
            System.out.println( "사용중" );
        }
    }//openDoor() end

    public void usingTime() { //화장실 사용하는 시간
        for( int i=0 ; i<100000000 ; i++ ) {
            if( i == 10000 ) {
                System.out.println( "끄으응" );
            }
        }
    }//usingTime() end
}

// Thread 클래스를 상속받아 Thread를 정의함.
class Family extends Thread {
    Toilet toilet;
    String who;
    boolean key; // 초기값: false
    // 생성자
    public Family( String name, Toilet t ) {
        who = name;
        toilet = t;
    }

    public void run() {
        toilet.openDoor( who, key );
    }
}

// 5개의 Thread를 만들어 실행 시키는 클래스
public class JavaTask86 {
    public static void main( String[] args ) {
        Toilet t = new Toilet();
        // thread 생성
        Family father = new Family("아버지", t );
        Family mother = new Family("어머니", t );
        Family sister = new Family("누나", t );
        Family brother = new Family("형", t );
        Family me = new Family("나", t );
        /*** 우선 순위 적용안됨
         father.setPriority(10);
         mother.setPriority(7);
         sister.setPriority(5);
         brother.setPriority(3);
         me.setPriority(1);
         */
        // 각 Thread는 Runnable 상태에 들어감
        father.start();
        mother.start();
        sister.start();
        brother.start();
        me.start();
    }
}