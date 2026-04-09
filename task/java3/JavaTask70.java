package task.java3;

import java.util.*;

// Map 예제 p599-600

// 잘 안쓰는 방식 - Hashtable  활용
class HashtableEx {
    Map<String, String> map = new Hashtable<String, String>();
    public void HashtableKeyValue() {
        map.put("spring", "12");
        map.put("summer", "123");
        map.put("fall", "1234");
        map.put("winter", "12345");
    }
    public void HashtableMethod() {
        HashtableKeyValue();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("아이디와 비밀번호를 입력해주세요");
            System.out.print("아이디: ");
            String id = sc.nextLine();
            System.out.print("비밀번호: ");
            String pw = sc.nextLine();

            if (map.containsKey(id)) {
                if (map.get(id).equals(pw)) {
                    System.out.println("로그인 성공");
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다");
                }
            } else {
                System.out.println("입력하신 아이디가 존재하지 않습니다");
            }
        }
    }
}

class HashTableTest02{
    public void hashTableTest02() {
        Hashtable<String, String> ht= new Hashtable</* 생략해도 됨 어차피 자동으로 문자열처리됨! String, String*/>( );
        ht.put("사과", "Apple");
        ht.put("딸기", "StrawBerry");
        ht.put("포도", "Grapes");

        // 키 알고 있을 때는 해쉬 테이블의 값을 키 이용하여 얻는다.
        String Val = ht.get("포도");
        if(Val != null) {
            System.out.println("포도-> " + Val);
        }

        // 키 값을 모를 때 열거
        // keys()는 Hashtable 해시테이블에서, keySet()은 HashMap 해시맵에서 사용
        Enumeration<String> Enum = ht.keys();  //해쉬 테이블의 키 요소들에 대한 Enumeration 객체 반환
        while(Enum.hasMoreElements()){
            String  k = Enum.nextElement();
            String  v = ht.get(k);
            System.out.println(k + " : "+ v );
        }
    }
}


// 잘 쓰는 건 HashMap
class HashMapKeyValue {
    private final Map<String, String> hashMap = new HashMap<>();
    public HashMapKeyValue() {
        hashMap.put("spring", "12");
        hashMap.put("summer", "123");
        hashMap.put("fall", "1234");
        hashMap.put("winter", "12345");
    }
    public int HashMapMethod(String userId, String userPassword) {
        if (!hashMap.containsKey(userId)) return 1;
        if (!hashMap.get(userId).equals(userPassword)) return 2;
        return 0;
    }
}

// --------------------------------------------------------------------------------------------

public class JavaTask70 {
    public static void main(String[] args) {
        // 1. Hashtable 예제 실행
        System.out.println("Hashtable 사용 예제");
        HashtableEx hashtableEx = new HashtableEx();
        hashtableEx.HashtableMethod();

        System.out.println("------------------------------------------------------");

        // 2. HashMap 예제 실행
        System.out.println("HashMap 사용 예제");
        HashMapKeyValue hashMapEx = new HashMapKeyValue();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("[HashMap 로그인]");
                System.out.println("아이디와 비밀번호를 입력해주세요");
                System.out.print("아이디: ");
                String userId = scanner.nextLine();
                System.out.print("비밀번호: ");
                String userPassword = scanner.nextLine();

                int result = hashMapEx.HashMapMethod(userId, userPassword);

                if (result == 0) {
                    System.out.println("로그인 성공");
                    break;
                } else if (result == 1) {
                    System.out.println("입력하신 아이디가 존재하지 않습니다");
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다");
                }
            }
        }

        System.out.println("------------------------------------------------------");

        // 3. HashTable 열거형 예제 실행
        HashTableTest02 hashTableTest02 = new HashTableTest02();
        hashTableTest02.hashTableTest02();
    }
}