SELECT * FROM dept;
SELECT * FROM emp;

-- DUAL 듀얼 테이블
SELECT 10+20 FROM dept;
SELECT 10+20 FROM emp;
SELECT 10+20 FROM DUAL;     -- 30이 1개만 출력됨. dummy 길이 1밖에 없음
SELECT 10+20 FROM sys.DUAL; -- 듀얼 테이블은 sys소유의 테이블, 공개된 테이블.(공용 동의어)
SELECT * FROM DUAL;         -- 더미 컬럼 1개만 존재.
DESC DUAL;

-- 함수
SELECT -10, ABS(-10), ABS(-20) FROM DUAL;   -- ADB() 절댓값 구하는 함수
SELECT 34.5678, FLOOR(34.5678) FROM DUAL;   -- FLOOR() 소수점 이하 버리는 함수
SELECT 37, ROUND(37), 34.5678, ROUND(34.5678), -- ROUND() 특정 자리에서 반올림(자릿수 지정 가능)
    ROUND(34.5678, 2), ROUND(34.5678, -1) FROM DUAL;    -- 자릿수 음수: 1 10 100의 자리 & 양수: 소수점
SELECT 34.5678, TRUNC(34.5678), TRUNC(34.5678, 2),
    TRUNC(34.5678, -1), TRUNC(34.5678, -2) FROM DUAL;  -- TRUNC() 버림 함수
SELECT MOD(27,2), MOD(27,5), MOD(27,7) FROM DUAL;      -- MOD() %처럼 나머지 구하는 함수 
SELECT * FROM emp WHERE MOD(empno, 2)=1;

SELECT 'oracle', UPPER('oracle') FROM DUAL; -- UPPER() 대문자 변환 함수
SELECT 'ORACLE', LOWER('ORACLE') FROM DUAL; -- LOWER() 소문자 변환 함수
SELECT 'oracle', INITCAP('oracle'), INITCAP('ORACLE') FROM DUAL;   -- INITCAP() 첫글자만 대문자 변환
SELECT * FROM emp WHERE UPPER(job) = UPPER('manager');

SELECT LENGTH('oracle'), LENGTH('오라클') FROM DUAL; -- LENGTH() 문자열 길이 구하는 함수
SELECT LENGTHB('oracle'), LENGTHB('오라클') FROM DUAL; -- LENGTHB() 문자열의 바이트 수를 구하는 함수(영어는 문자 당 1바이트지만 한글은 그보다 큼)
SELECT SUBSTR('oracle',2,4), SUBSTRB('oracle',2,4) FROM DUAL; -- SUBSTR() 자바의 SUBSTRING처럼 일부 문자 잘라내는 함수.
                                                              -- 인덱스와 달리 2번째부터 4글자만 보여준다. racl 까지만 출력됨
SELECT SUBSTR('welcome to oracle',-4,2), SUBSTRB('welcome to oracle',-4,2) FROM DUAL;
--                  뒤에서 4번째부터 2글자 가져옴. ac만 출력됨
SELECT SUBSTR('오라클과 자바',2,6), SUBSTRB('오라클과 자바',2,6) FROM DUAL; -- SUBSTRB() 바이트수로 일부 자름
                                                                         -- 라클과 자바 , 라 만 나온다(한글의 바이트수가 더 커서)
                                                                                                                                                  
SELECT SUBSTR (hiredate, 1, 2) AS "년",
    SUBSTR (hiredate, 4, 2) AS "월",
    SUBSTR (hiredate, 7, 2) AS "일" FROM emp;
SELECT TO_CHAR(hiredate, 'YY') AS "년",
    TO_CHAR(hiredate, 'MM') AS "월",
    TO_CHAR(hiredate, 'DD') AS "일" FROM emp;
SELECT * FROM emp WHERE TO_CHAR(hiredate, 'YY') = '87';     -- 날짜 데이터를 바로 TO_NUMBER 변환하는 건 불가. 문자 변환 후 숫자 변환 필요
SELECT * FROM emp WHERE SUBSTR (hiredate, 1, 2) = '87';

SELECT * FROM emp WHERE ename LIKE '%E';
SELECT * FROM emp WHERE SUBSTR(ename, -1, 1)= 'E';

SELECT INSTR('ORACLE','O'), INSTR('oracle','O'),
    INSTR('OK ORACLE','O'), INSTR('OK ORACLE','O',1,2) FROM DUAL;  -- INSTR() 가장 먼저 나오는 문자의 위치를 찾는 함수
