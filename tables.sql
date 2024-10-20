create table user(
    num int primary key ,
    userid varchar(20) not null ,
    userpw varchar(20) not null ,
    nickname varchar(12),
    favorites varchar(300)
);

select * from user;

create table favorites(
    num int primary key ,
    userid varchar(20) not null ,
    part varchar(12) ,
    stockid varchar(12)
);

select * from favorites;

create table corpcode(
    corp_code int(8) primary key ,
   corp_name varchar(100) not null ,
    stock_code int(6) ,
    modify_date date
);

select * from corpcode;
explain select * from corpcode;

alter table corpcode add unique index idx_corp_code (corp_code);


create view listedcorp as
    (select * from corpcode where stock_code <> 0);

select * from listedcorp;