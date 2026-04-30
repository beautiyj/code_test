-- 저장 프로시저 : 오라클은 사용자가 만든 PL/SQL 문을 데이터베이스에 저장 할 수 있는 서비스를 제공함
--              사용자가 미리 만들어둔 PL/SQL을 저장해 놓고 필요한 경우 호출해 재사용하고 싶을 때(단축키처럼...)
--              저장 프로시저 사용 시 복잡한 DML 문들 필요할 때마다 간단하게 호출만 해서 사용 가능(=재사용성)! 함수/메소드 호출과 유사함.

/*  저장 프로시저를 생성하기 위한 CREATE PROCEDURE의 형식

    CREATE [OR REPLACE ] PROCEDURE procedure_name 
    ( argument1 [mode] data_type, 
      argument2 [mode] data_type . . .
    )
    IS 
    local_variable declaration
    BEGIN
    statement1;
    statement2;
    . . .
    END;
    /
*/

-- 프로시저 내의 모든 코드 라인 보기 (여기만 s 없이 USER_SOURCE)   (책 안에 적힌 모든 문장 보기)
SELECT * FROM USER_SOURCE;
-- 이건 프로시저 목록. 생성된 프로시저들의 이름 목록 보기 (책제목 쫙 나오는 것처럼.)
SELECT * FROM USER_PROCEDURES;


-- 저장 프로시저 생성하기
-- SET SERVEROUTPUT ON;     -- 처음에 창 새로 켜서 접속하기! 한 번 실행해주면 됨~~
CREATE OR REPLACE PROCEDURE del_all
IS
BEGIN
    DELETE FROM emp04;
END;
/

/*  SELECT * FROM USER_SOURCE; 실행하면 이렇게 나옴
DEL_ALL	PROCEDURE	1	"PROCEDURE del_all"
DEL_ALL	PROCEDURE	2	"IS"
DEL_ALL	PROCEDURE	3	"BEGIN"
DEL_ALL	PROCEDURE	4	"    DELETE FROM emp01;"
DEL_ALL	PROCEDURE	5	END;
*/


-- 프로시저 실행 (F9)
EXECUTE DEL_ALL;        -- 프로시저에 데이터삭제코드를 적었음
EXEC del_all;

SELECT * FROM emp04;        -- 테이블 내 데이터 모두 삭제됨
-- 만약 데이터가 300만개... 정도 되는 걸 프로시저로 할 경우 오라클 멈춤 이건 걍 TRUNCATE로 삭제하기. 두번이나멈추더라

ROLLBACK;       -- 롤백하면 데이터 다시 복구됨



-- 프로시저 매개변수 모드
/*
    모드(MODE)        역할                데이터의 방향
    IN          입력값 (기본값)         사용자 → 프로시저
    OUT         결과값 (결과 리턴용)     프로시저 → 사용자
    INOUT       입력 + 수정 후 결과     사용자 ⇄ 프로시저
*/



-- 매개변수가 있는 저장 프로시저 만들기
-- 매개변수 MODE가 IN으로 되어있는 프로시저에서 IN은 매개변수로 값을 받는 역할
CREATE OR REPLACE PROCEDURE del_ename(v_ename IN emp_copy.ename%type)
IS
BEGIN
    DELETE FROM emp_copy WHERE ename = v_ename;
END;
/           -- 프로시저 작성을 마친다는 종료 신호. 프로시저 코드가 많을 때 이거 안적으면 컴파일 오류날 수도 있음

SELECT * FROM USER_SOURCE;      -- 프로시저 잘 생성된 거 코드확인가능

SELECT * FROM emp_copy;         -- 해당 테이블 조회

-- 만약 프로시저 실행 시 컴파일 오류가 난다면 프로시저 상태 확인 후 오류메시지 체크하기
SELECT object_name, status FROM user_objects WHERE object_name = 'DEL_ENAME';       -- STATUS VALID여야함
SELECT * FROM USER_ERRORS WHERE NAME = 'DEL_ENAME';

EXECUTE del_ename('SCOTT');     -- 프로시저 실행하면 테이블 조회했을 때 해당 데이터 삭제됨(프로시저코드대로 진행되니까)
EXECUTE del_ename('KING');
EXECUTE del_ename('SMITH');



-- 매개변수가 있는 저장 프로시저 만들기
-- 매개변수 MODE가 IN, OUT으로 되어있는 프로시저에서 OUT은 매개변수로 값을 돌려주는 역할

-- 프로시저의 매개변수에 사원번호를 전달해서 사원명, 급여, 직책 구하는 프로시저 생성하기
CREATE OR REPLACE PROCEDURE sal_empno(
    v_empno IN emp.empno%type,
    v_ename OUT emp.ename%type,
    v_sal OUT emp.sal%type,
    v_job OUT emp.job%type)
IS
BEGIN
    SELECT ename, sal, job
    INTO v_ename, v_sal, v_job
    FROM emp
    WHERE empno = v_empno;
END;
/           -- 예제용이라서 프로시저와 실행코드 같이 뒀는데, 데이터베이스 메뉴에서 프로시저코너 코드 확인가능함.
            -- 나중엔 그냥 프로시저코드파일 따로 만들고 데베계정에선 sql실행만 하면 됨

SELECT * FROM USER_SOURCE;
SELECT * FROM emp;


-- 바인드 변수 만들기 : 매번 새로운 쿼리를 짜는 대신, 값만 들어갈 '빈칸'을 미리 만들어두고 재사용하는 기술
-- 프로시저를 실행할 때 결과를 돌려받는 변수가 바인드변수임.

VARIABLE var_ename  VARCHAR2(12);
VARIABLE var_sal    NUMBER;
VARIABLE var_job    VARCHAR2(10);

EXECUTE sal_empno(7788, :var_ename, :var_sal, :var_job);

EXECUTE sal_empno(7839, :var_ename, :var_sal, :var_job);

PRINT var_ename;
PRINT var_sal;
PRINT var_job;


