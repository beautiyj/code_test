select * from tab;
select * from board;
select * from REPLYBOARD;

-- 댓글 게시판
create table replyBoard (
	rno number primary key,
	bno number not null references board(num),
	replytext varchar2(500) not null,
	replyer varchar2(50) not null,
	regdate date not null,
	updatedate date not null
);

/*
-- 댓글 게시판
CREATE TABLE replyboard (
    rno         NUMBER         NOT NULL,                  -- 댓글번호 (PK)
    bno         NUMBER         NOT NULL,                  -- 원글번호 (FK, board.num 참조)
    replytext   VARCHAR2(500)  NOT NULL,                  -- 댓글내용
    replyer     VARCHAR2(50)   NOT NULL,                  -- 댓글작성자
    regdate     DATE           NOT NULL,                  -- 작성일
    updatedate  DATE           NOT NULL,                  -- 수정일
    CONSTRAINT pk_replyboard_rno PRIMARY KEY (rno),       -- 기본키 제약조건 (이름 지정)
    CONSTRAINT fk_replyboard_bno FOREIGN KEY (bno)        -- 외래키 제약조건 (이름 지정)
        REFERENCES board (num)
);

*/