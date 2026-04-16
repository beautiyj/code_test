SHOW databases;
SHOW tables;
DESC member;			-- 테이블 구조. DESCRIBE도 가능하고 줄인 것도 가능함
SELECT current_user(); 	-- 현재 접속한 유저 확인

-- auto_incrment : 자동으로 번호를 1씩 증가시켜 주는 역할, 시퀀스인 오라클보다 더 간단!
CREATE table member(
	id VARCHAR(20),
    name VARCHAR(20),
    email VARCHAR(20),
    address VARCHAR(100) );
    
INSERT INTO member
	VALUES('test','홍길동','hong@naver.com','서울시 마포구');

SELECT * FROM member;

# 세이프모드가 켜져있으면 프라이머리 키로만 where절 찾기 가능, 옵션 끄고 진행하기.
# Preferences → SQL Editor → 맨 아래 Safe Updates 체크 해제 → OK → 워크밴치 재연결
UPDATE member SET address='서울시 강남구'
	WHERE id='test';
    
DELETE FROM member WHERE id='test';