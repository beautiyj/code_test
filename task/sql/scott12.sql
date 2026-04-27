SELECT * FROM emp;
SELECT * FROM dept;
DESC dept;
DESC emp;
SELECT * FROM TAB;
SELECT * FROM dept;

-- 무결성 제약 조건. 낫널 유니크 프라이머리키 포린키 체크
-- 테이블에 부적절한 자료 입력하는 걸 막기 위한 규칙. 테이블 생성 각 컬럼에 대해서 정의하는 규칙이다


-- NOT NULL : 널 비허용
-- 테스트용 테이블 삭제-재생성
SELECT * FROM TAB;
SELECT * FROM dept;
SELECT * FROM emp06;
DESC emp06;
DROP TABLE emp06 PURGE;
CREATE TABLE emp06(
    empno NUMBER(4) NOT NULL,
    ename VARCHAR2(12) NOT NULL,
    job VARCHAR2(12),
    deptno NUMBER(2) );

--                     empno, ename은 NOT NULL 설정되어있어서 NULL 넣으면 오류남
INSERT INTO emp06 VALUES(1111,'홍길동','MANAGER',30);
INSERT INTO emp06(empno, ename, job, deptno) VALUES(2222,'R길동',NULL,NULL);


-- UNIQUE : 중복된 값 비허용. 항상 유일한 값(말그대로 유니크) 널 허용이고 널은 여러 개 들어가도 무방함
-- 제약조건은 테이블 클릭해서 제약조건 보면 나옴(Constraints) 혹은 쿼리로 확인하기.
SELECT constraint_name, constraint_type, search_condition
    FROM user_constraints
    WHERE table_name = 'EMP06';

DESC emp06;
DROP TABLE emp06 PURGE;
CREATE TABLE emp06(
    empno    NUMBER(4) UNIQUE,
    ename    VARCHAR2(12) NOT NULL,
    job      VARCHAR2(12),
    deptno   NUMBER(2) );

--                      유니크값이라 EMPNO만 중복불가 그외는 중복 넣어도 무방
INSERT INTO emp06 VALUES(5959,'R길동',NULL,10);
INSERT INTO emp06 VALUES(1111,'R길동','개발자',20);
INSERT INTO emp06 VALUES(2222,'R길동','개발자',20);




-- PRIMARY KEY : 기본키라고 부르기도. 프라이머리키는 널 비허용, 중복 비허용. 낫널+유니크 개념임
DESC emp06;
DROP TABLE emp06 PURGE;
CREATE TABLE emp06 (
    id      NUMBER,
    empno   NUMBER(4),
    ename   VARCHAR2(12) NOT NULL,
    job     VARCHAR2(12),
    deptno  NUMBER(2),
    
    -- 실제로는 제약 조건들만 따로 모아서 이름 지어주는 형태를 자주 씀(오류나면 정확하게 알려줘서 확인하기 쉬움)
    -- 형식: CONSTRAINT 이름 제약조건종류(컬럼명)
    CONSTRAINT pk_emp06_id    PRIMARY KEY(id),
    CONSTRAINT uk_emp06_empno UNIQUE(empno)
);

SELECT constraint_name, constraint_type, search_condition
    FROM user_constraints
    WHERE table_name = 'EMP06';
    
INSERT INTO emp06 VALUES(1,1111,'R길동','개발자',20);
INSERT INTO emp06 VALUES(2,2222,'R길동','개발자',20);
INSERT INTO emp06 VALUES(55,4444,'R길동','개발자',20);

    


-- FOREIGN KEY  : 왜래키라고 부르기도. 포린키는 참조되는 테이블의 칼럼의 값이 존재하면 허용
-- ㄴ 자식 테이블(포린 키를 가진 쪽)은 부모 테이블(참조되는 쪽)에 없는 데이터는 절대 가져다 쓸 수 없다
-- ㄴ 포린키로 묶으면 데이터 하나라도 있을 경우 삭제 불가. 보통 'fk_(테이블명)_(컬럼명)' 식으로 명시함
/*

    포린키 관계가 성립되면 두 테이블은 부모(참조되는 쪽)와 자식(참조하는 쪽) 관계가 됨
    부모 테이블 (Parent Table): 기준이 되는 정보(예: 부서 목록)를 가지고 있는 테이블.
                              보통 PK(Primary Key)가 있는 쪽이 부모 테이블임
    
    자식 테이블 (Child Table): 부모의 정보를 빌려다 쓰는 테이블(예: 사원 목록).
                             이쪽에 포린키 제약조건을 설정함
                             
                             
    포린키의 3대 철칙 (참조 무결성)
    포린키는 아래 3가지 규칙을 통해 데이터가 꼬이는 것을 원천 봉쇄합니다.
    
    1. 존재하지 않는 부모는 따를 수 없다 (Insert 규칙)
    자식 테이블에 데이터를 넣을 때, 부모 테이블에 없는 값은 절대 입력할 수 없습니다.
    예: 10번, 20번 부서만 있는데 사원을 99번 부서로 발령 낼 수 없음.
    
    2. 자식이 있는 부모는 함부로 떠날 수 없다 (Delete 규칙)
    자식 테이블에서 누군가 참조하고 있는 부모 데이터는 삭제할 수 없습니다.
    예: 10번 부서에 소속된 직원이 한 명이라도 있다면, 10번 부서 자체를 삭제할 수 없음.
    
    3. 부모의 이름(PK)이 바뀌면 자식은 미아가 된다 (Update 규칙)
    참조되고 있는 부모의 PK 값이 바뀌는 것도 기본적으로 금지됩니다. (관계를 유지해야 하기 때문)
    
    포린키 설정 예시
    CREATE TABLE emp07 (
    empno    NUMBER(4) PRIMARY KEY,
    ename    VARCHAR2(12),
    deptno   NUMBER(2), -- 부모의 PK와 데이터 타입이 같아야 함
    
    -- [포린키 설정]
    -- CONSTRAINT 이름 FOREIGN KEY(내 컬럼) REFERENCES 부모테이블(부모PK)
    
    CONSTRAINT fk_emp07_deptno 
        FOREIGN KEY(deptno) 
        REFERENCES dept(deptno)
        -- ON DELETE CASCADE  <-- 필요하면 여기에 옵션 추가
);

    포린키 사용 시 주의사항 (실무 팁)
    데이터 타입 일치: 부모의 PK가 NUMBER면 자식의 FK도 반드시 NUMBER여야 합니다.
                   크기도 맞춰주는 게 정석입니다.
    
    인덱스(Index): 포린키 컬럼에는 보통 인덱스를 따로 생성합니다.
                  조인(JOIN) 성능을 높이고, 데이터 삭제 시 발생하는 잠금(Lock) 문제를 방지하기 위해서입니다.
    
    성능 이슈: 포린키가 너무 많으면 데이터를 넣을 때마다 부모 테이블을 확인해야해서
              시스템 속도가 약간 느려질 수 있습니다.
             그래서 아주 거대한 데이터 시스템에서는 일부러 포린키를 생략하고 소스 코드로 제어하기도 합니다.

*/

