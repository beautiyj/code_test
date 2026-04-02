package task.java2;

// StringBuffer는 동기화 처리(스레드세이프) 지원하긴 하지만 속도 느려서 잘 안씀
// StringBuilder는 동기화 처리는 지원하지 않지만 빨라서 잘 사용하긴 함

/*
특징                 Java                        Python                           Kotlin
--------------------------------------------------------------------------------------------------------
클래스명    "StringBuffer, StringBuilder"       io.StringIO 또는 list             StringBuilder
속도          StringBuilder가 빠름               list + join()이 가장 빠름          자바와 동일함
실무 방식    StringBuilder 생성 후 append      리스트에 append 후 마지막에 join      buildString { } 블록 사용
 */

class StringBuffer1 {
    public void stringBuffer1() {

        // capacity() : heap메모리 상에 할당된 공간의 크기를 구해오는 메소드(기본값은 16바이트, 처음엔 언제나 여유공간 16이 존재.)
        StringBuffer sb1 = new StringBuffer("gemini");
        System.out.println("sb1.length() : " + sb1.length());           // 6
        System.out.println("sb1.capacity() : " + sb1.capacity());       // 22 (기본 16바이트+ 문자열 6)

        // 스트링버퍼 클래스는 메소드에 의해서 값의 변화가 일어나면 힙메모리 새 공간 할당x
        // 동적으로 공간 크기 변경됨 (가변, 스트링빌더도 가변. 스트링은 불변.)
        // 캐파시티에서 조금 추가 시 보통 (이전 용량 * 2) + 2 공식인데(기존22 이후 46) 많은 게 들어오면 딱 맞게 확장됨.
        sb1.append("A string buffer implements" +
                "a mutable sequence of characters");
        System.out.println("sb1.length() : " + sb1.length());     // 64 (58글자 추가됨)
        System.out.println("sb1.capacity() : " + sb1.capacity()); // 64
                                                    // (append 확장하면 캐파시티 확인 시 여유공간 없이 64)

        StringBuffer sb2 = new StringBuffer();
        System.out.println("sb2.length() : " + sb2.length());           // 0
        System.out.println("sb2.capacity() : " + sb2.capacity());       // 16

        if(sb1 == sb2){
            System.out.println("sb1 == sb2 같주소");
        } else {
            System.out.println("sb1 != sb2 다른주소");
        }

    }
}

class StringBuffer2 {
    public void stringBuffer2() {
        // StringBuffer 객체 생성
        StringBuffer sb1 = new StringBuffer("gemini");
        System.out.println("sb1 = " + sb1);

        // StringBuffer sb1에 문자열을 추가해 새로운 객체 생성
        StringBuffer sb2 = sb1.append(" is beautiful");
        System.out.println("sb2 = " + sb2); // sb2 = gemini is beautiful
        System.out.println("sb1 = " + sb1); // sb1 = gemini is beautiful

        System.out.println();

        // 정수형 데이타 형을 추가
        System.out.println(sb1.append(1004));       // gemini is beautiful1004
        System.out.println("sb1 = " + sb1);
        System.out.println("sb2 = " + sb2);

        // 스트링버퍼를 스트링 클래스 생성자를 이용해 스트링 클래스로 변환
//        String s = sb1.toString();
        String str = new String(sb1); // StringBuffer를 String으로 변환
        System.out.println(str.toUpperCase());      // GEMINI IS BEAUTIFUL1004
    }
}

class StringBuffer3 {
    public void stringBuffer3() {
        StringBuffer sb1 = new StringBuffer("gemini is beautiful");
        System.out.println(sb1);        // gemini is beautiful

        // insert(인덱스번호, 문자열) 10,1004 라면 10번자리에 1004를 차례로 삽입.
        // 기존의 글자는 인덱스 14부터 시작함. 칸이 쭉 뒤로 밀림.
        // 인덱스 0이면 무조건 맨앞부터 삽입, sb.length()는 맨뒤삽입 append와 동일함
        sb1.insert(10, "very");
        System.out.println(sb1);        // gemini is verybeautiful

        sb1.insert(0, 1004);
        System.out.println(sb1);        // 1004gemini is verybeautiful
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