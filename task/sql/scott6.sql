SELECT * FROM DUAL;
SELECT * FROM emp;

-- JOIN 조인은 2개 이상의 테이블을 결합해서 정보를 구하는 것. 크로스조인, 이너조인(이퀴조인, 논이퀴조인), 아우터조인, 셀프조인.
-- 조인은 공통의 컬럼이 존재해야 활용 가능하다(크로스조인은 조건 없으니 예외)
-- CROSS JOIN 크로스 조인의 경우: 조인 조건 없이 모든 행을 곱한 결과
SELECT * FROM emp, dept;        -- 이 경우 56가지 중복 데이터까지 나옴



-- EQUI JOIN 이퀴 조인의 경우: = 조건으로 연결 (같은 값끼리 매칭). 이퀴 조인이 가장 많이 쓰이는 조인.
SELECT * FROM emp, dept WHERE emp.deptno = dept.deptno;     -- 조인 정석. 사원테이블과 부서테이블에서 넘버링 동일한 데이터만 뽑기
SELECT * FROM emp JOIN dept ON emp.deptno = dept.deptno;    -- 명시적 조인 활용

-- SCOTT 사원이 소속된 부서명을 출력하는 방법
SELECT deptno FROM emp WHERE ename = 'SCOTT';
SELECT dname FROM dept WHERE deptno = 20;

-- 조인 활용하면 한줄로 가능. 만약 공통컬럼을 출력하려면 중복된 컬럼이라서 반드시 앞에 테이블명을 기입해야함
SELECT * FROM emp
    JOIN dept ON emp.deptno = dept.deptno WHERE ename = 'SCOTT';
SELECT emp.deptno, dname, ename
    FROM emp JOIN dept ON emp.deptno = dept.deptno
    WHERE ename = 'SCOTT';
SELECT emp.deptno, dname, ename
    FROM emp JOIN dept ON emp.deptno = dept.deptno AND ename = 'SCOTT';
    
SELECT e.deptno, dname, ename   -- 공통컬럼 외 컬럼들은 별칭 생략 가능.
    FROM emp e JOIN dept D ON e.deptno = d.deptno
    WHERE e.ename = 'SCOTT'; -- 별칭 앨리아스 대소문자 구분X, 별칭 사용 시 테이블명 무조건 별칭으로 사용!

SELECT e.deptno, d.dname, e.ename
    FROM emp e JOIN dept d ON e.deptno = d.deptno
    WHERE e.ename = 'SCOTT'; -- 실무 권장. 별칭 사용 시 WHERE 조건절 뒤는 별칭 없어도 출력 가능하나, 관례 상 붙여준다.




-- NON-EQUI JOIN 논 이퀴 조인의 경우:  BETWEEN, >, <, AND 등 범위 조건으로 연결
-- 공통 컬럼은 없으나 sal 급여와 salgrade 급여등급은 유사점이 있어서 조건 충족...암튼 다른 조건으로 연결하는 조인
-- 실제로는 조건 맞추기 어려워서 잘 안쓴다
SELECT * FROM salgrade;
SELECT * FROM emp
    JOIN salgrade ON emp.sal
    BETWEEN salgrade.losal AND salgrade.hisal;
    
SELECT ename, sal, grade
    FROM emp JOIN salgrade ON emp.sal
    BETWEEN salgrade.losal AND salgrade.hisal;
    
SELECT ename, sal, grade
    FROM emp, salgrade
    WHERE sal >= losal AND sal <= hisal;
    
SELECT e.ename, e.sal, s.grade
    FROM emp e JOIN salgrade s ON e.sal
    BETWEEN s.losal AND s.hisal;



-- SELF JOIN 셀프 조인의 경우:  같은 테이블을 두 번 조인 (별칭 필수!) 마찬가지로 조건 맞추기 어려워서 잘 안쓴다
SELECT * FROM emp;
SELECT e.ename AS 사원, m.ename AS 상사     -- 사원의 이름과 그 사원의 상사 이름을 함께 출력
    FROM emp e
    JOIN emp m ON e.mgr = m.empno;
    
SELECT e.ename AS 사원, m.ename AS 상사, m.job AS 상사직급
    FROM emp e
    JOIN emp m ON e.mgr = m.empno;      -- 조인에서는 조건식 자료형이 동일해야한다(숫자-문자 불가, 숫자-숫자 가능 etc)
    
SELECT e.ename || '의 직속 상사는 ' || m.ename
    FROM emp e
    JOIN emp m ON e.mgr = m.empno;      -- mgr컬럼이 null인 경우 데이터 출력되지 않음

SELECT e.ename || '의 직속 상사는 ' || NVL(m.ename, '없음(최고직급)')
FROM emp e
LEFT JOIN emp m ON e.mgr = m.empno;