-- 순서대로 1,0,1,4. 대소문자도 구분하고 가장 먼저 나오는 문자의 위치 하나만 찾는 거라 다음 문장은 직접 위치를 체크해야 가능함. (2,5하면 2번째부터 5번째 글자의 위치 지정이라서 0 나옴)

SELECT * FROM emp WHERE ename LIKE '__R%';
SELECT * FROM emp WHERE SUBSTR(ename, 3, 1) = 'R';
SELECT * FROM emp WHERE INSTR(ename, 'R', 3, 1) = 3;

/*
LPAD(문자열, 총길이, 채울문자)  -- 왼쪽을 채움
RPAD(문자열, 총길이, 채울문자)  -- 오른쪽을 채움
SELECT LPAD('HELLO', 10, '*')   -- *****HELLO            -- LPAD →  *****HELLO   (왼쪽부터 채움)
     , RPAD('HELLO', 10, '*')   -- HELLO*****            -- RPAD →  HELLO*****   (오른쪽부터 채움)
FROM DUAL;                                                           ↑↑↑↑↑↑↑↑↑↑
                                                                      총 10자리
*/
SELECT LPAD('ORACLE',10,'#') FROM DUAL;
SELECT RPAD('ORACLE',10,'#') FROM DUAL;
SELECT '           ORACLE         ', LTRIM('           ORACLE         ') FROM DUAL;           -- LTRIM() 왼쪽 공백 제거 함수
SELECT '           ORACLE         ', RTRIM('           ORACLE         ') FROM DUAL;           -- RTRIM() 오른쪽 공백 제거 함수
SELECT '           ORACLE         ', TRIM('           ORACLE         ') FROM DUAL;            -- TRIM() 양쪽 공백 제거 함수
SELECT TRIM('A' FROM 'AAAAAORACLEAAAAA') FROM DUAL;       -- TRIM()은 특정 문자도 제거해주는 함수

SELECT SYSDATE FROM DUAL;           -- SYSDATE 함수는 시스템의 날짜 구하는 함수, ()괄호 없음.
SELECT SYSDATE-1 어제 FROM DUAL;
SELECT SYSDATE+1 내일 FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;

SELECT SYSDATE - hiredate FROM emp;
SELECT TO_DATE(SYSDATE) - TO_DATE(hiredate) FROM emp;
SELECT ename, CEIL(SYSDATE - hiredate) FROM emp;        -- CEIL() 올림
SELECT ename
     , SYSDATE - hiredate                    -- 14235.7  (원본)
     , CEIL(SYSDATE - hiredate)              -- 14236    (올림)
     , FLOOR(SYSDATE - hiredate)             -- 14235    (내림)
     , ROUND(SYSDATE - hiredate)             -- 14236    (반올림)
     , TRUNC(SYSDATE - hiredate)             -- 14235    (버림)
FROM emp;

SELECT ename, MONTHS_BETWEEN(SYSDATE, hiredate) FROM emp; -- MONTHS_BETWEEN() 두 날짜 사이의 경과된 개월 수를 구하는 함수
SELECT ename, MONTHS_BETWEEN(hiredate, SYSDATE) FROM emp; -- 이것도 가능하지만 음수로 측정됨
SELECT ename
    , MONTHS_BETWEEN(hiredate, SYSDATE)
    , CEIL(MONTHS_BETWEEN(hiredate, SYSDATE))
    , FLOOR(MONTHS_BETWEEN(hiredate, SYSDATE))
    , ROUND(MONTHS_BETWEEN(hiredate, SYSDATE))
    , TRUNC(MONTHS_BETWEEN(hiredate, SYSDATE))
FROM emp;

SELECT ename, hiredate, ADD_MONTHS(hiredate, 6) FROM emp; -- ADD_MONTHS() 특정 날짜에 경과된 날짜를 구하는 함수
SELECT ADD_MONTHS('26/03/17', 6) FROM DUAL;
SELECT NEXT_DAY(SYSDATE, 'SATURDAY'), NEXT_DAY(SYSDATE, 'FRIDAY'),  -- NEXT_DAY() 해당 요일의 가장 가까운 날짜를 구하는 함수
    NEXT_DAY(SYSDATE, '금요일'), NEXT_DAY(SYSDATE, '토') FROM DUAL;  -- 영어는 'FRI' 불가능, 전체 적어야 가능함

SELECT ename, hiredate, LAST_DAY(hiredate) FROM emp;     -- LAST_DAY() 해당 달의 마지막 날짜를 구하는 함수 (7월의 마지막 날은 31일)
SELECT LAST_DAY(SYSDATE), LAST_DAY('26/02/01'), LAST_DAY('24/02/01') FROM DUAL;


