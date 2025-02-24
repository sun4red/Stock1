package test;

import http.ApiClient;
import http.ApiDart;

public class Test1 {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        ApiDart apiDart = new ApiDart();

        // 필옵틱스
        String corp_code = "00938721";
        String bsns_year = "2024"; // 2023년 3분기 이후부터 정보제공
        String reprt_code = "11013";
        String idx_cl_code = "M210000";

        String url = apiDart.fnlttSinglIndx(corp_code, bsns_year, reprt_code, idx_cl_code);
        String response = apiClient.getResponse(url);

        System.out.println(response);

    }
}
