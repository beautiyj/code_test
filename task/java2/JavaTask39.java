package task.java2;

import java.util.Arrays;
import java.util.StringTokenizer;

// StringTokenizer 클래스: 특정 구분자를 기준으로 문자열을 나누는 클래스.
// 토큰은 구분자로 나누어진 문자열 조각을, 구분자는 - | , 등의 기호를 뜻함.
// 실제로는 복사본이나 배열 등에 활용하는 용도로 split()를 자주 씀

class StringTokenizerTest1 {
    public void stringTokenizerTest1() {
        String source1 = "111-111|강원도|춘천시|퇴계동";
        StringTokenizer st1 = new StringTokenizer(source1, "|");

        String zip = st1.nextToken();
        String dou = st1.nextToken();
        String si = st1.nextToken();
        String dong = st1.nextToken();

        System.out.println("우편번호:" + zip);
        System.out.println("도:" + dou);
        System.out.println("시:" + si);
        System.out.println("동:" + dong);
    }
}

class StringTokenizerTest2 {
    public void stringTokenizerTest2() {
        String source1 = "한국 미국 태국 중국 이란";
        StringTokenizer st1 = new StringTokenizer(source1, " ");
        while (st1.hasMoreTokens()) {
            System.out.println("st1.token:" + st1.nextToken());
        }

        System.out.println();

        String source2 = "푸들,삽살개,풍산개,진돗개";
        StringTokenizer st2 = new StringTokenizer(source2, ",");
        while (st2.hasMoreTokens()) {
            System.out.println("st2.token:" + st2.nextToken());
        }

        System.out.println();

        // true 옵션은 구분자(,)도 토큰으로 포함해서 출력하겠다는 의미입니다.
        StringTokenizer st3 = new StringTokenizer(source2, ",", true);
        while (st3.hasMoreTokens()) {
            System.out.println("st3.token:" + st3.nextToken());
        }
    }
}

class StringTokenizerTest3 {
    public void stringTokenizerTest3() {
        StringTokenizer str = new StringTokenizer("이순신#을지문덕#강감찬#광개토대왕", "#");

        // int형 countTokens() : 파싱된 문자열이 모두 몇 개인지 되는지 알려주는 메소드
        // 꺼내지 않고 남아있는 토큰의 수를 알려주는 거라 nextToken()으로 꺼낸 뒤라면 횟수가 달라짐.
        // 그래서 보통은 반복문을 돌리기 전이나 도중에 안전하게 꺼낼 데이터가 있는지 확인 용도로 사용함
        int cnt = str.countTokens();
        System.out.println("파싱할 문자열의 총갯수-> " + cnt);        // 4

        // String형 nextToken() : 토큰을 하나씩 꺼내옴.
        // 대신 가져올 토큰이 없으면 예외 발생(NoSuchElementException 에러)
        // 한 번 소모한 토큰(데이터)로 돌아갈 수 없어서 일회용이나 다름없음.
        System.out.println(str.nextToken());        // 이순신

        // boolean형 hasMoreTokens : 남아있는 토큰이 있는지 여부를 확인함. 존재t 없으면 f
        // 데이터를 꺼내는 게 아니라서 조건식으로 많이 씀 (토큰 개수를 모를 경우의 로직에 유용함)
        while(str.hasMoreTokens()){ //토큰이 있으면
            System.out.print(str.nextToken() + " "); //차례대로 파싱된 문자열을 얻어온다. 있는 거 까지만 가져와라
        }

        System.out.println();
    }
}

// 위의 예제를 split으로 풀 경우
class StringSplit {
    public void stringSplit() {
        String str = "이순신#을지문덕#강감찬#광개토대왕";

        String[] arr = str.split("#");

        for (String str2 : arr) {
            System.out.println(str2);
        }
        /*  이순신
            을지문덕
            강감찬
            광개토대왕 */
        System.out.println(Arrays.toString(arr));   // [이순신, 을지문덕, 강감찬, 광개토대왕]

        // 배열을 스트림으로 바꿔서 바로 출력  ::는 람다식이 아닌 메소드 참조형태로 들어온 거 그대로 넘김!
        Arrays.stream(arr).forEach(System.out::println);
        /*  이순신
            을지문덕
            강감찬
            광개토대왕 */
    }
}

public class JavaTask39 {
    public static void main(String[] args) {
        StringTokenizerTest1 t1 = new StringTokenizerTest1();
        t1.stringTokenizerTest1();

        System.out.println("--------------------");

        StringTokenizerTest2 t2 = new StringTokenizerTest2();
        t2.stringTokenizerTest2();

        System.out.println("--------------------");

        StringTokenizerTest3 t3 = new StringTokenizerTest3();
        t3.stringTokenizerTest3();

        System.out.println("--------------------");

        StringSplit t4 = new StringSplit();
        t4.stringSplit();
    }
}