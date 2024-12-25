package api.model;

import lombok.Data;

@Data
public class MDartFnlttSinglAcntAllRequest {

    private String crtfc_key; // API 인증키 (필수)
    private String corp_code; // 고유번호 (필수)
    private String bsns_year; // 사업연도 (필수)
    private String reprt_code; // 보고서 코드 (필수)
    private String fs_div; // 개별/연결구분 (필수)
}
