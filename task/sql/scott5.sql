SELECT * FROM dept;
SELECT * FROM emp;

-- 인코딩 utf8로 되어있을 경우 해당 유니코드버전으로 되어있어야 파일 깨짐 없음. 도구-환경설정
-- 함수
-- TO_CHAR() TO_DATE() TO_NUMBER()

-- TO_CHAR() 날짜를 지정한 문자 형식으로 출력
SELECT SYSDATE
    , TO_CHAR(SYSDATE, 'YY-MM-DD')
    , TO_CHAR(SYSDATE, 'YY-MM-DD HH:MI:SS')
    , TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY DY MON HH24:MI:SS AM HH12')
    FROM DUAL;

SELECT ename, hiredate
    ,TO_CHAR(hiredate, 'YY-MM-DD DAY HH24:MI:SS')
    FROM emp;

SELECT TO_CHAR(123456,'000,000')
    , TO_CHAR(123456,'999,999')
    , TO_CHAR(123456,'000,0000')
    , TO_CHAR(123456,'00000,999')
    , TO_CHAR(123456,'L000,000.0')
    FROM DUAL;

SELECT ename, sal, comm
    , TO_CHAR(sal, '000,000')
    , TO_CHAR(sal, '9,999')
    , TO_CHAR(sal + NVL(comm,0), 'L9,000')   
    , TO_CHAR(sal + NVL(comm,0), '$9,000')      -- $ 달러 기호는 공통 화폐 기호라서 L아니어도 별도로 붙이기 가능(다른 건 안됨)
    FROM emp;

-- TO_DATE() 문자를 지정한 날짜 형식으로 출력
/*  슬래시나 하이픈 포맷팅이 적용되는 게 아니고 이건 구분선 용이다 */
SELECT SYSDATE 
    , ROUND(SYSDATE - TO_DATE('2026/01/01','YY-MM-DD'))
    , TO_DATE('20260101','YYYY-MM-DD')  
    , TO_DATE('260101','YY-MM-DD')  
    , TO_DATE('20260101','YY-MM-DD')        -- 현재 2026 기준으로 YY면 알아서 2026 처리해주는데    
    , TO_DATE('980101','YY-MM-DD')
    , TO_DATE('19980101','YYYY-MM-DD')      -- 19XX기준으로 YY면 2098이 나올 수도 있음. 이런 경우 YY가 아닌 RR로 처리 가능
    FROM DUAL;
    
SELECT TO_DATE('261225','YY-MM-DD') - SYSDATE
    , ROUND(TO_DATE('261225','YY-MM-DD') - SYSDATE)
    , TRUNC(TO_DATE('261225','YY-MM-DD') - SYSDATE)
    , TO_DATE('260908', 'YY-MM-DD') - TO_DATE('260317','YY-MM-DD')    
    , ROUND(TO_DATE('260908', 'YY-MM-DD') - TO_DATE('260317','YY-MM-DD'))
    FROM DUAL;
    
    
-- TO_NUMBER() 문자를 숫자형태로 변환
SELECT 20000 - 10000 
    , TO_NUMBER('20000' - '10000')      -- 자동 형변환도 가능하나 추천하지 않는 방식(오라클 자체적으로 중복 진행)
    , TO_NUMBER('5' - '99')
    , TO_NUMBER('20,000','00,000') - TO_NUMBER('10,000','00,000')   -- 특수문자가 포함된 경우 숫자 형변환 추천
    FROM DUAL;


-- 함수 DECODE()
-- DECODE(표현식, 조건1, 결과1, 조건2, 결과2, ..., 기본결과 N). SWITCH-CASE문처럼 여러 가지 경우에 대해 선택 가능
SELECT ename, deptno
    , DECODE(deptno
        , 10, 'ACCOUNTING'
        , 20, 'RESEARCH'
        , 30, 'SALES'
        , 40, 'OPERATIONS') DNAME별칭
    FROM emp ORDER BY deptno;
    
    
