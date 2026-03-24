package task.java;

// sort 정렬

import java.util.Arrays;
import java.util.Collections;

public class JavaTask18 {
    public static void main(String[] args) {

        int[] s = {30,20,75,29,80,12};
        Integer[] q = {30,20,75,29,80,12};      // 자바에서 내림차순은 객체 형태여야 인지함. 랩퍼클래스

        Arrays.sort(s);
        System.out.println(Arrays.toString(s));

        Arrays.sort(q, Collections.reverseOrder());
        System.out.println(Arrays.toString(q));
    }
}
