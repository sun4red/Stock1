USE [stock1]
GO

/****** Object:  View [dbo].[v_ListedCorp]    Script Date: 2025-01-11 ¿ÀÈÄ 11:26:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

create view [dbo].[v_ListedCorp] as
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
GO


