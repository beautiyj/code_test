-- PL/SQL 반복문

/*  PL/SQL 반복문은 SQL 문을 반복적으로 여러 번 실행할 때 씀 

    1. 조건 없이 반복 작업을 제공하기 위한 BASIC LOOP문
    2. COUNT를 기본으로 작업의 반복 제어를 제공하는 FOR LOOP문
    3. 조건을 기본으로 작업의 반복 제어를 제공하기 위한 WHILE LOOP문
    4. LOOP를 종료하기 위한 EXIT문
*/

/*  1. BASIC LOOP문 : JAVA의 do-while문과 비슷한 무한루프 반복문.
    END LOOP에 도달할 때마다 그와 짝을 이루는 LOOP 문으로 되돌아감 (= 무한루프) 
    베이직 루프는 조건 충족 상태여도 최소 1번 실행됨. (조건이 이미 충족된 상태여도 무조건 1번은 실행됨)
    
    EXIT 필수! 반복문이라 자바 break처럼, EXIT WHEN 조건 없으면 영원히 못빠져나오는 무한루프!
    ++ EXIT 위치가 중요함
    EXIT 를 앞에 두면 → 조건 체크 먼저
    EXIT 를 뒤에 두면 → 실행 먼저, 조건 체크 나중

    LOOP
    statement1;
    statement2;
    . . . . . .
    EXIT [WHERE condition];
    END LOOP

*/

-- 베이직 루프문으로 1~5까지 출력하기
DECLARE
    n NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(n);
        n := n+1;           -- EXIT없어도 일정 행까지만 반복하다가 중단되긴 함
        
        IF n > 5            -- IF문으로 넣으면 여러줄이고
        THEN EXIT;
        END IF;
        
--        EXIT WHEN n > 5;    -- EXIT에 바로 조건 걸기도 가능

    END LOOP;
END;


-- 1부터 10까지 합 구하기
DECLARE
    n NUMBER := 0;      -- 누적합계 저장되는 변수
    i NUMBER := 0;      -- 루프물 변수
BEGIN
    LOOP
        i := i+1;
        n := n+i;
        
        IF i >= 10
        THEN EXIT;
        END IF;
        
--        EXIT WHEN i >= 10;    -- EXIT에 바로 조건 걸기도 가능
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(n);
END;


/*  2. FOR LOOP문 : 반복되는 횟수가 정해진 경우
    형식은 FOR 변수 IN [REVERSE] 작은값..큰값 LOOP, 1씩만 커지고 작아지는 거라 임의값 증가감소 지정 불가
    
    FOR index_counter 
    IN [REVERSE] lower_bound..upper_bound LOOP
    statement1;
    statement2;
    . . . . . .
    END LOOP

        + index_counter 는 DECLARE 에 선언 안해도 됨! FOR 문이 자동으로 생성하고 관리함 (FOR 루프의 카운터 변수만)
            FOR i IN 1..10 LOOP   -- i 를 따로 선언 안해도 됨!
    
        + index_counter 값을 루프 안에서 변경 불가!
            FOR i IN 1..10 LOOP
                i := i + 2;       -- ❌ 오류! 직접 변경 불가
            END LOOP;
    
        + REVERSE 사용 시 큰값..작은값 으로 쓰는거 아님! 그냥 똑같이 작은값..큰값 으로 써야함!
            FOR i IN REVERSE 1..10 LOOP   -- ✅ 10→9→8...1 순서로 실행
            FOR i IN REVERSE 10..1 LOOP   -- ❌ 오류!
*/

-- 포 루프문으로 1~5까지 출력하기
BEGIN       --  FOR 루프의 카운터 변수만 디클레어 생략 가능함
    FOR n IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(n);
    END LOOP;
END;

