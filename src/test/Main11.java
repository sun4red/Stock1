package test;

import java.util.ArrayList;
import java.util.List;

import api.krx.DataFileManagerKRXListedInfo;
import api.krx.model.KRXListedInfoDTO;
import data.update.UpdateKRXListedInfo;
import database.krx.KRXListedInfoDAO;

public class Main11 {
    public static void main(String[] args) {

        List<KRXListedInfoDTO> list = new ArrayList<>();

DataFileManagerKRXListedInfo dfm = new DataFileManagerKRXListedInfo();
String filePath = dfm.filePath("20241208", "20250108","2","xml");


        list = new DataFileManagerKRXListedInfo().readXmlFile(filePath);

        // KRXListedInfoDTO dto = list.get(0);

        // KRXListedInfoDAO dao = new KRXListedInfoDAO();

        // dao.insert(dto);

UpdateKRXListedInfo update = new UpdateKRXListedInfo();

int result = update.xmlToDB("20241208", "20250108","2","xml");
System.out.println(result);

    }
}
