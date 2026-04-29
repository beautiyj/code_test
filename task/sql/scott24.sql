-- PL/SQL 선택문(=조건문)
-- IF문만 있는데 3가지 IF문 있음

/* 1. IF-THEN-END IF : 조건에 따라 어떤 명령을 선택적으로 처리하는 선택문
    어떤 경우에 어떤 행동을 해라!와 같은 간단한 처리를 할 때 사용한다
    
    IF condition THEN ..... 조건문
    statements; .............. 조건에 만족할 경우 실행되는 문장
    END IF

*/

-- 사원 테이블에서 SCOTT 사원의 부서번호를 이용해서 부서명 출력하기
SET SERVEROUTPUT ON;
DECLARE
    v_empno     NUMBER(4);
    v_ename     VARCHAR2(20);
    v_deptno    dept.deptno%type;       -- 레퍼런스 변수, 그 외 스칼라변수
    v_dname     VARCHAR2(20) := NULL;
BEGIN
    SELECT empno, ename, deptno
    INTO v_empno, v_ename, v_deptno
    FROM emp
    WHERE ename = 'SCOTT';
    
    IF v_deptno = 10
        THEN v_dname := 'ACCOUNTING';
    END IF;
    IF v_deptno = 20
        THEN v_dname := 'RESEARCH';
    END IF;
    IF v_deptno = 30
        THEN v_dname := 'SALES';
    END IF;
    IF v_deptno = 40
        THEN v_dname := 'OPERATIONS';
    END IF;
        
    DBMS_OUTPUT.PUT_LINE('사번 : ' || v_empno);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || v_ename);
    DBMS_OUTPUT.PUT_LINE('부서번호 : ' || v_deptno);
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || v_dname);

    DBMS_OUTPUT.PUT_LINE('사번   /   이름   /   부서명');
    DBMS_OUTPUT.PUT_LINE('-----------------');
    DBMS_OUTPUT.PUT_LINE(v_empno || ' / ' || v_ename || ' / ' || v_dname);
END;
/*  실행 결과는 이렇게 나옴

    사번 : 7788
    사원명 : SCOTT
    부서번호 : 20
    부서명 : RESEARCH
    사번   /   이름   /   부서명
    -----------------
    7788 / SCOTT / RESEARCH
    
    PL/SQL 프로시저가 성공적으로 완료되었습니다.
*/

-- 사원 테이블에서 SCOTT 사원의 연봉 구하기
DECLARE                         -- rowtype 사용 시, emp는 8개컬럼이니 8개 전부 참조
    v_emp    emp%rowtype;     -- 레퍼런스 변수 %rowtype: 해당 테이블의 모든 컬럼을 한번에 참조.
    annsal   NUMBER(7,2);     -- 스칼라 변수
BEGIN
    SELECT *
    INTO v_emp
    FROM emp
    WHERE ename = 'SCOTT';
    
    IF v_emp.comm IS NULL
        THEN v_emp.comm := 0;
    END IF;
    
    annsal := v_emp.sal * 12 + v_emp.comm;      -- 연봉 계산
    
    DBMS_OUTPUT.PUT_LINE('사번   /   이름   /   연봉');
    DBMS_OUTPUT.PUT_LINE('-----------------');
    DBMS_OUTPUT.PUT_LINE(v_emp.empno || ' / ' || v_emp.ename || ' / ' || v_emp.comm);
    
END;



/*  2. IF ~ THEN ~ ELSE ~ END IF
    참일 때와 거짓일 때 각각 다른 문장을 수행하도록 지정할 수 있는 선택문

    [문장1]
    IF condition THEN ....... 조건문
    statements; ...... 조건에 만족할 경우 실행되는 문장[문장2]
    ELSE
    statements; ...... 조건에 만족하지 않을 경우 실행되는 문장[문장3]
    END IF
    [문장4]
*/
-- 사원 테이블에서 SCOTT 사원의 연봉 구하기(comm 부분의 널을 선택문에서 미리 계산)
DECLARE
    v_emp    emp%rowtype;
    annsal   NUMBER(7,2);
BEGIN
    SELECT *
    INTO v_emp
    FROM emp
    WHERE ename = 'SCOTT';
    
    IF v_emp.comm IS NULL
        THEN annsal := v_emp.sal * 12;
    ELSE annsal := v_emp.sal * 12 + v_emp.comm;
    END IF;

    DBMS_OUTPUT.PUT_LINE('사번   /   이름   /   연봉');
    DBMS_OUTPUT.PUT_LINE('-----------------');
    DBMS_OUTPUT.PUT_LINE(v_emp.empno || ' / ' || v_emp.ename || ' / ' || annsal);

END;



/*  3. IF ~ THEN ~ ELSIF ~ ELSE ~ END IF 경우의 수가 둘이 아닌 셋 이상에서 하나를 선택해야 할 때 사용.
    참 거짓을 선택하는 과정에서 한번만 사용되었지만, 이프댄엘스이프엘스엔드이프...는 둘 중에 하나를 선택 가능한 선택문.
    ELSIF는 오라클에서, MYSQL에선 ELSEIF, 자바코틀린은 else if, 파이썬은 elif
    
    IF condition THEN
    statements;
    ELSIF condition THEN
    statements;
    ELSIF condition THEN
    statements;
    ELSE
    statements;
    END IF
*/

-- 사원 테이블에서 SCOTT 사원의 부서번호를 이용해서 부서명 출력하기
DECLARE
    v_emp    emp%rowtype;
    v_dname  VARCHAR2(14);
BEGIN
    SELECT *
    INTO v_emp
    FROM emp
    WHERE ename = 'SCOTT';
    
    IF v_emp.deptno = 10
        THEN v_dname := 'ACCOUNTING';
    ELSIF v_emp.deptno = 20
        THEN v_dname := 'RESEARCH';
    ELSIF v_emp.deptno = 30
        THEN v_dname := 'SALES';
    ELSIF v_emp.deptno = 40
        THEN v_dname := 'OPERATIONS';
    ELSE v_dname := '해당없음';
    END IF;
        
    DBMS_OUTPUT.PUT_LINE('사번 : ' || v_emp.empno);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || v_emp.ename);
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || v_dname);

    DBMS_OUTPUT.PUT_LINE('사번   /   이름   /   부서명');
    DBMS_OUTPUT.PUT_LINE('-----------------');
    DBMS_OUTPUT.PUT_LINE(v_emp.empno || ' / ' || v_emp.ename || ' / ' || v_dname);
END;


