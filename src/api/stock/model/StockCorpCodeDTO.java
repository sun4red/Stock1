package api.stock.model;

import lombok.Data;

@Data
public class StockCorpCodeDTO {

    private String corp_code;
    private String corp_name;
    private String stock_code;
    private String modify_date;

}