-- OUTER JOIN 아우터 조인의 경우 래프트아우터조인, 라이트아우터조인, 풀아우터조인 있음. 이퀴 조인 다음으로 많이 쓰임
-- LEFT OUTER JOIN 래프트 아우터조인은 왼쪽 테이블 전부 + 오른쪽 매칭된 것만
-- RIGHT OUTER JOIN : 오른쪽 테이블 전부 + 왼쪽 매칭된 것만
-- FULL OUTER JOIN : 양쪽 전부 출력.
-- 이너조인은 매칭 안되면 버림, 아우터조인은 매칭 안돼도 NULL로 채워서 출력
SELECT e.ename || '의 직속 상사는 ' || m.ename
    FROM emp e, emp m
    WHERE e.mgr = m.empno(+);   -- 이건 오라클 전용 구문(+) 형태라서 잘 안씀
    
SELECT e.ename || '의 직속 상사는 ' || m.ename
    FROM emp e
    LEFT JOIN emp m ON e.mgr = m.empno; -- 실무 및 관례 상 서식은 조인명 추가

SELECT * FROM emp
    FULL OUTER JOIN dept ON emp.deptno = dept.deptno;       -- 아우터 조인을 활용하면 DEPTNO 40 값도 출력된다(직원없는부서)

SELECT e.ename, d.deptno, d.dname       -- 만약 기준을 e.deptno로 잡는다면 결과가 null.
    FROM emp e
    FULL OUTER JOIN dept d ON e.deptno = d.deptno;
    
SELECT ename, dname
    FROM emp
    RIGHT JOIN dept ON emp.deptno = dept.deptno;    
    /*
    조인 종류       SELECT      40번 출력      deptno값
    LEFT JOIN      e.deptno   ❌ 행 자체 없음     -
    LEFT JOIN      d.deptno   ❌ 행 자체 없음     -
    RIGHT JOIN     e.deptno   ⚠️ 있지만 NULL     NULL
    RIGHT JOIN     d.deptno   ✅ 정상 출력       40    
    FULL OUTER     e.deptno   ⚠️ 있지만 NULL     NULL
    FULL OUTER     d.deptno   ✅ 정상 출력       40
    */



 -- ANSI JOIN: 공통적으로 해당되는 표준 SQL 조인
SELECT * FROM emp CROSS JOIN dept;
/* -- ANSI INNER JOIN: 표준 SQL조인은 ON 사용
SELECT * FROM table1                 SELECT * FROM emp      JOIN ON 형태가 안씨이너조인 형태임
INNER JOIN table2                    JOIN dept              WHERE = BETWEEN는 오라클전용
ON table1.column1 = table2.column2   ON emp.deptno = dept.deptno; */
SELECT e.ename, d.dname, d.deptno
    FROM emp e
    JOIN dept d
    ON e.deptno = d.deptno
    WHERE e.ename = 'SCOTT';        -- 웨어절 있어도 ANSI JOIN
    
-- ANSI JOIN에서 USING 사용하면 앨리아스는 사용 불가함(사용빈도 적은 편)
SELECT ename, dname, deptno
    FROM emp
    JOIN dept
    USING(deptno)           -- 대신 공통 조건을 간략하게 표현 가능
    WHERE ename = 'SCOTT';

/* -- NATURAL JOIN 내추럴 조인: 두 테이블에 각각 조인을 정의한 컬럼의 이름이 동일하다면
      USING 절에서 조인할 컬럼을 지정하여 구문을 더 간단하게 표현할 수 있다
SELECT *                     SELECT EMP.ENAME, DEPT.DNAME 
    FROM table1              FROM EMP
    NATURAL JOIN table2      NATURAL JOIN DEPT; */

/* -- ANSI Outer Join: 안씨 아우터 조인.
    어느 한쪽 테이블에는 해당하는 데이터가 존재하는데 다른 쪽 테이블에는 데이터가 존재하지 않을 경우
    데이터가 출력되지 않는 문제점을 해결하기 위해 사용하는  조인
SELECT * FROM table1                            SELECT * FROM emp
    [LEFT | RIGHT | FULL] Outer Join table2     RIGHT OUTER JOIN dept on emp.deptno = dept.deptno;
*/    -- 연습용 테이블 생성하기
CREATE TABLE dept01(deptno number(2), dname VARCHAR2(14));
INSERT INTO dept01 VALUES(10, 'ACCOUNTING');
INSERT INTO dept01 VALUES(20, 'RESEARCH');
SELECT * FROM dept01;
CREATE TABLE dept02(deptno number(2), dname VARCHAR2(14));
INSERT INTO dept02 VALUES(10, 'ACCOUNTING');
INSERT INTO dept02 VALUES(30, 'SALES');
SELECT * FROM dept02;

SELECT * FROM dept01
    LEFT OUTER JOIN dept02
    USING(deptno);
SELECT * FROM dept01
    RIGHT OUTER JOIN dept02
    USING(deptno);    
SELECT * FROM dept01
    FULL OUTER JOIN dept02
    USING(deptno);


SELECT * FROM emp e
    FULL OUTER JOIN dept d
    ON e.deptno = d.deptno;

