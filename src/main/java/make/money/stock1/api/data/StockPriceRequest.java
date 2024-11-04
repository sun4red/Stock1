package make.money.stock1.api.data;

import lombok.Data;

@Data
public class StockPriceRequest {


    private String serviceKey;	// 서비스키	400	1	공공데이터포털에서 받은 인증키	공공데이터포털에서 받은 인증키
    private int numOfRows;	// 한 페이지 결과 수	4	1	1	한 페이지 결과 수
    private int pageNo;	// 페이지 번호	4	1	1	페이지 번호
    private String resultType;	//  결과형식	4	1	xml	구분(xml, json) Default: xml
    private String basDt;	// 기준일자 8	0	20220919	검색값과 기준일자가 일치하는 데이터를 검색
    private String beginBasDt;	// 기준일자8	0	20220919	기준일자가 검색값보다 크거나 같은 데이터를 검색
    private String endBasDt;	//기준일자 8	0	20220919	기준일자가 검색값보다 작은 데이터를 검색
    private String likeBasDt;	//기준일자 8	0	20220919	기준일자값이 검색값을 포함하는 데이터를 검색
    private String likeSrtnCd;	//단축코드 9	0	900110	단축코드가 검색값을 포함하는 데이터를 검색
    private String isinCd;	// ISIN코드 12	0	HK0000057197	검색값과 ISIN코드이 일치하는 데이터를 검색
    private String likeIsinCd;	// ISIN코드 12	0	HK0000057198	ISIN코드가 검색값을 포함하는 데이터를 검색
    private String itmsNm;	// 종목명 120	0	이스트아시아홀딩스	검색값과 종목명이 일치하는 데이터를 검색
    private String likeItmsNm;	// 종목명 120	0	이스트아시아홀딩스	종목명이 검색값을 포함하는 데이터를 검색
    private String mrktCls;	// 시장구분40	0	KOSDAQ	검색값과 시장구분이 일치하는 데이터를 검색
    private int beginVs;	// 대비10	0	-8	대비가 검색값보다 크거나 같은 데이터를 검색
    private int endVs;	// 대비10	0	-8	대비가 검색값보다 작은 데이터를 검색
    private double beginFltRt;	// 등락률11	0	-4.57	등락률이 검색값보다 크거나 같은 데이터를 검색
    private double endFltRt;	// 등락률11	0	-4.57	등락률이 검색값보다 작은 데이터를 검색
    private long beginTrqu;	// 거래량 12	0	2788311	거래량이 검색값보다 크거나 같은 데이터를 검색
    private long endTrqu;	// 거래량 12	0	2788311	거래량이 검색값보다 작은 데이터를 검색
    private long beginTrPrc;	// 거래대금 21	0	475708047	거래대금이 검색값보다 크거나 같은 데이터를 검색
    private long endTrPrc;	// 거래대금 21	0	475708047	거래대금이 검색값보다 작은 데이터를 검색
    private long beginLstgStCnt;	// 상장주식수 15	0	219932050	상장주식수가 검색값보다 크거나 같은 데이터를 검색
    private long ndLstgStCnt;	// 상장주식수 15	0	219932050	상장주식수가 검색값보다 작은 데이터를 검색
    private long beginMrktTotAmt;	// 시가총액 21	0	36728652350	시가총액이 검색값보다 크거나 같은 데이터를 검색
    private long endMrktTotAmt;	// 시가총액 21	0	36728652350	시가총액이 검색값보다 작은 데이터를 검색


}
