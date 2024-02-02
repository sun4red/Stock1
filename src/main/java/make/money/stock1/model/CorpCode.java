package make.money.stock1.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("corpCode")
public class CorpCode {
    private int corp_code;
    private String corp_name;
    private int stock_code;
    private Date modify_date;
}
