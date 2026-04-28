-- 시퀀스(Sequence): 자동 번호표 기계. 게시판 글 번호처럼 순차적으로 증가하는 번호를 자동으로 만들어주는 객체

-- MAXVALUE / NOMAXVALUE: 번호가 어디까지 올라갈지 정합니다.
--     MAXVALUE 시퀀스가 가질 수 있는 최대값
--     NOMAXVALUE 지정 시, 오름차순 정렬에선 10의27승 내림차순 정렬에선 -1로 설정


-- MINVALUE / NOMINVALUE: 번호의 시작 최솟값을 정합니다.
--     MINVALUE 시퀀스가 가질수 있는 최소값
--     NOMINVALUE하게 지정 시, 오름차순 정렬에선 1 내림차순 정렬에선 10의26승로 설정


-- CYCLE / NOCYCLE: 최대값에 도달했을 때 다시 처음으로 돌아가서 번호를 매길지 결정합니다.
--     CYCLE 지정된 시퀀스(번호)가 끝(MAXVALUE)까지 가면
--           다시 처음(START WITH)으로 돌아가서 1번부터 다시 시작(=무한루프)
--     NOCYCLE 지정된 시퀀스(번호)를 끝까지 다 써버리면, 더 이상 번호를 만들지 않고 에러(=선착순 한정판매)



-- CACHE / NOCACHE: 번호를 미리 메모리에 뽑아두고 대기할지 정합니다. 기본값은 20개입니다.
--     CACHE (번호표 미리 뽑아두기) 맛집 대기 줄이 엄청 길어서, 직원이 미리 번호표 20장을 출력해서 손에 들고 있는 상태입니다.
--         장점: 손님이 올 때마다 기계를 돌릴 필요 없이 손에 든 걸 바로 주면 되니까 속도가 아주 빠릅니다.
--         단점: 만약 정전이 되면? 직원이 들고 있던 번호표 20장 소멸. 정전 후 기계는 다음 번호인 21번부터 뽑고 중간에 번호 구멍(공백)이 생길 수 있습니다.
--     NOCACHE (그때그때 뽑기) 손님이 올 때마다 기계 버튼을 꾹 눌러서 한 장씩 새로 뽑는 상태입니다.
--         장점: 정전이 되든 말든, 마지막으로 나간 번호가 기계에 딱 기록되어 있어서 번호가 중간에 빌 일이 없습니다. 정확함이 생명인 곳에 씁니다.
--         단점: 매번 기계를 작동시켜야 하니 사람이 몰리면 속도가 조금 느려질 수 있습니다.



-- 시퀀스 생성
CREATE SEQUENCE deptno_deptno_seq
START WITH 10           -- 시작할 번호값
INCREMENT BY 10;        -- 증가치

-- 시퀀스 목록
SELECT * FROM seq;
SELECT * FROM user_sequences;

/*
        시퀀스는 은행의 '번호표 기계'와 똑같습니다.
        CREATE SEQUENCE: 번호표 기계를 갓 설치했습니다. (기계는 꺼져 있고, 화면은 비어있습니다.)
        CURRVAL (현재값): 기계 화면에 떠 있는 번호를 읽으라는 뜻입니다.
                         기계를 설치하고 아직 아무도 번호표를 뽑지 않았다면 화면에 숫자가 아무것도 안 떠 있겠죠?(=먼저 쓰면 에러)
        NEXTVAL (다음값): 버튼을 눌러서 첫 번째 번호표를 뽑는 동작입니다.
                         이때 기계가 비로소 윙~ 소리를 내며 작동을 시작하고 화면에 '10'이라는 숫자를 띄웁니다.
*/

-- CURRVAL는 시퀀스의 현재값을 반환. 넥스트 사용 후에 써야 에러가 나지 않는다
-- NEXTVAL는 시퀀스의 다음값을 반환.
SELECT deptno_deptno_seq.NEXTVAL FROM DUAL; -- 누를 때마다 10씩 증가됨. 시퀀스 규칙으로 10부터 시작해서 10씩 증가하도록 했으니까
SELECT deptno_deptno_seq.CURRVAL FROM DUAL; -- 위를 누른 뒤 가장 최종값(=현재값) 알려줌


DROP TABLE emp01 PURGE;
CREATE TABLE emp01 (
    empno    NUMBER(4),
    ename    VARCHAR2(10),
    hiredate DATE,
    CONSTRAINT pk_empno PRIMARY KEY(empno)
);
-- 시퀀스 생성
CREATE SEQUENCE emp01_empno_seq;
SELECT * FROM TAB;
SELECT * FROM seq;
INSERT INTO emp01 VALUES(emp01_empno_seq.NEXTVAL, '홍길동', SYSDATE);
SELECT * FROM emp01;        -- empno 시퀀스 생성됨



-- 테이블생성부터 시퀀스생성, 데이터 삽입 쭉 이어서 순서
CREATE TABLE dept_example (
    deptno    NUMBER(2),
    dname     VARCHAR2(15),
    loc       VARCHAR2(15),
    CONSTRAINT pk_deptno PRIMARY KEY(deptno)
);
CREATE SEQUENCE dept_example_seq
START WITH 10
INCREMENT BY 10;

SELECT * FROM TAB;
SELECT * FROM seq;

INSERT INTO dept_example VALUES(dept_example_seq.NEXTVAL, '인사과', '서울');
INSERT INTO dept_example VALUES(dept_example_seq.NEXTVAL, '경리과', '서울');
INSERT INTO dept_example VALUES(dept_example_seq.NEXTVAL, '총무과', '대전');
INSERT INTO dept_example VALUES(dept_example_seq.NEXTVAL, '기술팀', '인천');
SELECT * FROM dept_example;


-- 시퀀스 삭제는 시퀀스 이름만 알면 삭제 가능
SELECT * FROM seq;
DROP SEQUENCE dept_example_seq



-- 시퀀스 수정하려면 ALTER SEQUENCE 문 활용 필요
/*
    ALTER SEQUENCE sequence_name 
    [INCREMENT BY n] 
    [{MAXVALUE n | NOMAXVALUE}] 
    [{MINVALUE n | NOMINVALUE}] 
    [{CYCLE | NOCYCLE}] 
    [{CACHE n | NOCACHE}] 
*/

-- 테이블생성부터 시퀀스생성, 데이터 삽입 쭉 이어서 순서
-- 예제 수정을 위해 시퀀스 삭제 후 재생성
DROP SEQUENCE dept_deptno_seq;
CREATE SEQUENCE dept_deptno_seq
START WITH 10
INCREMENT BY 10
MAXVALUE 30;        -- 최대값

SELECT * FROM TAB;
SELECT * FROM seq;

SELECT dept_deptno_seq.NEXTVAL FROM DUAL;   -- 10
SELECT dept_deptno_seq.NEXTVAL FROM DUAL;   -- 20
SELECT dept_deptno_seq.NEXTVAL FROM DUAL;   -- 30
SELECT dept_deptno_seq.NEXTVAL FROM DUAL;   -- 최대값 30까지만 지정해둬서 여기부턴 에러남


-- 시퀀스 MAXVALUE 속성을 30 -> 100000으로 수정하기
ALTER SEQUENCE dept_deptno_seq MAXVALUE 100000;
SELECT dept_deptno_seq.NEXTVAL FROM DUAL;   -- 수정된 거 확인 가능
SELECT dept_deptno_seq.CURRVAL FROM DUAL;