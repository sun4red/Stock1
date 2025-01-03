package test;

import data.update.UpdateFnlttSinglAcntAll;

public class Main8 {
    public static void main(String[] args) {
        


UpdateFnlttSinglAcntAll update = new UpdateFnlttSinglAcntAll();

// update.newXmlData(2015, 2025, "00938721", "CFS");

update.xmlToDB("00938721");

    }
}
