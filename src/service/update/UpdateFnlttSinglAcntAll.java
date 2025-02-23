package service.update;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import database.DartFnlttSinglAcntAllDAO;
import filesystem.DataFileManagerFnlttSinglAcntAll;
import filesystem.SaveDataFile;
import http.ApiClient;
import http.ApiDart;
import model.DartFnlttSinglAcntAllDTO;

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
            if (data.equals("")) {
                System.out.println("API 연결 확인 필요: " + filePath);
            }
        }

        if (!data.equals("")) {
            result = SaveDataFile.getInstance().saveDataToXml(data, filePath);
        }

        status = dataFileManagerFnlttSinglAcntAll.xmlFileStatus(filePath);

        if (!status.equals("000")) {
            System.out.println("데이터 확인 필요: " + filePath);
            if (status.equals("013")) {
                SaveDataFile.getInstance().deleteFile(filePath);
            }
        }

        return result;
    }

    // #Overloaded
    // 기간(연), 사업보고서 반복
    public int newXmlData(int startYear, int endYear, String corp_code, String fs_div) {
        int result = 0;

        String[] reprt_codes = { "11011", "11012", "11013", "11014" };

        for (int year = startYear; year <= endYear; year++) {
            for (String reprt_code : reprt_codes) {
                String bsns_year = Integer.toString(year);
                result += newXmlData(corp_code, bsns_year, reprt_code, fs_div);
            }
        }

        return result;
    }

    // DB
    public int xmlToDB(String corp_code) {
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

            DartFnlttSinglAcntAllDAO dbDartFnlttSinglAcntAll = new DartFnlttSinglAcntAllDAO();
            String rcept_no = dbDartFnlttSinglAcntAll.select_rcept_no(reprt_code, bsns_year, corp_code);

            if (rcept_no.isEmpty() || rcept_no == null) {

                List<DartFnlttSinglAcntAllDTO> list = new ArrayList<>();

                list = dataFileManager.readXmlFile(directory + fileName);

                if (!list.isEmpty()) {
                    try{
                    dbDartFnlttSinglAcntAll.insertList(list);
                    System.out.println("DB insert: " + fileName);
                    }catch(Exception e){
                        rcept_no = dbDartFnlttSinglAcntAll.select_rcept_no(reprt_code, bsns_year, corp_code);
                        dbDartFnlttSinglAcntAll.delete(rcept_no);
                        System.out.println("오류 발생, delete rcept_no: " + rcept_no);
                        e.printStackTrace();
                    }
                }

            } else {
                System.out.println("rcept_no: " + rcept_no);
                System.out.println("DB에 이미 존재하는 파일: " + fileName);
            }

        }
        return result;

    }

}
