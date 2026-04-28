-- 인덱스(index) : 빠르게 검색을 하기 위해서 사용되는 객체

-- 인덱스 생성하기
/*  CREATE INDEX index_name
    ON table_name (column_name); */



-- 인덱스 목록 확인
SELECT * FROM user_indexes;
-- 기본키(primary key)와 UNIQUE 유니크로 설정된 컬럼은 자동으로 고유 인덱스로 설정된다.

-- [실습]
-- 인덱스 실습 : 인덱스 사용 유.무에 따른 검색 속도 비교

-- 1. 테이블 생성
DROP TABLE emp01 PURGE;
-- 복사본 테이블 생성 : 제약조건은 복사 되지 않는다.
CREATE TABLE emp01 AS SELECT * FROM emp;
SELECT * FROM emp01;

-- 2. emp01 테이블에 데이터 입력 : 5800만건 데이터 입력됨
INSERT INTO emp01 SELECT * FROM emp01;

-- 3. 검색용 데이터 입력
INSERT INTO emp01(empno, ename) VALUES(1111, 'ahn');

-- 4. 검색시간 측정 타이머 온으로 설정
SET TIMING ON

-- 5. 검색용 데이터로 검색시간을 측정 : 인덱스가 설정되지 않은 경우
SELECT * FROM emp01 WHERE ename = 'ahn';      -- 4.102초 소요

-- 6. 인덱스 생성 : emp01테이블의 ename 컬럼에 인덱스를 적용
CREATE INDEX idx_emp01_ename ON emp01(ename);

-- 7. 인덱스 목록 확인
SELECT * FROM user_indexes;

-- 8. 검색용 데이터로 검색시간을 측정 : 인덱스가 설정된 경우
SELECT * FROM emp01 WHERE ename = 'ahn';     -- 0.012 초 소요





-- 인덱스 삭제
-- 형식 : DROP INDEX index_name;
DROP INDEX idx_emp01_ename;




-- 인덱스 종류(고유/비고유/단일/결합/함수기반)
-- 고유 인덱스 : 중복된 데이터가 없는 컬럼에 적용할 수 있는 인덱스
-- 비고유 인덱스 : 중복된 데이터가 있는 컬럼에 적용할 수 있는 인덱스


-- 1. 테이블 생성
DROP TABLE dept01 PURGE;

-- 테이블 구조만 복사
CREATE TABLE dept01 AS SELECT * FROM dept WHERE 1=0;

-- 2. 데이터 입력 : loc 컬럼은 중복된 데이터가 입력
SELECT * FROM dept01;
INSERT INTO dept01 VALUES(10, '인사과', '서울');
INSERT INTO dept01 VALUES(20, '총무과', '대전');
INSERT INTO dept01 VALUES(30, '교육팀', '대전');



-- 3. 고유 인덱스 : deptno 컬럼에 고유 인덱스를 적용
CREATE UNIQUE INDEX idx_dept01_deptno ON dept01(deptno);

-- 4. 인덱스 목록 확인
SELECT * FROM user_indexes;
-- 고유 인덱스로 설정된 deptno 컬럼에 중복 데이터를 입력 해보자?
-- deptno 컬럼은 고유 인덱스가 설정된 이후에 중복된 데이터를 입력할 수 없다.
INSERT INTO dept01 VALUES(30, '교육팀', '대전');        -- 에러발생



-- 5. 비고유 인덱스
--    loc 컬럼에 고유, 비고유 인덱스를 적용 해보자?

-- loc 컬럼에 고유 인덱스 적용
-- : loc 컬럼은 중복된 데이터가 있기 때문에 고유 인덱스를 만들 수 없다.
CREATE UNIQUE INDEX idx_dept01_loc ON dept01(loc);        -- 에러발생

-- loc 컬럼에 비고유 인덱스 적용
CREATE INDEX idx_dept01_loc ON dept01(loc);      -- 비고유 인덱스 생성됨
SELECT * FROM user_indexes;




-- 6. 결합 인덱스 : 2개 이상의 컬럼으로 만들어진 인덱스
CREATE INDEX idx_dept01_com ON dept01(deptno, dname);



-- 7. 함수 기반 인덱스 : 수식이나 함수를 적용하여 만든 인덱스
CREATE INDEX idx_emp01_annsal ON emp(sal * 12 + NVL(comm, 0));
SELECT * FROM user_indexes;
