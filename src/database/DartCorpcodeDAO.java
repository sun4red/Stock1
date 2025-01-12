package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DartCorpcodeDTO;

public class DartCorpcodeDAO {

    public int insertCorpCode(DartCorpcodeDTO mDartCorpcode) {
        int result = 0;

        String sql = "INSERT INTO CORPCODE (corp_code, corp_name, stock_code, modify_date) VALUES (?, ?, ?, ?)";

        result = DBConnectionManager.executeUpdate(sql,
                mDartCorpcode.getCorp_code(),
                mDartCorpcode.getCorp_name(),
                mDartCorpcode.getStock_code(),
                mDartCorpcode.getModify_date());

        return result;
    }

    public List<DartCorpcodeDTO> selectCorpcode() {
        List<DartCorpcodeDTO> result = new ArrayList<>();

        String sql = "SELECT * FROM CORPCODE";

        try {
            Connection connection = DBConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = null;

            rs = pstmt.executeQuery();

            while (rs.next()) {

                DartCorpcodeDTO mDartCorpcode = new DartCorpcodeDTO();

                String corp_code = rs.getString("corp_code");
                String corp_name = rs.getString("corp_name");
                String stock_code = rs.getString("stock_code");
                String modify_date = rs.getString("modify_date");

                mDartCorpcode.setCorp_code(corp_code);
                mDartCorpcode.setCorp_name(corp_name);
                mDartCorpcode.setStock_code(stock_code);
                mDartCorpcode.setModify_date(modify_date);

                result.add(mDartCorpcode);
            }
            DBConnectionManager.closeConnection(connection, pstmt, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
