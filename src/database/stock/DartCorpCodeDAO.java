package database.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.stock.model.StockCorpCodeDTO;
import database.DBConnectionManager;
import utility.EnvReader;

public class DartCorpCodeDAO {

    private DBConnectionManager dbManager = new DBConnectionManager();

    public List<StockCorpCodeDTO> selectViewListedCorp() throws Exception {
        List<StockCorpCodeDTO> list = new ArrayList<>();

        String sql = "select * from v_ListedCorp";

        
        Connection con = dbManager.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = null;

        rs = pstmt.executeQuery();

        while (rs.next()) {

            StockCorpCodeDTO dto = new StockCorpCodeDTO();

            String corp_code = rs.getString("corp_code");
            String corp_name = rs.getString("corp_code");
            String stock_code = rs.getString("corp_code");
            // String modify_date = rs.getString("modify_date");

            dto.setCorp_code(corp_code);
            dto.setCorp_name(corp_name);
            dto.setStock_code(stock_code);
            // dto.setModify_date(modify_date);

            list.add(dto);

        }
        dbManager.closeConnection(con, pstmt, rs);

        return list;
    }

}