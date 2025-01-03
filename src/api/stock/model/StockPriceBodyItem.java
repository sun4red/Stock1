package api.stock.model;

import lombok.Data;

@Data
public class StockPriceBodyItem {

    private String basDt;    // 기준일자	8	0	20220919	기준 일자
    private String srtnCd;    // 단축코드	9	0	900110	종목 코드보다 짧으면서 유일성이 보장되는 코드(6자리)
    private String isinCd;    // ISIN코드	12	0	HK0000057197	국제 채권 식별 번호. 유가증권(채권)의 국제인증 고유번호
    private String itmsNm;    // 종목명	120	0	이스트아시아홀딩스	종목의 명칭
    private String mrktCtg;    // 시장구분	40	0	KOSDAQ	주식의 시장 구분 (KOSPI/KOSDAQ/KONEX 중 1)
    private int clpr;    // 종가	12	0	167	정규시장의 매매시간 종료시까지 형성되는 최종가격
    private int vs;    // 대비	10	0	-8	전일 대비 등락
    private double fltRt;    // 등락률	11	0	-4.57	전일 대비 등락에 따른 비율
    private int mkp;    // 시가	12	0	173	정규시장의 매매시간 개시 후 형성되는 최초가격
    private int hipr;    //고가	12	0	176	하루 중 가격의 최고치
    private int lopr;    //저가	12	0	167	하루 중 가격의 최저치
    private long trqu;    // 거래량	12	0	2788311	체결수량의 누적 합계
    private long trPrc;    // 거래대금	21	0	475708047	거래건 별 체결가격 * 체결수량의 누적 합계
    private long lstgStCnt;    // 상장주식수	15	0	219932050	종목의 상장주식수
    private long mrktTotAmt;    // 시가총액	21	0	36728652350	종가 * 상장주식수


}
