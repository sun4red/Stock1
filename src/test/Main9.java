package test;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.text.DateFormatter;

import api.ApiKRX;
import api.SaveDataFile;
import api.krx.DataFileManagerKRXListedInfo;
import api.krx.model.KRXListedInfoRequest;
import http.ApiClient;

public class Main9 {
    public static void main(String[] args) {

        KRXListedInfoRequest krxRequest = new KRXListedInfoRequest();
        krxRequest.setNumOfRows("10000");

        krxRequest.setPageNo("5");
        krxRequest.setResultType("xml");
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        String endBasDt = today.format(dateTimeFormatter);
        String beginBasDt = lastMonth.format(dateTimeFormatter);

        krxRequest.setBeginBasDt(beginBasDt);
        krxRequest.setEndBasDt(endBasDt);

        String url = new ApiKRX().krxListedInfo(krxRequest);

        ApiClient apiClient = new ApiClient();

        String data = apiClient.getResponse(url);

        DataFileManagerKRXListedInfo dfmkrx = new DataFileManagerKRXListedInfo();

        String filePath = dfmkrx.filePath(beginBasDt, endBasDt, "5", "xml");

        SaveDataFile saveDataFile = SaveDataFile.getInstance();

        saveDataFile.saveDataToXml(data, filePath);

    }
}
