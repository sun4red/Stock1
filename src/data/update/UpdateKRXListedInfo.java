package data.update;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import api.ApiKRX;
import api.SaveDataFile;
import api.krx.DataFileManagerKRXListedInfo;
import api.krx.model.KRXListedInfoDTO;
import api.krx.model.KRXListedInfoRequest;
import database.krx.KRXListedInfoDAO;
import http.ApiClient;

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
    public int newXmlData() {
        int result = 0;

        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String endBasDt = today.format(dateTimeFormatter);
        String beginBasDt = lastMonth.format(dateTimeFormatter);

        String numOfRows = "10000";
        String pageNo = "";
        String resultType = "xml";

        DataFileManagerKRXListedInfo dfm = new DataFileManagerKRXListedInfo();

        for (int i = 1; i <= 10; i++) {

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
    // 중복회사 문제 발생
    public int xmlToDB(String beginBasDt, String endBasDt, String pageNo, String resultType) {
        int result = 0;

        DataFileManagerKRXListedInfo dfm = new DataFileManagerKRXListedInfo();
        String filePath = dfm.filePath(beginBasDt, endBasDt, pageNo, resultType);

        List<KRXListedInfoDTO> list = dfm.readXmlFile(filePath);
        KRXListedInfoDAO dao = new KRXListedInfoDAO();
        for (int i = 0; i < list.size(); i++) {

            KRXListedInfoDTO dto = list.get(i);

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
