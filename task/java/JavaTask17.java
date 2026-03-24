package task.java;

// 배열 예제 이어서

/*
배열이나 컬렉션에서 쓸 때 for문 서식이 다른 게 더 있는데

for (변수: 자료구조) {
    실행 문장;
}

파이썬 코틀린에서는 각각 for (s in score) for s in score같은 거

 */

public class JavaTask17 {
    public static void main(String[] args) {

// ============================================================================

        // 예제 1. 확장for문
        int[] score = {95,71,84,93,87};

        // 기본 for문의 경우
        int sum = 0;
        for (int i=0; i<score.length; i++){
            sum += score[i];
        }
        System.out.println(sum);

        // 확장 for문의 경우
        int sum1 = 0;
        for (int s : score) {
            sum1 += s;
        }
        System.out.println(sum1);

// ============================================================================

        // 예제 2. 배열 복사
        int[] oldArray = {10,20,30};
        int[] newArray = new int[5];

        for (int i=0; i<oldArray.length; i++){
            newArray[i] = oldArray[i];
        }

        for (int i : newArray){
            System.out.println(i+"\t");
        }

// ============================================================================

        // 예제3. 사용자 정의 메소드를 활용한 문자열 숫자 변환, 절대값 구하기
        // run 파일의 구성편집 -> 프로그램 인수에 -10 -20 입력하면 이후엔 출력됨
        System.out.println(args[0]);    // "-10"
        System.out.println(args[1]);    // "-20"

        int num = Integer.parseInt(args[0]);
        System.out.println(abs(num));

    }

    // 음수->양수 변환 절대값 구하기 메소드
    public static int abs(int data) {
        if (data <0) {
            data = -data;
        }
        return data;
    }

}
