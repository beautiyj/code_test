package task.java3;

import java.util.Vector;

// 제네릭 예제 등등

// GenericTest05
class GenericClass<T> {
    private T member;

    public T getValue() {
        return member;
    }

    public void setValue(T value) {
        member = value;
    }
}

class Collections06 {
    public void collection06() {
        Vector<String> vec = new Vector<String>();

//    제네릭 사용하지 않을 경우 Vector vec2 = new Vector(); ++ 여러가지 자료형 넣을 수 있음
        vec.add("Apple");   // 업캐스팅
        vec.add("banana");
        vec.add("oRANGE");
//        vec.add(30);

        String temp;
        for( int i = 0; i<vec.size();i++) {
//          제네릭을 사용하지 않으면 자료형 생략 불가
//            temp = (String) vec.get(i);   // 다운캐스팅
            temp = vec.get(i);
            System.out.println(temp.toUpperCase());
        }
    }
}


class JavaTask76 {
    public static void main(String[] args) {
        // GenericTest05
        GenericClass<Double> obj01 = new GenericClass<Double>();
        obj01.setValue(3.4);
        System.out.println("되돌리는 값은->" + obj01.getValue());

        GenericClass<Integer> obj02 = new GenericClass<Integer>();
        obj02.setValue(10);
        System.out.println("되돌리는 값은->" + obj02.getValue());

        GenericClass<String> obj03 = new GenericClass<String>();
        obj03.setValue("이해할 수 있다.");
        System.out.println("되돌리는 값은->" + obj03.getValue());

        System.out.println("=============================================================");
        System.out.println();

        Collections06 col06 = new Collections06();
        col06.collection06();    }
}