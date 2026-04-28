-- ROWNUM 로우넘 컬럼 (테이블에 저장된 고정값이 아닌! 검색 결과에 임시로 붙여주는 번호). 페이징 처리 용도로 씀
-- 1. 데이터 검색 순서를 갖고 있는 논리적인 컬럼
-- 2. 로우넘 값은 1번부터 시작하고, 해당 값은 ORDER BY 정렬해도 값이 바뀌지 않음
--    (단, WHERE 조건으로 결과 행이 달라지면 해당 결과 기준으로 다시 번호 부여됨)
-- 3. 로우넘은 검색 결과에 임시로 붙는 번호이므로, 검색 조건이 바뀌면 결과 집합이 바뀌고 로우넘도 바뀜
--    (테이블 자체의 저장 순서를 바꾸려면 테이블을 변경해야함)

SELECT * FROM dept;
SELECT ROWNUM, ROWID, deptno, dname, loc FROM dept; -- 로우넘도 로우아이디도 이미 만들어져있는 시스템의 컬럼(아이디는 고유번호)
SELECT ROWNUM, ename, sal FROM emp;
SELECT ROWNUM, ename, sal FROM emp WHERE ename = 'SCOTT';  -- 이 경우 로우넘은 1로 변경됨(스콧은 원래 로우넘 8)

SELECT ROWNUM, ename, sal FROM emp;
SELECT ROWNUM, ename, sal FROM emp ORDER BY sal DESC;   -- 정렬해도 로우넘은 바뀌지 않음



-- 사원 테이블에서 입사일 빠른 사원 5명 구하기
-- 먼저 정렬로 확인하고
SELECT empno, ename, hiredate FROM emp ORDER BY hiredate;
-- 뷰 생성하기
CREATE OR REPLACE VIEW hiredate_view
    AS
    SELECT empno, ename, hiredate FROM emp ORDER BY hiredate;
-- 로우넘 포함해서 출력
SELECT ROWNUM, ename, hiredate FROM hiredate_view;
SELECT ROWNUM, ename, hiredate FROM hiredate_view WHERE ROWNUM <=5;

-- 이걸 인라인 뷰(서브쿼리로 만들어진 뷰) 활용해서 만들 경우
SELECT ROWNUM, ename, hiredate
FROM (
    SELECT empno, ename, hiredate
    FROM emp
    ORDER BY hiredate
    )
WHERE ROWNUM <= 5;



-- 사원 테이블에서 사원번호 빠른 사원 5명 구하기
SELECT ROWNUM, empno, ename
FROM (
    SELECT empno, ename
    FROM emp
    ORDER BY empno
    )
WHERE ROWNUM <= 5;


-- 사원 테이블에서 급여 많은 사원 5명 구하기(높은 급여->낮은 급여)
SELECT ROWNUM, sal, ename
FROM (
    SELECT sal, ename
    FROM emp
    ORDER BY sal DESC
    )
WHERE ROWNUM <= 5;


-- 사원 테이블에서 급여를 많이 받는 사원 3번째에서 5번째까지 구하기: 서브쿼리 2번 써야함
/*
    SELECT ROWNUM, sal, ename
    FROM (
        SELECT sal, ename
        FROM emp
        ORDER BY sal DESC
        )
    WHERE ROWNUM BETWEEN 3 AND 5;      -- 이렇게 하면 데이터가 아무것도 안나옴(오류는 아니지만 출력데이터 행도 없음)
*/

-- 서브쿼리를 2번 사용하는 형태: ROWNUM을 rnum으로 확정시키고 바깥에서 조건 걸기
SELECT ROWNUM, rnum, sal, ename        -- 출력본으로 보면 로우넘과 r넘 차이 확인 가능
FROM (
    SELECT ROWNUM AS rnum, sal, ename  -- ← 2번째 인라인뷰: ROWNUM을 rnum으로 확정(로우넘이 이미 정렬버전으로 확정됐으니 뒤죽박죽 될 일 없음)
    FROM (
        SELECT sal, ename              -- ← 1번째 인라인뷰: 정렬 먼저(로우넘을 먼저 해버리면 로우넘은 정렬로 번호 수정이 안되니까)
        FROM emp                       -- 페이징 처리에서 조건이 많을 경우, 안쪽 1번째 인라인뷰에서 정렬 먼저 시킴(where절도 가능)
        ORDER BY sal DESC
    )
)
WHERE rnum BETWEEN 3 AND 5;           -- ← rnum은 이미 확정된 값이라 BETWEEN 가능














