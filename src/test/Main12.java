package test;

import java.util.List;

import api.stock.model.StockCorpCodeDTO;
import data.update.UpdateFnlttSinglAcntAll;
import database.stock.DartCorpCodeDAO;

public class Main12 {
    public static void main(String[] args) {
        

// v_ListedCorp

UpdateFnlttSinglAcntAll update = new UpdateFnlttSinglAcntAll();

DartCorpCodeDAO dao = new DartCorpCodeDAO();
List<StockCorpCodeDTO> list =  dao.selectViewListedCorp();

System.out.println("list size = " + list.size());

for(int i = 40; i < 50; i++){

    String corp_code = list.get(i).getCorp_code();


    update.newXmlData(2020, 2024, corp_code, "CFS");
}





    }
}
