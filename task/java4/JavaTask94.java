package task.java4;

// 입출력 스트림 - 객체 직렬화

// 객체 직렬화: 각 사람에 대한 객체를 만들어 놓고 객체 단위로 입.출력 하는 것을 말함.
// 독립 객체들도 내부적으로는 사방에 흩어져 존재 하지만 입.출력 할때는 줄을 세워서 입.출입 하기 때문에 객체 직렬화라고 함
// 객체 단위로 저장하고 읽기 위해서 2개의 클래스가 제공된다. (ObjectInputStream, ObjectOutputStream)

import java.io.*;
import java.util.Date;


// 신상 정보를 간직한 객체를 만들기 위한 클래스

// 객체 직렬화를 위해서는 Serializable이라는 인터페이스를 상속받아야 한다.(메소드는 없음)
// Serializable 인터페이스는 직렬화 한다는 표시자의 역할만 함. Serializable 인터페이스를 구현한 클래스로 객체를 만들고
// 입.출력을 하면 우리가 프로그램에서 체크하지 않아도 중복된 객체가 입.출력하는 것을 방지해 준다.
class PersonInformation implements Serializable {
    // 멤버 변수
    private String name;
    private int age;
    private String address;
    private String telephone;

    // 생성자
    public PersonInformation(String name, int age, String address, String telephone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.telephone = telephone;
    }

    // 각 멤버 변수의 값을 리턴시키는 getXXX()메소드
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }
}

// 객체를 실제로 입.출력 시키는 클래스
class ObjectStreamTest {
    // PersonInforamtion 객체를 선언
    PersonInformation gemini;
    PersonInformation johnharu;
    Date d;

    // 생성자
    public ObjectStreamTest() {

        // PersonInforamtion 객체를 생성
        gemini = new PersonInformation("gemini", 10, "seoul", "02-321-3234");
        johnharu = new PersonInformation("johnharu", 20, "seoul", "02-473-4232");

        // 날짜 정보를 지니는 Data 객체 생성
        d = new Date();
    }//생성자 end

    public static void main(String[] args) {
        ObjectStreamTest ost = new ObjectStreamTest();
        ost.writeObjectFile();
        ost.readObjectFile();
    }

    // File에 객체를 저장하는 메소드
    public void writeObjectFile() {
        try {
            // 파일에 저장하기 위한 FileOutputStream 생성
            FileOutputStream fos = new FileOutputStream("person.dat");

            // 파일에 객체를 저장하기 위한 ObjectOutputStream 객체 생성
            // argument로 FileOutputStream 객체를 받음
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // write()를 이용해 객체를 file에 저장
            oos.writeObject(gemini);
            oos.writeObject(johnharu);
            oos.writeObject(d);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // File에서 객체를 읽어오는 메소드
    public void readObjectFile() {
        try {
            // 파일에서 데이터를 읽어오기 위한 FileInputStream 객체 생성
            FileInputStream fis = new FileInputStream("person.dat");

            // File에 저장된 객체를 읽어 오기 위해 FileInputStream 객체를 생성자 argument를 받아 객체 생성
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o = null;
            // 파일(person.dat)에 저장된 객체를 모두 읽어 올 때까지 반복
            while ((o = ois.readObject()) != null) {

                // if( 변수 instanceof 클래스명): 변수가 이 클래스의 instance인지 아닌지를 체크함.
                // 만약 읽어온 객체가 PersonInforamtion 객체이면
                if (o instanceof PersonInformation) {
                    System.out.print(((PersonInformation) o).getName() + " : ");
                    System.out.print(((PersonInformation) o).getAge() + " : ");
                    System.out.print(((PersonInformation) o).getAddress() + " : ");
                    System.out.print(((PersonInformation) o).getTelephone());

                    System.out.println();
                } else {
                    System.out.println(o.toString());
                }
            }//while end
        } catch (Exception e) {
        }
    }
}


public class JavaTask94 {
    public static void main(String[] args) {
//        ObjectStreamTest.main(args);
    }
}
