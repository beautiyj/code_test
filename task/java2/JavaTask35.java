package task.java2;

// API클래스 - String

@SuppressWarnings("all")
class StringTest0 {
    public static void stringTest0() {
        String str1 = new String("Java Programming");
        String str2 = new String("Java Programming");

        if (str1 == str2) { // 다른주소
            System.out.println("같주소");
        } else {
            System.out.println("다른주소");
        }
        String str3 = "Java Programming";
        String str4 = "Java Programming";

        if (str3 == str4) { // 같주소
            System.out.println("같주소");
        } else {
            System.out.println("다른주소");
        }

        if (str1.equals(str3)) { // 같은 값
            System.out.println("같은 값");
        } else {
            System.out.println("다른 값");
        }

    }
}

class StringTest1 {
    public static void stringTest1() {
        String str1 = "Java Programming";
        str1.toUpperCase();     // 이 경우 가비지(쓰레기)발생
        // String 객체 생성 후 메소드에 의해 값 변화 일어나면 힙 메모리에 또 생성됨.
        // 변수에 할당하지 않고 메소드만 실행해서 만들어진 결과물 객체들을 가비지 컬렉션이 청소함
        // 자바의 경우 힙(Heap) 메모리를 감시하다가 더 이상 아무도 참조(연결)하지 않는 객체가 있으면 자동으로 삭제

        System.out.println(str1);
        System.out.println(str1.toUpperCase()); // 대문자로 출력됨

        String str2 = str1.toUpperCase();
        System.out.println(str2);   // 얘도 대문자
        String str3 = str1.toLowerCase();
        System.out.println(str3);   // 이건다시소문자
    }
}

class StringTest2 {

    public static void stringTest2() {
        // String 객체 선언
        String gemini = "gemini";
        String johnharu = "johnharu";

        // 두 String 객체를 "+" 연산 수행
        String tempString1 = gemini + johnharu;
        System.out.println(tempString1);      // geminijohnharu
        System.out.println("gemini" + "johnharu");    // geminijohnharu

        // String + 정수형
        String tempString2 = tempString1 + 100;
        System.out.println(tempString2);  // geminijohnharu100
    }
}

class StringTest3 {
    public static void stringTest3() {
        String message = "Java program creates many objects.";

        int len = message.length();
        System.out.println(len);  // len = 34;

        // charAt(index)는 String객체에서 해당 인덱스의 char 반환하는 메소드.
        // message 중에서 ' '을 찾음
        for (int i = 0; i < len; i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                System.out.println("index = " + i);
            }
        }

    }
}

class StringTest4 {
    public static void stringTest4() {
        String message = "Java program creates many objects.";

        // indexOf(문자열 문자 숫자-아스키코드나 유니코드)는 인덱스 번호 구해주는 거
        // 자바에서는 기본이 유니코드.
        int index1 = message.indexOf('a');
        int index2 = message.indexOf(97);

        System.out.println(index1);
        System.out.println(index2);

        //index번호 13번째 자리 포함 다음부터 a를찾음
        int index3 = message.indexOf('a', 13);
        System.out.println(index3);

        int index4 = message.indexOf("av");
        System.out.println(index4);

        int index5 = message.indexOf("man", 12);
        System.out.println(index5);

        int index6 = message.indexOf("java"); // 해당단어가 없다면 -1 반환
        System.out.println(index6);
        // int index = message.toLowerCase().indexOf("java".toLowerCase());
        // 원본과 찾는 단어 모두 소문자 통일 후 찾기 형태로 자주 쓰임
    }
}

class StringTest5 {
    public static void stringTest5() {
        String str1 = "gemini   ";
        String str2 = "   gemini ";

        System.out.println(str1.equals(str2));   // false
        System.out.println(str1.trim().equals(str2.trim())); // true

        //trim() 앞뒤 공백 제거 문자열 반환
        String str3 = str1.trim();
        System.out.println(str3);
    }
}

class StringTest6 {
    public static void stringTest6() {

        String message = "Java program creates many objects.";

        // substring(int) - 시작 번호부터 끝까지 전부 잘라내기-붙여넣기
        // 같은 내용의 새 객체를 만든다.            13부터 끝까지.
        String str1 = message.substring(13);
        System.out.println(str1);

        // substring(int, int) - 시작 번호부터 끝 인덱스는 미포함으로
        // 잘라내기-붙여넣기 새 객체를 만든다. ex 13,16이면 13,14,15만 포함.
        String str2 = message.substring(13, 16);
        System.out.println(str2);

        // 아래와 같은 주민번호 남녀 판별
        String jumin = "950101-1234567";
        String num = jumin.substring(7, 8);

        int n = Integer.parseInt(num);
        if (n == 1 || n == 3) {
            System.out.println("남");
        } else if (n == 2 || n == 4) {
            System.out.println("여");
        } else {
            System.out.println("x");
        }

        //  chatAt 사용 시
        char n2 = jumin.charAt(7);
        if (n2 == '1' || n2 == '3') {
            System.out.println("남");
        } else if (n2 == '2' || n2 == '4') {
            System.out.println("여");
        } else {
            System.out.println("x");
        }


    }
}

