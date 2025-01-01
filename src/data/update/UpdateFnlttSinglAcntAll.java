package data.update;

import java.io.File;

import api.ApiDart;
import api.SaveDataFile;
import api.dart.DataFileManagerFnlttSinglAcntAll;
import http.ApiClient;

public class UpdateFnlttSinglAcntAll {

    // #Base Method
    public int newXmlData(String corp_code, String bsns_year, String reprt_code, String fs_div) {
        int result = 0;

        String urlString = new ApiDart().fnlttSinglAcntAllXml(corp_code, bsns_year, reprt_code, fs_div);

        DataFileManagerFnlttSinglAcntAll dataFileManagerFnlttSinglAcntAll = new DataFileManagerFnlttSinglAcntAll();
        String filePath = dataFileManagerFnlttSinglAcntAll.filePath(corp_code, bsns_year, reprt_code, fs_div, "xml");

        File file = new File(filePath);
        String data = "";
        String status = "";
        if (file.exists()) {
            status = dataFileManagerFnlttSinglAcntAll.xmlFileStatus(filePath);
            if (!status.equals("000")) {
                data = new ApiClient().getResponse(urlString);
            } else {
                System.out.println("이미 존재하는 파일: " + filePath);
            }
        } else {
            data = new ApiClient().getResponse(urlString);
        }

        if (data.equals("")) {
            System.out.println("API 연결 확인 필요: " + filePath);
        }

        if (!data.equals("")) {
            result = SaveDataFile.getInstance().saveDataToXml(data, filePath);
        }

        status = dataFileManagerFnlttSinglAcntAll.xmlFileStatus(filePath);

        if (!status.equals("000")) {
            System.out.println("데이터 확인 필요: " + filePath);
        }

        return result;
    }

}
