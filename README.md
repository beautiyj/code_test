# 🚀 code_test
> **Intellij를 활용하여 Python, Java, Kotlin 형태로 문제 풀기**

---

### 📂 폴더 구조
* **task 폴더**: 기출 문제 위주
* **test 폴더**: 기초 및 입문용 연습 문제 위주
* **공통**: 같은 예제를 각기 다른 언어로 풀이 진행
* **sql 폴더**: SQL 파일 및 기초 명령어, SQL문 개념 위주

---

### 📚 사용 교재
* **Python**: [혼자 공부하는 파이썬]
* **Java**: [혼자 공부하는 자바]
* **Kotlin**: [이것이 안드로이드다 with 코틀린] 또는 [코틀린으로 배우는 안드로이드 앱 개발 실전 노하우 2/e]
  * *팁: 코틀린은 아예 모른다면 전자를, 지식이 있다면 후자를 활용할 것! 후자는 안드로이드 개발서에 가깝다.*

### 📝문제 설명 (키워드 검색으로 찾기! ex) 역순출력, 팩토리얼 )
# task
1. 최댓값 최솟값: 키보드로 정수를 입력받았을 때 max min 구하기 (조건연산자 활용-코틀린 제외)
2. 최댓값 최솟값: 키보드로 정수를 입력받았을 때 max min 구하기 (if-else문 활용)
3. 팩토리얼(반복문): 키보드로 정수를 입력받았을 때 n! 팩토리얼 구하기
4. 구구단(반복문): 구구단을 세로 방향으로 출력하기
5. 배열 최대최소: 키보드로 정수를 입력받아 배열에 대입, 배열에 저장된 값 중 최댓값 최솟값 구하기
6. 2차원 배열(이중반복문)1: 과목별 총점과 학생별 총점 점수 출력하기
7. 클래스와 생성자 초기화: 회원정보를 입력받고 새로운 클래스의 멤버변수에 저장, 출력하기
8. 클래스와 setter메소드 초기화(+@Getter Setter 어노테이션 사용한 Lombok 롬복 라이브러리): 7번과 동일하나 멤버변수 초기화 방법만 다름
9. Math.random(): 랜덤함수를 사용해 로또번호 추출하기(기본 버전과 간단 버전 2가지)
10. Calendar: 캘린더 클래스를 활용해 오늘 날짜 시간 요일 출력하기(파이썬은 datetime 모듈 활용)
11. 조건문 자바 switch-case문(+yield): (코틀린은 when문, 파이썬은 match-case문을 활용) 점수에 따라 학점 측정하기
12. 반복문 for문: for문을 활용한 반복예제. 문자열+숫자 반복출력, 누적합계 홀짝 판별, 구구단 출력
13. 반복문 while문: while문을 활용한 반복예제. 문자열+숫자 반복출력, 누적합계 홀짝 판별, 구구단 출력
14. 반복문 do while문: do while문을 활용한 반복예제. (파이썬 제외) 문자열+숫자 반복출력, 누적합계 홀짝 판별, 대화형 에코프로그램
15. 보조 제어문 break문 & continue문: 무한루프 및 반복문에서의 활용 예제. 특정 숫자 출력, 반복문 중단, Random() 중단
16. 배열: 자료형에 따른 배열 초기화 방식과 간단 예제
17. 배열2: 확장for문 및 배열 예제 (+ 절대값 구하기 및 문자열->숫자 변환 예제 포함 Wrapper 클래스)
18. 정렬(sort): 오름차순 내림차순 정렬
19. 2차원 배열: 이차원 배열의 데이터가 주어졌을 때 행렬처럼 출력하기, 과목별 학생별 총점 구하기
20. 메소드 함수: 기본형과 참조형 메소드(=함수) 작성하기
21. 메소드 함수2:누적합계 구하기, 키보드로 입력받은 숫자 중 max min 구하기, 값과 주소 비교
22. Scanner클래스 next메소드 활용: 파이썬은 input isdigit(), 코틀린은 readlnOrNull() readln()
23. 2차원 배열 & 중첩for문2: 이중for문 활용하여 주어진 배열의 sum 누적합계, avg 평균값 구하기
24. 클래스, 생성자, 메소드1: 클래스, 생성자, 메소드 예제
25. 클래스, 생성자, 메소드2: 클래스, 생성자, 메소드 예제(파이썬,코틀린 모두 24파일하나 통합)
26. 클래스, 생성자, 메소드3: this 활용 및 생성자 오버로딩(+빌더패턴 활용)
27. 클래스4: 리턴값이 없는 메소드 void
28. 클래스5: 클래스 내부에서 메소드 호출
29. 클래스6: 정적필드와 정적메소드 static(코틀린은 컴패니언객체), 그 외 자바의 정적메소드(=내장함수같은 거) Math 등
30. 로또: 로또 프로그램 만들기
31. Singleton: 싱글톤 객체
32. API 클래스: Date(날짜), Timestamp(DB시간), Calendar(날짜계산), LocalDateTime(신형날짜),
SimpleDateFormat/DateTimeFormatter(포맷팅), InputStream/Scanner(입력), Random(난수)
33. 패키지: 같은 패키지와 다른 패키지의 메소드 호출하기
34. final: final 메소드, 클래스, 상속 불가 예제
35. API 클래스 String: toUpperCase(대문자), toLowerCase(소문자), charAt(인덱스반환), indexOf(인덱스번호구하기),
trim(공백제거), substring(잘라내기붙여넣기), replace(대체), replaceFirst replaceAll, split(조건 분리)
36. 주민번호 판별: 남녀 성별 판별하기 & 유효성 검사
37. 주민번호 판별: 주민번호 유효성 판별 공식 활용하기 & 유효성 검사
38. StringBuffer: 스트링버퍼 클래스
39. StringTokenizer: 스트링토크나이저 클래스 및 split로 푸는 방법(split을 더 많이 써서)
40. Wrapper: boxing unboxing Auto-boxing Aucdto-unboxing 박싱 언박싱 자동박싱 자동언박싱 etc & 2진수 8진수 16진수 변환
41. Wrapper2: 기본형에서의 박싱과 언박싱, Object 객체에서의 박싱과 언박싱(범용성 확인용) 예제
42. Wrapper2-1: Task41의 Lombok 롬복 라이브러리 활용 버전
43. Wrapper 예제: DecimalFormat 클래스를 활용하여 원주/원면적/구표면적/구부피 구하기
44. 예제: 윤년 평년 판별하는 프로그램
45. AWT 상속 방식: 버튼을 클릭하면 창의 배경색이 바뀌는 간단한 이벤트 처리 프로그램(gui)
46. 상속: 상속, super, 생성자 호출 순서
47. 상속: 상속, super()
48. AWT 포함 방식: 45 예제의 Has-a 포함 형태 예제(gui)
49. 상속 + Getter/Setter
50. 상속: 상속에서의 필드, 은닉변수, super 등
51. 상속: 상속의 방향성 (상속에서의 메소드)
52. 메소드 오버라이딩
53. 메소드 오버라이딩 예제2: p341~342
54. 상속: 상속에서의 접근 제한자 : 부모 클래스 & 자식클래스는 package task.java2.t54; 위치
55. 추상클래스: 추상클래스를 활용한 예제 - 상속, 다형성, 다중 상속 불가, 계층적 상속
56. 인터페이스: 상수와 추상메소드만 가질 수 있는 인터페이스, 인터페이스 다중 상속, implements
57. GregorianCalendar: GregorianCalendar 활용하여 44번 예제 풀기(윤년 평년 판별하는 프로그램)
58. 인터페이스 다중 상속: 클래스와 인터페이스 상속 시 순서, extends implements
59. 인터페이스 다중 상속2: 인터페이스 간의 상속과 다중 상속, extends, 인터페이스 메소드 오버라이딩
60. 레퍼런스 형변환: 상속 기반으로 일어나는 업캐스팅(자동형변환) 다운캐스팅(강제형변환)
61. 레퍼런스 형변환2: 예제 + 박싱언박싱. 추상 클래스와 상속, 인터페이스, 자동박싱과 업캐스팅, equals 객체 값 비교, 리스트 데이터 추출과 형변환, 반복문 다운캐스팅과 언박싱
62. Collection - Set: 컬렉션 프레임워크의 set 인터페이스. 중복을 허가하지 않아서 데이터 중복 판별에 쓰는 인터페이스
63. Collection - HashSet: 해시셋 예제 & Iterator 이터레이터 반복자
64. Collection - TreeSet: 트리셋 예제. 데이터를 오픔차순으로 정렬해서 저장하고 출력하는 기능 제공
65. Set 예제(+제네릭 버전): set 자료구조를 사용한 중복방지 오름차순 정렬 로또 프로그램
66. Collection - List, ArrayList: 리스트 인터페이스는 인덱스 번호(입력순) 자료형 저장, 중복저장 가능, 동적으로 크기 조절.
67. Generic 제네릭 <> + ArrayList 예제: 제네릭은 컬렉션 프레임워크에 속하는 거의 모든 인터페이스 & 클래스에서 사용 가능함. 어레이리스트 활용 예제
68. Vector 벡터 클래스: 동기화된 메소드로 구성되어 있어서 스레드에 안전, 하지만 전부 동기화 되어있어서 무거움. 잘 안쓴다. 요즘은 멀티스레드 방식으로 Collections.synchronizedList()나 CopyOnWriteArrayList 씀
69. Collection - Map: HashMap 해시맵 가장 많이 씀, Hashtable 해시테이블 잘 안씀, TreeMap Properties는 트리맵 프로퍼티는 툭수 상황 매핑
70. Hashtable HashMap 예제: 해시테이블과 해시맵을 활용해서 아이디 비밀번호 일치 프로그램 만들기
71. 큐(Queue) 인터페이스: FIFO(First Input First Output) 구조. 먼저 입력된 자료가 먼저 출력되는 구조, offer() 넣고 poll() 뺀다. LinkedList PriorityQueue ArrayBlockingQueue LinkedBlockingQueue
72. 스택(Stack) 클래스: LIFO(Last Input First Output) 구조. 마지막으로 입력된 자료가 가장 먼저 출력되는 구조. 기능 자체는 중요한데 무거워서 잘 안쓰고 요즘은 큐&스택 양방향 ArrayDeque 씀
73. 클래스와 setter메소드 초기화, List: 회원정보를 입력받고 새로운 클래스의 멤버변수에 저장, List 자료구조를 이용해서 출력하기
74. 콘솔로 게시판 만들기 예제: ArrayList, DTO 등 활용
75. 콘솔로 게시판 만들기 예제2: lombok 롬복 활용한 버전 + builder 빌더 패턴 활용
76. 제네릭: 제네릭 관련 예제(연습용)
77. 예외처리 try-catch 구문: try-catch 구문을 활용한 예외처리들 예제
78. 예외처리2 try-catch-catch 구문 (멀티처리): try-catch-catch 구문을 활용한 예외 멀티처리 예제
79. 예외처리3 try-catch-finally 구문: try-catch-finally 구문을 활용한 예외처리 예제
80. 예외처리4 throws: throws 키워드를 활용한 예외 떠넘기기 예제
81. 예외처리5 throw: throw 키워드를 활용한 예외 발생시키기 예제
82. Thread: 스레드 클래스 상속, Runnable 인터페이스 구현, 멀티스레드 등
83. Thread: 스레드 생명주기
84. Thread: 스레드의 우선순위
85. Thread: 스레드 상태 제어
86. Thread: 스레드 동기화 - synchronized 동기화 메소드
87. 입출력스트림: InputStream read InputStreamReader
88. 입출력스트림: BufferedReader 
89. 스레드 예제: 스레드를 이용해서 현재 시간을 1초에 1번씩 출력하는 프로그램
90. 입출력스트림: read() reader() FileReader FileInputStream BufferedReader
91. 입출력스트림: writer() OutputStream() FileInputStream FileOutputStream FileReader FileWriter BufferedWriter
92. 입출력스트림 예제: 기본 타입 입출력 스트림 DataInputStream, DataOutputStream 클래스를 이용, 기본 데이터 타입을 유지 하면서 입.출력을 처리하는 스트림
93. 입출력스트림 File 클래스: 디렉토리 생성이나 파일 & 디렉터리 삭제 기능이 있는 파일 클래스
94. 입출력스트림
95. BufferedReader,FileWriter,InputStreamReader: 키보드로 입력한 문장을 파일 result.txt에 저장하는 프로그램
96. 데이터베이스 연동: JDBC 드라이버, MySQL, Oracle 등 데이터베이스 연동 예제
97. g
107. 중간 시험
108. MVC 게시판 :
109. 

