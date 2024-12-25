package api.data;

import java.io.File;

import api.model.MDartFnlttSinglAcntAllRequest;

public class CreateFilePath {

    private String dir = "data/";

    public String fnlttSinglAcntAll(MDartFnlttSinglAcntAllRequest mDartFnlttSinglAcntAllRequest, String extension) {

        String subDir = mDartFnlttSinglAcntAllRequest.getCorp_code() + "/";
        File fileDir = new File(dir + subDir);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        String filePath = "";
        String fileName = "";

        if (mDartFnlttSinglAcntAllRequest.getCorp_code() != null && !mDartFnlttSinglAcntAllRequest.getCorp_code().isEmpty()) {
            fileName = fileName
                    + mDartFnlttSinglAcntAllRequest.getCorp_code()
                    + "_";
        }
        if (mDartFnlttSinglAcntAllRequest.getBsns_year() != null && !mDartFnlttSinglAcntAllRequest.getBsns_year().isEmpty()) {
            fileName = fileName
                    + mDartFnlttSinglAcntAllRequest.getBsns_year()
                    + "_";
        }
        if (mDartFnlttSinglAcntAllRequest.getReprt_code() != null && !mDartFnlttSinglAcntAllRequest.getReprt_code().isEmpty()) {
            fileName = fileName
                    + mDartFnlttSinglAcntAllRequest.getReprt_code()
                    + "_";
        }
        if (mDartFnlttSinglAcntAllRequest.getFs_div() != null && !mDartFnlttSinglAcntAllRequest.getFs_div().isEmpty()) {
            fileName = fileName
                    + mDartFnlttSinglAcntAllRequest.getFs_div();
            // + "_" ;
        }

        filePath = dir + subDir + fileName + "." + extension;
        // System.out.println(filePath);

        return filePath;
    }

}
