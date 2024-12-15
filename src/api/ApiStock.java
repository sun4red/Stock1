package api;

import utility.EnvReader;

public class ApiStock {

    EnvReader envReader = new EnvReader();
    private final String serviceKey = EnvReader.readEnv().get("StockPriceInfoKey");

    // 주식시세 Stock
    public String stockPrice() {

        String apiUrl = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo";

        return "";
    }

    // 신주인수권증서시세 PreemptiveRightCertificate
    public String preemptiveRightCertificatePrice() {

        String apiUrl = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getPreemptiveRightCertificatePriceInfo";

        return "";
    }


    // 수익증권시세 Securities
    public String securitiesPrice() {

        String apiUrl = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getSecuritiesPriceInfo";

        return "";
    }

    // 신주인수권증권시세 PreemptiveRightSecurities
    public String preemptiveRightSecuritiesPrice() {

        String apiUrl = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getPreemptiveRightSecuritiesPriceInfo";

        return "";
    }


}


