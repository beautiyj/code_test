package test.java;

/*
 해시함수는 딕셔너리에서 데이터 꺼내오는 행위.
 딕셔너리가 키:값, 이름표와 바구니일 때
 해시는 자판기에서 해당 이름표를 보고 바구니를 가져오는 행위를 말함.

 */
import java.util.HashMap;

public class JavaTest13 {

    public static void main(String[] args) {

        // 1. 과일 개수 세기 (데이터 카운팅 - 자판기 재고 확인)
        System.out.println("--- 1. 과일 개수 세기 ---");
        HashMap<String, Integer> inventory = new HashMap<>();

        inventory.put("사과", 5);
        inventory.put("바나나", 10);
        inventory.put("포도", 3);

        System.out.println("사과 재고: " + inventory.get("사과") + "개");
        System.out.println("전체 자판기 상태: " + inventory);
        System.out.println();


        // 2. 학생 성적 관리 (데이터 매핑 - 이름표로 바구니 찾기)
        System.out.println("--- 2. 학생 성적 관리 ---");
        HashMap<String, Integer> scores = new HashMap<>();

        scores.put("철수", 90);
        scores.put("영희", 100);
        scores.put("민수", 85);

        String target = "영희";
        // '영희'라는 이름표를 스캔해서 100점 바구니를 꺼내옵니다.
        System.out.println(target + "의 점수: " + scores.get(target) + "점");

    }

}

/*
    해시(Map) 활용의 4대 코딩 서식

1. 데이터 넣기 (Create / Update)
"이 이름표에 이 물건을 담아!" 혹은 "기존 물건을 새걸로 바꿔!" 할 때 씁니다.

    Java: map.put("키", "값");
    Kotlin: map["키"] = "값" 또는 map.put("키", "값")
    Python: dict["키"] = "값"

2. 데이터 가져오기 (Read)
"이 이름표가 붙은 바구니 가져와!" 할 때 씁니다.

    Java: map.get("키");
    Kotlin/Python: map["키"] (대괄호를 쓰는 게 공통 서식입니다.)

3. 데이터 존재 확인 (Check)
"자판기에 이 이름표가 붙은 물건이 있긴 한 거야?"라고 물어볼 때 씁니다. (이거 중요합니다!)

    Java: map.containsKey("키") (결과는 true/false)
    Kotlin: map.containsKey("키") 또는 "키" in map
    Python: "키" in dict (가장 직관적이죠?)

4. 데이터 삭제 (Delete)
"이 이름표랑 바구니 이제 치워버려!" 할 때 씁니다.

    Java/Kotlin: map.remove("키");
    Python: del dict["키"]

안드로이드에서 매핑한다는 게 결국 해시 구조를 만든다는 말임
(보통 해시 서식 JSON으로 오고 그걸 클래스에 끼워넣는 걸 데이터매핑)


================================================================================

 해시(Map)의 언어별 작성 서식

 (코드 뼈대)해시는 if문처럼 한 줄로 끝나는 게 아니라,
 **[1. 선언 서식]**과 [2. 활용 서식] 두 단계로 나뉩니다.

 1. 선언 서식 (자판기 만들기)
 처음에 "이런 자판기를 쓰겠다"라고 선언하는 규칙입니다.
 Java: HashMap<키타입, 값타입> 변수명 = new HashMap<>();
 Kotlin: val 변수명 = mutableMapOf<키타입, 값타입>()
 Python: 변수명 = {}

 2. 활용 서식 (기계팔 휘두르기)
 가장 궁금해하셨던 실제 코드 작성 규칙입니다.
 기능              Java (서식)       Kotlin (서식)     Python (서식)
 넣기          맵.put(키, 값);       맵[키] = 값        딕셔너리[키] = 값
 가져오기       맵.get(키);          맵[키]             딕셔너리[키]
 확인          맵.containsKey(키)   키 in 맵           키 in 딕셔너리
 삭제          맵.remove(키);       맵.remove(키)      del 딕셔너리[키

해시의 서식: Java는 .put(), .get(), 파이썬/코틀린은 [] 대괄호를 쓰는 규칙.
해시 함수: 우리가 get("키")라고 썼을 때, 그 "키"를 숫자 좌표로 바꿔주는 내부 계산기.
 */