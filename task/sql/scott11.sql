SELECT * FROM emp;
SELECT * FROM dept;
DESC dept;
DESC emp;
SELECT * FROM TAB;
SELECT * FROM dept01;

-- DML 데이터 조작어

-- INSERT 데이터 입력
-- INSERT INTO 테이블(컬럼1, 컬럼2,...) VALUES(데이터1, 데이터2,...)
-- INSERT INTO 테이블 VALUES(데이터1, 데이터2,...)   데이터 수 = 컬럼 수라면 생략 가능
-- INSERT INTO 테이블 SELECT * FROM 다른테이블 WHERE 조건;      서브쿼리로 입력할 경우 values는 같이 못쓴다

INSERT INTO dept01(deptno, dname) VALUES(10, 'ACCOUNTING');

ALTER TABLE dept01 ADD(loc VARCHAR2(13));

INSERT INTO dept01 VALUES(20, 'RESEARCH', 'DALLAS');
INSERT INTO dept01 VALUES(30, '영업부', '서울');
INSERT INTO dept01 SELECT * FROM dept WHERE loc = 'BOSTON';  -- WHERE 조건절이 없으면 dept의 전체 데이터가 그대로 복붙됨


-- NULL값 입력하기
INSERT INTO dept01(deptno, dname) VALUES(40, '개발부');
INSERT INTO dept01 VALUES(50, '기획부', NULL);





-- UPDATE 데이터 수정
-- UPDATE 테이블명 SET 컬럼1 = 수정할 값1, 컬럼2 = 수정할 값2 ,..., WHERE 조건절;
-- UPDATE 테이블명 SET 컬럼1 = 수정할 값1; 만 쓸 경우 컬럼1의 모든 데이터들이 수정할 값1로 전부 바뀌니 조건절 필수.
SELECT * FROM emp03;
DESC emp03;
UPDATE emp03 SET sal = sal * 1.1;   -- 조건절이 없을 경우 전체 급여 10% 인상 
UPDATE emp03 SET sal = sal * 5 WHERE ename = 'FORD';        -- 조건절이 있으면 해당 컬럼의 값만 수정됨
UPDATE emp03 SET sal = sal * 2 WHERE SAL >= 3000;

CREATE TABLE emp06 AS SELECT * FROM emp;
SELECT * FROM emp06;
DESC emp06;
UPDATE emp06 SET hiredate = SYSDATE
    WHERE hiredate BETWEEN '87/01/01' AND '87/12/31';
    
    
UPDATE emp06 SET hiredate = SYSDATE, sal = 50, comm = 4000
    WHERE ename = 'SCOTT';



-- DELETE 데이터 삭제
-- DELETE FROM 테이블명 WHERE 조건절;
-- 마찬가지로 조건절 없으면 전체 데이터 삭제되는데, ROLLBACK; 롤백가능함(롤백=실행취소).
-- 대신 COMMIT; 한 직후라면 롤백 불가! 자동커밋 켜져있는지 확인하고 진행하기
DELETE FROM emp06;
ROLLBACK;

SELECT * FROM emp06;
DELETE FROM emp06 WHERE deptno = 30;





-- 트랜잭션: 논리적인 작업 단위. 트랜잭션은 DML(인서트업뎃딜맅)으로 시작함.
-- 완전한 ALL 혹은 아예 취소하는 NOTHING 방식으로 처리됨(ALL-OR-NOTHING)
-- 데이터의 일관성을 유지하면서 데이터를 안정적으로 복구하기 위해 사용됨

-- TCL: COMMIT SAVEPOINT ROLLBACK 
-- COMMIT : 트랜잭션을 종료(메모리 상에서 실행된 DML SQL문이 데이터베이스에 반영됨) = 저장된다
-- SAVEPOINT : 복구할 시점(저장점)을 지정하는 역할
-- ROLLBACK : 트랜잭션을 취소(메모리 상에서 실행된 DML SQL문 취소). 대신 DDL은 자동 커밋돼서 DML만 취소됨!
--  예) A 테이블 생성 후 2번 업데이트, 롤백누르면 2번 업데이트만 취소됨. A 테이블 생성한 건 취소되지 않는다(= 자동 커밋돼서 롤백 적용 X, 세이브포인트를 A 전에 적어도 덮어쓰기된다)


-- 롤백 예시용 테이블 삭제-재생성
DROP TABLE dept01 PURGE;
CREATE TABLE dept01 AS SELECT * FROM dept;
SELECT * FROM DEPT01;

DELETE FROM dept01;
ROLLBACK;
SELECT * FROM DEPT01;


-- 커밋 예시용
DELETE FROM dept01 WHERE deptno = 20;       -- 여기서 롤백하면 취소됨. 데이터베이스에 아직 완전저장되지 않았고 임시저장 정도?
COMMIT;     -- 커밋하면 롤백해도 deptno = 20 삭제 취소 불가. 계속 DEPTNO = 20은 삭제된 상태임.

-- ++ 자동커밋되는 경우. 오토커밋 켜놔도 자동커밋된다
-- SQL 디벨로퍼는 아니지만, QUIT / EXIT로 SQL*Plus 종료 시 자동 COMMIT 됨 (CON.CLOSE()같은 것도 자동커밋됨)
-- DDL(CREATE, ALTER, DROP, TRUNCATE) DCL(GRANT, REVOKE) 실행되면 자동 커밋됨
-- 그리고 자동커밋이든 커밋이든 하고 나면 롤백 불가함


