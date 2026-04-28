-- 비공개 동의어 예
-- 1. system 계정으로 접속후 테이블 생성
CONN system/oracle
CREATE TABLE systbl ( ename VARCHAR2(20) );

-- 2. 생성된 테이블에 데이터 입력
CONN system/oracle
INSERT INTO systbl VALUES('홍길동');
INSERT INTO systbl VALUES('안화수');

SELECT * FROM systbl;

-- 3. scott 계정에게 systbl 테이블에 대한 SELECT 객체 권한을 부여한다.
CONN system/oracle
GRANT SELECT ON systbl TO scott;

-- 5. scott 계정에게 동의어를 생성할 수 있는 권한을 부여한다.
CONN system/oracle
GRANT CREATE SYNONYM TO scott;


-- 공개 동의어
-- 1. DBA 계정으로 접속해서 공개 동의어를 생성할 수 있다.
-- 2. 공개 동의어를 만들때는 public 을 붙여서 생성할 수 있다.

-- 공개 동의어 생성
CONN system/oracle
CREATE PUBLIC SYNONYM pubdept FOR scott.dept;

-- 공개 동의어 목록 확인
SELECT * FROM dba_synonyms;

-- 공개 동의어 삭제
CONN system/oracle
DROP PUBLIC SYNONYM pubdept;