-- PL/SQL(프로시저는 전체스크립트실행은 f5, 특정프로시저출력은 드래그묶어서 컨+엔 혹은 f5)

SET SERVEROUTPUT ON;

-- PL/SQL로 Hello World 출력하기 (간단한 메시지 출력하기)
-- 
/*  환경변수 프로시저를 사용하지 않으면 적용은 되지만 출력이 안됨
    SQL> begin
      2  dbms_output.put_line('Hello WORLD!');
      3  end;
      4  /
    
    PL/SQL procedure successfully completed.
    
    SQL>
*/

/*  SERVEROUTPUT는 오라클의 환경 변수인데 디폴트값 OFF이기에 ON으로 변경 먼저 해줘야함.(화면출력도와주는프로시저)
+ 화면 출력을 위해서는 PUT_LINE이란 프로시저를 이용
  PUT_LINE은 오라클이 제공해주는 프로시저로 DBMS_OUTPUT 패키지에 묶여 있음
  DBMS_OUTPUT.PUT_LINE과 같이 사용해야함!

    SQL> SET SERVEROUTPUT ON
    SQL> begin
      2  dbms_output.put_line('Hello WORLD!');
      3  end;
      4  /
    Hello WORLD!
    
    PL/SQL procedure successfully completed.
    
    SQL>
*/

-- 콘솔이 아닌 디벨로퍼에서 진행한다면 코드로,
-- 혹은 [보기(View)] → [DBMS 출력(DBMS Output)] 활용해서 [DBMS 출력] 전용 창 사용하기(+ 버튼누르고 f5나 f9)
-- SET SERVEROUTPUT ON 한번만 실행 후 세미콜론 없이 엔터쳐서 PL/SQL 블록 실행도 가능함.
-- SET SERVEROUTPUT ON;        -- 보통은 세미콜론으로 먼저 실행 후 이후 프로시저 실행함

BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello WORLD!');
END;
/




-- 변수 사용하기(스칼라 변수 사용 예제)
-- SET SERVEROUTPUT ON; 위에서 on 실행했으면 안해도됨
-- 스칼라변수는 내부 구조를 가지지 않고 숫자(NUMBER)면 숫자, 문자(VARCHAR2)면 문자 딱 한 덩어리만 저장(프로시저가 종료되면 사라짐)
DECLARE                                 -- 프로시저 선언부 시작
    v_empno    NUMBER(4);               -- 변수 선언에 쓰는 게 스칼라변수. 가독성을 위해 vempno 보단 v_(변수약자)empno를 추천
    v_ename    VARCHAR2(10);            -- c_ 상수 p_ 매개변수 o_ 출력변수 이런식으로 활용함
BEGIN                                   -- 프로시저 실행부 시작
    v_empno  :=  7788;
    v_ename  :=  'SCOTT';
    DBMS_OUTPUT.PUT_LINE('사번   /   이름');
    DBMS_OUTPUT.PUT_LINE('-----------------');
    DBMS_OUTPUT.PUT_LINE(v_empno || ' / ' || v_ename);    -- 변수명 대소문자 구분X
END;                                    -- 실행부 종료
    


-- 레퍼런스 변수 활용하기
-- 레퍼런스 변수: 이전에 선언된 다른 변수 또는 데이터베이스 컬럼에 맞추어
-- 변수를 선언하기 위해 %TYPE속성을 사용할 수 있음


-- 사원 번호와 이름 검색하기
-- SET SERVEROUTPUT ON;     -- 디벨로퍼 접속 킬 때마다 실행해줘야함(1번만, 창 새로 열어도 실행필요)

DECLARE
    v_empno emp.empno%type;          -- 변수 선언: 레퍼런스 변수
    v_ename emp.ename%type;
BEGIN
    SELECT empno, ename
    INTO v_empno, v_ename
    FROM emp
    WHERE ename = 'SCOTT';
    
    DBMS_OUTPUT.PUT_LINE('사번   /   이름');
    DBMS_OUTPUT.PUT_LINE('-----------------');
    DBMS_OUTPUT.PUT_LINE(v_empno || ' / ' || v_ename);
END;






-- ==================================================================================

-- ====================================================
-- 스칼라(Scalar) 변수 vs 레퍼런스(Reference) 변수
-- ====================================================

-- 한눈에 보는 비교표
-- ┌─────────────┬──────────────────────────────┬──────────────────────────────────┐
-- │ 구분         │ 스칼라(Scalar) 변수           │ 레퍼런스(Reference) 변수          │
-- ├─────────────┼──────────────────────────────┼──────────────────────────────────┤
-- │ 정의         │ 타입을 직접 지정              │ 기존 테이블의 타입을 참조(%TYPE)   │
-- │             │ (예: NUMBER, VARCHAR2 등)     │                                  │
-- ├─────────────┼──────────────────────────────┼──────────────────────────────────┤
-- │ 선언 방식    │ v_empno NUMBER(4)            │ v_empno emp.empno%TYPE           │
-- ├─────────────┼──────────────────────────────┼──────────────────────────────────┤
-- │ 유연성       │ 데이터 크기 변경 시           │ DB가 바뀌면 자동으로 따라감       │
-- │             │ 코드도 직접 고쳐야 함         │ (유지보수 최고)                   │
-- ├─────────────┼──────────────────────────────┼──────────────────────────────────┤
-- │ 정확성       │ 타입을 잘못 지정하면          │ 데이터 타입 불일치 에러           │
-- │             │ 에러 날 확률 높음             │ (ORA-06550) 방지                 │
-- ├─────────────┼──────────────────────────────┼──────────────────────────────────┤
-- │ 실무 선호도  │ 간단한 임시 변수에 사용       │ 실무/포폴에서 권장                │
-- └─────────────┴──────────────────────────────┴──────────────────────────────────┘

-- ====================================================
-- 선언 예시
-- ====================================================

DECLARE
    -- 스칼라 변수 : 타입 직접 지정
    v_empno     NUMBER(4);
    v_ename     VARCHAR2(15);
    v_sal       NUMBER(7, 2);

    -- 레퍼런스 변수 : 테이블 컬럼 타입 참조
    v_empno2    emp.empno%TYPE;     -- emp 테이블의 empno 타입을 그대로 참조
    v_ename2    emp.ename%TYPE;     -- emp 테이블의 ename 타입을 그대로 참조
    v_sal2      emp.sal%TYPE;       -- emp 테이블의 sal   타입을 그대로 참조

BEGIN
    NULL;
END;

-- ====================================================
-- 실무 활용 예시
-- ====================================================

DECLARE
    -- 레퍼런스 변수로 emp 테이블에서 데이터 받아오기
    v_empno     emp.empno%TYPE;
    v_ename     emp.ename%TYPE;
    v_sal       emp.sal%TYPE;

BEGIN
    SELECT empno, ename, sal
    INTO v_empno, v_ename, v_sal    -- 조회 결과를 변수에 저장
    FROM emp
    WHERE empno = 7369;

    DBMS_OUTPUT.PUT_LINE('사번 : ' || v_empno);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || v_ename);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || v_sal);
END;

-- ====================================================
-- 왜 레퍼런스 변수를 실무에서 선호하냐?
-- ====================================================
-- 예시) emp.empno 컬럼이 NUMBER(4) → NUMBER(6) 으로 변경된 경우

-- 스칼라 변수 사용 시
-- v_empno NUMBER(4);  ← 직접 NUMBER(6)으로 고쳐야 함 (실수 위험!)

-- 레퍼런스 변수 사용 시
-- v_empno emp.empno%TYPE;  ← DB 컬럼 바뀌면 자동으로 따라감 (수정 불필요!)

