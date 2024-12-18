package test;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import api.*;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
import api.data.*;
import http.ApiClient;
import http.JSONByApi;
import utility.CreateFilePath;
import utility.SaveData;

public class Main {

    public static void main(String[] args) {

        DartReportRequest drr = new DartReportRequest();

        drr.setCorp_code("00938721");
        drr.setBgn_de("20240101");
        // drr.setEnd_de("20241201");
        // drr.setSort("rpt");
        // drr.setSort_mth("desc");
        drr.setPblntf_ty("A");

        System.out.println(drr);

        String urlString = "";
        ApiDart ad = new ApiDart();
        System.out.println(ad);

        urlString = ad.dartReports(drr);

        // System.out.println(urlString);

        // JSONByApi jsonByApi = new JSONByApi();

        // JSONObject json = new JSONObject();

        // json = jsonByApi.getJSON(urlString);

        // System.out.println(json);

        // 파일 경로 설정
        // String filePath = "data/output3.json";
        String filePath = "data/output3.xml";

        ApiClient apiClient = new ApiClient();
        String data = apiClient.getResponse(urlString);

        SaveData saveData = SaveData.getInstance();
        // saveJson.saveJson(json, filePath);

        // saveData.saveJson(data, filePath);
        saveData.saveXml(data, filePath);

        FnlttSinglAcntAll fnlttSinglAcntAll = new FnlttSinglAcntAll();
        fnlttSinglAcntAll.setBsns_year("2023");
        fnlttSinglAcntAll.setCorp_code("00938721");
        fnlttSinglAcntAll.setFs_div("CFS");
        fnlttSinglAcntAll.setReprt_code("11013");

        System.out.println(fnlttSinglAcntAll);

        CreateFilePath createFilePath = new CreateFilePath();

        urlString = ad.fnlttSinglAcntAll(fnlttSinglAcntAll);
        filePath = createFilePath.fnlttSinglAcntAll(fnlttSinglAcntAll, "xml");
        data = apiClient.getResponse(urlString);
        saveData.saveXml(data, filePath);

    }
}
