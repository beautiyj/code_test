package test.java;

/*

시프트 연산
 이진수에서 자릿수가 하나 올라간다는 건 2를 곱한다는 뜻이고,
 내려간다는 건 2로 나눈다는 뜻입니다.

(참고로 제곱계산은 자바코틀린 - Math.pow() 파이썬은 **)

 << (Left Shift): 비트를 왼쪽으로 밀고, 빈 오른쪽 칸은 0으로 채웁니다.
 결과적으로 숫자가 2배가 됩니다. (n * 2의 제곱)

 >> (Right Shift): 비트를 오른쪽으로 밀고, 넘치는 비트는 버립니다.
 결과적으로 숫자를 2로 나눈 몫이 됩니다. (n / 2의 제곱)

 */
public class JavaTest12 {
    public static void main(String[] args) {

        // <<, >> (Shift): 빠르게 계산하기 (곱하기 & 나누기 2)
        int n = 10; // 이진수: 1010

        // 왼쪽으로 1칸 밀기 (10 * 2)
        int leftShift = n << 1;
        System.out.println("10 << 1 = " + leftShift); // 20

        // 오른쪽으로 1칸 밀기 (10 / 2)
        int rightShift = n >> 1;
        System.out.println("10 >> 1 = " + rightShift); // 5

    }
}
/*
    이진수 단위로 밀고 계산 가능.

    n << 1 : *2     n >> 1 : /2
    n << 2 : *4     n >> 2 : /4
    n << 3 : *8     n >> 3 : /8
    n << 4 : *16    n >> 4 : /16

 */