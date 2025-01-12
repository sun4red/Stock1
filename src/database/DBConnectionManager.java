package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.EnvReader;

public class DBConnectionManager {

    private static final String mssql_url = EnvReader.readEnv().get("MSSQL_URL");
    private static final String mssql_user = EnvReader.readEnv().get("MSSQL_USER");
    private static final String mssql_password = EnvReader.readEnv().get("MSSQL_PASSWORD");

    // DB 연결 생성
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(mssql_url, mssql_user, mssql_password);
    }

    // DB 연결 종료
    // #Base Method
    public static void closeConnection(Connection con, PreparedStatement pstmt, ResultSet rs)
            throws SQLException, IOException {

        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (con != null) {
            con.close();
        }

    }

    // DB 연결 종료
    public static void closeConnection(AutoCloseable... closeables) throws Exception {

        for (AutoCloseable closeable : closeables) {
            if (closeable != null) {
                closeable.close();
            }
        }

    }

    // SQL 실행 메소드 (PreparedStatement 사용)
    // INSERT/UPDATE/DELETE 쿼리 실행 메소드
    public static int executeUpdate(String sql, Object... params) {
        int result = 0;
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {

            // 파라미터 설정
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            // 쿼리 실행
            result = pstmt.executeUpdate();

            try {
                closeConnection(con, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 다른 클래스로 ResultSet 객체를 보낼 수 없음, try문을 벗어나면 자동으로 객체가 닫힘

}
