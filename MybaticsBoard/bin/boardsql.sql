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
	/*�������� ���� �� ��� �θ����̺��� ���� �������� �ڽ����̺��� ���� �������ߵ�*/
	/*CASCADE ������������ ����Ŭ���� �˾Ƽ� ã�Ƽ� �ڽĸ��� ����� �θ�����*/
	,name varchar2(15) not null
	,content varchar2(1000) not null
);

CREATE SEQUENCE reply_seq;