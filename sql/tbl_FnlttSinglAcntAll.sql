USE [stock1]
GO

/****** Object:  Table [dbo].[FnlttSinglAcntAll]    Script Date: 2024-12-25 ¿ÀÈÄ 7:07:55 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[FnlttSinglAcntAll](
	[rcept_no] [nvarchar](50) NULL,
	[reprt_code] [nvarchar](50) NULL,
	[bsns_year] [char](4) NULL,
	[corp_code] [nvarchar](8) NULL,
	[sj_div] [nvarchar](10) NULL,
	[sj_nm] [nvarchar](10) NULL,
	[account_id] [nvarchar](300) NULL,
	[account_nm] [nvarchar](300) NULL,
	[account_detail] [nvarchar](300) NULL,
	[thstrm_nm] [nvarchar](10) NULL,
	[thstrm_amount] [numeric](18, 0) NULL,
	[frmtrm_nm] [nvarchar](10) NULL,
	[frmtrm_amount] [numeric](18, 0) NULL,
	[bfefrmtrm_nm] [nvarchar](10) NULL,
	[bfefrmtrm_amount] [numeric](18, 0) NULL,
	[ord] [int] NULL,
	[currency] [nvarchar](10) NULL
) ON [PRIMARY]
GO


