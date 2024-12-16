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
import http.JSONByApi;
import utility.SaveJSON;

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

        JSONByApi jsonByApi = new JSONByApi();

        JSONObject json = new JSONObject();

        json = jsonByApi.getJSON(urlString);

        System.out.println(json);



        // 파일 경로 설정
        String filePath = "data/output2.json";

        SaveJSON saveJson = SaveJSON.getInstance();
        saveJson.save(json, filePath);


    }
}
