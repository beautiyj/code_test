-- 트리거: 특정 테이블이 변경되면 이를 이벤트로 다른 테이블이 자동으로 변경되도록 하기 위해서 사용
-- 트리거는 특정 동작을 이벤트로 그로 인해서만 실행되는 프로시저의 일종입니다. 
-- 이벤트 DML SQL문을 이용해서 이벤트 발생시키면 연쇄적으로 실행부 BEGIN 안의 내용을 자동실행시키는 게 트리거.

/*
    CREATE TRIGGER trigger_name 
    timing[BEFORE|AFTER] event[INSERT|UPDATE|DELETE]
    ON table_name
    [FOR EACH ROW]
    [WHEN conditions]
    BEGIN 
    statement
    END

*/

-- 예제 1. 사원 테이블에 새로운 데이터가 들어오면 '신입사원이 입사했습니다.'란 메시지를 출력하는 문장 레벨 트리거 만들기.
--        emp01이라는 사원테이블 미리 만들어두기
DROP TABLE emp01 PURGE;
-- 테이블 복붙하려면 이걸로 CREATE TABLE emp01 AS SELECT * FROM emp;
CREATE TABLE emp01(
    empno       NUMBER(4),
    ename       VARCHAR2(20),
    job         VARCHAR2(20),
    CONSTRAINT pk_emp01_empno PRIMARY KEY (empno)
);

--
--CREATE OR REPLACE TRIGGER trig_01
--    AFTER INSERT ON emp01               -- 이벤트 발생
--BEGIN
--    DBMS_OUTPUT.PUT_LINE('신입사원이 입사했습니다.');
--END;
--/

-- 트리거 목록 확인하기
SELECT * FROM USER_TRIGGERS;

-- 이벤트 발생: EMP01테이블에 회원가입하기(데이터 입력하기)
--SET SERVEROUTPUT ON;
INSERT INTO emp01 VALUES(1111, '홍길동', '개발자');
-- 신입사원이 입사했습니다. 실행됨!  1 행 이(가) 삽입되었습니다. 이건 오라클에서 실행하면 뜨는 거고
INSERT INTO emp01 VALUES(2222, '홍길동', '개발자');
INSERT INTO emp01 VALUES(3333, '홍길동', '개발자');
INSERT INTO emp01 VALUES(4444, '홍길동', '개발자');

-- 이벤트 처리 결과 확인하기
SELECT * FROM emp01;

-- 트리거 삭제하기
DROP TRIGGER trig_01;



-- 예제2. 사원테이블에 신입 사원이 등록되면 급여 테이블에 신입 사원의 급여 정보를 자동으로 생성하는 트리거 작성하기
-- emp01 부모테이블, 그리고 자식테이블인 sal01 생성하기
DROP TABLE emp01 PURGE;
CREATE TABLE emp01(
    empno       NUMBER(4),
    ename       VARCHAR2(20),
    job         VARCHAR2(20),
    CONSTRAINT pk_emp01_empno PRIMARY KEY (empno)
);

CREATE TABLE sal01(
    salno       NUMBER(4),
    sal         NUMBER(7,2),
    empno       NUMBER(4),
    CONSTRAINT pk_sal01_salno PRIMARY KEY (salno),
    CONSTRAINT fk_sal01_empno FOREIGN KEY (empno) REFERENCES emp01(empno)
);

-- 시퀀스 생성
CREATE SEQUENCE sal01_salno_seq;
SELECT * FROM seq;

-- 트리거 생성
-- :new.컬럼명 : INSERT, UPDATE문을 이용해서 이벤트가 발생한 경우에 사용
-- :old.컬럼명 : DELETE문을 이용해서 이벤트가 발생한 경우에 사용

--CREATE OR REPLACE TRIGGER trig_02
--    AFTER INSERT ON emp01           -- 이벤트 발생. emp01 테이블에 INSERT가 일어난 직후에 실행
--    FOR EACH ROW                    -- 행레벨 트리거: 입력되는 '행 하나하나마다' 각각 실행
--BEGIN                               -- sal은 임의로 300으로 정함.       empno는 부모테이블의 사원번호를 구해온다
--    INSERT INTO sal01 VALUES(sal01_salno_seq.NEXTVAL, 300, :new.empno);
--END;
--/

SELECT * FROM USER_TRIGGERS;

--SET SERVEROUTPUT ON;
INSERT INTO emp01 VALUES(1111, '홍길동', '개발자');
INSERT INTO emp01 VALUES(2222, '홍길동', '개발자');
INSERT INTO emp01 VALUES(3333, '홍길동', '개발자');
INSERT INTO emp01 VALUES(4444, '홍길동', '개발자');

-- 이벤트 처리 결과 확인하기
SELECT * FROM emp01 e INNER JOIN sal01 s ON e.empno = s.empno;

-- 트리거 삭제하기
DROP TRIGGER trig_02;

