-- 데이터베이스 사용자 관리 스콧버전
-- 시스템권한 예제는 SYSTEM19.SQL 파일에에 있음


-- 데이터베이스 보안을 위한 권한

-- 1. 시스템 권한: 데이터베이스 관리자 DBA의 권한
--    CREATE USER, DROP USER 등이 대표적인 예시.
--    시스템 관리자가 일반 사용자에게 부여해야하는 권한
--    ㄴ EX) CREATE SESSION 데이터베이스 접속 권한
--           CREATE TABLE/VIEW/SEQUENCE/PROCEDURE(프로시저) 생성 권한

-- 2. 객체 권한: 오라클의 객체 권한.
--    오라클의 객체는 테이블 뷰 시퀀스 인덱스 동의어 프로시저 트리거 등등





-- 객체 권한 예시
/*
    GRANT privilege_name [(column_name)] | ALL
    ON object_name | role_name | PUBLIC
    TO user_name;
*/
-- 새로 생성된 유저01 계정에 권한 부여하기: 스콧 계정 소유의 EMP테이블 객체에 대한 SELECT 객체 권한
GRANT SELECT ON emp TO USER01;
-- 그다음 콘솔에서 유저01 계정 로그인, SELECT * FROM SCOTT.emp; 명령어 입력 시 테이블 출력됨
-- SELECT * FROM emp;는 에러남. 앞에 스콧을 꼭 붙여야 조회된다


/* -- 부여된 권한 취소하기(뺏기, 철회하기)
    REVOKE {privilege_name | all}
    ON object_name
    FROM {user_name | role_name | public};
*/
REVOKE SELECT ON EMP FROM USER01;
SELECT * FROM USER_TAB_PRIVS_MADE; -- 권한 철회 시 데이터 딕셔너리에 객체 권한에 대한 정보도 사라짐
-- 콘솔에서 유저01 계정 로그인, SELECT * FROM SCOTT.emp; 명령어 입력 시 에러남(권한 취소됐으니까)



-- WITH GRANT OPTION 옵션: 권한을 받은 사용자가 그 권한을 다른 사용자에게 부여할 수 있는 옵션
-- 예시
GRANT SELECT ON emp TO user02 WITH GRANT OPTION;
-- 유저02가 SELECT 권한을 받고, 유저2는 다른 유저한테도 SELECT 권한을 줄 수 있음

-- WITH GRANT OPTION 없는 경우
GRANT SELECT ON emp TO user02;
-- 유저02는 SELECT 만 가능, 유저02는 다른 사람한테 권한 못줌
-- 해당 유저 계정으로 디벨로퍼 연결한 뒤 emp 테이블 보면 권한 부여 코너에서 확인 가능

-- 유저02로 접속하면 SELECT * FROM SCOTT.emp; 검색 조회 가능!
/*
    -- SQL Developer (SCOTT 계정으로 접속된 상태)
    GRANT SELECT ON emp TO user01;
    -- → 이미 SCOTT 계정이니까 SCOTT. 생략 가능
    
    -- 콘솔 (터미널에서 SYSTEM/관리자 계정으로 접속된 상태)
    GRANT SELECT ON SCOTT.emp TO user01;
    -- → 어떤 계정의 emp인지 명시해줘야 함!
    --   SCOTT. 을 붙여야 SCOTT의 emp 테이블인걸 알 수 있음
*/
-- 유저 1에게 권한부여했으니 유저 01계정으로 접속 후 SELECT * FROM SCOTT.emp;도 가능!





--   객체별 권한 종류
--
-- | 권한                    | TABLE | VIEW | SEQUENCE | PROCEDURE |
-- |------------------------|-------|------|----------|-----------|
-- | ALTER                  |   v   |      |    v     |           |
-- | DELETE                 |   v   |  v   |          |           |
-- | EXECUTE(실행)           |       |      |          |     v     |
-- | INDEX(색인)             |   v   |      |          |           |
-- | INSERT                 |   v   |  v   |          |           |
-- | REFERENCES(참조/외래키)  |   v   |      |          |           |
-- | SELECT                 |   v   |  v   |    v     |           |
-- | UPDATE                 |   v   |  v   |          |           |
-- |------------------------|-------|------|----------|-----------|

-- 권한 설명
-- ALTER              : 객체 구조 변경 권한 (테이블 컬럼 추가/수정, 시퀀스 값 변경 등)
-- DELETE             : 데이터 삭제 권한 (테이블/뷰)
-- EXECUTE(실행)      : 프로시저(PROCEDURE) 실행 권한
-- INDEX(색인)        : 테이블에 인덱스 생성 권한
-- INSERT             : 데이터 삽입 권한 (테이블/뷰)
-- REFERENCES(참조/외래키) : 다른 테이블을 참조하는 외래키(FK) 생성 권한
-- SELECT             : 데이터 조회 권한 (테이블/뷰/시퀀스)
-- UPDATE             : 데이터 수정 권한 (테이블/뷰)



