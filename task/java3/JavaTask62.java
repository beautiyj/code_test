package task.java3;

// 컬렉션 인터페이스 - Collection set 인터페이스
// 중복을 허가하지 않아서 데이터 중복 판별에 쓰는 인터페이스

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JavaTask62 {
    public static void main(String[] args) {

        // set은 인터페이스라서 자체적으로 객체 생성 불가능함 Set s = new Set(); 오류

        // 업캐스팅 방식으로 HashSet 클래스의 객체 생성
        Set hs = new HashSet();
//      HashSet hs = new HashSet();         // 이건 일반객체생성

        // hs 객체에 데이터 객체 보관
        hs.add( "gemini" );
        hs.add( "johnharu" );
//		Date d=new Date();
//      hs.add( d );
        hs.add( new Date() );

        // hs 객체가 보관하고 있는 데이터 객체 출력
        System.out.println( "hs의 내용 : " + hs );

        // "johnharau" 데이터 객체를 hs 객체에서 제거
        hs.remove( "johnharu" );
        System.out.println( "hs의 내용 : " + hs );

        // hs 객체에 있는 데이터 개체의 갯수를 출력
        System.out.println("hs의 데이터 갯수" + hs.size());

    }
}

