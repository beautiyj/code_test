SHOW databases;
show tables;
select * from boardtest;

-- AUTO_INCREMENT: 오라클의 시퀀스같은 역할.
-- mySQL용, 1부터 1씩 증가된 값이 자동으로 입력되도록 해주는 역할
CREATE TABLE boardtest(
                          no int auto_increment primary KEY,
                          writer VARCHAR(20),
                          title VARCHAR(100),
                          content VARCHAR(1000),
                          register date);	-- SYSDATE()나 NOW()는 2026-04-16 14:12:17 형식, datetime으로 지정해야 함
-- date는 2026-04-16만 나오는 형식.
/* 서식은 INSERT into 테이블명(컬럼,..) VALUES(데이터,..);
 * 그리고 INSERT into 테이블명 VALUES(데이터,..);
 */
INSERT into boardtest(writer, title, content, register)
VALUES('홍길동','게시판연습제목','게시판연습내용내용',SYSDATE() );	-- 데이터들어가긴하는데 시간 형식부분에서만 약간의 오류 있음
INSERT into boardtest(writer, title, content, register)
VALUES('김길동','제목입니다','게시판내용임',NOW() );

-- 최근 글 5개 검색하기
select * from boardtest order by no desc; -- 최신순으로 정렬(내림차순)
select * from boardtest order by no desc limit 5; -- 최신순으로 정렬, 상위 5개(내림차순)
-- select * from boardtest order by no desc limit 5,5; -- 5번 건너뛰고 5개 가져와라 = 10등~6등 가져오기
select * from boardtest order by no asc;  -- 오름차순


---------------------------------------------------------------------------------

-- 테이블 생성
-- CREATE table customer(
--     no int(4) auto_increment PRIMARY KEY,
--     name varchar(20),
--     email VARCHAR(20),
--     tel VARCHAR(20)
-- );

-- 컬럼 추가(열 추가)
-- ALTER TABLE customer ADD(address VARCHAR(50));
-- ALTER TABLE customer ADD(reg_date TIMESTAMP);

select * from customer;

-- 디비버에선 엑셀처럼 바로 수정삭제 가능함(데이터탭으로 가서)

------------------------------------------------------------------------------------

CREATE table borad(
                      no int auto_increment PRIMARY KEY,
                      writer varchar(20) not null,
                      pw VARCHAR(20) not null,
                      subject VARCHAR(100) not null,
                      content VARCHAR(1000) not null,
                      reg_date TIMESTAMP );
-- 열 이름을 바꾸고 싶다면			기존 컬럼명	새로 바꾸는 컬럼명
ALTER TABLE borad RENAME COLUMN subject TO title;

SELECT * FROM borad;
SELECT COUNT(*) FROM borad;