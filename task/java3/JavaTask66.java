package task.java3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 컬렉션 인터페이스 - Collection 프레임워크의 list 인터페이스
// 리스트 인터페이스는 인덱스 번호(입력순) 자료형 저장, 중복저장 가능, 동적으로 크기 조절.
// ArrayList

public class JavaTask66 {
    public static void main(String[] args) {
        // 리스트는 인터페이스니까 자체 객체 생성 불가
        // List list = new List();

        System.out.println("---------------------------------------------------------");
        System.out.println("어레이리스트 활용");

        List list = new ArrayList();                // 업캐스팅
        ArrayList arrayList = new ArrayList();

        arrayList.add("하나");
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(3.42);
        arrayList.add("넷");
        arrayList.add("five");
        arrayList.add(6);

        System.out.println(arrayList);
        System.out.println();

//-------------------------------------------------------------------------------

        System.out.println("---------------------------------------------------------");
        System.out.println("전체 리스트 출력 & 특정 인덱스 번호 데이터 출력하기");

        List list1 = new ArrayList();
        //	ArrayList list = new ArrayList();

        list1.add("하나");
        list1.add(2);
        list1.add(3.42);
        list1.add("넷");
        list1.add("five");
        list1.add(6);

        // 츌력방법
        System.out.println(list1);
        System.out.println(list1.get(2));       // 특정 인덱스 번호의 데이터 출력
        System.out.println();

        System.out.println("---------------------------------------------------------");
        System.out.println("반복문 - 업캐스팅 활용하기");

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(i + " 번째 요소는 " + list1.get(i));
            Object obj = list1.get(i);          // 이건 업캐스팅이라 오류 없음
            System.out.println(obj);
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("반복문 - toString 활용하기");

        for (int i = 0; i < list1.size(); i++) {
//          String s = (String) (list.get(i));      // 리스트 안의 데이터형이 여러개라서
            String s = list1.get(i).toString();     // 출력하려면 이렇게 사용하기. 모든 객체는 toString()을 가짐
            System.out.println(s);
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("Iterator 반복자 활용하기");

        // 이터레이터 반복자
        Iterator elements = list1.iterator();
        while (elements.hasNext()) {
            System.out.println("\t\t" + elements.next());

        }
    }
}