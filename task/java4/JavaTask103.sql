-- JavaTask103
CREATE table borad(
    no number PRIMARY KEY,
    writer varchar2(20) not null,
    pw VARCHAR2(20) not null,
    subject VARCHAR2(100) not null,
    content VARCHAR2(1000) not null,
    reg_date TIMESTAMP
);

-- 열 이름을 바꾸고 싶다면		  기존 컬럼명	새로 바꾸는 컬럼명
ALTER TABLE borad RENAME COLUMN subject TO title;

CREATE sequence borad_seq
    START WITH 1
    INCREMENT BY 1;

SELECT * FROM TAB;
SELECT * FROM seq;
SELECT * FROM borad;
SELECT COUNT(*) FROM borad;
