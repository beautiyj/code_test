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
    
insert into reactboard3 values(reactboard3_seq.nextval,'홍길동','react게시판','내용',sysdate)    
    	
        