select distinct(rcept_no) from [dbo].[FnlttSinglAcntAll] order by rcept_no asc;

delete from [dbo].[FnlttSinglAcntAll];

-- 4419행 제거

select * from [dbo].[FnlttSinglAcntAll];

-- 행 개수 일치

select * from [dbo].[CORPCODE];