# test
1. 역순출력: 학생들의 점수 배열을 뒤에서부터 하나씩 출력하는 프로그램
2. temp활용: 두 변수 값을 교환하기(파이썬 제외)
3. 입력출력: 키보드로 정수 입력 받아서 a= b= 형태로 출력하기
4. 입력출력 반복: 키보드로 문자열과 정수n 입력 받아서 문자열을 n번 반복 출력하기
5. 문자열 반복 함수: 문자열 my_string을 정수 k번 반복한 문자열을 return 하는 함수 만들기
6. 문자열 비교 함수: 양의 정수를 문자열 변환하여 비교, 더 큰 문자열을 return 하는 함수 만들기
7. 문자열 비교 함수2: 양의 정수와 문자열 변환값을 비교, 더 큰 값을 return 하는 함수 만들기
8. n의 배수: num과 n이 주어질 때, n의 배수 여부를 구하는 함수 만들기
9. 공배수: num이 n과 m의 공배수인지 판단하는 함수 만들기
10. 홀짝 판단과 조건문: 홀짝 판단, 조건문과 반복문을 활용한 함수 만들기
11. ***배타적 논리합 ^ XOR 연산자(+개념)***: 짝 없는 숫자 찾기 & temp 없이 값 swap & 암호화 복호화
12. ***시프트 연산(+개념)***: 코틀린은 shl shr 자바와 파이썬은 >> << Shift 연산 표기법과 예제
13. ***hash & map 해시 매핑(+개념)***: 해시함수 및 서식, 해시와 맵 매핑 설명과 활용 예제
14. 문자열 결합 조건문: switch-case / when / match-case 조건문을 활용해 문자열 결합+수식 TF 판별
15. 배열 & 2차원 배열 예제3: k배수 오름차순 구하기, 조건에 맞는 배열 구하기, 조건에 맞게 배열 이어붙여서 새로운 배열 만들기
16. 배열 & 2차원 배열 예제4:
17. d
18. ㄹ