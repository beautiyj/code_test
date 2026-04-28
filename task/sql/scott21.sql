-- 동의어(synonym) : 같은 의미를 가진 단어.
-- 1. 비공개 동의어
--      : 객체에 대한 접근 권한을 부여받은 사용자가 정의한 동의어로써 
--        동의어를 만든 사용자만 사용할 수 있다.

-- 2. 공개 동의어
--      : DBA 권한을 가진 사용자만 생성할 수 있으며, 누구나 사용할 수 있다.

--    공개 동의어의 예
--      sys.tab    --->    tab                      SELECT * FROM tab;
--      sys.seq    --->    seq                      SELECT * FROM seq;
--      sys.dual   --->    dual                     SELECT * FROM dual;

--------------------------------------------------------------------------------------------------------------------------------------------------------

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

-- 4. scott 계정으로 접속후에 검색을 해보자?
CONN scott/tiger
SELECT * FROM systbl;               -- 에러발생 (누구의 systbl인지 모르기 때문)
SELECT * FROM system.systbl;        -- 정상적인 검색 가능함

-- 5. scott 계정에게 동의어를 생성할 수 있는 권한을 부여한다.
CONN system/oracle
GRANT CREATE SYNONYM TO scott;

-- 6. scott 계정으로 접속후에 비공개 동의어 생성
--    system.systbl --- > systbl (비공개 동의어)
CONN scott/tiger
CREATE SYNONYM systbl FOR system.systbl;

-- 7. 동의어 목록
CONN scott/tiger
SELECT * FROM user_synonyms;

-- 8. 동의어를 이용해서 검색을 해보자?
CONN scott/tiger
SELECT * FROM system.systbl;
SELECT * FROM systbl;   -- 비공개 동의어로 검색함. 비공개동의어로 만들어두면 DBA에서도 사용불가함(스콧전용)

-- 9. 비공개 동의어 삭제
-- 형식 : DROP SYNONYM synonym_name;
CONN scott/tiger
DROP SYNONYM systbl;




-- 공개 동의어
-- 1. DBA 계정으로 접속해서 공개 동의어를 생성할 수 있다.
-- 2. 공개 동의어를 만들때는 public 을 붙여서 생성할 수 있다.

-- 공개 동의어 생성
CONN system/oracle
CREATE PUBLIC SYNONYM pubdept FOR scott.dept;

-- 공개 동의어 목록 확인
CONN system/oracle
SELECT * FROM dba_synonyms;

-- 공개 동의어 삭제
CONN system/oracle
DROP PUBLIC SYNONYM pubdept;