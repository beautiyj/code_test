package task.java3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// HashSet 해시셋 : 트리셋과 달리 정렬은 x


public class JavaTask63 {
    public static void main( String[] args ) {

        // HashSet 클래스의 객체 생성
        // set은 인터페이스라서 자체적으로 객체 생성 불가능함 Set s = new Set(); 오류
        Set set = new HashSet();
//        HashSet	set = new HashSet();

        System.out.println("요소의 갯수->" + set.size());        // 요소의 갯수->0
        set.add("하나");
        set.add(2);
        set.add(3.42);
        set.add("넷");
        set.add("five");
        set.add(6);
        set.add(6);


        // Set은 중복된 데이터 저장하지 못함 -> 중복데이터 판별용으로 씀, 순서 제어x
        System.out.println("요소의 갯수->" + set.size());        // 요소의 갯수->6
        System.out.println(set);                         // [2, 6, 넷, 하나, 3.42, five]

        // Iterator 반복자
        Iterator elements = set.iterator();
        while (elements.hasNext()) {
            System.out.println("\t\t" + elements.next());
        }

        /*  Vector에만 적용
            Enumeration enu = set.elements();
            while( enu.hasMoreElements()){
                System.out.println( enu.nextElement() );
            }
        */
    }
}
