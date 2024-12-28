package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import api.data.ReadData;
import api.model.MDartFnlttSinglAcntAll;
import database.dart.DBDartFnlttSinglAcntAll;

public class Main3 {
    public static void main(String[] args) {

        List<MDartFnlttSinglAcntAll> list = new ArrayList<>();

        ReadData readData = new ReadData();
        list = readData.XmlDartFnlttSinglAcntAll("00938721", "2021", "11011", "CFS");
        // System.out.println(list);

MDartFnlttSinglAcntAll mDartFnlttSinglAcntAll = new MDartFnlttSinglAcntAll();
mDartFnlttSinglAcntAll = list.get(0);
// System.out.println( mDartFnlttSinglAcntAll);

// BigDecimal bigDecimal  = new BigDecimal(mDartFnlttSinglAcntAll.getFrmtrm_amount());
// System.out.println(bigDecimal);

DBDartFnlttSinglAcntAll dbDartFnlttSinglAcntAll = new DBDartFnlttSinglAcntAll();
// dbDartFnlttSinglAcntAll.insertFnlttSinglAcntAll(mDartFnlttSinglAcntAll);
dbDartFnlttSinglAcntAll.insertList(list);




    }
}