-- 물론 DBA관리자 계정으로는 Flashback, RMAN 백업복구 등으로 가능함. Flashback 기능 활성화 & UNDO 데이터 보존 기간 내에서만 복구 가능

/*
    -- DBA 계정에서
    SELECT table_name, owner
    FROM dba_tables
    WHERE owner = 'SCOTT';  -- SCOTT 계정 테이블 전부 조회 가능
    
    -- SCOTT 계정에서
    SELECT * FROM user_tables;  -- SCOTT 꺼만 보임
    
    -- DBA 계정에서
    SELECT * FROM dba_tables;   -- 전체 계정 다 보임
    
    -- DBA 계정에서 SCOTT 테이블 직접 조회
    SELECT * FROM scott.emp;
    --            ↑ 계정명.테이블명

    
    -- 관리자 계정에서 복구 가능한 기능은 오라클 플래시백 Oracle Flashback 기능!
    FLASHBACK TABLE emp TO TIMESTAMP (SYSTIMESTAMP - INTERVAL '10' MINUTE);
    -- 10분 전으로 복구 가능함
    
    -- 또는
    FLASHBACK DATABASE TO SCN 123456;
    -- 특정 시점으로 DB 전체 복구도 가능함. 123456은 예시인데 깃허브의 커밋해시처럼 오라클의 SCN 번호임.
    -- 현재 SCN 번호 확인 방법은
    SELECT CURRENT_SCN FROM v$database;
    -- 혹은 시간대로 체크할 경우 - 특정 시점의 SCN 확인
    SELECT TIMESTAMP_TO_SCN(SYSDATE - 1/24) FROM dual;
    --                      ↑ 1시간 전 SCN 번호
    -- 혹은 오라클이 자동으로 저장해주는 트랜잭션 로그에서 확인
    SELECT SCN, TIMESTAMP 
    FROM flashback_transaction_query
    WHERE table_name = 'EMP';
    
    보통은 큰 작업 전에 미리 SELECT CURRENT_SCN FROM v$database; 찾아두고 자동화스크립트ㄱㄱ하는 편.
*/


-- 세이브포인트 예제
/*
    40번 부서 삭제
                    커밋
    30번 부서 삭제
                    세이브포인트 c1 설정
    20번 부서 삭제
                    세이브포인트 c2 설정
    10번 부서 삭제
*/

-- 세이브포인트 연습용 테이블 삭제-재생성
DROP TABLE dept01 PURGE;
CREATE TABLE dept01 AS SELECT * FROM dept;
SELECT * FROM DEPT01;

DELETE FROM dept01 WHERE deptno = 40;   -- 40번 부서 삭제
COMMIT;                                 -- 커밋. 롤백해도 40번 부서 복구 불가

DELETE FROM dept01 WHERE deptno = 30;   -- 30번 부서 삭제
SAVEPOINT C1;                           -- ROLLBACK TO C1 하면 30번 복구 불가
                                        -- 그냥 ROLLBACK하면 복구 가능
                                        
DELETE FROM dept01 WHERE deptno = 20;   -- 20번 부서 삭제
                                        -- ROLLBACK TO C1하면 20번 복구 가능, 3040 불가
SAVEPOINT C2;                           -- ROLLBACK TO C2하면 20번 복구 불가

DELETE FROM dept01 WHERE deptno = 10;   -- 10번 부서 삭제
                                        -- ROLLBACK TO C2하면 10번 복구 가능, 203040 불가
                                        
                                        -- 중간에 롤백이 아니라 가장 마지막에 롤백 투 세이브포인트해도 결과는 동일함
                                        
-- 세이브포인트 연습용 테이블 삭제-재생성
DROP TABLE dept01 PURGE;
CREATE TABLE dept01 AS SELECT * FROM dept;
SELECT * FROM DEPT01;

DELETE FROM dept01 WHERE deptno = 40;   -- 40번 부서 삭제
COMMIT;                                 -- 커밋. 롤백해도 40번 부서 복구 불가

DELETE FROM dept01 WHERE deptno = 30;   -- 30번 부서 삭제
SAVEPOINT C1;                           -- ROLLBACK TO C1 하면 30번 복구 불가
                                        -- 그냥 ROLLBACK하면 복구 가능
                                        
DELETE FROM dept01 WHERE deptno = 20;   -- 20번 부서 삭제
                                        -- ROLLBACK TO C1하면 20번 복구 가능, 3040 불가
SAVEPOINT C2;                           -- ROLLBACK TO C2하면 20번 복구 불가

DELETE FROM dept01 WHERE deptno = 10;   -- 10번 부서 삭제
                                        -- ROLLBACK TO C2하면 10번 복구 가능, 203040 불가
                                        
        -- 중간에 롤백이 아니라 가장 마지막에 롤백 투 세이브포인트해도 결과는 동일함
        -- ROLLBACK TO C1하면 C1 이후 전부 복구 = 20번, 10번 복구 가능, 30번 40번 불가
        -- ROLLBACK TO C2하면 C2 이후 전부 복구 = 10번만 복구 가능, 20번 30번 40번 불가
        -- 그냥 ROLLBACK하면 C1, C2 전부 무시하고 COMMIT 시점으로! 세이브포인트는 무시된다. 102030 전부 복구, 40불가
        /*
        
        COMMIT      = 본 세이브
        SAVEPOINT   = 임시 퀵세이브
        ROLLBACK TO = 퀵세이브 불러오기
        ROLLBACK    = 본 세이브 불러오기 (퀵세이브 무시!)
        */
        
        
SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM TAB;
