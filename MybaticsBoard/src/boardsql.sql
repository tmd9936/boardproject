CREATE table board(
	boardnum number constraint board_boardnum_Pk primary key
	,name varchar2(15) not null
	,title varchar2(100) not null
	,content varchar2(2000) not null
	,hits number default 0
	,indate date default sysdate
);

CREATE SEQUENCE board_seq;

CREATE TABLE reply(
	replynum number constraint reply_replynum_pk primary key
	,boardnum number constraint reply_boardnum_fk 
	references board ON DELETE CASCADE
	/*종속적인 관계 일 경우 부모테이블의 값이 지워지면 자식테이블의 값도 지원져야됨*/
	/*CASCADE 제약조건으로 오라클에서 알아서 찾아서 자식먼저 지우고 부모지움*/
	,name varchar2(15) not null
	,content varchar2(1000) not null
);

CREATE SEQUENCE reply_seq;