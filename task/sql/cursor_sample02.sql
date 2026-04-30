create or replace PROCEDURE cursor_sample02
IS
    v_dept      dept%rowtype;       -- 로컬변수
    CURSOR c2                       -- 포루프문에서도 커서 선언까지는 동일함
    IS
    SELECT * FROM dept;
BEGIN
    DBMS_OUTPUT.PUT_LINE('부서번호   /   부서명   /   지역명');
    DBMS_OUTPUT.PUT_LINE('-------------------------------');

    FOR v_dept IN c2 LOOP                       -- 포루프문 사용하면 fetch 필요없고 커서 열고 닫는 것도 알아서 해줌!
        EXIT WHEN c2%notfound;
        DBMS_OUTPUT.PUT_LINE(v_dept.deptno || '/' || v_dept.dname || '/' || v_dept.loc);
    END LOOP;

END;
/