package test.java;

/*
문자열 my_string과 정수 k가 주어질 때,
my_string을 k번 반복한 문자열을 return 하는 함수를 작성

입출력 예시
my_string	k	    result
-------------------------------
"string"	3	   "stringstringstring"
"love"  	10	   "lovelovelovelove... 아무튼10번"

변수:
입력값 문자열 my_string, 정수 k,
상태값 반복변수i, 반복한문자열결과값
행위: 문자열k번반복제어, 문자열return

 */

// 편한 코드실행을 위해 class로 분리, main 내에서 직접 함수 설정도 가능.

class JavaTest5Class{

    public String javaTest5Class(String my_string, int k) {
        String result = "";
        for (int i=0; i<k; i++) {
            result += my_string;
        }
        return result;
    }

}

public class JavaTest5 {
    public static void main(String[] args) {
        JavaTest5Class t5 = new JavaTest5Class();
        String result = t5.javaTest5Class("test", 3);

        System.out.println(result);
    }



}
