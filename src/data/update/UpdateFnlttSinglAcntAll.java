package data.update;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import api.ApiDart;
import api.SaveDataFile;
import api.dart.DataFileManagerFnlttSinglAcntAll;
import api.dart.model.DartFnlttSinglAcntAllDTO;
import database.dart.DBDartFnlttSinglAcntAll;
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

    public int newXmlData(int startYear, int endYear, String corp_code, String fs_div) {
        int result = 0;







        
        return result;
    }

    // DB
    public int updateData(String corp_code) {
        int result = 0;

        DataFileManagerFnlttSinglAcntAll dataFileManager = new DataFileManagerFnlttSinglAcntAll();

        List<String> fileList = dataFileManager.fileList(corp_code);

        String directory = dataFileManager.dir(corp_code);

        System.out.println("Directory: " + directory);

        for (int i = 0; i < fileList.size(); i++) {
            String fileName = fileList.get(i);
            String[] splitFileName = fileName.split("_");
            // String corp_code = splitFileName[0];
            String bsns_year = splitFileName[1];
            String reprt_code = splitFileName[2];

            DBDartFnlttSinglAcntAll dbDartFnlttSinglAcntAll = new DBDartFnlttSinglAcntAll();
            String rcept_no = dbDartFnlttSinglAcntAll.select_rcept_no(reprt_code, bsns_year, corp_code);
            System.out.println(rcept_no);

            if (rcept_no.isEmpty() || rcept_no == null) {

                List<DartFnlttSinglAcntAllDTO> list = new ArrayList<>();

                list = dataFileManager.readXmlFile(directory + fileName);

                if (!list.isEmpty()) {
                    dbDartFnlttSinglAcntAll.insertList(list);
                    System.out.println("DB insert: " + fileName);
                }

            } else {
                System.out.println("rcept_no: " + rcept_no);
                System.out.println("DB에 이미 존재하는 파일: " + fileName);
            }

        }
        return result;

    }

}
