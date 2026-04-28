-- PL/SQL

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
SET SERVEROUTPUT ON;        -- 보통은 세미콜론으로 먼저 실행 후 이후 프로시저 실행함

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
    
