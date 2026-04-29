/*  -- 0428 SQL 과제
    
    Q1. 전산실에 새로 입사한 사원에게 새로운 계정을 생성해 주려고
            합니다. 아래의 요구 사항을 만족하는 SQL문을 각각 작성 하세요 ?
    [요구1] USER명 : woman, 패스워드 : tiger
    [요구2] CREATE SESSION 이라는 시스템 권한을 부여해 줍니다.
            (단, 또 다른 유저에게도 권한을 줄 수 있도록 한다.)
    [요구3] woman유저에게 connect, resource, dba 권한을 부여합니다.
    
    Q2. user1 계정을 생성 하세요? (비밀번호: tiger)
    
    Q3. user1 계정에게 오라클 데이터 베이스에 접속해서, 테이블을
        생성할 수 있는 권한을 부여하시오.(user1계정에게 롤을 부여한다.)
*/



-- Q1
-- DBA 계정에서 실행

-- woman/tiger 계정 생성하기
CREATE USER woman IDENTIFIED BY tiger;

-- CREATE SESSION, connect, resource, dba 권한, WITH ADMIN OPTION(임시관리자 권한) 부여하기
GRANT CREATE SESSION, CONNECT, RESOURCE, DBA
TO woman
WITH ADMIN OPTION;


-- Q2
-- DBA 계정에서 실행
CREATE USER user1 IDENTIFIED BY tiger;


-- Q3
-- DBA 계정에서 실행
CREATE ROLE mrole;      -- 커넥트, 리소스, 세션, 테이블만 부여해도 무방함(롤안써도)
GRANT CREATE TABLE TO mrole;
GRANT mrole TO user1;





