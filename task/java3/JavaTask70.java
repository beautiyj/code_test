package task.java3;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

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
        sc.close();
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

public class JavaTask70 {
    public static void main(String[] args) {
        System.out.println("Hashtable 사용 예제");

        HashtableEx hashtableEx = new HashtableEx();
        hashtableEx.HashtableMethod();

//--------------------------------------------------------------------------------------

        System.out.println("HashMap 사용 예제");

        HashMapKeyValue hashMapEx = new HashMapKeyValue();

        // try-with-resources 구문 사용하면 알아서 스캐너 닫아줌
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
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
    }
}