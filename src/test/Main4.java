package test;

import database.dart.DBDartFnlttSinglAcntAll;

public class Main4 {
    public static void main(String[] args) {

        DBDartFnlttSinglAcntAll dbDartFnlttSinglAcntAll = new DBDartFnlttSinglAcntAll();

        String rcept_no = dbDartFnlttSinglAcntAll.select_rcept_no("11011", "2021", "00938721");

        System.out.println(rcept_no);

        int result = 0;

        result = dbDartFnlttSinglAcntAll.delete(rcept_no);

        System.out.println(result);

    }
}