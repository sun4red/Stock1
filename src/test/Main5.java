package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import api.data.CreateFilePath;
import api.data.ReadData;
import api.model.MDartFnlttSinglAcntAll;
import database.DartFnlttSinglAcntAllDAO;

public class Main5 {
    public static void main(String[] args) {


DartFnlttSinglAcntAllDAO dbDartFnlttSinglAcntAll = new DartFnlttSinglAcntAllDAO();
dbDartFnlttSinglAcntAll.updateData("00938721");





    }

    //     CreateFilePath createFilePath = new CreateFilePath();

    //     List<String> fileList = createFilePath.fnlttSinglAcntAllList("00938721");

    //     String directory = createFilePath.fnlttSinglAcntAllDir("00938721");

    //     System.out.println("Directory: " + directory);

    //     for (int i = 0; i < fileList.size(); i++) {
    //         String fileName = fileList.get(i);
    //         String[] splitFileName = fileName.split("_");
    //         String corp_code = splitFileName[0];
    //         String bsns_year = splitFileName[1];
    //         String reprt_code = splitFileName[2];

    //         DBDartFnlttSinglAcntAll dbDartFnlttSinglAcntAll = new DBDartFnlttSinglAcntAll();
    //         String rcept_no = dbDartFnlttSinglAcntAll.select_rcept_no(reprt_code, bsns_year, corp_code);
    //         System.out.println(rcept_no);
    //         if (rcept_no.isEmpty()  ||  rcept_no == null) {


    //             List<MDartFnlttSinglAcntAll> list = new ArrayList<>();
    //             ReadData readData = new ReadData();
    //             list = readData.XmlDartFnlttSinglAcntAll(directory + "/" + fileName);

    //             dbDartFnlttSinglAcntAll.insertList(list);
    //             System.out.println("DB insert: " + fileName);
    //             System.out.println(rcept_no);

    //         }

    //     }
    // }
}
