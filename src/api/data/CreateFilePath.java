package api.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import api.model.MDartFnlttSinglAcntAllRequest;

public class CreateFilePath {

    private String dir = "data/";
    private String dartDir = "dart/";
    private String fnlttSinglAcntAllDir = "fnlttSinglAcntAll/";

    // #Base Method
    public String fnlttSinglAcntAll(String corp_code, String bsns_year, String reprt_code, String fs_div,
            String extension) {

        String corpDir = corp_code + "/";
        String directory = dir + dartDir + fnlttSinglAcntAllDir + corpDir;

        File fileDir = new File(directory);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        String filePath = directory;
        String fileName = "";

        if (corp_code != null
                && !corp_code.isEmpty()) {
            fileName = fileName
                    + corp_code
                    + "_";
        }
        if (bsns_year != null
                && !bsns_year.isEmpty()) {
            fileName = fileName
                    + bsns_year
                    + "_";
        }
        if (reprt_code != null
                && !reprt_code.isEmpty()) {
            fileName = fileName
                    + reprt_code
                    + "_";
        }
        if (fs_div != null && !fs_div.isEmpty()) {
            fileName = fileName
                    + fs_div;
            // + "_" ;
        }

        filePath += fileName + "." + extension;

        return filePath;
    }

    // #메소드 오버로딩
    public String fnlttSinglAcntAll(MDartFnlttSinglAcntAllRequest mDartFnlttSinglAcntAllRequest, String extension) {

        String filePath = "";

        String corp_code = mDartFnlttSinglAcntAllRequest.getCorp_code();
        String bsns_year = mDartFnlttSinglAcntAllRequest.getBsns_year();
        String reprt_code = mDartFnlttSinglAcntAllRequest.getReprt_code();
        String fs_div = mDartFnlttSinglAcntAllRequest.getFs_div();

        filePath = fnlttSinglAcntAll(corp_code, bsns_year, reprt_code, fs_div, extension);

        return filePath;
    }

    public String fnlttSinglAcntAllDir(String corp_code) {
        String Directory = dir + dartDir + fnlttSinglAcntAllDir + corp_code;

        return Directory;
    }

    public List<String> fnlttSinglAcntAllList(String corp_code) {
        String Directory = dir + dartDir + fnlttSinglAcntAllDir + corp_code;
        List<String> fileList = new ArrayList<>();

        File fileDir = new File(Directory);

        // 디렉토리 확인 및 파일 목록 가져오기
        if (fileDir.exists() && fileDir.isDirectory()) {
            // 디렉토리 안의 파일 및 서브디렉토리 이름 배열 가져오기
            String[] fileNames = fileDir.list();

            if (fileNames != null) {
                System.out.println("디렉토리 내 파일 목록:");
                for (String fileName : fileNames) {
                    fileList.add(fileName);
                    System.out.println(fileName);
                }
            } else {
                System.out.println("디렉토리가 비어 있거나 오류가 발생했습니다.");
            }
        } else {
            System.out.println("지정된 경로가 디렉토리가 아니거나 존재하지 않습니다.");
        }

        return fileList;

    }

}
