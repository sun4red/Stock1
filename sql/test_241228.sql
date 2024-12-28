select * from [dbo].[FnlttSinglAcntAll] order by ord;




select account_nm, thstrm_amount from [dbo].[FnlttSinglAcntAll] where sj_div='CIS' order by ord


select (select thstrm_amount from [dbo].[FnlttSinglAcntAll] where sj_div='CIS' and account_nm = '영업이익(손실)')/(select thstrm_amount from [dbo].[FnlttSinglAcntAll] where sj_div='CIS' and account_nm = '매출액') from [dbo].[FnlttSinglAcntAll]



select * from [dbo].[FnlttSinglAcntAll] where ord = 1;


delete from [dbo].[FnlttSinglAcntAll] where 1=1;

select distinct(rcept_no) from [dbo].[FnlttSinglAcntAll] where reprt_code = '11011' and bsns_year = '2021' and corp_code = '00938721'