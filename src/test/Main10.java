package test;

import java.util.List;

import filesystem.DataFileManagerKRXListedInfo;
import model.KRXListedInfoDTO;
import service.update.UpdateKRXListedInfo;

public class Main10 {
    public static void main(String[] args) {
        DataFileManagerKRXListedInfo dfm = new DataFileManagerKRXListedInfo();

        String filePath = dfm.filePath("20241206", "20250106", "5", "xml");

        List<KRXListedInfoDTO> list = dfm.readXmlFile(filePath);

        System.out.println(list.get(0));

        UpdateKRXListedInfo update = new UpdateKRXListedInfo();
        update.newXmlData();

    }
}
