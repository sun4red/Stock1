package utill;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class DataFileManager {

    private static DataFileManager instance;

    public DataFileManager getInstance() {
        if (instance == null) {
            instance = new DataFileManager();
        }
        return instance;
    }

    public String makeFileName(String[] info, String extension) {
        String fileName = "";

        int count = 0;
        for (int i = 0; i < info.length; i++) {
            if (count++ > 0) {
                fileName += "_";
            }
            fileName += info[i];

        }
        fileName += "." + extension;

        return fileName;
    }

    public int saveDataFile(String data, String filePath) {
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

    public int deleteDataFile(String filePath) {
        int result = 0;
        File file = new File(filePath);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("삭제된 파일: " + filePath);
                result = 1;
            }
        } else {
            System.out.println("존재하지 않는 파일: " + filePath);
        }
        return result;
    }

    public void readDataFile() {

    }

}
