package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import api.model.MDartCorpcode;
import utility.EnvReader;

public class DBConnection {

    EnvReader envReader = new EnvReader();

    private static final String mssql_url = EnvReader.readEnv().get("MSSQL_URL");
    private static final String mssql_user = EnvReader.readEnv().get("MSSQL_USER");
    private static final String mssql_password = EnvReader.readEnv().get("MSSQL_PASSWORD");

    public int insertDCorpCode(MDartCorpcode mDartCorpcode) {
        Connection connection = null;
        int inserted = 0;

        try {

            connection = DriverManager.getConnection(mssql_url, mssql_user, mssql_password);

            String sql = "INSERT INTO CORPCODE (corp_code, corp_name, stock_code, modify_date) VALUES (?, ? , ? , ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mDartCorpcode.getCorp_code());
            pstmt.setString(2, mDartCorpcode.getCorp_name());
            pstmt.setString(3, mDartCorpcode.getStock_code());
            pstmt.setString(4, mDartCorpcode.getModify_date());

            inserted = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return inserted;
    }
}