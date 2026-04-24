SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM TAB;
SELECT * FROM USER_TABLES;  -- 시스템 테이블. 자세한 테이블 정보 제공
DESC dept;
DESC emp;
--DROP TABLE 테이블명 PURGE;  -- 테이블 완전삭제용 코드


-- DDL 데이터 정의어
-- CREATE 테이블 생성
-- ALTER 테이블 구조 변경
-- RENAME 테이블 이름 변경
-- DROP 테이블 삭제 (테이블 자체 삭제, 복구 가능, 롤백 불가)
-- TRUNCATE 테이블 삭제(데이터만 삭제 (구조는 남음), 복구불가, 롤백 불가, 잘 안씀)

-- CREATE TABLE 테이블명 (컬럼1, 데이터타입, 컬럼2, 데이터타입, ... )
CREATE TABLE emp01( empno NUMBER(4)     -- 최대 38자리까지 가능, 숫자 기입 안하면 기본 40자리
                  , ename VARCHAR2(20) 
                  , sal NUMBER(7,2) );  -- 7 전체 길이, d 소수점 이하 자릿수. 소수점은 자릿수 포함x

CREATE TABLE emp02 AS SELECT * FROM emp;    -- 복사본 테이블 생성 
DESC emp;
DESC emp01; -- 위에서 생성한 대로 컬럼 들어가있음
DESC emp02; -- 복사본이라서 emp와 구조 동일(데이터도 복붙됨)

-- 특정 컬럼 복사본 테이블
CREATE TABLE emp03 AS SELECT empno, ename, sal FROM emp;
DESC emp03; -- emp의 특정 컬럼만 복사한 테이블

-- 특정 데이터행으로 구성된 복사본 테이블
CREATE TABLE emp04 AS SELECT * FROM emp WHERE deptno = 10;
DESC emp04; -- emp의 특정 컬럼만 복사한 테이블
SELECT * FROM emp04;    -- 부서 10 데이터들만 들어감

-- 테이블 구조 복사하기
CREATE TABLE emp05 AS SELECT * FROM emp WHERE 1 = 0;
DESC emp05;     -- 구조는 그대로
SELECT * FROM emp05;    -- 데이터는 없음




-- ALTER는 컬럼 추가 수정 삭제 담당
ALTER TABLE emp01 ADD(job VARCHAR2(10));    -- 컬럼 추가
DESC emp01;

ALTER TABLE emp01 MODIFY(job VARCHAR2(30)); -- 컬럼 수정
DESC emp01;                 -- 대신 안에 데이터가 있는 경우 타입/크기줄이기 수정 불가

ALTER TABLE emp01 DROP(job);                -- 컬럼 삭제
DESC emp01;



-- RENAME은 테이블 이름 변경
-- RENAME 기존 테이블명 TO 새로운 테이블명;
RENAME emp01 TO testtable;
SELECT * FROM TAB;


-- TRUNCATE 테이블의 모든 데이터 삭제 + 복구 불가
-- TRUNCATE TABLE 테이블명;
TRUNCATE TABLE emp02;
SELECT * FROM emp02;    -- 구조는 남음, 데이터만 삭제됨. 즉각적으로 삭제돼서 없어짐


-- DROP 테이블 자체 삭제지만 복구는 가능. 휴지통으로 가서 복구 가능하긴 함
-- DROP TABLE 테이블명 PURGE; 완전삭제, DROP TABLE 테이블명; 만 하면 임시테이블로 교체됨.(오라클10G부터)
DROP TABLE testtable;       -- BIN$MKGstzUrRgmgZrZj56vYAg==$0 같은 임시테이블이 존재함
PURGE RECYCLEBIN;           -- 임시테이블 삭제하기
DROP TABLE testtable PURGE;
SELECT * FROM TAB;
SELECT * FROM testtable;


-- 좌측 접속 창에서 테이블 생성, 컬럼 설정, 테이블 삭제도 가능
-- 테이블 삭제 시 계단식 제약 조건은 테이블 참조하는 외래키(FK) 제약조건도 같이 삭제한다는 거
-- 비우기 체크하면 휴지통X 바로 삭제됨