package task.java3;

// set 자료구조를 활용한 과제
/*
1~45 사이의 정수 중에서 6개의 숫자를 추출하는 로또 프로그램
단, set 자료구조를 사용해서 중복 숫자가 나오지 않도록 하고
    추출된 6개의 숫자를 오름차순으로 정렬해서 출력하기

 */

import java.util.Random;
import java.util.TreeSet;

public class JavaTask65 {
    public static void main(String[] ar) {
        // 오름차순 정렬해주는 트리셋으로 사용
        TreeSet treeSet = new TreeSet();

        // Math.random()
        while (treeSet.size() < 6) {
            int num = (int) (Math.random() * 45) + 1;
            treeSet.add(num);
        }
        System.out.println(treeSet);

        System.out.println();

//------------------------------------------------------------------------------------

        // Random() 활용
        TreeSet treeSet2 = new TreeSet();
        Random r = new Random();

        for (int i = 0; i < 6; i++) {
            int n = r.nextInt(45) + 1;
            treeSet2.add(n);
        }
        System.out.println(treeSet2);

    }
}