class StringTest7 {
    public static void stringTest7() {

        // replace(문자,문자 혹은 문자열,문자열 타입 일치 필요), 숫자는 오류남.
        // 대신 숫자는 "100"이나 (char)97(=a출력. 아스키코드)캐스팅 필요함.
        // 기존 특정문자나 단어를 , 뒤의 문자나 단어로 대체하는 메소드.
        // 대신 문장에 a가10개면 10개 전부 바뀜(원본은 그대로 유지, 힙메모리 new 객체생성됨)
        String oldStr = "자바는 객체지향 언어 입니다.";
        String newStr = oldStr.replace("자바", "JAVA");
        System.out.println(oldStr);
        System.out.println(newStr);

        // 만약 특정 인덱스만 대체하고 싶다면 리플레이스 말고 StringBuilder 사용을 추천.
        // replaceFirst 같은 경우는 딱 첫 번째만 변경 가능하고, replaceAll는 문장 맨 끝만 변경.
        String phone = "010-1234-1234";
        // 첫 번째로 나오는 대시(-)만 공백으로 바꾸기
        String result = phone.replaceFirst("-", " ");
        System.out.println(result); // "010 1234-1234" (뒤의 대시는 그대로!)

        String data = "가격은 50,000원 입니다!!!";
        // 숫자가 아닌 모든 문자([^0-9])를 빈 문자열("")로 바꿈 (=삭제)
        String cleanData = data.replaceAll("[^0-9]", "");
        System.out.println(cleanData); // "50000"
    }
}

class StringTest8 {
    public static void stringTest8() {

        // split(정규표현식) - 전체 문자열에서 구분기호를 이용해 파싱, 배열로 반환
        // . + * ? | 등으로 나누려면 "\\." 처럼 \\ 를 추가해야 분리 가능.
        String jumin = "950101-1234567";
        String[] j = jumin.split("-");
        System.out.println("주민번호 앞자리: " + j[0]);
        System.out.println("주민번호 뒷자리: " + j[1]);

        for (int i = 0; i < j.length; i++) {
            System.out.println(j[i] + "\t");
        }
        System.out.println();
        for (String s : j) {
            System.out.println(s + "\t");
        }

        String tel = "010-1234-5678";
        String[] t = tel.split("-");
        System.out.println("전화번호 앞자리: " + t[0]);
        System.out.println("전화번호 중간자리: " + t[1]);
        System.out.println("전화번호 뒷자리: " + t[2]);

        String email = "totoro@naver.com";
        String[] e = email.split("@");
        System.out.println("이메일 앞자리: " + e[0]);
        System.out.println("이메일 뒷자리: " + e[1]);

        String data = "사과,배,,";
        String[] res1 = data.split(",");
        System.out.println(res1.length); // 2 (사과, 배만 남고 뒤의 빈 칸은 무시됨)

        // 빈 칸까지 다 살리고 싶다면? (두 번째 인자에 -1 넣기)
        String[] res2 = data.split(",", -1);
        System.out.println(res2.length); // 4 (사과, 배, "", "" 모두 포함)

        // 여러 구분 기호 기입 가능함. | 기호 사용. 대신 각 기호마다 띄어쓰기하면 안됨!
        String text = "홍길동&이수홍,박연수,김자바-최명호";
        String[] name = text.split("&|,|-");
        String[] name2 = text.split("[&,-]");   // 동일함
        for(int i=0; i<name.length; i++){
            System.out.println(name[i] + "\t" + name2[i] + "\t");
        }

        // 향상된 for문
        for (String n : name) {
            System.out.println(n + "\t");
        }


    }

}

public class JavaTask35 {
    public static void main(String[] args) {

        StringTest0.stringTest0();
        System.out.println("===============================");
        StringTest1.stringTest1();
        System.out.println("===============================");
        StringTest2.stringTest2();
        System.out.println("===============================");
        StringTest3.stringTest3();
        System.out.println("===============================");
        StringTest4.stringTest4();
        System.out.println("===============================");
        StringTest5.stringTest5();
        System.out.println("===============================");
        StringTest6.stringTest6();
        System.out.println("===============================");
        StringTest7.stringTest7();
        System.out.println("===============================");
        StringTest8.stringTest8();

    }
}
