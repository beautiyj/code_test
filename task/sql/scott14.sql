-- 제약 조건 설정 방식

--   1. 컬럼레벨 방식으로 제약조건 설정
--   2. 테이블레벨 방식으로 제약조건 설정


-- 1. 컬럼레벨 방식으로 제약조건 설정
DROP TABLE emp01 PURGE;

CREATE TABLE emp01 (
    empno  NUMBER(4)    PRIMARY KEY,
    ename  VARCHAR2(15) NOT NULL,
    job    VARCHAR2(10) UNIQUE,
    deptno NUMBER(2)    REFERENCES dept(deptno)
);

-- 2. 테이블레벨 방식으로 제약조건 설정
DROP TABLE emp02 PURGE;

CREATE TABLE emp02 (
    empno  NUMBER(4),
    ename  VARCHAR2(15) NOT NULL, -- NOT NULL 제약조건은 컬럼레벨 방식만 가능하다.
    job    VARCHAR2(10),
    deptno NUMBER(2),
    PRIMARY KEY(empno),
    UNIQUE(job),
    FOREIGN KEY(deptno) REFERENCES dept(deptno)
);

-- =============================================================================


-- 제약 조건을 설정할 때 테이블 레벨 방식만 가능한 경우

--   1. 기본키를 복합키로 사용하는 경우 (기본키 제약조건을 2개 이상 생성하는 것)
--   2. ALTER TABLE 명령으로 제약조건을 추가할 경우

-- 1. 2개 이상의 컬럼을 기본키로 설정
DROP TABLE member02 PURGE;

    -- 1) 컬럼레벨 방식으로 2개의 컬럼을 PRIMARY KEY로 설정
    CREATE TABLE member02 (
        id     VARCHAR2(20) PRIMARY KEY,
        passwd VARCHAR2(20) PRIMARY KEY -- 에러발생
    );
    -- ORA-02260: table can have only one primary key

    -- 2) 테이블레벨 방식으로 2개의 컬럼을 PRIMARY KEY로 설정
    CREATE TABLE member02 (
        id     VARCHAR2(20),
        passwd VARCHAR2(20),
        PRIMARY KEY(id, passwd)
    );


-- 2. ALTER TABLE 명령으로 제약조건을 추가할 경우
DROP TABLE emp01 PURGE;


-- =============================================================================

-- 제약조건이 없는 테이블 생성
CREATE TABLE emp01 (
    empno  NUMBER(4),    -- PRIMARY KEY
    ename  VARCHAR2(15), -- NOT NULL
    job    VARCHAR2(10), -- UNIQUE
    deptno NUMBER(2)     -- FOREIGN KEY
);

-- PRIMARY KEY 제약조건 추가 : empno
ALTER TABLE emp01 ADD PRIMARY KEY(empno);

-- NOT NULL 제약조건 추가 : ename
ALTER TABLE emp01 MODIFY ename NOT NULL;

-- UNIQUE 제약조건 추가 : job
ALTER TABLE emp01 ADD UNIQUE(job);

-- FOREIGN KEY 제약조건 추가 : deptno
ALTER TABLE emp01 ADD FOREIGN KEY(deptno) REFERENCES dept(deptno);


-- =============================================================================


-- 제약조건 제거
-- 형식 : ALTER TABLE 테이블명 DROP CONSTRAINT constraint_name;

-- 조회하면 이름값이 나오는데, 해당값에 맞게 넣으면 됨
/*  SELECT constraint_name, constraint_type, search_condition
        FROM user_constraints
        WHERE table_name = 'EMP01'; -- 테이블명은 반드시 대문자로! */

-- PRIMARY KEY 제약조건 제거
                    -- 위 주석코드를 조회하면 이름값이 나오는데, 해당값에 맞게 넣으면 됨
ALTER TABLE emp01 DROP CONSTRAINT sys_c007025;      -- 컴퓨터마다 값이 다를 수 있음!
ALTER TABLE emp01 DROP PRIMARY KEY;

-- UNIQUE 제약조건 제거
ALTER TABLE emp01 DROP CONSTRAINT sys_c007027;
ALTER TABLE emp01 DROP UNIQUE(job);

-- NOT NULL 제약조건 제거
ALTER TABLE emp01 DROP CONSTRAINT sys_c007026;

-- FOREIGN KEY 제약조건 제거
ALTER TABLE emp01 DROP CONSTRAINT sys_c007028;


-- =============================================================================


-- 제약조건의 활성화 / 비활성화
-- 테이블에 status가 ENABLED 되어있는건 제약조건 활성화된 상태라는 소리

-- Q. 부모테이블(DEPT)의 데이터를 삭제 해보자?
DELETE FROM dept WHERE deptno = 10; -- 에러 발생

-- 1) 자식테이블(EMP)에서 부모키(deptno)를 참조하는 외래키가 있기 때문에
--    부모 테이블의 데이터를 삭제 할 수 없다.

-- 2) 부모 테이블의 데이터를 삭제하기 위해서는 참조하는 자식테이블의 외래키를 비활성화
--    시키면, 부모 테이블의 데이터를 삭제 할 수 있다.


-- 1. 부모 테이블 생성
DROP TABLE dept01 PURGE;

