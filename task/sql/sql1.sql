SHOW databases;		-- 데이터베이스 목록
USE mysql;			-- 데이터베이스 선택
SHOW tables;		-- 테이블 목록
SELECT * FROM db;
SELECT * FROM user;

-- 1. 새로운 데이터베이스 생성
CREATE database jsptest;
-- 2. 유저 생성 (user : jspid  password : jsppass)
CREATE user jspid@'%' IDENTIFIED BY 'jsppass';
-- 유저 생성 확인
SELECT user, host FROM mysql.user;
-- 3. 권한 부여		이데베모든테이블에권한부여  어디서든접속혀용한다는 퍼센트표시 
GRANT ALL PRIVILEGES ON jsptest.* TO jspid@'%' WITH GRANT OPTION;
-- 권한 확인
SHOW GRANTS FOR jspid@'%';
-- 4. 권한 적용(GRANT로 하면 자동으로 적용 된다) 
FLUSH PRIVILEGES;