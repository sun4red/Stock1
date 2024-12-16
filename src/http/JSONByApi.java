package http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;

public class JSONByApi {

    public JSONObject getJSON(String urlString) {

        JSONObject retrunJSON = new JSONObject();

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
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 7. JSON 파싱
                String jsonString = response.toString();
                retrunJSON = new JSONObject(jsonString);

                // 8. JSON 데이터 저장
                // System.out.println("JSON 데이터: " + retrunJSON.toString(4));

            } else {
                System.out.println("HTTP 요청 실패. 응답 코드: " + responseCode);
            }

            // 9. 연결 닫기
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retrunJSON;
    }

}
