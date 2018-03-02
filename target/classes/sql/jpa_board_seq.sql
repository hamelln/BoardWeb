select * from board3 order by seq desc;

-- null값 처리
update board3 set cnt = nvl(cnt,0);

-- 자동발번용 sequence생성
create sequence board_seq
increment by 1
start with 57
;

select board_seq.nextval from dual;
