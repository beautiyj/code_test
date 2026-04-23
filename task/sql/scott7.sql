SELECT * FROM emp;
SELECT * FROM dept;

-- 서브쿼리
SELECT dname        -- 이건 메인쿼리
FROM dept
WHERE deptno = ( SELECT deptno      -- 괄호 내의 내용은 서브쿼리. 값을 모를 때 서브쿼리로 조건 찾는 용도
                 FROM emp           -- 조인은 다른 테이블 컬럼을 셀렉트에 추가하고 싶을 때 쓰는 거고
                 WHERE ename = 'SCOTT' );
-- 서브쿼리가 없으면 2번 구해야함 (조건을 deptno = 20 조건을 모르니까)
SELECT deptno FROM emp WHERE ename = 'SCOTT';
SELECT dname FROM dept WHERE deptno = 20;
-- 조인으로 구해도 한줄로 가능
SELECT dname
    FROM emp e
    JOIN dept d ON e.deptno = d.deptno
    WHERE e.ename = 'SCOTT';


-- 단일행 서브쿼리: 서브쿼리의 검색 결과가 1개만 반환되는 쿼리. 메인 쿼리의 WHERE 조건절에서 비교 연산자 활용 가능.
SELECT ename, hiredate
    FROM emp
    WHERE hiredate = ( SELECT MAX(hiredate)
                       FROM emp);
    
SELECT ename, sal
    FROM emp
    WHERE sal = ( SELECT MAX(sal)
                  FROM emp);

-- 직속 상사가 king인 직원명과 급여
SELECT ename, sal
    FROM emp
    WHERE mgr = ( SELECT empno
                  FROM emp
                  WHERE ename = 'KING' );
                  
-- 260423 과제
-- Q1. 직급이 MANAGER인 사원의 이름, 부서명을 출력하는 SQL문을 작성 (JOIN을 사용하여 처리)
SELECT e.ename, e.deptno, d.dname, e.job
    FROM emp e
    JOIN dept d ON e.deptno = d.deptno
    WHERE e.job = 'MANAGER';


-- Q2. 매니저가 KING 인 사원들의 이름과 직급을 출력하는 SQL문 작성
SELECT ename, job, mgr
    FROM emp
    WHERE mgr = ( SELECT empno
                    FROM emp
                    WHERE ename = 'KING');


-- Q3. SCOTT과 동일한 근무지에서 근무하는 사원의 이름을 출력하는 SQL문 작성
SELECT e.ename, d.loc, e.deptno
    FROM emp e
    JOIN dept d ON e.deptno = d.deptno
    WHERE e.deptno = ( SELECT deptno
                       FROM emp
                       WHERE ename = 'SCOTT');

