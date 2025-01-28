package test;

import java.util.List;

import database.DartFnlttSinglAcntAllDAO;
import model.DartFnlttSinglAcntAllDTO;

public class Main14 {
    public static void main(String[] args) {

        DartFnlttSinglAcntAllDAO dao = new DartFnlttSinglAcntAllDAO();

        List<DartFnlttSinglAcntAllDTO> list = dao.selectByRcept_no("20230511000206");

        // System.out.println(list);

        for(int i = 0; i<list.size();i++){
            DartFnlttSinglAcntAllDTO dto = list.get(i);
            System.out.println(dto);
        }

    }
}
