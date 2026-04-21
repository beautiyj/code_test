DESC dept;
DESC emp;

SELECT * FROM emp ORDER BY sal ASC;

-- 대소문자 구분은 없지만 관례상 키워드, 명령어는 대문자/컬럼, 테이블명 소문자.
SELECT * FROM TAB;
--      원하는 컬럼명            테이블
SELECT loc, dname, deptno FROM dept;
SELECT * FROM emp;
SELECT empno, ename, sal FROM emp;


-- 연산
SELECT sal + comm FROM emp;
SELECT sal - 100 FROM emp;
-- ++ null 있을 경우 null데이터에 값을 준 뒤 연산해야함.
-- 오라클에서는 NVL(CAL,N1)와 COALESCE (C1,C2,C3..,N1) 두가지 가능함.
-- NVL은 인자 2개만 가능, COALESCE는 인자 여러 개 가능하고 모든 DB 공통 사용 가능
SELECT NVL(comm, 0) FROM emp;   --  null 데이터에 0을 일괄적으로 대입하는 경우
/*
보통 테이블 설정부터 널처리하는 편.
ALTER TABLE emp MODIFY comm DEFAULT 0;  -- null이면 0 기본 대입
ALTER TABLE emp MODIFY comm NOT NULL;   -- 처음부터 null 허용하지 않음
*/


-- 연봉 구하기
SELECT ename, job, sal, NVL(comm,0), sal * 12 + NVL(comm,0) FROM emp;


-- 별칭(alias) 지정하기. 관례 상 별칭에 "" 쌍따옴표는 잘 쓰지 않음(생략가능하니까)
SELECT sal * 12 + NVL(comm, 0) AS 연봉 FROM emp;  -- AS 사용
SELECT sal * 12 + NVL(comm, 0) 연봉 FROM emp;     -- AS 생략도 가능
SELECT sal * 12 + NVL(comm, 0) "연봉" FROM emp;   -- "" 생략도 가능


-- Concatenation 연산자 ||
SELECT ename, ' is a ', job FROM emp;       -- 이건 컬럼이 나뉜 상태 그대로 출력
SELECT ename ||' is a '|| job FROM emp;     -- 문자열까지 연결돼서 한 컬럼처럼 처리


-- DISTINCT 키워드
SELECT DISTINCT deptno FROM emp;        -- 중복된 행을 제외한 데이터 하나씩 출력
SELECT DISTINCT job FROM emp;
SELECT COUNT(DISTINCT job) FROM emp;    -- 카운트에서도 중복 제거 카운트 가능
SELECT COUNT(comm) FROM emp;            -- 널 제외 데이터만 카운트


-- SQL에서 값이 다르다라는 연산자는 != (가장많이씀) <> (많이씀, 표준) ^=(오라클전용, 잘안씀)
-- WHERE 조건절 & 비교 연산자
SELECT ename, sal FROM emp WHERE sal >= 3000;
SELECT ename, sal FROM emp WHERE sal < 3000;
SELECT ename, sal FROM emp WHERE sal != 3000;
SELECT ename, sal FROM emp WHERE sal = 3000;

SELECT empno, ename, sal FROM emp WHERE sal <=1500;
SELECT ename, job FROM emp WHERE job = 'CLERK';
SELECT ename, job FROM emp WHERE ename = 'FORD';    -- 문자열 데이터는 대소문자 구분 필수!

SELECT ename, hiredate FROM emp WHERE hiredate = '81/12/03';
SELECT ename, hiredate FROM emp WHERE hiredate = TO_DATE('1981-12-03', 'YYYY-MM-DD');   -- 명시적 추천 방식!
SELECT ename, hiredate FROM emp WHERE hiredate BETWEEN '81/01/01' AND '81/12/31';   -- 범위 조회
SELECT * FROM emp WHERE hiredate >= '1982/01/01' ORDER BY hiredate ASC;


-- 논리 연산자 AND OR NOT
SELECT * FROM emp WHERE deptno = 10 AND job = 'MANAGER';
SELECT * FROM emp WHERE deptno = 10 OR job = 'MANAGER';

SELECT * FROM emp WHERE job NOT IN ('MANAGER', 'CLERK');    -- 같은 컬럼이면 NOT IN으로 활용 가능
SELECT * FROM emp WHERE NOT (deptno = 10 OR job = 'MANAGER');

SELECT * FROM emp WHERE sal >=2000 AND sal <=3000;
SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;      -- BETWEEN은 AND 연산자와 세트. 작은값 큰값 순서 지켜서 적어야 적용된다

SELECT * FROM emp WHERE comm = 300 OR comm = 500 OR comm = 1400;
SELECT * FROM emp WHERE comm IN (300,500,1400);     -- IN 연산자는 OR 연산자같은 거고 같은 컬럼만 가능

SELECT * FROM emp WHERE comm NOT IN (300,500,1400);
SELECT * FROM emp WHERE NVL(COMM,0) NOT IN (300,500,1400);
SELECT * FROM emp WHERE comm != 300 AND comm != 500 AND comm != 1400;

SELECT * FROM emp WHERE sal < 2000 OR sal > 3000;
SELECT * FROM emp WHERE hiredate BETWEEN '87/01/01' AND '87/12/31';

SELECT * FROM emp WHERE empno = 7521 OR empno = 7844;
SELECT * FROM emp WHERE empno IN(7521,7844);
