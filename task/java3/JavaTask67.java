package task.java3;

import java.util.ArrayList;
import java.util.List;

// 제네릭<>을 활용한 리스트 예제 + ArrayList
// 제네릭은 컬렉션 프레임워크에 속하는 거의 모든 인터페이스 & 클래스에서 사용 가능함.

public class JavaTask67 {
    public static void main(String[] args) {

        // generic 제네릭: 한 가지 자료형의 데이터만 저장하도록 만들어주는 기능
        List<String> list = new ArrayList<String>();

        list.add("Java");
        list.add("JDBC");
        list.add("Servlet/JSP");
        System.out.println("현재 리스트: "+list);
        list.add(2,"Database");
        System.out.println("현재 리스트: "+list);
        list.add("iBATIS");
        System.out.println("현재 리스트: "+list);
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        int size = list.size();
        System.out.println("총 객체 수: "+size);

        // 리스트 자료구조에서 get() 메소드로 값 구해올 때, 제네릭 처리된 건 자료형 생략 가능함
//        String skill = (String) list.get(2);  다운캐스팅 패스 가능(자동으로 다운캐스팅 처리됨)
        String skill = list.get(2);
        System.out.println("2: "+skill);
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            System.out.println(i +": "+str);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        list.remove(2);     // 2번 인덱스 객체 삭제 (Database)
        System.out.println("2번 인덱스 Database 삭제 후 변경됨: "+list.get(2));

        list.remove(2);     // 2번 인덱스 객체 삭제 (Servlet/JSP)
        System.out.println("2번 인덱스 Servlet/JSP 삭제 후 변경됨: "+list.get(2));
        System.out.println("현재 리스트: "+list);

        list.remove("iBATIS");
        System.out.println("iBATIS 데이터 삭제, 현재 리스트: "+list);
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            System.out.println(i +": "+str);
        }
    }
}
