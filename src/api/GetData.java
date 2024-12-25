package api;

import api.data.CreateFilePath;
import api.data.SaveData;
import api.model.MDartFnlttSinglAcntAllRequest;
import http.ApiClient;

public class GetData {

    public int fnlttSinglAcntAll(int startYear, int endYear, String corp_code, String fs_div, String extension) {

        MDartFnlttSinglAcntAllRequest fnlttSinglAcntAll = new MDartFnlttSinglAcntAllRequest();

        int countYear = endYear - startYear + 1;
        String[] years = new String[countYear];
        for (int i = 0; i < countYear; i++) {
            years[i] = Integer.toString(startYear + i);
        }

        // int cnt_year = years.length;

        // fnlttSinglAcntAll.setBsns_year("2023");
        // fnlttSinglAcntAll.setCorp_code("00938721");
        // fnlttSinglAcntAll.setFs_div("CFS");
        // fnlttSinglAcntAll.setReprt_code("11013");

        String[] reprt_code = new String[4];
        reprt_code[0] = "11013";
        reprt_code[1] = "11012";
        reprt_code[2] = "11014";
        reprt_code[3] = "11011";

        // 1분기보고서 : 11013
        // 반기보고서 : 11012
        // 3분기보고서 : 11014
        // 사업보고서 : 11011

        fnlttSinglAcntAll.setCorp_code(corp_code);
        fnlttSinglAcntAll.setFs_div(fs_div);

        String year = "";

        String urlString = "";
        ApiDart apiDart = new ApiDart();
        String filePath = "";
        CreateFilePath createFilePath = new CreateFilePath();
        String data = "";
        ApiClient apiClient = new ApiClient();
        SaveData saveData = SaveData.getInstance();

        for (int i = 0; i < years.length; i++) {
            year = years[i];
            fnlttSinglAcntAll.setBsns_year(year);
            for (int j = 0; j < reprt_code.length; j++) {
                fnlttSinglAcntAll.setReprt_code(reprt_code[j]);

                urlString = apiDart.fnlttSinglAcntAll(fnlttSinglAcntAll);
                filePath = createFilePath.fnlttSinglAcntAll(fnlttSinglAcntAll, "xml");
                data = apiClient.getResponse(urlString);
                saveData.saveXml(data, filePath);

            }
        }

        return 1;

    }

}
