package test;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {


//        try {
//            // HttpClient 생성
//            HttpClient client = HttpClient.newHttpClient();
//
//            // 요청 생성
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}"))
//                    .build();
//
//            // 요청 보내기 및 응답 받기
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            // 응답 출력
//            System.out.println("Response Code: " + response.statusCode());
//            System.out.println("Response Body: " + response.body());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println("ME");
//
//    }

        String urlString = "https://jsonplaceholder.typicode.com/posts/1"; // 예제 API

        try {
            // 1. URL 객체 생성
            URL url = new URL(urlString);

            // 2. HttpURLConnection 객체 열기
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 3. HTTP 메서드 설정 (GET)
            conn.setRequestMethod("GET");

            // 4. 요청 속성 설정 (헤더 추가 가능)
            conn.setRequestProperty("Accept", "application/json");

            // 5. 응답 코드 확인
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 6. 응답 데이터 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 7. JSON 파싱
                String jsonString = response.toString();
                JSONObject jsonObject = new JSONObject(jsonString);

                // 8. JSON 데이터 저장
                System.out.println("JSON 데이터: " + jsonObject.toString(4));

                // 특정 데이터 접근 예제
                System.out.println("Title: " + jsonObject.getString("title"));
            } else {
                System.out.println("HTTP 요청 실패. 응답 코드: " + responseCode);
            }

            // 9. 연결 닫기
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