CREATE TABLE dept01 (
    deptno NUMBER(2)    PRIMARY KEY,
    dname  VARCHAR2(14),
    loc    VARCHAR2(13)
);

INSERT INTO dept01 VALUES(10, 'ACCOUNTING', 'NEW YORK');
SELECT * FROM dept01;



-- 2. 자식 테이블
DROP TABLE emp01 PURGE;

CREATE TABLE emp01 (
    empno  NUMBER(4)    PRIMARY KEY,
    ename  VARCHAR2(10) NOT NULL,
    job    VARCHAR2(10) UNIQUE,
    deptno NUMBER(2)    REFERENCES dept01(deptno) -- 외래키
);

INSERT INTO emp01 VALUES(1111, '홍길동', '개발자', 10);
SELECT * FROM emp01;



-- 3. 부모 테이블(DEPT01)의 데이터 삭제
DELETE FROM dept01; -- 자식테이블(EMP01)에서 참조하고 있기 때문에 삭제 안됨.
SELECT * FROM dept01;
SELECT * FROM emp01;



-- 4. 자식 테이블의 외래키 제약조건을 비활성 시켜보자.
-- 부모 테이블(DEPT01)의 데이터를 삭제하기 위해서는 자식 테이블(EMP01)의 외래키
-- 제약조건을 비활성화 시키면, 부모 테이블의 데이터를 삭제할 수 있다.

-- 제약조건 활성화 및 비활성화
-- 형식 : ALTER TABLE 테이블명 DISABLE[ENABLE] CONSTRAINT constraint_name;


-- 자식 테이블(EMP01) 테이블의 외래키 제약조건을 비활성화 해보자?
ALTER TABLE emp01 DISABLE CONSTRAINT SYS_C007037;
-- 조회하면 이름값이 나오는데, 해당값에 맞게 넣으면 됨
/*  SELECT constraint_name, constraint_type, search_condition
        FROM user_constraints
        WHERE table_name = 'EMP01'; -- 테이블명은 반드시 대문자로! */



-- 5. 부모 테이블(DEPT01)의 데이터를 삭제 해보자?
DELETE FROM dept01;
SELECT * FROM dept01;


-- ============================================================================


-- CASCADE 옵션
-- 1. CASCADE 옵션을 붙여서 제약조건을 비활성화(DISABLE) 또는 삭제(DROP) 시킬 때
--    참조하고 있는 자식테이블(emp01)의 외래키 제약조건도
--    똑같이 비활성화(DISABLE) 또는 삭제(DROP) 된다.
SELECT constraint_name, constraint_type, search_condition
        FROM user_constraints
        WHERE table_name = 'DEPT01';
ALTER TABLE dept01 DISABLE CONSTRAINT sys_c007040 CASCADE;      -- 조회는 위 코드에서!

-- 2. CASCADE 옵션을 붙여서 제약조건이 설정되면 부모테이블(dept01)의 PRIMARY KEY 제거하면,
--    참조하는 자식테이블(emp01)의 FOREIGN KEY 제약조건도 같이 제거 된다.

-- 형식 : ALTER TABLE 테이블명 DROP CONSTRAINT constraint_name;
ALTER TABLE dept01 DROP PRIMARY KEY CASCADE;        -- dept01에 아직 프라이머리키 제한이 걸려있으면 이거 실행해야함



-- 1. 부모 테이블 생성
DROP TABLE dept01 PURGE;

CREATE TABLE dept01 (
    deptno NUMBER(2)    PRIMARY KEY,
    dname  VARCHAR2(14),
    loc    VARCHAR2(13)
);

INSERT INTO dept01 VALUES(10, 'ACCOUNTING', 'NEW YORK');
SELECT * FROM dept01;



-- 2. 자식 테이블 생성
DROP TABLE emp01 PURGE;

CREATE TABLE emp01 (
    empno  NUMBER(4)    PRIMARY KEY,
    ename  VARCHAR2(10) NOT NULL,
    job    VARCHAR2(10) UNIQUE,
    deptno NUMBER(2)    REFERENCES dept01(deptno) ON DELETE CASCADE -- 외래키
);
-- ON DELETE CASCADE 옵션
-- : 부모 테이블의 데이터를 삭제하면, 참조하는 자식 테이블의 데이터도 같이 삭제 해주는 옵션


INSERT INTO emp01 VALUES(1111, '홍길동', '개발자', 10);
SELECT * FROM emp01;


-- 3. 부모 테이블(dept01)의 데이터를 삭제 해보자?
DELETE FROM dept01 WHERE deptno = 10;

SELECT * FROM dept01; -- 데이터 삭제됨
SELECT * FROM emp01; -- CASCADE 옵션 때문에 참조하는 자식 테이블의 데이터도 같이 삭제됨
-- 테이블 편집 - 제약조건 들어가면 참조된 제약 조건에서 자식테이블 - 종속 삭제로 되어있는 것도 확인 가능함
-- 부모테이블엔 작업 없음으로 되어있는데, 이미 자식테이블에서 종속삭제 설정되어있으면 부모테이블에도 적용이라서
-- 부모테이블에서 데이터 삭제 시 자식테이블 종속삭제도 같이 적용됨.

