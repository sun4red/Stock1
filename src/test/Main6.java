package test;

import java.util.ArrayList;
import java.util.List;

import api.GetData;
import api.data.ReadData;
import api.model.MDartFnlttSinglAcntAll;

public class Main6 {
    public static void main(String[] args) {

        ReadData readData = new ReadData();

        List<MDartFnlttSinglAcntAll> list = new ArrayList<>();
        list = readData.dartFnlttSinglAcntAll("00938721", "2022", "11011", "CFS", "xml");

        System.out.println(list);

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        // if (!list.isEmpty() || list != null) {
        if (list.isEmpty()) {

            System.out.println("비어있음음");

        } else {
            System.out.println("아님님");
        }


GetData getData = new GetData();
getData.fnlttSinglAcntAll(2021,2024, "00938721", "CFS", "xml");


    }
}
