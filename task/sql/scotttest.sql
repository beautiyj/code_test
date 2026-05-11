--사원 테이블(EMP)에서 
--SCOTT의 급여보다 적게 받는 사원의 이름, 급여를
--출력하는 SQL문을 작성하시오? (10점)

SELECT * FROM emp order by sal;

SELECT ename, sal
FROM emp
WHERE sal < ANY (SELECT SAL
                 FROM emp
                 WHERE ename = 'SCOTT');
                 
--사원 테이블(EMP)에서 각 부서번호별 평균 급여를 구하는 SQL문을 작성하시오? (10점)                 
SELECT * FROM emp;

SELECT AVG(sal), deptno
FROM emp
GROUP BY deptno;

--사원테이블(EMP)에서  사원명에 A가 포함된 사원을 검색하는 SQL문을 작성하시오? (10점)
SELECT * FROM emp
WHERE ename LIKE '%A%';

--[문항4]  사원테이블(EMP)에서 급여를 많이 받는 사원  5명을 구하는 SQL문을 인라인뷰로 작성하시오? (10점)
SELECT ROWNUM, sal, ename
FROM (
    SELECT sal, ename
    FROM emp
    ORDER BY sal DESC
    )
WHERE ROWNUM <= 5;


--문항5]  사원테이블(EMP)에서 82년도에 입사한 모든 사원의 정보를 출력하는 SQL문을 작성하시오? (10점)
SELECT ename, hiredate
FROM emp
WHERE hiredate BETWEEN '82/01/01' AND '82/12/31';


--사원테이블(EMP)에서 사번, 이름, 급여, 연봉을 조회하는 SQL문장을 작성하시오? (10점)
--단, 연봉은 별칭을 사용하고, comm이 null값인 경우에는 0으로 연산 처리하시오.
SELECT empno, ename, sal, sal * 12 + NVL(comm,0)
AS 연봉
FROM emp;


SELECT * FROM TAB;
DROP table book PURGE;
DROP table customer2 PURGE;
DROP table orders PURGE;

CREATE TABLE book(
    bookid      NUMBER(2),
    bookname    VARCHAR2(40),
    publisher   VARCHAR2(40),
    price       NUMBER(8),
    
    CONSTRAINT pk_book_bookid PRIMARY KEY (bookid)
);

CREATE TABLE customer2(
    custid      NUMBER(2),
    name        VARCHAR2(40),
    address     VARCHAR2(50),
    phone       VARCHAR2(20),
    
    CONSTRAINT pk_customer_custid PRIMARY KEY (custid)
);

CREATE TABLE orders(
    orderid     NUMBER(2),
    custid      NUMBER(2),
    bookid      NUMBER(2),
    saleprice   NUMBER(8),
    orderdate   DATE,
    
    CONSTRAINT pk_orders_orderid PRIMARY KEY (orderid),
    CONSTRAINT fk_orders_custid FOREIGN KEY (custid) REFERENCES customer2(custid),
    CONSTRAINT fk_orders_bookid FOREIGN KEY (bookid) REFERENCES book(bookid)

);



