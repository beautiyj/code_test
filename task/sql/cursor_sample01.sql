CREATE OR REPLACE PROCEDURE cursor_sample01
IS
    v_dept      dept%rowtype;
    CURSOR c1           -- 커서 선언
    IS
    SELECT * FROM dept;
BEGIN
    DBMS_OUTPUT.PUT_LINE('부서번호   /   부서명   /   지역명');
    DBMS_OUTPUT.PUT_LINE('-------------------------------');
    
    OPEN c1;             -- 커서 열기(첫번째 데이터 가져오기)
    
    LOOP
        FETCH c1 INTO v_dept.deptno, v_dept.dname, v_dept.loc;    -- 인출
        EXIT WHEN c1%notfound;          -- 커서가 더이상 가져올 데이터 없을 경우 루프 탈출
        DBMS_OUTPUT.PUT_LINE('v_dept.deptno || '/' || v_dept.dname || '/' || v_dept.loc');
    END LOOP;
    
    CLOSE c1;            -- 커서 닫기
END;
/