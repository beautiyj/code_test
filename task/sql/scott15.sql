-- 뷰는 보안/편의성/재사용성을 위해 쓰는 거 (민감컬럼제외하고 출력 등등)
-- VIEW 뷰: 기본 테이블을 이용해서 만든 가상 테이블
-- 뷰 실습을 위한 기본 테이블 dept_copy, emp_copy 생성

CREATE TABLE dept_copy AS SELECT * FROM dept;
CREATE TABLE emp_copy AS SELECT * FROM emp;

SELECT * FROM emp_copy;
SELECT * FROM dept_copy;
DESC dept_copy;
DESC emp_copy;

/* 뷰(VIEW) 생성 기본 서식
    CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW view_name
    [(alias, alias, alias, ...)]
    AS subquery
    [WITH CHECK OPTION]
    [WITH READ ONLY];

    뷰 생성 권한 부여 (SYSTEM 계정으로 접속 필요)
    -- 1. 관리자(SYSTEM) 계정으로 접속. 명령어로 접속할 경우엔
    CONN system/설정한비밀번호;
    
    -- 2. 특정 사용자(scott)에게 뷰 생성 권한 부여
    GRANT CREATE VIEW TO scott;
*/

CREATE VIEW emp_view30
    AS
    SELECT empno, ename, deptno FROM emp_copy WHERE deptno = 30;
/*
    -- 뷰 생성 (OR REPLACE를 붙이면 나중에 수정할 때도 편합니다)
    CREATE OR REPLACE VIEW v_emp30
    AS
    SELECT empno, ename, deptno 
    FROM emp_copy 
    WHERE deptno = 30;
*/

SELECT * FROM emp_view30;
SELECT * FROM emp_copy;
SELECT * FROM user_views;

-- Q. 뷰 emp_view30에 INSERT로 데이터 입력할 경우, 기본 테이블 emp_copy에도 데이터 입력되는지
-- A. 입력된다. DML작업은 뷰에서 해도 테이블에 영향이 감
/*  대신 일부 작업은 영향X
    그룹 함수 사용: SUM, AVG, COUNT 등이 포함된 뷰
    중복 제거: DISTINCT가 들어간 뷰
    표현식: 컬럼에 연산이 들어간 경우 (예: sal * 12)
    그룹화: GROUP BY나 HAVING이 들어간 뷰
    조인(JOIN): 여러 테이블을 합쳐서 만든 뷰 (이 경우 특정 조건 하에서만 제한적으로 가능)
*/

INSERT INTO emp_view30 VALUES(1111,'홍길동',30);



-- =================================================================================

DROP TABLE emp_copy PURGE;
CREATE TABLE emp_copy AS SELECT * FROM emp;

-- 뷰의 종류
-- 단순뷰 : 하나의 기본 테이블로 생성된 뷰
-- 복합뷰 : 여러개의 기본 테이블로 생성된 뷰

-- 1. 단순뷰
-- Q. 기본 테이블 emp_copy를 이용해서 20번 부서에 소속된 사원들의 사번과 이름, 부서번호, 직속상사의 사번을 출력하는 뷰(emp_view20)를 생성

CREATE VIEW emp_view20
    AS
    SELECT empno, ename, deptno, mgr 
    FROM emp_copy 
    WHERE deptno = 20;

-- 뷰 확인
SELECT * FROM tab;
SELECT * FROM user_views;



-- 2. 복합뷰(DML 불가)
-- Q. 각 부서별(부서명) 최대급여와 최소급여를 출력하는 뷰를 sal_view라는 이름으로 생성

CREATE VIEW sal_view
    AS
    SELECT dname, MAX(sal) AS max, MIN(sal) AS min 
    FROM dept, emp
    WHERE dept.deptno = emp.deptno 
    GROUP BY dname;
        
-- 뷰 확인
SELECT * FROM tab;
SELECT * FROM user_views;

-- 뷰 데이터 확인
SELECT * FROM sal_view;



-- 뷰 삭제
-- 형식 : DROP VIEW 뷰이름;
DROP VIEW sal_view;


-- 뷰를 생성할 때 사용하는 옵션
-- 1. or replace 옵션
--    기존에 뷰가 존재하지 않으면 뷰를 생성하고, 만약 동일한 이름을 가진 뷰가 존재할 경우 뷰의 내용을 수정 하도록 만들어 주는 옵션

    -- 1) or replace 옵션없이 동일한 뷰(emp_view30)를 생성 : 에러발생
    CREATE VIEW emp_view30
        AS
        SELECT empno, ename, deptno, sal, comm 
        FROM emp_copy 
        WHERE deptno = 30;
    
    -- 2) or replace 옵션을 붙여서 동일한 뷰(emp_view30)를 생성 : 뷰의 내용이 수정된다.
    CREATE OR REPLACE VIEW emp_view30
        AS
        SELECT empno, ename, deptno, sal, comm 
        FROM emp_copy 
        WHERE deptno = 30;

    -- 3) 뷰 확인
    SELECT * FROM emp_view30;   -- 컬럼추가됨 등 뷰내용수정됨


-- 2. with check option
--    : where 조건절에 사용된 값을 수정하지 못하도록 만들어 주는 옵션(WHERE 조건만 지키면 수정추가등등가능)

    -- 1) with check option을 사용하지 않은 경우
    CREATE OR REPLACE VIEW emp_view30
    AS
    SELECT empno, ename, deptno, sal, comm 
    FROM emp_copy 
    WHERE deptno = 30;

    -- Q. emp_view30 뷰에서 급여가 1200 이상인 사원들의 부서번호를 30번에서 20번으로 수정?
    UPDATE emp_view30 
        SET deptno = 20 
        WHERE sal >= 1200;     --- 데이터가 수정됨
    
    SELECT * FROM emp_view30;
    
    -- 2) with check option을 사용한 경우
    -- 뷰에 insert, update, delete 가 실행되면, 기본 테이블에도 동일한 내용이 적용된다.
    DROP TABLE emp_copy PURGE;
    CREATE TABLE emp_copy AS SELECT * FROM emp;    -- 기본 테이블 생성
    
    -- with check option 옵션 사용해서 뷰생성(이미 존재하면 덮어쓰기되는 리플레이스)
    CREATE OR REPLACE VIEW emp_view30
        AS
        SELECT empno, ename, deptno, sal, comm 
        FROM emp_copy 
        WHERE deptno = 30
        WITH CHECK OPTION;
        
    SELECT * FROM emp_view30;
    
    -- Q. emp_view30 뷰에서 급여가 1200 이상인 사원들의 부서번호를 30번에서 20번으로 수정?
    UPDATE emp_view30 
    SET deptno = 20 
    WHERE sal >= 1200;     --- 에러발생


-- 3. with read only 옵션
--    : 읽기 전용의 뷰를 만들어 주는 옵션
--    : 뷰를 통해서 기본 테이블의 내용을 수정하지 못하도록 만들어 주는 옵션(아예 DML 사용 불가)

CREATE OR REPLACE VIEW view_read30
    AS
    SELECT empno, ename, sal, comm, deptno 
    FROM emp_copy
    WHERE deptno = 30 
    WITH READ ONLY;               -- 읽기 전용의 view 생성
    
SELECT * FROM user_views;    
SELECT * FROM view_read30;    

-- Q. 생성된 뷰(read_view30)를 수정 해보자?
UPDATE view_read30 
SET sal = 3000;      -- 에러 발생
-- with read only 옵션 때문에 수정이 안된다.




