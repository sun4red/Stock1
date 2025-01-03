package api.krx.model;

import lombok.Data;

@Data
public class KRXListedInfoDTO {

    // 헤더
    // private String resultCode;   // 결과코드 2
    // private String resultMsg;    // 결과메시지 50

    private String numOfRows;   // 한 페이지 결과 수 4
    private String pageNo;      // 페이지 번호 4
    private String totalCount;  // 전체 결과 수 10

    private String basDt;       // 기준일자 8

    private String srtnCd;      // 단축코드 9
    private String isinCd;      // ISIN코드 12

    private String mrktCtg;     // 시장 구분 10

    private String itmsNm;      // 종목명 240

    private String crno;        // 법인등록번호 20
    private String corpNm;      // 법인명 240

}
