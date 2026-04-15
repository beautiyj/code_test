-- 테이블 목록
SELECT * FROM TAB;

-- 테이블 생성
CREATE table customer(
    no number(4) PRIMARY KEY,
    name varchar2(20),
    email VARCHAR2(20),
    tel VARCHAR2(20)
);

-- 프라이머리키는 반드시 중복되지 않는 값을 저장해야한다는 의미의 키워드 (같은 1,1 로 넣으면 오류남.)
-- number(4) : 숫자 4자리까지 저장할 수 있다
-- 인텔리제이에선 쿼리 실행이... 유료버전이어야 가능함
-- 그래서 연습용으로 적고 디비버로 실행 그대로 해서 테이블 생성함

-- 시퀀스 목록
SELECT * FROM SEQ;

SELECT * FROM CUSTOMER;

-- 컬럼 추가(열 추가)
ALTER TABLE customer ADD(address VARCHAR2(50));
ALTER TABLE customer ADD(reg_date TIMESTAMP);

-- 시퀀스 이름은 가급적 테이블명이 포함된 상태로 지정하기.(자동으로 번호값 증가)
-- 디비버 기준 시퀀스가 이미 존재하긴 함
SELECT * FROM user_sequences WHERE sequence_name = 'CUSTOMER_NO_SEQ';

-- 만약 시퀀스 있으면 지우고 다시 만들어도 상관 없고 냅둬도 상관없음
-- DROP SEQUENCE customer_no_seq; -- 있으면 지우는 코드(없으면 에러나지만 무시)
CREATE SEQUENCE customer_no_seq
    START WITH 1
    INCREMENT BY 1;