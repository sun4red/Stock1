package database.dart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import api.model.MDartCorpcode;
import database.DBConnectionManager;
import utility.EnvReader;

public class DBDartCorpcode {

    private static final String mssql_url = EnvReader.readEnv().get("MSSQL_URL");
    private static final String mssql_user = EnvReader.readEnv().get("MSSQL_USER");
    private static final String mssql_password = EnvReader.readEnv().get("MSSQL_PASSWORD");

    // DB 연결 생성
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(mssql_url, mssql_user, mssql_password);
    }

    public int insertCorpCode(MDartCorpcode mDartCorpcode) {
        int result = 0;

        String sql = "INSERT INTO CORPCODE (corp_code, corp_name, stock_code, modify_date) VALUES (?, ?, ?, ?)";

        result = DBConnectionManager.executeUpdate(sql,
                mDartCorpcode.getCorp_code(),
                mDartCorpcode.getCorp_name(),
                mDartCorpcode.getStock_code(),
                mDartCorpcode.getModify_date());

        return result;
    }

    public List<MDartCorpcode> selectCorpcode() {
        List<MDartCorpcode> result = new ArrayList<>();

        String sql = "SELECT * FROM CORPCODE";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            ResultSet rs = null;

            rs = pstmt.executeQuery();

            while (rs.next()) {

                MDartCorpcode mDartCorpcode = new MDartCorpcode();

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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
