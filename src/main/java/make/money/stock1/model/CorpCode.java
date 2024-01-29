package make.money.stock1.model;

import lombok.Data;

import java.util.Date;

@Data
public class CorpCode {
    private int corp_code;
    private String corp_name;
    private int stock_code;
    private Date modify_date;
}
