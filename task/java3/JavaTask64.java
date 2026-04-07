package task.java3;

import java.util.Iterator;
import java.util.TreeSet;

// TreeSet 트리셋 : 데이터를 오픔차순으로 정렬해서 저장하고 출력하는 기능 제공
// 중복된 데이터 저장 x
// 오름차순기준 - 숫자나 문자열은 문제없는데 문자형은 유니코드 작은 순으로 진행됨.

public class JavaTask64 {
    public static void main(String[] args) {
        TreeSet hs = new TreeSet();

        if (hs.add("korea")) {
            System.out.println("첫 번째 korea 추가 성공");
        } else {
            System.out.println("첫 번째 korea 추가 실패");
        }

        if (hs.add("japan")) {
            System.out.println("japan 추가 성공");
        } else {
            System.out.println("japan 추가 실패");
        }

        if (hs.add("america")) {
            System.out.println("america 추가 성공");
        } else {
            System.out.println("america 추가 실패");
        }

        if (hs.add("britain")) {
            System.out.println("britain 추가 성공");
        } else {
            System.out.println("britain 추가 실패");
        }

        if (hs.add("korea")) {
            System.out.println("두 번째 korea 추가 성공");
        } else {
            System.out.println("두 번째 korea 추가 실패");
        }

        System.out.println();

        Iterator it = hs.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

/*
첫 번째 korea 추가 성공
japan 추가 성공
america 추가 성공
britain 추가 성공
두 번째 korea 추가 실패

america
britain
japan
korea

 */