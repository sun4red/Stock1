package api.data;

import lombok.Data;

@Data
public class StockPriceHeader {

    private String resultCode;    // 결과코드	2	1	00	API 호출 결과의 상태 코드
    private String resultMsg;    // 결과메시지	50	1	NORMAL SERVICE.	API 호출 결과의 상태


}
