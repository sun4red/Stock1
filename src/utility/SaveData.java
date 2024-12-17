package utility;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class SaveData {

    private static SaveData instance;

    public static SaveData getInstance() {
        if (instance == null) {
            instance = new SaveData();
        }
        return instance;
    }

    public void saveJson(String data, String filePath) {

        // 파일에 JSON 데이터를 저장
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            writer.write(data);
            System.out.println("JSON 데이터가 파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveXml(String data, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            writer.write(data);
            System.out.println("XML 데이터가 파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

// 4. 인스턴스 생성을 제어
// 싱글턴 패턴을 사용하면 객체의 인스턴스를 명시적으로 제어할 수 있습니다. 객체를 생성할 때마다 동일한 인스턴스를 반환하도록 보장함으로써,
// 여러 번 객체를 생성하는 오류를 방지할 수 있습니다. 싱글턴 패턴에서는 생성자를 private으로 설정하여 외부에서 인스턴스를 생성하지
// 못하게 하므로 인스턴스를 유일하게 관리할 수 있습니다.
//
// 예시:
// 파일 시스템 접근 객체: 파일 시스템에 대한 접근을 관리하는 객체를 싱글턴으로 구현하여 여러 부분에서 동일한 파일 핸들러를 사용할 수
// 있습니다.