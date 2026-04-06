package task.java2;

// 상속 + Getter/Setter

class Point2D{                       // 부모 클래스
    private int x;                   // 필드
    private int y;

    public int getX( ){              // 메소드
        return x;
    }
    public void setX(int new_X){
        x=new_X;
    }       // x=10
    public int getY( ){
        return y;
    }
    public void setY(int new_Y){
        y=new_Y;
    }       // y=20
}

// 부모 클래스(Point2D)의 필드와 메소드를 상속 받아서 사용할 수 있다.
class Point3D extends Point2D{       // 자식 클래스
    private int z;
    public int getZ( ){
        return z;
    }
    public void setZ(int new_Z){
        z=new_Z;
    }       // z=30
}

public class JavaTask49 {
    public static void main(String[] args){

        Point3D  pt=new Point3D( );
        pt.setX(10);  //상속받아 사용
        pt.setY(20);  //상속받아 사용
        pt.setZ(30);  //자신의 것 사용
        System.out.println( pt.getX( )//상속받아 사용     10
                +", "+ pt.getY( )  //상속받아 사용        20
                +", "+ pt.getZ( ));//자신의 것 사용       30
    }
}
