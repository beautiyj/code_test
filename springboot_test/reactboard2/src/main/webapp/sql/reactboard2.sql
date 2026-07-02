-- react 게시판

create table reactboard3(
	    no number primary key,
        writer  varchar2(30),
        title  varchar2(50),
        content  varchar2(200),     
        register  date);
        
create sequence reactboard3_seq
    start with 1
    increment by 1
    nocache;		
        