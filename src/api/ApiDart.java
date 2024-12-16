package api;

import java.util.Map;

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
                if (dartReportRequest.getCorp_code() != null && !dartReportRequest.getCorp_code().isEmpty()) {
                        // null 값인지 먼저 확인해야한다고함
                        // String 객체를 다룰 때 isEmpty() 메서드를 호출하기 전에 null 체크를 해야 합니다. 그렇지 않으면 null인 객체에서
                        // isEmpty()를 호출하려 할 때 NullPointerException이 발생합니다.
                        requestUrl = requestUrl
                                        + "&corp_code="
                                        + dartReportRequest.getCorp_code();
                }

                // 시작일 bgn_de
                if (dartReportRequest.getBgn_de() != null && !dartReportRequest.getBgn_de().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&bgn_de="
                                        + dartReportRequest.getBgn_de();
                }

                // 종료일 end_de
                if (dartReportRequest.getEnd_de() != null && !dartReportRequest.getEnd_de().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&end_de="
                                        + dartReportRequest.getEnd_de();
                }

                // 최종보고서 검색여부 last_reprt_at
                if (dartReportRequest.getLast_reprt_at() != null && !dartReportRequest.getLast_reprt_at().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&last_reprt_at="
                                        + dartReportRequest.getLast_reprt_at();
                }

                // 공시유형 pblntf_ty
                if (dartReportRequest.getPblntf_ty() != null && !dartReportRequest.getPblntf_ty().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&pblntf_ty="
                                        + dartReportRequest.getPblntf_ty();
                }

                // 공시상세유형 pblntf_detail_ty
                if (dartReportRequest.getPblntf_detail_ty() != null
                                && !dartReportRequest.getPblntf_detail_ty().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&pblntf_detail_ty="
                                        + dartReportRequest.getPblntf_detail_ty();
                }

                // 법인구분 corp_cls
                if (dartReportRequest.getCorp_cls() != null && !dartReportRequest.getCorp_cls().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&corp_cls="
                                        + dartReportRequest.getCorp_cls();
                }

                // 정렬 sort
                if (dartReportRequest.getSort() != null && !dartReportRequest.getSort().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&sort="
                                        + dartReportRequest.getSort();
                }

                // 정렬방법 sort_mth
                if (dartReportRequest.getSort_mth() != null && !dartReportRequest.getSort_mth().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&sort_mth="
                                        + dartReportRequest.getSort_mth();
                }

                // 페이지 번호 page_no
                if (dartReportRequest.getPage_no() != null && !dartReportRequest.getPage_no().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&page_no="
                                        + dartReportRequest.getPage_no();
                }

                // 페이지 별 건수 page_count
                if (dartReportRequest.getPage_count() != null && !dartReportRequest.getPage_count().isEmpty()) {
                        requestUrl = requestUrl
                                        + "&page_count="
                                        + dartReportRequest.getPage_count();
                }
                
                // System.out.println(requestUrl);
                return requestUrl;
        }

        // 기업개황 생략

        // 공시서류원본파일

        // 고유번호

}
