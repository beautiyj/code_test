-- 커서 CURSOR : 2개 이상의 데이터를 처리할 때 사용
-- 명시적으로 CURSOR를 선언하기 위해 CURSOR문장을 사용함.
/*
    CURSOR cursor_name IS
    select_statement;
    여기서 cursor_name는 PL/SQL 식별자
    select_statement는 INTO절이 없는 SELECT 문장
    

    DECLARE
    -- 커서 선언
    CURSOR cursor_name IS statement;
    BEGIN
    -- 커서 열기
    OPEN cursor_name;
    --커서로부터 데이터를 읽어와 변수에 저장
    FECTCH cur_name INTO variable_name;
    --커서 닫기
    CLOSE cursor_name;
    END;

*/

-- 1. 부서 테이블의 모든 데이터 출력하기(커서+프로시저생성. cursor_sample01.sql 파일로도 별도 생성해둠)
--SET SERVEROUTPUT ON;
--
--CREATE OR REPLACE PROCEDURE cursor_sample01
--IS
--    v_dept      dept%rowtype;
--    CURSOR c1           -- 커서 선언
--    IS
--    SELECT * FROM dept;
--BEGIN
--    DBMS_OUTPUT.PUT_LINE('부서번호   /   부서명   /   지역명');
--    DBMS_OUTPUT.PUT_LINE('-------------------------------');
--    
--    OPEN c1;             -- 커서 열기(첫번째 데이터 가져오기)
--    
--    LOOP
--        FETCH c1 INTO v_dept.deptno, v_dept.dname, v_dept.loc;    -- 인출
--        EXIT WHEN c1%notfound;          -- 커서가 더이상 가져올 데이터 없을 경우 루프 탈출
--        DBMS_OUTPUT.PUT_LINE(v_dept.deptno || '/' || v_dept.dname || '/' || v_dept.loc);
--    END LOOP;
--    
--    CLOSE c1;            -- 커서 닫기
--END;
--/

SELECT * FROM USER_SOURCE;

EXECUTE cursor_sample01;




-- ========================================================================================================

-- 2. 부서 테이블의 모든 데이터 출력하기 (CURSOR와 FOR LOOP 커서&포루프문 사용하는 버전)

/*
    CURSOR FOR LOOP는 명시적 CURSOR에서 행을 처리함.
    LOOP에서 각 반복마다 CURSOR를 열고 행을 인출(FETCH)하고
    모든 행이 처리되면 자동으로 CURSOR가 CLOSE되므로 사용하기가 편리합니다. (트라이위드리소스 구문같은)
    OPEN ~ FETCH ~ CLOSE가 없이 FOR ~ LOOP ~ END LOOP문을 사용하여 보다 간단하게 커서를 처리하는 형식

    FOR record_name IN cursor_name LOOP
    statement1;
    statement2;
    . . . . . .
    END LOOP

*/

--create or replace PROCEDURE cursor_sample02
--IS
--    v_dept      dept%rowtype;       -- 로컬변수
--    CURSOR c2                       -- 포루프문에서도 커서 선언까지는 동일함
--    IS
--    SELECT * FROM dept;
--BEGIN
--    DBMS_OUTPUT.PUT_LINE('부서번호   /   부서명   /   지역명');
--    DBMS_OUTPUT.PUT_LINE('-------------------------------');
--
--    FOR v_dept IN c2 LOOP                       -- 포루프문 사용하면 fetch 필요없고 커서 열고 닫는 것도 알아서 해줌!
--        EXIT WHEN c2%notfound;
--        DBMS_OUTPUT.PUT_LINE(v_dept.deptno || '/' || v_dept.dname || '/' || v_dept.loc);
--    END LOOP;
--
--END;
--/

SELECT * FROM USER_SOURCE;

EXECUTE cursor_sample02;


-- ========================================================================================================

-- 예제 3. 사원 테이블에서 부서번호 전달하여 해당 부서에 소속된 사원 정보를 출력하는 프로시저+커서

--CREATE OR REPLACE PROCEDURE into_emp(
--    v_deptno IN emp.deptno%type)
--IS
--    v_emp   emp%rowtype;     -- 로컬변수
--    
--    CURSOR c3               -- 커서 선언
--    IS
--    SELECT *
--    FROM emp
--    WHERE deptno = v_deptno;
--    
--BEGIN
--    DBMS_OUTPUT.PUT_LINE('부서번호   /   부서명   /   사원번호   /   사원명   /   직급   /   급여');
--    DBMS_OUTPUT.PUT_LINE('------------------------------------');
--    
--    FOR v_emp IN c3 LOOP
--        EXIT WHEN c3%notfound;
--        DBMS_OUTPUT.PUT_LINE(
--               v_emp.deptno || '/' || 
--               v_emp.ename  || '/' || 
--               v_emp.empno  || '/' || 
--               v_emp.ename  || '/' || 
--               v_emp.job    || '/' || 
--               v_emp.sal
--        );    
--    END LOOP;
--END;
--/
--

SELECT * FROM USER_SOURCE;

EXECUTE into_emp(10);
EXECUTE into_emp(20);
EXECUTE into_emp(30);
EXECUTE into_emp(40);




-- ========================================================================================================

