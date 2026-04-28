-- 데이터베이스 사용자 관리 시스템관리자버전
-- 객체 권한 예제는 SCOTT19.SQL 파일에 있음


-- 데이터베이스 보안을 위한 권한

-- 1. 시스템 권한: 데이터베이스 관리자 DBA의 권한
--    CREATE USER, DROP USER 등이 대표적인 예시.
--    시스템 관리자가 일반 사용자에게 부여해야하는 권한
--    ㄴ EX) CREATE SESSION 데이터베이스 접속 권한
--           CREATE TABLE/VIEW/SEQUENCE/PROCEDURE(프로시저) 생성 권한

-- 2. 객체 권한: 오라클의 객체 권한.
--    오라클의 객체는 테이블 뷰 시퀀스 인덱스 동의어 프로시저 트리거 등등

 



-- 시스템 권한 예시
/*  -- 시스템관리자에서 사용자 계정 생성하기
    CREATE USER user_name
    IDENTIFIED BY password;
*/
CREATE USER USER01 IDENTIFIED BY TIGER;
SELECT * FROM dba_users;        -- 조회하면 유저01 계정 생성된 거 확인 가능!

/*  -- 시스템관리자에서 사용자에게 시스템 권한 부여하기(권한 부여하려면 DBA계정 접속 필수)
    GRANT privilege_name, …
    TO user_name;
*/
GRANT CREATE SESSION        -- 유저01 계정에 데이터베이스 접속 권한 부여
TO USER01;
GRANT CREATE SESSION, CREATE TABLE 
TO USER01;


-- WITH ADMIN OPTION 옵션: 사용자에게 시스템 권한을 WITH ADMIN OPTION 사용해서 부여하면
-- 해당 유저는 DBA 아니어도 부여받은 시스템 권한을 타 유저에게도 재부여 가능(임시 DBA 권한 생성되는 개념)
CREATE USER USER02 IDENTIFIED BY TIGER;
SELECT * FROM dba_users;

GRANT CREATE SESSION
TO USER02
WITH ADMIN OPTION;
CREATE USER USER03 IDENTIFIED BY TIGER;

/*  SQLPLUS 콘솔창에서
    CONN USER02/tiger
    SHOW USER
    GRANT CREATE SESSION TO USER03 입력 시 권한 부여됨
    SQL디벨로퍼에서 데이터베이스 접속용 계정 연결하면 여기서 가능한데, 번거로우니 테스트는 콘솔 추천
    유저03 계정은 유저02에게 권한 부여받아서 이제 데이터베이스 접속 가능.
    이 방법보단 롤 형태로 자주 활용함
*/



-- 객체 권한 예시
/*
    GRANT privilege_name [(column_name)] | ALL
    ON object_name | role_name | PUBLIC
    TO user_name;
*/

