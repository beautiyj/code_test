package test.java;

/*
배타적 논리합 ^ XOR 연산자
: 두 값이 같으면 0 (false), 다르면 1 (true)로 계산하는 연산자
둘 다 tt면 f, ff면 t 뭔가... 애매한 or+not 같다

- true ^ true = false
- true ^ false = true
- false ^ true = true
- false ^ false = false

배타적 논리합 ^ 주요 활용처 예제
 */

public class JavaTest11 {
    public static void main(String[] args) {

        // 1. 짝 없는 숫자 찾기
        System.out.println("1. 짝 없는 숫자 찾기");
        int[] arr = {2, 3, 2, 4, 3}; // 4를 제외한 나머지는 짝이 존재함
        int result = 0;

        for (int num : arr) {
            result ^= num;  // result = result ^ num;
        }
        System.out.println("혼자 남은 짝 없는 숫자: " + result);
        System.out.println();

        // 2. temp처럼 임시 변수 쓰지 않고도 두 변수의 값을 바꾸는 swap 예제
        System.out.println("2. 임시 변수 없이 값 바꾸기(Swap)");
        int a = 10;
        int b = 20;
        System.out.println("바꾸기 전 -> a: " + a + ", b: " + b);
        a = a ^ b; // a= 10^20(이진수로 계산됨, 하지만 숫자 30의 값을 갖는다고 하기엔 다름;
                    //   0 1 0 1 0 (1010인데 비교하기 편하게 01010으로 지정)
                    // ^ 1 0 1 0 0
                    // = 1 1 1 1 0) 그럼 30됨. 12 ^ 10이면 6이 되는 등등... 이진수기준임
        b = a ^ b;  // b = a^b 인데 현재 a가 a^b이므로 b= a^b^b. b^b=0이라 b=a.
        a = a ^ b;  // a = a^b 인데 현재 a가 a^b, b=a라서 a=a^b^a, a=b.
        System.out.println("바꾼 후   -> a: " + a + ", b: " + b);
        System.out.println();


        // 3. 암호화 및 복호화
        System.out.println("3. 암호화 및 복호화");
        int originalData = 12345;
        int secretKey = 999;

        // 암호화 (데이터에 비밀키의 마스크를 씌움)
        int encrypted = originalData ^ secretKey;
        System.out.println("원본 데이터: " + originalData);
        System.out.println("암호화된 데이터 (알 수 없는 값): " + encrypted);

        // 복호화 (암호화된 데이터에 똑같은 비밀키를 한 번 더 씌움)
        int decrypted = encrypted ^ secretKey;
        System.out.println("복호화된 데이터 (원상복구): " + decrypted);

    }
}
