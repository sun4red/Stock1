select * from [dbo].[KRXListedInfo];

select * from [dbo].[CORPCODE];


select * from [dbo].[CORPCODE] where corp_name = '금호전기'
-- 00106395
-- 001210

select * from [dbo].[CORPCODE] where corp_name = '필옵틱스';

select * from [dbo].[FnlttSinglAcntAll] where corp_code = '00938721';


select * from [dbo].[KRXListedInfo] as krx where itmsNm = '필옵틱스';

select * from [dbo].[CORPCODE] as corp where corp_name = '한국제지';

select corp.* from [dbo].[CORPCODE] as corp join  [dbo].[KRXListedInfo] as krx on corp.corp_name = krx.itmsNm;

create view v_ListedCorp as select corp.corp_code, corp.corp_name, corp.stock_code from CORPCODE as corp join KRXListedInfo as krx on corp.corp_name = krx.itmsNm;

select * from v_ListedCorp;


select * from [dbo].[CORPCODE] as corp where corp_code = '00159412';


select corp_name, max(modify_date) as modify_date from [dbo].[CORPCODE] group by corp_name;


select corp.corp_code,corp.corp_name, corp.stock_code from CORPCODE as corp 
join
(select corp_name, max(modify_date) as modify_date from [dbo].[CORPCODE] group by corp_name) as dcorp 
on 
corp.corp_name = dcorp.corp_name and corp.modify_date = dcorp.modify_date;

select c.* from
	(select corp.corp_code,corp.corp_name, corp.stock_code from CORPCODE as corp 
	join
	(select corp_name, max(modify_date) as modify_date from [dbo].[CORPCODE] group by corp_name) as dcorp 
	on 
	corp.corp_name = dcorp.corp_name and corp.modify_date = dcorp.modify_date) as c
join
	KRXListedInfo as krx
on
	c.corp_name = krx.itmsNm;


drop view v_ListedCorp;

create view v_ListedCorp as
select c.* from
	(select corp.corp_code,corp.corp_name, corp.stock_code from CORPCODE as corp 
	join
	(select corp_name, max(modify_date) as modify_date from [dbo].[CORPCODE] group by corp_name) as dcorp 
	on 
	corp.corp_name = dcorp.corp_name and corp.modify_date = dcorp.modify_date) as c
join
	KRXListedInfo as krx
on
	c.corp_name = krx.itmsNm;

select * from v_ListedCorp where corp_name = '한국제지';


select * from CORPCODE where corp_code = '00480367';