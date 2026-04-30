-- 패키지: 관련 있는 프로시저를 보다 효율적으로 관리하기 위해서 패키지 단위로 배포할 때 유용하게 사용됩니다. 

/*  패키지는 패키지 선언(명세부)과 패키지 몸체 선언(몸체부) 두 가지 모두를 정의해야 합니다.
    저장프로시저 사용할 때는 프로시저 이름이, 저장함수일 때는 저장함수 이름이 선언부에 들어감. 둘 다 들어가는 것도 가능!
    
    
        여기는 선언부! 명세부에는 몸체부에 정의한 함수들을 선언
        
    CREATE [ OR REPLACE ] PACKAGE package_name 
    IS
    PROCEDURE procedure_name1;
    PROCEDURE procedure_name2;
    END;
    /
    
        여기서부터 몸체 선언! 몸체부내에는 여러 가지의 프로시저나 함수를 정의함
        몸체부에 정의한 프로시저나 함수는 앞장에서 배운 저장 프로시저와 저장 함수와 동일한 문법구조
        
    CREATE [ OR REPLACE ] PACKAGE BODY package_name 
    IS
    PROCEDURE procedure_name1 
    IS
    ....
    END;
    END;
    /
    
    나중에 패키지 실행할 때는
    EXECUTE [패키지명].[프로시저명]

*/
--
---- 패키지 헤드 생성
--CREATE OR REPLACE PACKAGE exam_pack
--IS
--    FUNCTION cal_bonus(
--        v_empno IN emp.empno%type
--    ) RETURN NUMBER;
--    
--    PROCEDURE cursor_sample02;
--END exam_pack;
--/
--
---- 패키지 바디 생성
--CREATE OR REPLACE PACKAGE BODY exam_pack
--IS
--    -- FUNCTION: cal_bonus 실행
--    FUNCTION cal_bonus(
--        v_empno IN emp.empno%type
--            ) RETURN NUMBER
--    IS
--        v_sal NUMBER(7, 2);
--    BEGIN
--        SELECT sal INTO v_sal
--        FROM emp
--        WHERE empno = v_empno;
--    
--        RETURN v_sal * 2; 
--    END cal_bonus;
--    
--    -- PROCEDURE: cursor_sample02 실행 
--    PROCEDURE cursor_sample02 IS
--            v_dept      dept%rowtype;
--            CURSOR c2 IS SELECT * FROM dept;
--        BEGIN
--            DBMS_OUTPUT.PUT_LINE('부서번호   /   부서명   /   지역명');
--            DBMS_OUTPUT.PUT_LINE('-------------------------------');
--        
--            FOR v_dept IN c2 LOOP
--                DBMS_OUTPUT.PUT_LINE(v_dept.deptno || '/' || v_dept.dname || '/' || v_dept.loc);
--            END LOOP;
--    
--    END cursor_sample02;
--END exam_pack;
--/
--
--/*
------ PROCEDURE: cursor_sample02 실행부에서 포루프문이 변수를 자동으로 만들어줘서
------ 커서 변수 선언 생략, 로컬변수 생략도 가능함.
--
--    PROCEDURE cursor_sample02 IS
--    BEGIN
--        FOR v_dept IN (SELECT * FROM dept) LOOP
--            DBMS_OUTPUT.PUT_LINE(v_dept.deptno || '/' || v_dept.dname);
--        END LOOP;
--    END cursor_sample02;
--END exam_pack;
--/
--*/

-- 저장프로시저 패키지 실행
EXECUTE exam_pack.cursor_sample02;

-- 바인드변수 + 저장함수 패키지 실행
VARIABLE var_res NUMBER;
EXECUTE :var_res := exam_pack.cal_bonus(7788);
PRINT var_res;




