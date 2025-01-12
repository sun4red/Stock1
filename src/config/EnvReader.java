package config;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class EnvReader {

    public static Map<String, String> readEnv() {


        // 프로젝트 시작 파일의 클래스 파일이 위치한 디렉토리를 기준으로 상대 경로 계산
        String classFilePath = EnvReader.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String projectDirectory = classFilePath.substring(0, classFilePath.indexOf("/")); // 프로젝트 디렉토리
        String envFilePath = projectDirectory + ".env"; // 프로젝트 디렉토리 내의 .env 파일


        Map<String, String> envMap = new HashMap<>();
        BufferedReader reader;

        try {

            reader = new BufferedReader(new FileReader(envFilePath));
            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty() && !line.startsWith("#")) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        String key = parts[0].trim();
                        String value = parts[1].trim();
                        envMap.put(key, value);
                    }
                }

            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return envMap;
    }
}
