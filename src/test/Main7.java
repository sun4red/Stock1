package test;

import data.update.UpdateFnlttSinglAcntAll;

public class Main7 {
    public static void main(String[] args) {
        UpdateFnlttSinglAcntAll updateFnlttSinglAcntAll = new UpdateFnlttSinglAcntAll();
        // <reprt_code>11014</reprt_code>
        // <bsns_year>2021</bsns_year>
        // <corp_code>00938721</corp_code>
        updateFnlttSinglAcntAll.newXmlData("00938721", "2021", "11014", "CFS");
    }
}
