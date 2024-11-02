package make.money.stock1.api.data;

import lombok.Data;

import java.util.List;

@Data
public class DartReportResponse {

    private String status;
    private String message;
    private int page_no;
    private int page_count;
    private int total_count;
    private int total_page;
    private List<DartReport> list;

}
