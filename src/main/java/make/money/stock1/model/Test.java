package make.money.stock1.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("test")
public class Test {

    private int no;
    private String name;

}