-- CASE 함수는 IF-ELSE문 역할
-- CASE WHEN 조건 THEN 결과, WHEN 조건2 THEN 결과2, ..., ELSE 결과 N END
SELECT ename, deptno,
    CASE
        WHEN deptno = 10 THEN 'ACCOUNTING'
        WHEN deptno = 20 THEN 'RESEARCH'
        WHEN deptno = 30 THEN 'SALES'
        WHEN deptno = 40 THEN 'OPERATION'
        ELSE 'ERROR'
    END DNAME FROM emp ORDER BY deptno;

SELECT ename, deptno,
    CASE deptno                     -- 컬럼을 추가해두면 조건식이 아닌 데이터 값만 넣어도 가능함
        WHEN 10 THEN 'ACCOUNTING'
        WHEN 20 THEN 'RESEARCH'
        ELSE 'OTHERS'
    END DNAME FROM emp ORDER BY deptno
    
    
-- 그룹 함수: 하나 이상의 데이터를 그룹으로 묶어서 연산 등을 수행, 하나의 결과로 처리
-- SUM() 숫자 데이터 합계 구하는 함수
SELECT SUM(sal)
    , SUM(comm)      -- SUM() 함수는 null 널값은 제외하고 합산함
--    ,SUM(comm, NULL) 이건 오류남. 대신 comm+NULL은 NULL로 출력됨
    , SUM(sal+comm)  -- 이 경우, comm이 널이 아닌 경우의 직원 sal만 합한다
    , SUM(sal + NVL(comm,0))    -- 널값이 행에 포함되어있다면 널 변환 후 그룹함수 사용 필요.
    FROM emp;

SELECT deptno, SUM(sal) FROM emp GROUP BY deptno;

-- AVG() 평균 구하는 함수
SELECT ROUND(AVG(sal))
    , AVG(comm)
    , ROUND(AVG(NVL(comm,0)))
    , ROUND(AVG(sal + comm))
    , ROUND(AVG(sal + NVL(comm,0)))
    FROM emp;


-- MAX() MIN() 최대 최소 구하는 함수
--SELECT ename, MAX(sal) FROM emp;  -- 에러 발생. 일반 컬럼과 그룹함수 같이 사용 불가
SELECT MAX(sal) FROM emp;
SELECT MAX(hiredate) FROM emp;  -- 날짜도 가능. 연도가 가장 큰 숫자로 나옴.
SELECT ename FROM emp ORDER BY ename DESC;
SELECT MAX(ename) FROM emp;

SELECT MIN(sal) FROM emp;
SELECT MIN(hiredate) FROM emp;
SELECT ename FROM emp ORDER BY ename DESC;
SELECT MIN(ename) FROM emp;

-- 그룹함수들은 같이 사용 가능
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) FROM emp;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal) FROM emp WHERE deptno = 10;
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal), deptno FROM emp GROUP BY deptno ;        -- GROUP BY 활용하면 컬럼 & 그룹함수 같이 사용 가능
SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal), deptno FROM emp GROUP BY deptno ORDER BY deptno;

-- COUNT() 총 데이터 개수 구하는 함수
SELECT COUNT(sal) FROM emp;
SELECT COUNT(comm) FROM emp;        -- 널 비포함
SELECT COUNT(job) FROM emp;         -- 이 경우 중복행 포함됨
SELECT COUNT(DISTINCT job) FROM emp; -- 중복 비포함 카운트 가능

SELECT ename, job
    , SUM(sal)
    , AVG(sal + NVL(comm,0))
    , AVG(sal)
    , MAX(sal)
    , MIN(sal)
    FROM emp GROUP BY ename, job ORDER BY job;
    
SELECT deptno
    , COUNT(deptno)
    , COUNT(comm)
    FROM emp GROUP BY deptno;


-- HAVING 조건절 : 그룹의 결과를 제한할 때 (WHERE 대신)
SELECT deptno, ROUND(AVG(sal)) FROM emp GROUP BY deptno ORDER BY AVG(sal);
SELECT deptno, ROUND(AVG(sal)) FROM emp GROUP BY deptno HAVING ROUND(AVG(sal)) >= 2000;
SELECT deptno, MAX(sal) FROM emp GROUP BY deptno HAVING MAX(sal) >= 2900;

SELECT * FROM DUAL;
SELECT * FROM emp;