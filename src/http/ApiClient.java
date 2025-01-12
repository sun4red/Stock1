package http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {

    static int dartCallCount;
    static int dataCallCount;
    static int apiCallCount = dartCallCount + dataCallCount;

    private static final String dartApiUrl = "https://opendart.fss.or.kr/";
    private static final String dataApiUrl = "https://apis.data.go.kr/";

    private Map<String, Map<String, Integer>> apiUsageData;
    private static final String usageDataFile = "log/apiusagedata.csv";

    public String getResponse(String urlString) {

        String responseData = "";

        try {

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 요청 속성 설정 (헤더 추가 가능)
            // conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                responseData = response.toString();

                // API호출 카운트
                recordCount(urlString);

            } else {
                System.out.println("HTTP 요청 실패. 응답 코드: " + responseCode);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;
    }

    // API 호출 횟수 저장 ==============================

    private void recordCount(String urlString) {
        if (urlString.startsWith(dartApiUrl)) {
            dartCallCount += 1;
            increment("dart");
        }
        if (urlString.startsWith(dataApiUrl)) {
            dataCallCount += 1;
            increment("data");
        }
    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

    // 파일에서 데이터 읽기
    private void loadDataFromFile() {
        File file = new File(usageDataFile);
        if (!file.exists()) {
            return; // 파일이 없다면 그냥 종료
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String date = parts[0];
                Map<String, Integer> dailyData = new HashMap<>();

                for (int i = 1; i < parts.length; i += 2) {
                    String apiName = parts[i];
                    int count = Integer.parseInt(parts[i + 1]);
                    dailyData.put(apiName, count);
                }
                apiUsageData.put(date, dailyData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 특정 API 호출 횟수 증가
    public void increment(String apiName) {
        this.apiUsageData = new HashMap<>();
        loadDataFromFile();
        String today = getCurrentDate();
        apiUsageData.putIfAbsent(today, new HashMap<>());
        Map<String, Integer> dailyData = apiUsageData.get(today);

        // API 호출 횟수 증가
        dailyData.put(apiName, dailyData.getOrDefault(apiName, 0) + 1);

        // 총합(sum) 갱신
        dailyData.put("sum", dailyData.getOrDefault("sum", 0) + 1);

        // 데이터를 파일에 저장
        saveDataToFile();
    }

    // 파일에 데이터 저장
    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usageDataFile))) {
            for (String date : apiUsageData.keySet()) {
                Map<String, Integer> dailyData = apiUsageData.get(date);
                StringBuilder line = new StringBuilder(date);

                for (Map.Entry<String, Integer> entry : dailyData.entrySet()) {
                    line.append(",").append(entry.getKey()).append(",").append(entry.getValue());
                }

                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
