-- 게시판
select * from tab;
select * from board1;
/*
create table board1 (
	num number primary key, 			-- primary key
	writer varchar2(20) not null, 		-- 작성자
	subject varchar2(50) not null, 		-- 제목
	content varchar2(500) not null, 	-- 내용
	email varchar2(30) , 				-- 이메일
	readcount number default 0, 		-- 조회수
	passwd varchar2(12) not null, 		-- 비밀번호
	ref number not null, 				-- 답변글끼리 그룹
	re_step number not null, 			-- 댓글 출력 순서
	re_level number not null, 			-- 댓글 레벨
	ip varchar2(20) not null, 			-- 작성자 ip
	reg_date date not null, 			-- 작성일
	del char(1)
);
*/

CREATE TABLE board1 (
    num         NUMBER         NOT NULL,                  -- 글번호 (PK)
    writer      VARCHAR2(20)   NOT NULL,                  -- 작성자
    subject     VARCHAR2(50)   NOT NULL,                  -- 제목
    content     VARCHAR2(500)  NOT NULL,                  -- 내용
    email       VARCHAR2(30),                             -- 이메일
    readcount   NUMBER         DEFAULT 0,                 -- 조회수
    passwd      VARCHAR2(12)   NOT NULL,                  -- 비밀번호
    ref         NUMBER         NOT NULL,                  -- 답변글끼리 그룹
    re_step     NUMBER         NOT NULL,                  -- 댓글 출력순서
    re_level    NUMBER         NOT NULL,                  -- 댓글 레벨
    ip          VARCHAR2(20)   NOT NULL,                  -- 작성자 ip
    reg_date    DATE           NOT NULL,                  -- 작성일
    del         CHAR(1),                                  -- 글삭제유무 (y or n)

    CONSTRAINT pk_board_num PRIMARY KEY (num)             -- 기본키 제약조건 (이름 지정)
);