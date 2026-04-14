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