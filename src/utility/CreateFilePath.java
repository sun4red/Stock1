package utility;

import api.data.FnlttSinglAcntAll;

public class CreateFilePath {

    private String dir = "data/";

    public String fnlttSinglAcntAll(FnlttSinglAcntAll fnlttSinglAcntAll, String extension) {

        String filePath = "";
        String fileName = "";

        if (fnlttSinglAcntAll.getCorp_code() != null && !fnlttSinglAcntAll.getCorp_code().isEmpty()) {
            fileName = fileName
                    + fnlttSinglAcntAll.getCorp_code()
                    + "_";
        }
        if (fnlttSinglAcntAll.getBsns_year() != null && !fnlttSinglAcntAll.getBsns_year().isEmpty()) {
            fileName = fileName
                    + fnlttSinglAcntAll.getBsns_year()
                    + "_";
        }
        if (fnlttSinglAcntAll.getReprt_code() != null && !fnlttSinglAcntAll.getReprt_code().isEmpty()) {
            fileName = fileName
                    + fnlttSinglAcntAll.getReprt_code()
                    + "_";
        }
        if (fnlttSinglAcntAll.getFs_div() != null && !fnlttSinglAcntAll.getFs_div().isEmpty()) {
            fileName = fileName
                    + fnlttSinglAcntAll.getFs_div();
            // + "_" ;
        }

        filePath = dir + fileName + "." + extension;
        // System.out.println(filePath);

        return filePath;
    }

}
