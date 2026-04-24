SELECT * FROM emp05;
SELECT * FROM dept01;
DESC dept;
DESC emp;
--DROP TABLE 테이블명 PURGE;  -- 테이블 완전삭제용 코드


-- 이게 단일행 서브쿼리
SELECT dname        -- 이건 메인쿼리
FROM dept
WHERE deptno = ( SELECT deptno      -- 괄호 내의 내용은 서브쿼리. 값을 모를 때 서브쿼리로 조건 찾는 용도
                 FROM emp           -- 조인은 다른 테이블 컬럼을 셀렉트에 추가하고 싶을 때 쓰는 거고
                 WHERE ename = 'SCOTT' );
                 
-- 다중행 서브쿼리: 결과가 2개 이상 구해지는 쿼리문을 서브 쿼리로 기술할 경우에는 다중행 연산자와 함께 사용해야함
-- 메인쿼리의 WHERE 조건절에서 다중행 연산자 사용하기, 다중행 연산자는 IN, ANY, SOME, ALL, EXIST 등이 존재
SELECT MAX(sal), deptno FROM emp GROUP BY deptno;   -- 각 부서별로 최고급여 받는 사람 구하는 조건은 하나

-- 다중행 서브쿼리가 필요할 때: 급여 3000 이상 받는 사람과 해당 부서 사람들의 정보 조건 두 가지 충족해서 출력하기 
-- IN 연산자: 서브쿼리의 검색 결과 중에서 하나라도 일치되면 참(출력) + 비교연산자 사용 불가(문법오류)
SELECT sal, deptno, ename
    FROM emp
    WHERE deptno IN ( SELECT deptno
                     FROM emp
                     WHERE sal >= 3000 );

-- 30번 부서에 소속된 사원 중 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 타 부서 사원의 이름, 급여 출력
-- ALL 연산자: 메인 쿼리의 비교 조건이 서브쿼리 검색 결과와 모든 값이 일치되면 참(출력)
SELECT ename, sal       -- 단일행 서브쿼리로 구할 경우
    FROM emp
    WHERE sal > (SELECT MAX(sal)
                 FROM emp
                 WHERE deptno = 30);
                 
                 
SELECT ename, sal       -- 다중행 서브쿼리로 구할 경우
    FROM emp
    WHERE sal > ALL(SELECT sal      -- 서브쿼리 결과 전부보다 크다 = 그 중 MAX보다 크다 와 같은 의미!
                    FROM emp
                    WHERE deptno = 30);
                    

/*  ALL, ANY, MAX, NIN 연산자는 이런 의미임
    연산자     의미          동일한 표현
    > ALL   전부보다 크다     > MAX
    < ALL   전부보다 작다     < MIN
    > ANY   하나라도 크다     > MIN
    < ANY   하나라도 작다     < MAX

*/
            
-- ANY 연산자: 메인쿼리의 비교 조건이 서브쿼리의 검색 결과와 하나 이상 일치되면 참
-- 부서 번호가 30인 사원들의 급여 중 가장 낮은 급여보다 더 많은 급여를 받는 사원명 급여 출력
SELECT ename, sal           -- 단일행 서브쿼리로 하면
    FROM emp
    WHERE sal > ( SELECT MIN(sal)
                    FROM emp
                    WHERE deptno = 30);   
                    
SELECT ename, sal           -- ANY 연산자 활용한 다중행 서브쿼리의 경우
    FROM emp
    WHERE sal > ANY( SELECT sal         -- > ANY는 하나라도 크면 전부 출력 = 하나라도 MIN보다 크다
                    FROM emp
                    WHERE deptno = 30);                    



SELECT FROM WHERE ( SELECT
                    FROM
                    WHERE );

SELECT FROM WHERE ( SELECT
                    FROM
                    WHERE );

SELECT FROM WHERE ( SELECT
                    FROM
                    WHERE );
                                                                                                              