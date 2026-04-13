package task.java4;

// File 클래스는 데이터들이 입.출력 하면서 사용하는 파일이나 디렉토리 체제를 관리하는 클래스임.
// 디렉토리 생성이나 파일 & 디렉터리 삭제 기능이 있는 파일 클래스

import java.io.File;

class FileTest {
    public static void execute() {
        try {
            // File 객체 생성. c:/java01/temp 폴더가 생성되고, 현 위치 하위에 test폴더가 생성됨
            // 경로명 test90으로 최상위루트의 하위에 생김
            File temp = new File("C:/java01", "temp");
            File tempFile = new File("test90");

            // 디렉토리 생성(mkdirs()는 디렉토리를 만들면 true를 반환함)
            // 디렉토리 생성 메소드 mkdir()는 부모 디렉토리가 존재하지 않으면 디렉토리를 생성하지 못하지만,
            // mkdirs()는 부모 디렉토리가 존재하지 않아도 디렉토리를 생성할 수 있음
            System.out.println("create directory state : " + temp.mkdirs());
            System.out.println("create directory state : " + tempFile.mkdirs());

            // 디렉토리 삭제 메소드 delete() - 디렉토리가 비어있을 때만 삭제할 수 있음
            // 디렉토리가 비어있지 않을 때는 false를 반환함(삭제 불가) 디렉토리가 비어있을 때는 true를 반환함(삭제 성공)
//            tempFile.delete();
//            System.out.println("delete directory state : " + temp.delete());

            // 비어있지 않는 디렉토리 안의 내용을 삭제하려면 리스트화 -> 삭제
            // ListFiles() 메소드는 디렉토리 내의 모든 파일과 디렉토리를 File 객체 배열로 반환함
            // ex) temp 디렉토리 안에 이미지 파일 존재 -> 삭제됨. 이후 디렉토리 비워서 삭제하면 됨
            File[] list = temp.listFiles();
            for (File f : list) {
                System.out.println(f.delete());
            }
//            temp.delete();          // 부모삭제x 자식디렉토리인 temp만 삭제됨
//            이클립스의 경우 파일락때문에 프로세스 중단 메시지가 뜰 수 있는데, 이전 실행 프로세스완전종료 새로고침 재실행하면 삭제됨
            /*
완전 종료: 콘솔창 오른쪽 위에 있는 **빨간색 네모 버튼(Terminate)**을 눌러 좀비 프로세스를 죽입니다. (버튼이 회색이 될 때까지!)
새로고침(Refresh): 프로젝트 우클릭 -> Refresh (F5). 이클립스가 "아, 윈도우 탐색기에서 이미 뭐가 바뀌었구나"라고 인지하게 만듭니다.
재실행: 락이 풀린 상태에서 다시 delete()를 시도하면 true가 반환되며 시원하게 지워집니다.
             */

//            File[] arr = tempFile.listFiles();
//            for (File f : arr) {
//                System.out.println(f.delete());
//            }
//            tempFile.delete();

            // File 클래스에서 제공하는 메소드로 파일 시스템에 대한 여러가지 정보를 얻을수 있음
            System.out.println("temp canRead : " + temp.canRead());
            System.out.println("temp canWrite : " + temp.canWrite());
            System.out.println("temp getAbsoluteFile : " + temp.getAbsoluteFile());
            System.out.println("temp getName : " + temp.getName());
            System.out.println("temp getParent : " + temp.getParent());
            System.out.println("temp getPath : " + temp.getPath());
            System.out.println("temp isDirectory : " + temp.isDirectory());
            System.out.println("temp isFile : " + temp.isFile());
        } catch (Exception e) {
        }
    }
}

public class JavaTask93 {
    public static void main(String[] args) {
        FileTest.execute();
    }
}
