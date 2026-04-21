-- LIKE 와 % _ 와일드카드. LIKE연산자의 경우 숫자도 ''로 적용해서 사용 가능하나(문자취급)
-- 성능면에서 숫자 사용은 그닥 좋지 않아서 문자열 위주로만 사용함
SELECT * FROM emp;
SELECT * FROM emp WHERE ename LIKE 'F%';    -- F로 시작하는 데이터만 조회
SELECT * FROM emp WHERE ename LIKE '%S';    -- S로 끝나는 데이터만 조회
SELECT * FROM emp WHERE ename LIKE '%L%';   -- 위치와 상관 없이 L 포함되는 모든 데이터
SELECT * FROM emp WHERE ename LIKE 'A_';    -- A로 시작하는 딱 2글자
SELECT * FROM emp WHERE ename LIKE '___L%'; -- 4번째 글자가 L인 데이터
SELECT * FROM emp WHERE ename LIKE '_LL%';  -- 2,3번째 글자가 L인 데이터
SELECT * FROM emp WHERE ename LIKE '%LL%';  -- LL이 연달아 붙어서 들어있는 데이터
SELECT * FROM emp WHERE ename LIKE '_L%K%'; -- 2번째 글자가 L이고 이름에 K가 들어있는 데이터
SELECT * FROM emp WHERE ename LIKE '_A%';   -- 2번째 글자가 A인 데이터
SELECT * FROM emp WHERE ename LIKE '_____'; -- 이름이 5글자인 데이터

SELECT * FROM emp WHERE ename LIKE '%N';
SELECT * FROM emp WHERE ename LIKE '%n';    -- 데이터는 대소문자 구분함!
SELECT * FROM emp WHERE ename LIKE '%A%';
SELECT * FROM emp WHERE ename NOT LIKE '%A%';
SELECT * FROM emp WHERE comm IS NULL;
SELECT * FROM emp WHERE comm IS NOT NULL;  

-- & 특정 데이터가 있는지 빠르게 확인 (검색창 역할) && 보고서나 테스트용 (반복 작업), 자바 프로그래밍 전 로직 테스트
-- SELECT * FROM emp WHERE ename = '&name'     -- 팝업 뜨면 안에 특정 데이터 입력해서 검색 가능함                                            
-- &&name 로 쓰면 재사용되는거라 다음 쿼리에서도 팝업입력된 데이터 매칭됨. 이 경우 UNDEFINE name;로 해제 후 새 데이터 입력 가능

-- 오름차순 정렬은 문자:ABC사전순, 날짜는 빠른 날짜순 정렬 내림차순은 반대.
-- NULL의 경우 오름차순에선 널값 가장 마지막, 내림차순에선 가장 먼저 출력됨
SELECT * FROM emp ORDER BY sal ASC;
SELECT * FROM emp ORDER BY sal;         -- 기본 정렬은 오름차순
SELECT * FROM emp ORDER BY sal DESC;
SELECT * FROM emp ORDER BY ename ASC;
SELECT * FROM emp ORDER BY sal, ename ASC;  -- sal을 첫번째 기준으로, 중복이 있는 건 2번째 ename을 기준으로 오름차순
                                            -- 보통 댓글 게시판을 만드는 경우 활용함(여러 조건 정렬)
SELECT * FROM emp ORDER BY comm ASC;    -- NULL 널값 포함 오름차순
SELECT * FROM emp ORDER BY mgr ASC;     -- NULL 널값 포함 오름차순(널이 가장 마지막)
SELECT * FROM emp ORDER BY sal ASC;
SELECT * FROM emp ORDER BY hiredate ASC; -- 빠른 날짜부터 정렬
SELECT * FROM emp ORDER BY hiredate DESC;
SELECT * FROM emp ORDER BY sal DESC, ename ASC; -- sal 은 내림차순, ename은 오름차순으로 진행할 경우
SELECT * FROM emp ORDER BY hiredate ASC, ename DESC;    -- 입사일 오름차순(빠른,이른순) 이름 SELECT * FROM emp
SELECT * FROM emp ORDER BY deptno ASC, hiredate DESC;

