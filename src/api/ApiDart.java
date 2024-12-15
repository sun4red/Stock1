package api;

import api.data.DartReportRequest;
import utility.EnvReader;


public class ApiDart {

    EnvReader envReader = new EnvReader();
    private final String crtfc_key = EnvReader.readEnv().get("OpenDartKey");

    // 공시정보
    public String dartReports(DartReportRequest dartReportRequest) {

        String apiUrl = "https://opendart.fss.or.kr/api/list.json";

        // API 인증키 crtfc_key
        String requestUrl = apiUrl
                + "?crtfc_key=" + crtfc_key;

        // 고유번호 corp_code
        if (!dartReportRequest.getCorp_code().isEmpty() && dartReportRequest.getCorp_code() != null) {
            requestUrl =
                    requestUrl
                            + "&corp_code="
                            + dartReportRequest.getCorp_code();
        }

        // 시작일 bgn_de
        if (!dartReportRequest.getBgn_de().isEmpty() && dartReportRequest.getBgn_de() != null) {
            requestUrl =
                    requestUrl
                            + "&bgn_de="
                            + dartReportRequest.getBgn_de();
        }

        // 종료일 end_de
        if (!dartReportRequest.getEnd_de().isEmpty() && dartReportRequest.getEnd_de() != null) {
            requestUrl =
                    requestUrl
                            + "&end_de="
                            + dartReportRequest.getEnd_de();
        }

        // 최종보고서 검색여부 last_reprt_at
        if (!dartReportRequest.getLast_reprt_at().isEmpty() && dartReportRequest.getLast_reprt_at() != null) {
            requestUrl =
                    requestUrl
                            + "&last_reprt_at="
                            + dartReportRequest.getLast_reprt_at();
        }

        // 공시유형 pblntf_ty
        if (!dartReportRequest.getPblntf_ty().isEmpty() && dartReportRequest.getPblntf_ty() != null) {
            requestUrl =
                    requestUrl
                            + "&pblntf_ty="
                            + dartReportRequest.getPblntf_ty();
        }

        // 공시상세유형 pblntf_detail_ty
        if (!dartReportRequest.getPblntf_detail_ty().isEmpty() && dartReportRequest.getPblntf_detail_ty() != null) {
            requestUrl =
                    requestUrl
                            + "&pblntf_detail_ty="
                            + dartReportRequest.getPblntf_detail_ty();
        }

        // 법인구분 corp_cls
        if (!dartReportRequest.getCorp_cls().isEmpty() && dartReportRequest.getCorp_cls() != null) {
            requestUrl =
                    requestUrl
                            + "&corp_cls="
                            + dartReportRequest.getCorp_cls();
        }

        // 정렬 sort
        if (!dartReportRequest.getBgn_de().isEmpty() && dartReportRequest.getBgn_de() != null) {
            requestUrl =
                    requestUrl
                            + "&sort="
                            + dartReportRequest.getBgn_de();
        }

        // 정렬방법 sort_mth
        if (!dartReportRequest.getSort_mth().isEmpty() && dartReportRequest.getSort_mth() != null) {
            requestUrl =
                    requestUrl
                            + "&sort_mth="
                            + dartReportRequest.getSort_mth();
        }

        // 페이지 번호 page_no
        if (!dartReportRequest.getPage_no().isEmpty() && dartReportRequest.getPage_no() != null) {
            requestUrl =
                    requestUrl
                            + "&page_no="
                            + dartReportRequest.getPage_no();
        }

        // 페이지 별 건수 page_count
        if (!dartReportRequest.getPage_count().isEmpty() && dartReportRequest.getPage_count() != null) {
            requestUrl =
                    requestUrl
                            + "&page_count="
                            + dartReportRequest.getPage_count();
        }

//        RestTemplate restTemplate = new RestTemplate();
//        DartReportResponse dartReportResponse = restTemplate.getForObject(requestUrl, DartReportResponse.class);
//
//        System.out.println(requestUrl);
//
//        System.out.println(dartReportResponse);
//
//        System.out.println(dartReportResponse.getStatus());
//        System.out.println(dartReportResponse.getList());

//        if (response != null && "success".equals(response.getStatus())){
//
//        }*


        return "redirect:" + requestUrl;
    }

    // 기업개황 생략

    // 공시서류원본파일

    // 고유번호

}
