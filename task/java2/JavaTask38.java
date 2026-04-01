package task.java2;

// StringBuffer는 동기화 처리(스레드세이프) 지원하긴 하지만 속도 느려서 잘 안씀
// StringBuilder는 동기화 처리는 지원하지 않지만 빨라서 잘 사용하긴 함

class StringBuffer1 {
    public void stringBuffer1() {

        // capacity() : heap메모리 상에 할당된 공간의 크기를 구해오는 메소드(기본값은 16바이트)
        StringBuffer sb1 = new StringBuffer("gemini");
        System.out.println("sb1.length() : " + sb1.length());
        System.out.println("sb1.capacity() : " + sb1.capacity());

        // 스트링버퍼 클래스는 메소드에 의해서 값의 변화가 일어나면 힙메모리 새 공간 할당x
        // 동적으로 공간 크기 변경됨 (가변, 스트링빌더도 가변. 스트링은 불변.)
        sb1.append("A string buffer implements" +
                "a mutable sequence of characters");
        System.out.println("sb1.length() : " + sb1.length());
        System.out.println("sb1.capacity() : " + sb1.capacity());

        StringBuffer sb2 = new StringBuffer();
        System.out.println("sb2.length() : " + sb2.length());
        System.out.println("sb2.capacity() : " + sb2.capacity());
    }
}

class StringBuffer2 {
    public void stringBuffer2() {
        // StringBuffer 객체 생성
        StringBuffer sb1 = new StringBuffer("gemini");
        System.out.println("sb1 = " + sb1);

        // StringBuffer sb1에 문자열을 추가해 새로운 객체 생성
        StringBuffer sb2 = sb1.append(" is beautiful");
        System.out.println("sb2 = " + sb2);
        System.out.println("sb1 = " + sb1);

        // 정수형 데이타 형을 추가
        System.out.println(sb1.append(1004));
        System.out.println("sb1 = " + sb1);
        System.out.println("sb2 = " + sb2);

        String str = new String(sb1); // StringBuffer를 String으로 변환
        System.out.println(str.toUpperCase());
    }
}

class StringBuffer3 {
    public void stringBuffer3() {
        StringBuffer sb1 = new
                StringBuffer("gemini is beautiful");
        System.out.println(sb1);

        sb1.insert(10, "very");
        System.out.println(sb1);

        sb1.insert(0, 1004);
        System.out.println(sb1);
    }
}

public class JavaTask38 {
    public static void main(String[] args) {
        StringBuffer1 s1 = new StringBuffer1();
        s1.stringBuffer1();

        System.out.println("--------------------");

        StringBuffer2 s2 = new StringBuffer2();
        s2.stringBuffer2();

        System.out.println("--------------------");

        StringBuffer3 s3 = new StringBuffer3();
        s3.stringBuffer3();
    }
}