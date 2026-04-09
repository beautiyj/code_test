package task.java3;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

// map 인터페이스
// HashMap 해시맵은 스레드 안전성은 xx지만 키와 밸루 모두 널 허용
// Hashtable 해시테이블은 스레드 안전성은 있지만 널 비허용이고 거의 안쓴다
// TreeMap은 특수목적에만 사용함. 키를 기준으로 자동정렬해주는 사전같은 매핑
// Properties는 설정파일 전용이고 키와 값 모두 문자열만 취급해서
// 프로그램 설정값 외부 파일(.properties) 이 용도로 자주 씀

public class JavaTask69 {
    public static void main(String[] args) {
        // HashMap 객체 생성. Map은 인터페이스라서 자체 객체 생성 불가함.
//		Map hm = new HashMap();         // 업캐스팅방식
        HashMap hm = new HashMap();     // 이것도 가능함

        //키와 데이터 쌍을 삽입
        hm.put( "woman", "gemini" );
        hm.put( "man", "johnharu" );
        hm.put( "age", 10 );        // 자동박싱
        hm.put( "city", "seoul" );
        hm.put( "city1", "seoul" );
        hm.put( "city", "busan" );      // 키가 중복되면 밸루는 부산만 출력됨

        //HashMap에 있는 객체들을 출력
        System.out.println( hm );   // {city1=seoul, woman=gemini, city=busan, man=johnharu, age=10}

        //키 값만 출력
        System.out.println( hm.keySet() );  // [city1, woman, city, man, age]

        //키를 이용해 해당 데이터를 출력
        System.out.println( hm.get( "woman" ));
        System.out.println( hm.get( "city" ));
        System.out.println( hm.get( "city1" ));
        System.out.println();

//------------------------------------------------------------------------------------------

        // 불가능한 예
//        Map ht = new Hashtable();           // 업캐스팅하면 아래의 keys에서 오류가 생김
//        업캐스팅하면 부모의 참조만 사용 가능해서.업캐스팅하면서 사용도 하려면 keys()말고 keySet() 사용하기.

        Hashtable ht = new Hashtable();
        //  Hashtable ht= new Hashtable();      // 그냥 객체생성도 가능하긴 함

        // 해쉬 테이블에 키/데이터를 입력한다.
        ht.put("딸기", "StrawBerry");
        ht.put("사과", "Apple");
        ht.put("포도", "Grapes");

        // 방법1 - 키 알고 있을 때
        // 해쉬 테이블의 값을 키를 이용하여 얻는다.
        //  Object obj = ht.get("포도");
        String Val = (String) ht.get("포도");
        if (Val != null) {
            System.out.println("포도-> " + Val);
        }

        // 방법2 - 키 모를 때
        // Enumeration 이뉴머레이션(열거): 컬렉션에 들어있는 데이터들을 순서대로 하나씩 훑어볼 때 사용하는 인터페이스
        // 마찬가지로 요즘은 거의 안씀 해시테이블이나 벡터랑 자주 쓰지
        Enumeration Enum = ht.keys();
        while (Enum.hasMoreElements()) {
            Object k = Enum.nextElement();
            Object v = ht.get(k);
            System.out.println(k + " : " + v);
        }
    }
}
