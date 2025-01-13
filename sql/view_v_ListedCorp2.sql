USE [stock1]
GO

/****** Object:  View [dbo].[v_ListedCorp]    Script Date: 2025-01-13 ¿ÀÈÄ 10:03:34 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[v_ListedCorp] AS
WITH RankedData AS (
    SELECT 
        corp.corp_code,
        corp.corp_name,
        corp.stock_code,
        corp.modify_date,
        ROW_NUMBER() OVER (
            PARTITION BY corp.corp_name
            ORDER BY corp.modify_date DESC
        ) AS RowNum
    FROM [dbo].[CORPCODE] AS corp
)
SELECT 
    c.corp_code,
    c.corp_name,
    c.stock_code
FROM RankedData AS c
JOIN [dbo].[KRXListedInfo] AS krx
ON c.corp_name = krx.itmsNm
WHERE c.RowNum = 1;
GO


