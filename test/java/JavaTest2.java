package test.java;
/*
* temp를 활용하여 두 변수 값을 교환하기
* */

public class JavaTest2 {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        System.out.println("Before swap: x = " + x + ", y = " + y);

        int temp = x; // temp에 x의 값을 저장. temp = x = 3
        x = y;        // y의 값을 x에 저장 (원래 y의 값). x = y = 5
        y = temp;     // y에 temp의 값을 저장 (원래 x의 값). y= temp = 3
        System.out.println("After swap: x = " + x + ", y = " + y);

//        int v1 =15;
//
//        if(v1>10) {
//            int v2;
//            v2 = v1-10; // if문 안에서 선언된 v2 지역변수는 if문 밖에서는 사용할 수 없
//
//        }
//        int v3 = v1+v2+5;
    }
}

