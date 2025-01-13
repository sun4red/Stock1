package test;

import service.update.UpdateFnlttSinglAcntAll;
import service.update.UpdateKRXListedInfo;

public class Main13 {
    public static void main(String[] args) {
        

UpdateFnlttSinglAcntAll updateFnl = new UpdateFnlttSinglAcntAll();

UpdateKRXListedInfo updateKRX = new UpdateKRXListedInfo();
// DB insert시 지우고 집어넣거나 merge 처리 필요
// updateKRX.newXmlData();
// updateKRX.xmlToDB("20241113", "20250113");

// 00938721	필옵틱스	161580
// 01179617	한국비엔씨	256840


updateFnl.newXmlData(2010, 2024, "00938721", "CFS");

updateFnl.newXmlData(2010, 2024, "01179617", "OFS");

updateFnl.xmlToDB("00938721");
updateFnl.xmlToDB("01179617");




    }
}
