package test;

import java.util.ArrayList;
import java.util.List;

import database.krx.KRXListedInfoDAO;
import filesystem.DataFileManagerKRXListedInfo;
import model.KRXListedInfoDTO;
import service.update.UpdateKRXListedInfo;

public class Main11 {
    public static void main(String[] args) {

        List<KRXListedInfoDTO> list = new ArrayList<>();

DataFileManagerKRXListedInfo dfm = new DataFileManagerKRXListedInfo();
String filePath = dfm.filePath("20241108", "20250108","2","xml");


        // list = new DataFileManagerKRXListedInfo().readXmlFile(filePath);

        // KRXListedInfoDTO dto = list.get(0);

        // KRXListedInfoDAO dao = new KRXListedInfoDAO();

        // dao.insert(dto);

UpdateKRXListedInfo update = new UpdateKRXListedInfo();
update.newXmlData();

int result = update.xmlToDB("20241111", "20250111");
// System.out.println(result);

    }
}
