package http;

import config.EnvReader;
import model.KRXListedInfoRequest;

public class ApiKRX {

    EnvReader envReader = new EnvReader();
    private final String serviceKey = EnvReader.readEnv().get("DataGOKRKey");

    // 금융위원회_KRX상장종목정보
    public String krxListedInfo(KRXListedInfoRequest krxRequest) {

        String apiUrl = "https://apis.data.go.kr/1160100/service/GetKrxListedInfoService/getItemInfo";

        String requestUrl = apiUrl + "?serviceKey=" + serviceKey;

        if (krxRequest.getNumOfRows() != null && !krxRequest.getNumOfRows().isEmpty()) {
            requestUrl = requestUrl
                    + "&numOfRows="
                    + krxRequest.getNumOfRows();
        }

        if (krxRequest.getPageNo() != null && !krxRequest.getPageNo().isEmpty()) {
            requestUrl = requestUrl
                    + "&pageNo="
                    + krxRequest.getPageNo();
        }
        if (krxRequest.getResultType() != null && !krxRequest.getResultType().isEmpty()) {
            requestUrl = requestUrl
                    + "&resultType="
                    + krxRequest.getResultType();
        }

        if (krxRequest.getBasDt() != null && !krxRequest.getBasDt().isEmpty()) {
            requestUrl = requestUrl
                    + "&basDt="
                    + krxRequest.getPageNo();
        }
        if (krxRequest.getBeginBasDt() != null && !krxRequest.getBeginBasDt().isEmpty()) {
            requestUrl = requestUrl
                    + "&beginBasDt="
                    + krxRequest.getBeginBasDt();
        }

        if (krxRequest.getEndBasDt() != null && !krxRequest.getEndBasDt().isEmpty()) {
            requestUrl = requestUrl
                    + "&endBasDt="
                    + krxRequest.getEndBasDt();
        }
        if (krxRequest.getLikeBasDt() != null && !krxRequest.getLikeBasDt().isEmpty()) {
            requestUrl = requestUrl
                    + "&likeBasDt="
                    + krxRequest.getLikeBasDt();
        }
        if (krxRequest.getLikeSrtnCd() != null && !krxRequest.getLikeSrtnCd().isEmpty()) {
            requestUrl = requestUrl
                    + "&likeSrtnCd="
                    + krxRequest.getLikeSrtnCd();
        }
        if (krxRequest.getIsinCd() != null && !krxRequest.getIsinCd().isEmpty()) {
            requestUrl = requestUrl
                    + "&isinCd="
                    + krxRequest.getIsinCd();
        }

        if (krxRequest.getLikeIsinCd() != null && !krxRequest.getLikeIsinCd().isEmpty()) {
            requestUrl = requestUrl
                    + "&likeIsinCd="
                    + krxRequest.getLikeIsinCd();
        }
        if (krxRequest.getItmsNm() != null && !krxRequest.getItmsNm().isEmpty()) {
            requestUrl = requestUrl
                    + "&itmsNm="
                    + krxRequest.getItmsNm();
        }
        if (krxRequest.getLikeItmsNm() != null && !krxRequest.getLikeItmsNm().isEmpty()) {
            requestUrl = requestUrl
                    + "&likeItmsNm="
                    + krxRequest.getLikeItmsNm();
        }
        if (krxRequest.getCrno() != null && !krxRequest.getCrno().isEmpty()) {
            requestUrl = requestUrl
                    + "&crno="
                    + krxRequest.getCrno();
        }
        if (krxRequest.getCorpNm() != null && !krxRequest.getCorpNm().isEmpty()) {
            requestUrl = requestUrl
                    + "&corpNm="
                    + krxRequest.getCorpNm();
        }
        if (krxRequest.getLikeCorpNm() != null && !krxRequest.getLikeCorpNm().isEmpty()) {
            requestUrl = requestUrl
                    + "&likeCorpNm="
                    + krxRequest.getLikeCorpNm();
        }

        return requestUrl;
    }

}
