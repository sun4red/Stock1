USE [stock1]
GO

/****** Object:  Table [dbo].[KRXListedInfo]    Script Date: 2025-01-10 ���� 10:24:55 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[KRXListedInfo](
	[basDt] [nvarchar](8) NULL,
	[srtnCd] [nvarchar](9) NULL,
	[isinCd] [nvarchar](12) NULL,
	[mrktCtg] [nvarchar](10) NULL,
	[itmsNm] [nvarchar](240) NULL,
	[crno] [nvarchar](20) NULL,
	[corpNm] [nvarchar](240) NULL
) ON [PRIMARY]
GO


select * from [dbo].[KRXListedInfo];

delete from [dbo].[KRXListedInfo] where 1=1;

select distinct(isinCd) from [dbo].[KRXListedInfo];

select distinct(isinCd) from [dbo].[KRXListedInfo];


select * from [dbo].[KRXListedInfo] where mrktCtg = 'KOSPI';
select * from [dbo].[KRXListedInfo] where mrktCtg = 'KOSDAQ';