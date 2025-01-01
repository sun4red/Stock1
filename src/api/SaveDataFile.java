package api;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class SaveDataFile {

    private static SaveDataFile instance;

    public static SaveDataFile getInstance() {
        if (instance == null) {
            instance = new SaveDataFile();
        }
        return instance;
    }

    // #Base Method
    public int saveDataToXml(String data, String filePath) {
        int result = 0;

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            writer.write(data);

            System.out.println("저장된 파일: " + filePath);
            result = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    // #OverLoaded
    public int saveDataToXml(String data, String directory, String fileName) {
        String filePath = directory + fileName + ".xml";
        int result = saveDataToXml(data, filePath);
        return result;
    }
}
