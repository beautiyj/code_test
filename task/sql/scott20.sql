-- 롤 : 사용자에게 보다 효율적으로 권한을 부여할 수 있도록 여러 개의 권한을 묶어 놓은 것이

-- 오라클에서 기본적으로 제공되는 롤
    -- CONNECT롤 커넥트롤은 8가지 권한 ALTER SESSION, CREATE CLUSTER, CREATE DATABASE LINK,
    -- CREATE SEQUENCE, CREATE SESSION, CREATE SYNONYM, CREATE TABLE, CREATE VIEW

    -- RESOURCE롤 리소스롤은 20여가지 권한
    
    -- DBA롤 데이터베이스관리자롤은 130여가지 권한
    
/* 시스템 계정으로 명령어 실행하기
CREATE USER user04 IDENTIFIED BY tiger;
SELECT * FROM dba_users;
GRANT CONNECT, RESOURCE TO user04; */


-- 콘솔에서 유저04로 로그인 후 생성하면 됨
CONN user04/tiger
SHOW USER;
CREATE TABLE member(
    id     VARCHAR2(20),
    passwd VARCHAR2(20) );
    
-- ================================================================================================
    
-- 이건 DBA계정에서 진행 필요
-- 사용자 정의 롤 생성 : 롤에 시스템 권한을 부여
-- 1. 롤 생성
CREATE ROLE mrole;

-- 2. 생성된 롤에 시스템 권한을 추가한다.
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW TO mrole;

-- 3. mrole을 적용하기 위한 계정 생성 : user05 / tiger
CREATE USER user05 IDENTIFIED BY tiger;

-- 4. user05 계정에게 mrole을 부여한다.
GRANT mrole TO user05;

-- 5. user05 계정으로 접속 해보자?
-- sqlplus user05/tiger (콘솔에서 혹은 디벨로퍼는 접속연결 후)
-- CONN user05/tiger

------------------------------------------------------------------------------------------------------------------------------

-- DBA, SCOTT 계정 각기 다르게 명령어 존재함 CONN에 해당하는 걸로 실행하기!
-- 사용자 정의 롤 생성 : 롤에 객체 권한을 부여
-- 1. 롤 생성
CONN system/oracle
CREATE ROLE mrole02;

-- 2. 생성된 롤에 객체 권한을 부여한다.
CONN scott/tiger
GRANT SELECT ON emp TO mrole02;

-- 3. user05 계정에게 mrole02 를 부여한다.
CONN system/oracle
GRANT mrole02 TO user05;

-- 4. user05 계정으로 접속 후에 검색을 해보자?
CONN user05/tiger
SELECT * FROM scott.emp;        -- 재접속하면 콘솔에서 잘 출력됨

---------------------------------------------------------------------------------------------------------------------------------

-- 롤 회수 : 특정 계정에게 부여된 롤을 취소 하는 것.
-- 형식 : REVOKE 롤이름 FROM 사용자명;

-- Q. user05 계정에게 부여된 mrole과 mrole02를 회수 해보자?
CONN system/oracle
REVOKE mrole FROM user05;
REVOKE mrole02 FROM user05;

-- 롤 삭제
-- 형식 : DROP ROLE 롤이름;
CONN system/oracle
DROP ROLE mrole;
DROP ROLE mrole02;

------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 디폴트 롤을 생성해서 여러 사용자에게 롤 부여하기
-- 디폴트 롤 = 시스템 권한 + 객체 권한

-- 1. 디폴트 롤 생성
CONN system/oracle
CREATE ROLE def_role;

-- 2. 생성된 롤(def_role)에 시스템 권한을 추가
CONN system/oracle
GRANT CREATE SESSION, CREATE TABLE TO def_role;

-- 3. 생성된 롤(def_role)에 객체 권한을 추가
CONN scott/tiger
GRANT SELECT ON emp TO def_role;
GRANT UPDATE ON emp TO def_role;
GRANT DELETE ON emp TO def_role;

-- 4. 롤을 적용하기 위한 일반 계정 생성
CONN system/oracle
CREATE USER usera1 IDENTIFIED BY tiger;
CREATE USER usera2 IDENTIFIED BY tiger;
CREATE USER usera3 IDENTIFIED BY tiger;

-- 5. def_role을 생성된 계정에게 부여하기
CONN system/oracle
GRANT def_role TO usera1;
GRANT def_role TO usera2;
GRANT def_role TO usera3;

-- 6. usera1 계정으로 접속후에 검색을 해보자?
CONN usera1/tiger
-- CONN usera2/tiger
-- CONN usera3/tiger

SELECT * FROM scott.emp;       --- 콘솔이나 데베 접속 연결 후 진행하기. 검색 조회 출력 가능



