package api.dart.model;

import lombok.Data;

@Data
public class DartListDTO {

    private String status;
    private String message;
    private int page_no;
    private int page_count;
    private int total_count;
    private int total_page;
    private String corp_code;
    private String corp_name;
    private String stock_code;
    private String corp_cls;
    private String report_nm;
    private String rcept_no;
    private String flr_nm;
    private String rcept_dt;
    private String rm;
}
