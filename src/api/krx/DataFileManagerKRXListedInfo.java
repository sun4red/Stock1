package api.krx;

import java.io.File;

import api.DataFileManager;

public class DataFileManagerKRXListedInfo extends DataFileManager {

    public String dir(String basDat) {

        if (basDat != null && !basDat.isEmpty()) {
            basDat = basDat + "/";
            directory = krxDir + basDat;

            File dir = new File(directory);

            if (!dir.exists()) {
                dir.mkdirs();
            }

        }
        return directory;

    }

    public String fileName(String beginBasDt, String endBasDt, String pageNo) {
        String fileName = beginBasDt + "_" + endBasDt + "_" + pageNo;

        return fileName;
    }

    public String filePath(String beginBasDt, String endBasDt, String pageNo, String resultType) {
        String filePath = dir(endBasDt) + fileName(beginBasDt, endBasDt, pageNo) + "." + resultType;

        return filePath;
    }

}
