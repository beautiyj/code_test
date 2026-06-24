--회원관리
select * from tab;
select * from seq;
select * from join_member;

-- 회원관리
CREATE TABLE join_member (
    join_id          VARCHAR2(20)    NOT NULL,                  -- 회원아이디
    join_pwd         VARCHAR2(20)    NOT NULL,                  -- 회원비번
    join_name        VARCHAR2(50)    NOT NULL,                  -- 회원이름
    join_zip         VARCHAR2(5)     NOT NULL,                  -- 우편번호
    join_addr1       VARCHAR2(100)   NOT NULL,                  -- 주소
    join_addr2       VARCHAR2(100)   NOT NULL,                  -- 나머지 주소
    join_tel1        VARCHAR2(20)    NOT NULL,                  -- 전화번호
    join_tel2        VARCHAR2(20)    NOT NULL,                  -- 전화번호
    join_tel3        VARCHAR2(20)    NOT NULL,                  -- 전화번호
    join_phone1      VARCHAR2(20)    NOT NULL,                  -- 핸드폰번호
    join_phone2      VARCHAR2(20)    NOT NULL,                  -- 핸드폰번호
    join_phone3      VARCHAR2(20)    NOT NULL,                  -- 핸드폰번호
    join_mailid      VARCHAR2(100)   NOT NULL,                  -- 이메일주소
    join_maildomain  VARCHAR2(100)   NOT NULL,                  -- 이메일주소
    join_profile     VARCHAR2(100),                             -- 첨부파일명
    join_regdate     DATE,                                      -- 가입 날짜
    join_state       NUMBER(10),                                -- 가입회원 1, 탈퇴회원 2
    join_delcont     VARCHAR2(4000),                            -- 탈퇴 사유
    join_deldate     DATE,                                      -- 탈퇴 날짜
    CONSTRAINT pk_join_member_id PRIMARY KEY (join_id)          -- 기본키 제약조건 (이름 지정)
);
    
INSERT INTO join_member (join_id, join_pwd, join_name, join_zip,
    join_addr1, join_addr2, join_tel1, join_tel2, join_tel3, join_phone1, join_phone2,
    join_phone3, join_mailid, join_maildomain, join_regdate, join_state)
VALUES ('aaaaa', '77777', '홍길동',
    '74512', '서울시 마포구 대흥동', '중앙정보 처리학원', '02', '7777', '7777',
    '010', '9999', '9999', 'hong', 'naver.com', SYSDATE, 1);
    
/*create table join_member(
    join_id varchar2(20) primary key 		회원아이디
  , join_pwd varchar2(20) not null 			회원비번
  , join_name varchar2(50) not null 		회원이름
  , join_zip varchar2(5) not null 			우편번호 
  , join_addr1 varchar2(100) not null 		주소
  , join_addr2 varchar2(100) not null 		나머지 주소 
  , join_tel1 varchar2(20) not null 		전화번호
  , join_tel2 varchar2(20) not null 		전화번호
  , join_tel3 varchar2(20) not null 		전화번호
  , join_phone1 varchar2(20) not null		핸드폰번호 
  , join_phone2 varchar2(20) not null		핸드폰번호 
  , join_phone3 varchar2(20) not null		핸드폰번호 
  , join_mailid varchar2(100) not null 		이메일주소
  , join_maildomain varchar2(100) not null 	이메일주소
  , join_profile varchar2(100)  			첨부파일명
  , join_regdate date 						가입 날짜
  , join_state number(10) 					가입회원 1, 탈퇴회원 2 
  , join_delcont varchar2(4000) 			탈퇴 사유 
  , join_deldate date 						탈퇴 날짜 
);


insert into join_member (join_code,join_id,join_pwd,join_name,join_zip,
	join_addr1,join_addr2,join_tel1,join_tel2,join_tel3,join_phone1,join_phone2,
	join_phone3,join_mailid,join_maildomain,join_regdate,join_state)
values(join_member_joincode_seq.nextval,'aaaaa','77777','홍길동',
'74512','서울시 마포구 대흥동','중앙정보 처리학원','02','7777','7777',
'010','9999','9999','hong','naver.com',sysdate,1);

*/