-- 포 루프문으로 5부터 1까지 출력하기
BEGIN       --  FOR 루프의 카운터 변수만 디클레어 생략 가능함
    FOR n IN REVERSE 1..5 LOOP      -- 포 루프문에 리버스 추가 시 자동으로 1씩 감소됨. 그냥 IN이면 1씩 증가, IN REVERSE는 1씩 감소!
        DBMS_OUTPUT.PUT_LINE(n);
    END LOOP;
END;


-- 포 루프문으로 부서 테이블의 모든 정보 출력하기
DECLARE
    v_dept  dept%rowtype;
BEGIN
    DBMS_OUTPUT.PUT_LINE('부서번호   /   부서명   /   지역명');
    DBMS_OUTPUT.PUT_LINE('-----------------');
    FOR i IN 1..4 LOOP            -- i 루프문 변수
        SELECT *
        INTO v_dept
        FROM dept
        WHERE deptno = 10 * i;    -- 이렇게 쓰면 10,20,30,40 경우 정보 모두 출력됨!
                    -- 만약 deptno 가 10,20,35,40 이었다면? 10*3 = 30 → 35 랑 안맞아서 못쓰는 패턴!(이 경우 CURSOR패턴으로 써야함)

        DBMS_OUTPUT.PUT_LINE(v_dept.deptno || ' / ' || v_dept.dname || ' / ' || v_dept.loc);
    END LOOP;
END;




/* 3. WHILE LOOP 문 : 제어 조건이 TRUE인 동안만 일련의 문장을 반복할 때 사용하는 반복문.
    조건은 반복이 시작될 때 체크함, LOOP내의 문장이 한 번도 수행되지 않는 경우도 존재함
    LOOP을 시작할 때 조건이 FALSE이면 반복 문장 탈출.

    WHILE condition LOOP
    statement1;
    statement2;
    . . . . . .
    END LOOP

         기본 LOOP vs WHILE LOOP 핵심 차이
             기본LOOP  → 무조건 1번은 실행 (do~while)
             WHILE     → 조건 FALSE면 1번도 실행 안함 (while)
        
         EXIT WHEN 필요여부
             기본LOOP  → EXIT 필수!
             WHILE     → 조건이 FALSE되면 자동탈출! EXIT 불필요
*/


-- 와일 루프문으로 1부터 5까지 출력
DECLARE
    n NUMBER := 1;
BEGIN
    WHILE n <= 5 LOOP
        DBMS_OUTPUT.PUT_LINE(n);
        n := n +1;
    END LOOP;
END;

-- 와일 루프문으로 별 * 트리(삼각형) 형태 만들기
DECLARE
    n       NUMBER := 1;
    star    VARCHAR2(100) := '';
BEGIN
    WHILE n <= 5 LOOP
        star := star || '*';
        DBMS_OUTPUT.PUT_LINE(star);
        n := n+1;
    END LOOP;
END;
/*
    *
    **
    ***
    ****
    *****
*/

DECLARE
    n    NUMBER := 1;
BEGIN
    WHILE n <= 5 LOOP
        -- 공백은 ' ' 로, 별은 '*' 로 따로 처리!
        DBMS_OUTPUT.PUT_LINE(
            LPAD(' ', 5 - n) ||    -- 왼쪽 공백
            RPAD('*', n * 2 - 1, '*')   -- 별
        );
        n := n + 1;
    END LOOP;
END;
/*
*                       이건자꾸공백이사라지네; 글씨체폰트에따라서 맨위별만 공백없을수잇음
       ***
      *****
     *******
    *********
*/

-- WHILE 에는 REVERSE 없음! (FOR LOOP 전용)
-- n 을 5부터 시작해서 1씩 감소시키면 됨!

DECLARE
    n       NUMBER := 5;    -- ← 5부터 시작
    star    VARCHAR2(100) := '';
BEGIN
    WHILE n >= 1 LOOP       -- ← n >= 1 조건
        star := RPAD('*', n, '*');
        DBMS_OUTPUT.PUT_LINE(star);
        n := n - 1;         -- ← 1씩 감소
    END LOOP;
END;

/*
    *****
    ****
    ***
    **
    *
*/

