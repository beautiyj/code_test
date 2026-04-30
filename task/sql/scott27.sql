-- 저장 함수 생성 : 저장 함수는 저장 프로시저와 거의 유사한 용도로 사용함
--               차이점이라곤 함수는 실행 결과를 되돌려 받을 수 있다는 점(실행 결과를 돌려주는 기능 내장되어있음)

-- 근데 저장함수보단 저장 프로시저를 더 많이 씀

/* 저장함수 서식
    CREATE [OR REPLACE ] FUNCTION function_name 
    ( argument1 [mode] data_taye, 
      argument2 [mode] data_taye . . .
    )
    IS 
    RETURN data_type;
    BEGIN
    statement1;
    statement2;
    RETURN variable_name;
    END;

*/

-- 프로시저를 만들 때에는 PROCEDURE라고 기술하지만, 함수를 만들 때에는 FUNCTION이라고 기술합니다. 
-- 함수는 결과를 되돌려 받기 위해서 필요한 부분: 함수가 되돌려 받게 되는 자료형과 되돌려 받을 값 꼭 적어야함. 
-- 저장 함수는 호출 방식에 있어서도 저장 프로서저와 차이점이 존재. 
-- EXECUTE :varable_name := function_name(argument_list);


-- 예제1. 사원 테이블에서 특정 사원의 급여를 200% 인상한 결과를 돌려주는 저장함수 만들기
CREATE OR REPLACE FUNCTION cal_bonus(
    v_empno IN emp.empno%type
    )
RETURN NUMBER        -- 돌려줄 값의 자료형
IS
    v_sal NUMBER(7,2);    -- 로컬 변수
BEGIN
    SELECT sal
    INTO v_sal
    FROM emp
    WHERE empno = v_empno;
    
    RETURN v_sal * 2;       -- 200% 되도록. 만약 더하기 수치면 인상분이 200%니까 * 3
END;
/

-- 내장함수도 프로시저처럼 코드 조회 가능
SELECT * FROM USER_SOURCE;

SELECT * FROM emp;

-- 바인드 변수 생성
VARIABLE var_res NUMBER;

-- 저장함수 실행
EXECUTE :var_res := cal_bonus(7788);

-- 결과물 출력하기
PRINT var_res;

-- 에러 확인용
SELECT line, position, text 
FROM USER_ERRORS 
WHERE NAME = 'CAL_BONUS';

-- 프로시저처럼 데이터베이스의 함수 코너에서 만든 저장함수 파일 확인 가능!


-- 바인드변수를 만들지 않고 저장함수를 SQL문에 포함해서 실행할 경우
SELECT ename, sal, cal_bonus(7788)
FROM emp
WHERE empno = 7788;    





-- 예제2. 사원 테이블에서 사원명 검색하면 사원의 직급을 구해오는 저장함수만들기
CREATE OR REPLACE FUNCTION job_emp(
    v_ename IN emp.ename%type
    )
RETURN VARCHAR2
IS
    v_job emp.job%type;
BEGIN
    SELECT job
    INTO v_job
    FROM emp
    WHERE ename = v_ename;
    
    RETURN v_job;
END;
/

SELECT * FROM USER_SOURCE;

VARIABLE var_job VARCHAR2;

EXECUTE :var_job := job_emp('SCOTT');
EXECUTE :var_job := job_emp('KING');
PRINT var_job;


SELECT ename, job_emp('SCOTT')
FROM emp
WHERE ename = 'SCOTT';

SELECT ename, job_emp('KING')
FROM emp
WHERE ename = 'KING';

