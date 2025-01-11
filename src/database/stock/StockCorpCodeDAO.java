package database.stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.stock.model.StockCorpCodeDTO;
import utility.EnvReader;

public class StockCorpCodeDAO {

    private static final String mssql_url = EnvReader.readEnv().get("MSSQL_URL");
    private static final String mssql_user = EnvReader.readEnv().get("MSSQL_USER");
    private static final String mssql_password = EnvReader.readEnv().get("MSSQL_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(mssql_url, mssql_user, mssql_password);
    }

    public List<StockCorpCodeDTO> selectViewListedCorp() {
        List<StockCorpCodeDTO> list = new ArrayList<>();

        String sql = "select * from v_ListedCorp";

        try {

            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