-- dept테이블이 부모테이블이고 deptno가 pk이자 부모키 10,20,30,40 설정되어있음
-- emp테이블은 자식테이블이고 deptno가 fk 포린키이자 외래키 10,20,30 설정되어있음
-- emp테이블의 dept컬럼이 포린키 제약조건일 때, 포린키컬럼은 dept부모테이블의 부모키deptno 값만 참조 가능
-- 부모키 조건: 프라이머리키나 유니크 제약조건으로 설정되어있어야 함.
--INSERT INTO emp(empno, deptno) VALUES(1111,50) 이런 건 오류나서 불가능함. 부모키에 50이 없으니까.
/*
    CREATE TABLE emp06 (
        empno   NUMBER(4) PRIMARY KEY,
        ename   VARCHAR2(12) NOT NULL,
        job     VARCHAR2(12),
        deptno  NUMBER(2) REFERENCES dept(deptno) );        -- 이게 포린키 설정 방법
*/
SELECT * FROM emp06;
DESC emp06;
DROP TABLE emp06 PURGE;
CREATE TABLE emp06 (
    empno   NUMBER(4),
    ename   VARCHAR2(12) NOT NULL,
    job     VARCHAR2(12),
    deptno  NUMBER(2),

    CONSTRAINT pk_emp06_empno PRIMARY KEY(empno),
    CONSTRAINT fk_emp06_deptno  FOREIGN KEY(deptno) REFERENCES dept(deptno)
);

SELECT constraint_name, constraint_type, search_condition
    FROM user_constraints
    WHERE table_name = 'EMP06';
    
INSERT INTO emp06 VALUES(1111,'홍길동','개발자',10);
INSERT INTO emp06 VALUES(2222,'홍길동','개발자',20);
INSERT INTO emp06 VALUES(3333,'홍길동','개발자',30);
INSERT INTO emp06 VALUES(4444,'홍길동','개발자',40);-- deptno 50은 불가능함




-- CHECK : 저장 가능한 데이터 값의 범위나 조건을 지정하여 설정한 값만을 허용
-- SAL은 500~5000 사이, 성별체크용 조건을 추가할 경우
CREATE TABLE emp07 (
    empno   NUMBER(4) PRIMARY KEY,
    ename   VARCHAR2(12) NOT NULL,
    sal     NUMBER(7,2) CHECK (sal BETWEEN 500 and 5000),
    gender  VARCHAR2(1) CHECK(gender IN ('M','F')) );

SELECT constraint_name, constraint_type, search_condition
    FROM user_constraints
    WHERE table_name = 'EMP07';

INSERT INTO emp07 VALUES(1111,'홍길동',3000,'F');
INSERT INTO emp07 VALUES(2222,'홍길동',5000,'M');      -- 소문자 f,m 에러 / 급여 범위 외는 불가능, 500과 5000 가능.





-- DEFAULT 디폴트는 제약조건까진 아니지만 세트로 자주 쓰임.
-- 디폴트는 데이터가 없을 때 값을 채워주는(Fill) 역할인데, 규칙 어긋나도 에러가 아니라 데이터 들아가기 때문에 제약조건과 차이 있음
DESC dept02;

DROP TABLE dept02 PURGE;
CREATE TABLE dept02 (
    deptno  NUMBER(2),
    dname   VARCHAR2(14),
    loc     VARCHAR2(13) DEFAULT 'SEOUL',    
    CONSTRAINT pk_dept02_deptno PRIMARY KEY(deptno)
);

INSERT INTO dept02 VALUES(10,'ACCOUNTING','NEW YORK');
INSERT INTO dept02(deptno, dname) VALUES(20,'RESEARCH'); -- 디폴트값은 말그대로 기입되지 않을 경우의 기본값 설정.


SELECT * FROM dept02;
DESC dept02;
