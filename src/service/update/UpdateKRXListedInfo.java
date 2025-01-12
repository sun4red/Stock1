package service.update;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.krx.KRXListedInfoDAO;
import filesystem.DataFileManagerKRXListedInfo;
import filesystem.SaveDataFile;
import http.ApiClient;
import http.ApiKRX;
import model.KRXListedInfoDTO;
import model.KRXListedInfoRequest;
import model.KRXListedInfoSetDTO;

public class UpdateKRXListedInfo {

    // #Base Method
    public int newXmlData(String beginBasDt, String endBasDt, String numOfRows, String pageNo, String resultType) {
        int result = 0;

        KRXListedInfoRequest krxRequest = new KRXListedInfoRequest();
        krxRequest.setNumOfRows(numOfRows);
        krxRequest.setPageNo(pageNo);
        krxRequest.setResultType(resultType);
        krxRequest.setBeginBasDt(beginBasDt);
        krxRequest.setEndBasDt(endBasDt);

        String url = new ApiKRX().krxListedInfo(krxRequest);
        ApiClient apiClient = new ApiClient();
        String data = apiClient.getResponse(url);
        DataFileManagerKRXListedInfo dfmkrx = new DataFileManagerKRXListedInfo();
        String filePath = dfmkrx.filePath(beginBasDt, endBasDt, pageNo, resultType);
        SaveDataFile saveDataFile = SaveDataFile.getInstance();

        result = saveDataFile.saveDataToXml(data, filePath);

        return result;
    }

    // #OverLoaded
    // 최근 1개월, 10000개, 5page
    // 수정 2개월 20페이지지
    public int newXmlData() {
        int result = 0;

        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(2);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String endBasDt = today.format(dateTimeFormatter);
        String beginBasDt = lastMonth.format(dateTimeFormatter);

        String numOfRows = "10000";
        String pageNo = "";
        String resultType = "xml";

        DataFileManagerKRXListedInfo dfm = new DataFileManagerKRXListedInfo();

        // 페이지 수 저장 객체 필요
        for (int i = 1; i <= 20; i++) {

            pageNo = Integer.toString(i);

            result += newXmlData(beginBasDt, endBasDt, numOfRows, pageNo, resultType);

            String filePath = dfm.filePath(beginBasDt, endBasDt, pageNo, resultType);
            int totalCount = Integer.parseInt(dfm.xmlFileTotalCount(filePath));

            if (totalCount <= i * 10000) {
                System.out.println("TotalCount: " + totalCount);
                break;
            }
        }

        return result;
    }

    // #Base Method
        public int xmlToDB(String beginBasDt, String endBasDt) {
        int result = 0;

        DataFileManagerKRXListedInfo dfm = new DataFileManagerKRXListedInfo();

        KRXListedInfoSetDTO setDTO = dfm.readXmlFile(beginBasDt, endBasDt);
        List<String> isinCdList = setDTO.getIsinCdList();
        Map<String, KRXListedInfoDTO> dtoMap = setDTO.getDtoMap();

        KRXListedInfoDAO dao = new KRXListedInfoDAO();
        for (int i = 0; i < isinCdList.size(); i++) {

            String isinCd = isinCdList.get(i);
            KRXListedInfoDTO dto = dtoMap.get(isinCd);

            // KOSPI, KOSDAQ만 DB에 Insert
            if (dto.getMrktCtg().equals("KOSPI") || dto.getMrktCtg().equals("KOSDAQ")) {
                result += dao.insert(dto);
            } else if (dto.getMrktCtg().equals("KONEX")) {
                // KONEX insert X
            }

        }

        return result;
    }

}
