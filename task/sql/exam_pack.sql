-- 패키지 헤드 생성
CREATE OR REPLACE PACKAGE exam_pack
IS
    FUNCTION cal_bonus(
        v_empno IN emp.empno%type
    ) RETURN NUMBER;
    
    PROCEDURE cursor_sample02;
END exam_pack;
/

-- 패키지 바디 생성
CREATE OR REPLACE PACKAGE BODY exam_pack
IS
    -- FUNCTION: cal_bonus 실행
    FUNCTION cal_bonus(
        v_empno IN emp.empno%type
            ) RETURN NUMBER
    IS
        v_sal NUMBER(7, 2);
    BEGIN
        SELECT sal INTO v_sal
        FROM emp
        WHERE empno = v_empno;
    
        RETURN v_sal * 2; 
    END cal_bonus;
    
    -- PROCEDURE: cursor_sample02 실행 
    PROCEDURE cursor_sample02 IS
            v_dept      dept%rowtype;
            CURSOR c2 IS SELECT * FROM dept;
        BEGIN
            DBMS_OUTPUT.PUT_LINE('부서번호   /   부서명   /   지역명');
            DBMS_OUTPUT.PUT_LINE('-------------------------------');
        
            FOR v_dept IN c2 LOOP
                DBMS_OUTPUT.PUT_LINE(v_dept.deptno || '/' || v_dept.dname || '/' || v_dept.loc);
            END LOOP;
    
    END cursor_sample02;
END exam_pack;
/

/*
---- PROCEDURE: cursor_sample02 실행부에서 포루프문이 변수를 자동으로 만들어줘서
---- 커서 변수 선언 생략, 로컬변수 생략도 가능함.

    PROCEDURE cursor_sample02 IS
    BEGIN
        FOR v_dept IN (SELECT * FROM dept) LOOP
            DBMS_OUTPUT.PUT_LINE(v_dept.deptno || '/' || v_dept.dname);
        END LOOP;
    END cursor_sample02;
END exam_pack;
/
*/