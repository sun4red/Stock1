package api.data;

import lombok.Data;

import java.util.List;

@Data
public class StockPriceBody {

    private int numOfRows;    // 한 페이지 결과 수	4	1	1	한 페이지 결과 수
    private int pageNo;    // 페이지 번호	4	1	1	페이지 번호
    private int totalCount;    // 전체 결과 수	10	1	1713576	전체 결과 수
    private List<StockPriceBodyItem> stockPriceBodyItems;


}
