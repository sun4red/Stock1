package api.data;

import lombok.Data;

@Data
public class DartReportRequest {

    // 필수
    private String crtfc_key;
    private String corp_code;
    private String bgn_de;
    private String end_de;
    private String last_reprt_at;
    private String pblntf_ty;
    private String pblntf_detail_ty;
    private String corp_cls;
    private String sort;
    private String sort_mth;
    private String page_no;
    private String page_count;


}
