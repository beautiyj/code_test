--  컬럼 레벨 방식으로 제약 조건 설정

CREATE TABLE emp01 (
    empno  NUMBER(4)    PRIMARY KEY,
    ename  VARCHAR2(15) NOT NULL,
    job    VARCHAR2(10) UNIQUE,
    deptno NUMBER(4)    REFERENCES dept(deptno)
);


--  컬럼 레벨 방식으로 제약 조건 설정(constraint 키워드를 사용한 경우)

CREATE TABLE emp01 (
    empno  NUMBER(4)    CONSTRAINT emp01_empno_pk  PRIMARY KEY,
    ename  VARCHAR2(15) CONSTRAINT emp01_ename_nn  NOT NULL,
    job    VARCHAR2(10) CONSTRAINT emp01_job_uk    UNIQUE,
    deptno NUMBER(4)    CONSTRAINT emp01_deptno_fk REFERENCES dept(deptno)
);


-- 테이블 레벨 방식으로 제약조건 설정

CREATE TABLE emp01 (
    empno  NUMBER(4),
    ename  VARCHAR2(15) NOT NULL, -- NOT NULL은 테이블 레벨에서 설정이 불가능, 컬럼 레벨에 작성
    job    VARCHAR2(10),
    deptno NUMBER(4),

    PRIMARY KEY(empno),
    UNIQUE(job),
    FOREIGN KEY(deptno) REFERENCES dept(deptno)
);


-- 테이블 레벨 방식으로 제약조건 설정(constraint 키워드를 사용한 경우)

CREATE TABLE emp01 (
    empno  NUMBER(4),
    ename  VARCHAR2(15) CONSTRAINT emp01_ename_nn NOT NULL, -- NOT NULL은 컬럼 옆에만 가능
    job    VARCHAR2(10),        -- 그냥 낫널말고 이름까지 넣어서 오류 시 예외처리처럼 찾는 용도
    deptno NUMBER(4),

    CONSTRAINT emp01_empno_pk  PRIMARY KEY(empno),
    CONSTRAINT emp01_job_uk    UNIQUE(job),
    CONSTRAINT emp01_deptno_fk FOREIGN KEY(deptno) REFERENCES dept(deptno)
);