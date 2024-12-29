package api.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import api.model.MDartFnlttSinglAcntAllRequest;

public class CreateFilePath {

    private String dir = "data/";
    private String dartDir = "dart/";
    private String fnlttSinglAcntAllDir = "fnlttSinglAcntAll/";

    public String fnlttSinglAcntAll(MDartFnlttSinglAcntAllRequest mDartFnlttSinglAcntAllRequest, String extension) {

        String corpDir = mDartFnlttSinglAcntAllRequest.getCorp_code() + "/";
        String directory = dir + dartDir + fnlttSinglAcntAllDir + corpDir;

        File fileDir = new File(directory);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        String filePath = directory;
        String fileName = "";

        if (mDartFnlttSinglAcntAllRequest.getCorp_code() != null
                && !mDartFnlttSinglAcntAllRequest.getCorp_code().isEmpty()) {
            fileName = fileName
                    + mDartFnlttSinglAcntAllRequest.getCorp_code()
                    + "_";
        }
        if (mDartFnlttSinglAcntAllRequest.getBsns_year() != null
                && !mDartFnlttSinglAcntAllRequest.getBsns_year().isEmpty()) {
            fileName = fileName
                    + mDartFnlttSinglAcntAllRequest.getBsns_year()
                    + "_";
        }
        if (mDartFnlttSinglAcntAllRequest.getReprt_code() != null
                && !mDartFnlttSinglAcntAllRequest.getReprt_code().isEmpty()) {
            fileName = fileName
                    + mDartFnlttSinglAcntAllRequest.getReprt_code()
                    + "_";
        }
        if (mDartFnlttSinglAcntAllRequest.getFs_div() != null && !mDartFnlttSinglAcntAllRequest.getFs_div().isEmpty()) {
            fileName = fileName
                    + mDartFnlttSinglAcntAllRequest.getFs_div();
            // + "_" ;
        }

        filePath += fileName + "." + extension;
        // System.out.println(filePath);

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
