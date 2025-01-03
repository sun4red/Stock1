package api.krx.model;

import lombok.Data;

@Data
public class KRXListedInfoRequestDTO {
    
private String numOfRows;       //  한 페이지 결과 수   4
private String pageNo;          //  페이지 번호 4
private String resultType;      //  결과형식   4
private String serviceKey;      //  서비스키(필수수)   400
private String basDt;           //  기준일자    8
private String beginBasDt;      //  기준일자   8
private String endBasDt;        //  기준일자 8
private String likeBasDt;       //  기준일자    8
private String likeSrtnCd;      //  단축코드   9
private String isinCd;          //  ISIN코드   12
private String likeIsinCd;      //  ISIN코드   12
private String itmsNm;          //  종목명 240
private String likeItmsNm;      //  종목명 240
private String crno;            //  법인등록번호 20
private String corpNm;          //  법인명 240
private String likeCorpNm;      //  법인명 240


}
