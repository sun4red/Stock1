select * from [dbo].[v_ListedCorp] order by corp_code;

select * from [dbo].[v_ListedCorp] where corp_name = '필옵틱스';
select * from [dbo].[v_ListedCorp] where corp_name = '한국비엔씨';
select * from [dbo].[v_ListedCorp] where corp_name like '%크리%';

drop view [dbo].[v_ListedCorp];


    SELECT 
        corp.corp_code,
        corp.corp_name,
        corp.stock_code,
        corp.modify_date,
        ROW_NUMBER() OVER (
            PARTITION BY corp.corp_name
            ORDER BY corp.modify_date DESC
        ) AS RowNum
    FROM [dbo].[CORPCODE] AS corp;




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


select * from [dbo].[KRXListedInfo];
select * from [dbo].[KRXListedInfo] order by itmsNm;



select * from [dbo].[CORPCODE];


select * from [dbo].[FnlttSinglAcntAll] where rcept_no = '20241114002117';

select * from [dbo].[FnlttSinglAcntAll] where account_id = 'ifrs-full_Revenue';
select * from [dbo].[FnlttSinglAcntAll] where account_id = 'dart_OperatingIncomeLoss';


select thstrm_amount from [dbo].[FnlttSinglAcntAll] where account_id = 'ifrs-full_Revenue';
select thstrm_amount from [dbo].[FnlttSinglAcntAll] where account_id = 'dart_OperatingIncomeLoss';


--
WITH RevenueAndIncome AS (
    SELECT 
		revenue.reprt_code,
        revenue.corp_code,
        revenue.bsns_year,
        revenue.sj_div,
        revenue.thstrm_amount AS revenue_amount,
        income.thstrm_amount AS operating_income
    FROM 
        (SELECT rcept_no, reprt_code, corp_code, bsns_year, sj_div, thstrm_amount 
         FROM [dbo].[FnlttSinglAcntAll] 
         WHERE account_id = 'ifrs-full_Revenue') AS revenue
    JOIN 
        (SELECT rcept_no, reprt_code, corp_code, bsns_year, sj_div, thstrm_amount 
         FROM [dbo].[FnlttSinglAcntAll] 
         WHERE account_id = 'dart_OperatingIncomeLoss') AS income
    ON 
		revenue.rcept_no = income.rcept_no
        AND revenue.corp_code = income.corp_code
        AND revenue.bsns_year = income.bsns_year
        AND revenue.sj_div = income.sj_div
)
SELECT 
	reprt_code,
    corp_code,
    bsns_year,
    sj_div,
    revenue_amount AS 매출액,
    operating_income AS 영업이익,
    CASE 
        WHEN revenue_amount = 0 THEN NULL  -- 매출액이 0인 경우 NULL 처리
        ELSE CAST(operating_income AS FLOAT) / CAST(revenue_amount AS FLOAT) * 100
    END AS 영업이익률
FROM RevenueAndIncome order by corp_code, bsns_year desc, reprt_code asc;

--

select * from [dbo].[FnlttSinglAcntAll] where account_id = 'ifrs-full_Revenue' order by corp_code, bsns_year desc, reprt_code asc;
select * from [dbo].[FnlttSinglAcntAll] where account_id = 'dart_OperatingIncomeLoss' order by corp_code, bsns_year desc, reprt_code asc;