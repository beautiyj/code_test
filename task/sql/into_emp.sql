CREATE OR REPLACE PROCEDURE into_emp(
    v_deptno IN emp.deptno%type)
IS
    v_emp   emp%rowtype;     -- 로컬변수
    
    CURSOR c3               -- 커서 선언
    IS
    SELECT *
    FROM emp
    WHERE deptno = v_deptno;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('부서번호   /   부서명   /   사원번호   /   사원명   /   직급   /   급여');
    DBMS_OUTPUT.PUT_LINE('------------------------------------');
    
    FOR v_emp IN c3 LOOP
        EXIT WHEN c3%notfound;
        DBMS_OUTPUT.PUT_LINE(
               v_emp.deptno || '/' || 
               v_emp.ename  || '/' || 
               v_emp.empno  || '/' || 
               v_emp.ename  || '/' || 
               v_emp.job    || '/' || 
               v_emp.sal
        );    
    END LOOP;
END;
/