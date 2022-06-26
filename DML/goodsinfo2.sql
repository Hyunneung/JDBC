-- ���� ���
-- 1. �� ���� ������ ��� Ŀ���� ���� ���� ���� ���콺 ��Ŭ�� -> Execute Current Text(Alt+s)
drop table goodsinfo2 purge  -- ���� ���̺� �ִٸ� �����

-- 2. ���� ���� ������ ���
-- 	  ���� ���� �� ���콺 ��Ŭ�� -> Execute Selected Text (Alt+X) �Ǵ� Execute Selected Text As One Statement(Alt+C)
create table goodsinfo2(
	code varchar2(5) primary key,
	name varchar2(30) not null,
	price number(8) not null,
	maker varchar2(20)
);

insert into goodsinfo2 values ('10001', '������ TV', 350000, 'LG');
insert into goodsinfo2 values ('10002', 'DVD �÷��̾�', 250000, 'LG');
insert into goodsinfo2 values ('10003', '������ ī�޶�', 210000, '�Ｚ');
insert into goodsinfo2 values ('10004', '���ڻ���', 180000, '���̸���');
insert into goodsinfo2 values ('10005', '������ ������', 400000, '�Ｚ');

select * from goodsinfo2;



/*
 CODE  NAME		  PRICE MAKER
 ----- -------- - ----- -----
 10001 ������ TV    350000 LG
 10002 DVD �÷��̾�  250000 LG
 10003 ������ ī�޶�  210000 �Ｚ
 10004 ���ڻ���      180000 ���̸���
 10005 ������ ������  400000 �Ｚ

 */




