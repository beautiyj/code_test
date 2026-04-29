-- 260429 과제
-- 사원 테이블에서 사원명을 검색하여 사원의 직급을 구해오는 저장 프로시저 만들기

-- 셋온 + 프로시저 생성하기. 간편한 코드 실행을 위해 프로시저 작성 코드는 주석처리함
--SET SERVEROUTPUT ON;

--CREATE OR REPLACE PROCEDURE del_job(
--    v_ename IN emp.ename%type,
--    v_job OUT emp.job%type 
--    )
--IS
--BEGIN
--    SELECT job
--    INTO v_job
--    FROM emp
--    WHERE ename = v_ename;
--END;
--/

SELECT * FROM USER_SOURCE;
SELECT object_name, status FROM user_objects WHERE object_name = 'DEL_JOB';
SELECT * FROM USER_ERRORS WHERE NAME = 'DEL_JOB';

-- 코드 결과 출력 편의를 위해 바인드변수 여러 개 생성함
VARIABLE var_job1  VARCHAR2(10);
VARIABLE var_job2  VARCHAR2(10);
VARIABLE var_job3  VARCHAR2(10);

EXECUTE del_job('KING', :var_job1);
EXECUTE del_job('WARD', :var_job2);
EXECUTE del_job('ADAMS', :var_job3);

PRINT var_job1;
PRINT var_job2;
PRINT var_job3;