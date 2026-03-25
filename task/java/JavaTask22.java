package task.java;

// Scanner 클래스를 활용한 next 메소드
import java.util.Scanner;

public class JavaTask22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("age");
        int age = sc.nextInt();

        System.out.println("name");
        String name = sc.next();    // 단어출력용
        sc.nextLine();      // 정수뒤의공백제거용

        System.out.println("address");
        String address = sc.nextLine(); // 문장출력용

        // 실제로는 nextLine() 입력받고 변환하는 형태를 선호함
        System.out.print("나이 입력 문자열형태로받고 변환하기: ");
        String ageStr = sc.nextLine();
        int age2 = Integer.parseInt(ageStr); // 문자열을 정수로 변환

        System.out.println(age);
        System.out.println(name);
        System.out.println(address);

        System.out.println(age2);

        sc.close();
    }

}
