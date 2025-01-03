package api;

import utility.EnvReader;

public class ApiKRX {

    EnvReader envReader = new EnvReader();
    private final String serviceKey = EnvReader.readEnv().get("DataGOKRKey");

    // 금융위원회_KRX상장종목정보
    public String krxListedInfo() {

        String apiUrl = "https://apis.data.go.kr/1160100/service/GetKrxListedInfoService";

        return "";
    }



}


