-- JavaTask108 테이블 추가
CREATE TABLE board2 (
    no       NUMBER PRIMARY KEY,
    writer   VARCHAR2(50),
    passwd   VARCHAR2(50),
    subject  VARCHAR2(200),
    content  VARCHAR2(1000),
    register TIMESTAMP
);

CREATE SEQUENCE board2_seq
START WITH 1
INCREMENT BY 1;

SELECT * FROM TAB;
SELECT * FROM dept;
SELECT * FROM emp;

/*
DEPT - 부서 테이블
EMP - 사원 테이블
BONUS - 상여금
SALGRADE - 급여 등급
+ MGR컬럼은 직속상사 넘버링(=EMPNO 사원번호)
*/

-- 테이블 구조 보는 키워드 DESC(DESCRIBE)
DESC dept;
DESC emp;

-- 오라클에서만 숫자 데이터 NUMBER, 그 외는 INT
-- NUMBER(10) = 최대 10자리
-- NUMBER(7,2) = 전체 7자리, 소수점 2자리(ex: 12345.67)

-- 오라클에서만 가변형 문자데이터 VARCHER2, 그 외는 VARCHAR
-- CHAR(10) = 최대 20바이트, 5글자 쓰면 나머지 15는 낭비됨
-- VARCHAR2(10) = 5글자 쓰면 나머지 알아서 처리해줘서 메모리 측면 굿.
-- LONG() = CHAR는 2000바이트, VARCHAR2는 4000바이트, 롱은 2GB까지 가능
-- 롱으로 지정되는 데이터의 경우 검색 기능 지원X 너무 큰 데이터라 검색 불가

-- 날짜데이터는 숫자 형태라서 문자열로 활용하고 싶으면 문자열 변환 필요.
-- DATE는 연/월/일/시/분/초 (보통 연/월/일 까지만)
-- TIMESTAMP는 연/월/일/시/분/초/나노초


